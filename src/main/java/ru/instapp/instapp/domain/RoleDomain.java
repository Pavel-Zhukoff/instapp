package ru.instapp.instapp.domain;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum RoleDomain implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
