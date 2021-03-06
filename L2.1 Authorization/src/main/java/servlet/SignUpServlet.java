package servlet;

import account.AccountService;
import account.UserProfile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login == null || password == null) {
            response.getWriter().println("Please add login or password");
        } else {
            accountService.addNewUser(new UserProfile(login, password));
            response.getWriter().println("User was added success");
        }
    }

}

