package ru.youwork.models.enams;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, WORKER, CUSTOMER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
