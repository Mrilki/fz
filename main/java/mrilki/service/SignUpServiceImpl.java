package mrilki.service;

import mrilki.dto.SignUpForm;
import mrilki.models.User;
import mrilki.repositoris.UserRepository;
import mrilki.repositoris.UserRepositoryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLException;

public class SignUpServiceImpl implements SignUpService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(SignUpForm form) throws SQLException {
        User user = User.builder().
                username(form.getUsername()).
                firstName(form.getFirstName()).
                lastName(form.getLastName()).
                age(form.getAge()).
                password(passwordEncoder.encode(form.getPassword())).
                build();
        userRepository.save(user);
    }
}
