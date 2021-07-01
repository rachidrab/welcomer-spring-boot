package com.idrissbacha.welcomer.service.dto;

import com.idrissbacha.welcomer.domain.User;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO representing a user, with only the public attributes.
 */
public class UserDTO {

    private Long id;
    private String login;
    public UserDTO() {
        // Empty constructor needed for Jackson.
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserDTO{" +
            "id='" + id + '\'' +
            ", login='" + login + '\'' +
            "}";
    }
}
