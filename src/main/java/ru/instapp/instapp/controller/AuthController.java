package ru.instapp.instapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.instapp.instapp.config.EncryptionConfig;
import ru.instapp.instapp.domain.AccountDomain;
import ru.instapp.instapp.dto.AccountRegisterDto;
import ru.instapp.instapp.service.AccountService;

import javax.validation.Valid;
import java.util.Calendar;

@Controller
@RequestMapping("/")
@Slf4j
public class AuthController {

    private final AccountService accountService;
    private final EncryptionConfig encryptionConfig;

    public AuthController(AccountService accountService, EncryptionConfig encryptionConfig) {
        this.accountService = accountService;
        this.encryptionConfig = encryptionConfig;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("page", "login");
        return "base";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("page", "register");
        model.addAttribute("userForm", new AccountRegisterDto());
        return "base";
    }

    @PostMapping("/register")
    public String register(@Valid AccountRegisterDto userForm,
                           BindingResult bindingResult,
                           Model model) {

        log.info(String.valueOf(userForm));
        log.info(String.valueOf(bindingResult.getModel()));

        if (bindingResult.hasErrors()) {
            model.addAttribute("page", "register");
            model.addAttribute("userForm", new AccountRegisterDto());
            return "base";
        }

        AccountDomain newAccount = new AccountDomain();
        newAccount.setEmail(userForm.getEmail().toLowerCase());
        newAccount.setPassword(encryptionConfig.getPasswordEncoder().encode(userForm.getPassword()));
        newAccount.setRegisterDate(Calendar.getInstance());
        if (accountService.save(newAccount) == null) {
            model.addAttribute("page", "register");
            model.addAttribute("userForm", userForm);
            model.addAttribute("emailError", "Пользователь с такой почтой уже существует!");
            return "base";
        }

        return "redirect:/";
    }
}
