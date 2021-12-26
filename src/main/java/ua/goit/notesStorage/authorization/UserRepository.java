package ua.goit.notesStorage.authorization;

import org.springframework.stereotype.Repository;
import ua.goit.notesStorage.RepositoryI;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends RepositoryI<User, UUID> {

    Optional<User> findByUsername(String username);

}
