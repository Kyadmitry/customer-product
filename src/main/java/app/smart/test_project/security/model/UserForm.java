package app.smart.test_project.security.model;

import lombok.Data;

@Data
public class UserForm {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
}
