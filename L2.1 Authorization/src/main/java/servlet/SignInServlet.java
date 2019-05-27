package servlet;

import account.AccountService;
import account.UserProfile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserProfile userProfile = accountService.getUserByLogin(login);

        if (userProfile == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Status code(" + response.getStatus() + ")" + "\n" + "Unauthorized ");
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("Status code(" + response.getStatus() + ")" + "\n" + "Authorized: " + login);


    }

}
