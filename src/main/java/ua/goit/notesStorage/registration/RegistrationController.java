package ua.goit.notesStorage.registration;

import lombok.AllArgsConstructor;
import ua.goit.notesStorage.authorization.User;
import ua.goit.notesStorage.authorization.UserService;
import ua.goit.notesStorage.enums.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Validated
@Controller
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registration(Model model){
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){
        if (userService.findByUsername(user.getUsername()).isPresent()){
            model.addAttribute("message", Collections.singletonList("User exists!"));
            return "register";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/login";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ModelAndView onConstraintValidationException(ConstraintViolationException e, Model model) {
        model.addAttribute("message",e.getConstraintViolations().stream()
                        .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList()));
        return new ModelAndView("/register");
    }
}
