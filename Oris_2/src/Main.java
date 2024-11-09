
import java.sql.*;
import java.util.Scanner;


public class Main {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "278145";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from test");

        while (result.next()){
            System.out.println(result.getInt("id") + " " + result.getString("name") + " " + result.getString("age"));
        }

        ResultSet newResult = statement.executeQuery("select * from test " +
                "WHERE name LIKE'_____'");
        System.out.println("result where name len 5");
        while (newResult.next()){
            System.out.println(newResult.getInt("id") + " " + newResult.getString("name") + " " + newResult.getString("age"));
        }

        String sqlInsertUser = "insert into test(name, surname, age) VALUES (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertUser);
        for (int i = 0; i < 6; i++) {
            Scanner scanner = new Scanner(System.in);
            String firstName = scanner.nextLine();
            String seconName = scanner.nextLine();
            Integer age = scanner.nextInt();


            preparedStatement.setString(1 + i*3, firstName);
            preparedStatement.setString(2 + i*3, seconName);
            preparedStatement.setInt(3 + i*3, age);

        }
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.close();

//
//
//        System.out.println("Было добавлено " + affectedRows + "строк");
    }
}

