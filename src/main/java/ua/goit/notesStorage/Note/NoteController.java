package ua.goit.notesStorage.Note;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.notesStorage.authorization.User;
import ua.goit.notesStorage.authorization.UserService;
import ua.goit.notesStorage.enums.AccessTypes;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;
import java.util.stream.Collectors;

@Validated
@Controller
@RequestMapping(value = "/note")
public class NoteController {

    private final NoteService noteService;

    private final UserService userService;

    public NoteController(NoteService noteService, UserService userService){
        this.noteService=noteService;
        this.userService=userService;
    }

    @GetMapping("list")
    public String getNotes(@AuthenticationPrincipal User user,@RequestParam(required = false,defaultValue = "") String filter, Map<String, Object> model){
        List<Note> notes;
        if (filter != null && !filter.isEmpty()) {
            user = userService.getById(user.getId());
        }
        notes = noteService.findByAuthor(user.getId());
        int noteCount= notes.size();
        model.put("notes", notes);
        model.put("filter", filter);
        model.put("noteCount", noteCount);
        return "noteList";
    }

    @GetMapping("create")
    public String noteCreate(){
        return "noteCreate";
    }

    @GetMapping("edit/{id}")
    public String noteEdit(@AuthenticationPrincipal User user, @PathVariable String id,  Map<String, Object> model){
        Note note = noteService.getById(UUID.fromString(id));
        if (!note.getAuthor().getId().equals(user.getId())){
            model.put("message", Collections.singletonList("Editing the note is prohibited - you are not author"));
            return "noteError";
        }
        model.put("editNote", note);
        return "noteEdit";
    }

    @GetMapping("delete/{id}")
    public String noteDelete(@AuthenticationPrincipal User user,@PathVariable String id, Map<String, Object> model){
        if (!noteService.getById(UUID.fromString(id)).getAuthor().getId().equals(user.getId())){
            model.put("message", Collections.singletonList("Deleting the note is prohibited - you are not author"));
            return "noteError";
        }
        noteService.deleteById(UUID.fromString(id));
        return "redirect:/note/list";
    }

    @GetMapping("error")
    public String noteError(Map<String, Object> model){
        model.put("message", Collections.singletonList("TEST MESSAGE!"));
        return "noteError";
    }

    @GetMapping("share/{id}")
    public String noteShow(@AuthenticationPrincipal User user,@PathVariable String id, Map<String,Object> model){
        Optional<Note> note = noteService.findById(UUID.fromString(id));
        if ((note.isPresent() && ((user!=null && note.get().getAuthor().getId().equals(user.getId())) ||
                (user == null && note.get().getAccessType().equals(AccessTypes.PUBLIC))))){
        model.put("note", note.get());
        } else {
            model.put("message", Collections.singletonList("We can't find tis note "));
        }
        return "noteShow";
    }

    @PostMapping("create")
    public String addNote(@AuthenticationPrincipal User user, @ModelAttribute("editNote") Note editNote,
                          @RequestParam(required = false) String noteId, @RequestParam(required = false) String accessType){
        if (!noteId.isBlank()) {
            editNote.setId(UUID.fromString(noteId));
            editNote.setAccessType(AccessTypes.valueOf(accessType.toUpperCase()));
        }
        editNote.setAuthor(user);
        noteService.save(editNote);
        return "redirect:/note/list";
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ModelAndView onConstraintValidationException(ConstraintViolationException e, Model model) {
        model.addAttribute("message",e.getConstraintViolations().stream()
                        .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList()));
        return new ModelAndView("noteError");
    }
}
