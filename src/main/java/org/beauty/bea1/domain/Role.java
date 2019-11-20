package org.beauty.bea1.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, LECTURER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
