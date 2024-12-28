package mrilki.repositoris;
import mrilki.models.User;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainRepository {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "278145";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dzoris";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        UserRepository userRepository = new UserRepositoryImpl(connection);

        userRepository.save(User.builder().
                firstName("Denis").
                lastName("Kim").
                age(18).
                password("1232").
                username("Mrilki")
                .build());



    }
}
