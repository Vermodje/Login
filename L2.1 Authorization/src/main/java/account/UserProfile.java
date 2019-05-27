package account;

public class UserProfile {

    private final String login;
    private final String password;

    public UserProfile(String login, String password) {
        this.login = login;
        this.password = password;
    }

    String getLogin() {
        return login;
    }

}
