package ua.goit.notesStorage.App;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.goit.notesStorage.Note.Note;
import ua.goit.notesStorage.Note.NoteRepository;
import ua.goit.notesStorage.authorization.User;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final NoteRepository noteRepository;

    public MainController(NoteRepository noteRepository){
        this.noteRepository=noteRepository;
    }

    @GetMapping("/")
    public String greeting() {
        return "redirect:/note/list";
    }

    @GetMapping("main")
    public String main(@RequestParam(required = false,defaultValue = "") String filter, Map<String, Object> model){
        List<Note> notes;
        if (filter != null && !filter.isEmpty()) {
            notes = noteRepository.findByName(filter);
        } else {
            notes = noteRepository.findAll();
        }
        model.put("notes", notes);
        model.put("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user, @RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        noteRepository.save(Note.builder().name(tag).message(text).author(user).build());
        model.put("notes", noteRepository.findAll());
        return "main";
    }

}
