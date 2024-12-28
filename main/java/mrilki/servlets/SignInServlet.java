package mrilki.servlets;

import mrilki.dto.SignInForm;
import mrilki.dto.UserDto;
import mrilki.models.User;
import mrilki.repositoris.UserRepository;
import mrilki.repositoris.UserRepositoryImpl;
import mrilki.service.SignInService;
import mrilki.service.SignInServiceImpl;
import mrilki.service.SignUpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";

    private static final String DB_PASSWORD = "278145";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dzoris";
    private SignInService signInService;

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
        signInService = new SignInServiceImpl(userRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/html/signIn.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        SignInForm signInForm = SignInForm.builder()
                .username(username)
                .password(password)
                .build();
        try {
            UserDto user = signInService.signIn(signInForm);

            if (user != null) {
                HttpSession httpSession = req.getSession(true);

                httpSession.setAttribute("authenticated", true);
                httpSession.setAttribute("id", user.getId());
                httpSession.setAttribute("role", user.getRole());
                httpSession.setAttribute("name", user.getUsername());
                httpSession.setAttribute("isAdmin", user.isAdmin());

                resp.sendRedirect("/profile");
            }
            else {
                resp.sendRedirect("/signIn");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
