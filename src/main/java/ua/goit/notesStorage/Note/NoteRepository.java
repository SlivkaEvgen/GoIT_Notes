package ua.goit.notesStorage.Note;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.goit.notesStorage.RepositoryI;

import java.util.List;
import java.util.UUID;

@Repository
public interface NoteRepository extends RepositoryI<Note, UUID> {

    List<Note> findByName(String name);

    @Query("SELECT c FROM Note c WHERE (c.author.id=?1)")
    List<Note> findByAuthor(UUID uuid);

}