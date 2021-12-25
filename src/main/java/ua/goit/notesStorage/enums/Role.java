package ua.goit.notesStorage.enums;

import org.springframework.security.core.GrantedAuthority;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;

@NotNull
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public enum Role implements GrantedAuthority {

    USER,ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
