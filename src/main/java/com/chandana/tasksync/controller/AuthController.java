package com.chandana.tasksync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.chandana.tasksync.entity.User;
import com.chandana.tasksync.repository.BoardRepository;
import com.chandana.tasksync.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        userRepository.save(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {

        User existing = userRepository.findByEmail(user.getEmail());

        if (existing != null && existing.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", existing);
            return "redirect:/dashboard";
        }

        model.addAttribute("error", "Invalid Credentials");
        return "login";
    }

    /*@GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "dashboard";
    }
*/
    @Autowired
    private BoardRepository boardRepository;
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("boards", boardRepository.findAll());
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
