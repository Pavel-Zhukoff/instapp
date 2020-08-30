package ru.instapp.instapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.instapp.instapp.service.IAccountService;
import ru.instapp.instapp.service.PostService;

@Controller
@RequestMapping("/")
public class MainController {

    private final PostService postService;
    private final IAccountService iAccountService;

    public MainController(PostService postService, IAccountService iAccountService) {
        this.postService = postService;
        this.iAccountService = iAccountService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("page", "index");
        return "base";
    }

}
