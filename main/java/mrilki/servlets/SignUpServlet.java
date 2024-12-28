package mrilki.servlets;

import mrilki.dto.SignUpForm;
import mrilki.repositoris.UserRepository;
import mrilki.repositoris.UserRepositoryImpl;
import mrilki.service.SignUpService;
import mrilki.service.SignUpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "278145";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dzoris";

    private SignUpServiceImpl signUpService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/html/signUp.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String password = req.getParameter("password");

        SignUpForm signUpForm = SignUpForm.builder()
                .username(username)
                .firstName(firstname)
                .lastName(lastname)
                .age(age)
                .password(password)
                .build();

        try {
            signUpService.signUp(signUpForm);
            resp.sendRedirect("/signIn");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init() throws ServletException {
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException(e);
        }

        UserRepository userRepository = new UserRepositoryImpl(connection);
        signUpService = new SignUpServiceImpl(userRepository);

    }
}
