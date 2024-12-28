package mrilki.service;

import mrilki.dto.SignInForm;
import mrilki.dto.UserDto;
import mrilki.models.User;
import mrilki.repositoris.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLException;
import java.util.Optional;

public class SignInServiceImpl implements SignInService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public SignInServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDto signIn(SignInForm form) throws SQLException {
        Optional<User> userOptional = userRepository.findByUsername(form.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(form.getPassword(), user.getPassword())) {
                return UserDto.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .role(user.getRole())
                        .build();
            }
        }
        return null;
    }
}
