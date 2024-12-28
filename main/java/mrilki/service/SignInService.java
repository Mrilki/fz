package mrilki.service;

import mrilki.dto.SignInForm;
import mrilki.dto.UserDto;

import java.sql.SQLException;

public interface SignInService {
    UserDto signIn(SignInForm from) throws SQLException;
}