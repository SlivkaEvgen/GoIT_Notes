package ua.goit.notesStorage.swagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.goit.notesStorage.note.Note;

@RequestMapping("app")
public class MainControllerApp {

    private final Note note ;

    public MainControllerApp(Note note){
        this.note=note;
    }

    @GetMapping("")
    public Note greeting() {
        return note;
    }
}
