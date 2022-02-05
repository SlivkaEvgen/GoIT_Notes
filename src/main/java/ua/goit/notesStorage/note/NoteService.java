package ua.goit.notesStorage.note;

import org.springframework.stereotype.Service;
import ua.goit.notesStorage.ServiceI;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService extends ServiceI<Note,UUID> {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        super(noteRepository);
        this.noteRepository=noteRepository;
    }

    public List<Note> findByAuthor(UUID uuid){
        return noteRepository.findByAuthor(uuid);
    }

    public List<Note> findAll(){
        return super.findAll();
    }
}