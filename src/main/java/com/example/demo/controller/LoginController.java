package com.example.demo.controller;
//import com.example.demo.model.Usuario;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import com.example.demo.dao.UsuarioDao;

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
}