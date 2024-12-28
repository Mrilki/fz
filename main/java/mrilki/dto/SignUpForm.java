package mrilki.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpForm {
    private String username;
    private String firstName;
    private String lastName;
    private Integer age;
    private String password;
}
