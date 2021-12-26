package ua.goit.notesStorage.authorization;

import org.springframework.stereotype.Service;
import ua.goit.notesStorage.ServiceI;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService extends ServiceI<User, UUID> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> findAll(){
        return super.findAll();
    }

}
