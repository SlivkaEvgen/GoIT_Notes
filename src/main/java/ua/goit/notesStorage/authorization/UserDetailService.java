package ua.goit.notesStorage.authorization;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username!=null){
            if (userRepository.findByUsername(username).isPresent()) {
                return userRepository.findByUsername(username).get();
            }
        }
        return null;
    }
}
