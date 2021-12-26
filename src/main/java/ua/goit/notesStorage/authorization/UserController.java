package ua.goit.notesStorage.authorization;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.notesStorage.enums.Role;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("error")
    public String userError(@RequestParam User user, Model model){
        return "errorUser";
    }

    @PostMapping("")
    public String userSave(
            @RequestParam String userName,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user,
            Model model
    ){
        if (!userName.isBlank() && (userName.length()<6 || userName.length()>51)){
            model.addAttribute("message", "The login must be between 5 and 50 characters long")
                    .addAttribute("userId", user.getId());
            return "errorUser";
        }
        user.setUsername(userName);
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()){
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user).addAttribute("roles", Role.values());
        return "userEdit";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ModelAndView onConstraintValidationException(ConstraintViolationException e, Model model) {
        model.addAttribute("message",e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList()));
        return new ModelAndView("error");
    }

}
