package ua.goit.notesStorage.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRepository.findByUsername(username).isPresent()) {
            return userRepository.findByUsername(username).get();
        }
        return Optional.of(userRepository.findByUsername(username).get()).get();
    }
}
