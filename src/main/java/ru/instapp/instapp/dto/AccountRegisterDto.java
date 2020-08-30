package ru.instapp.instapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.instapp.instapp.constraints.FieldMatch;

import javax.validation.constraints.*;

//@FieldMatch(first = "password", second = "matchPassword", message = "Пароли не совпадают!")
@Data
@NoArgsConstructor
public class AccountRegisterDto {

    @NotEmpty(message = "Поле не должно быть пустым!")
    @Email(message = "Неверный формат электронной почты!")
    private String email;

    @NotEmpty(message = "Поле не должно быть пустым!")
    //@Pattern(regexp = "^[_!.?-A-Za-z0-9]*$",
    //        message = "Пароль должен содержать только символы латинского алфавита, цифры и символы _, !, ., ?, -")
    @Size(min = 8, max = 255, message = "Пароль должен быть длиннее 8 символов!")
    private String password;

    @NotEmpty(message = "Поле не должно быть пустым!")
    private String matchPassword;
}
