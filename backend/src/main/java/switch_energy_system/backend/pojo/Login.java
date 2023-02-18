package switch_energy_system.backend.pojo;

public class Login {
    private String userName;
    private String password;
    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }

    public void setInstaId(String instaId) {
        this.userName = instaId;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
