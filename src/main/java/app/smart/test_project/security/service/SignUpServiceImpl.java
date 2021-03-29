package app.smart.test_project.security.service;

import app.smart.test_project.security.model.Role;
import app.smart.test_project.security.model.State;
import app.smart.test_project.security.model.User;
import app.smart.test_project.security.model.UserForm;
import app.smart.test_project.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpServiceInterface{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * This method saves a new user to the database. When the "admin" login is
     * used, this method creates an ADMIN role (used only for testing purposes).
     * A USER role is created in other cases.
     *
     **/

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .firstname(userForm.getFirstname())
                .lastname(userForm.getLastname())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role("admin".equals(userForm.getLogin()) ? Role.ADMIN : Role.USER)
                .state(State.ACTIVE)
                .build();

        userRepository.save(user);
    }

}
