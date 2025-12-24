package net.soufiane.web;

import jakarta.validation.Valid;
import net.soufiane.entities.User;
import net.soufiane.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@Valid @ModelAttribute("user") User user,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {

        // Check for validation errors
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        // Check if username already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("usernameError", "Username already exists");
            return "signup";
        }

        // Check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            model.addAttribute("emailError", "Email already exists");
            return "signup";
        }

        // Encode password and save user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER"); // Default role for new users
        userRepository.save(user);

        redirectAttributes.addFlashAttribute("successMessage",
                "Registration successful! Please login with your credentials.");

        return "redirect:/login";
    }
}
