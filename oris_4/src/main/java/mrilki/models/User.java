package mrilki.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private String password;


}
