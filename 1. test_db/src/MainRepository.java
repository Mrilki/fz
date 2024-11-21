import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class MainRepository {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "278145";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dzoris";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        UserRepository userRepository = new UsersRepositoryJdbcImpl(connection);

        User testUser = new User(1L,"Denis", "Kim", 20, "kazan", 172, 70);
//        userRepository.save(testUser);
//        userRepository.update(testUser);
//        userRepository.remove(testUser);
//        userRepository.save(2);
//        System.out.println(userRepository.findAll());
//        System.out.println(userRepository.findAllByAge(21));
//        System.out.println(userRepository.findAllByCity("Da"));
//        System.out.println(userRepository.findAllByWeight(70));
        System.out.println(userRepository.findById(2L));



    }



}
