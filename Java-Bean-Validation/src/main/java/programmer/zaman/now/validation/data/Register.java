package programmer.zaman.now.validation.data;

import jakarta.validation.constraints.NotBlank;
import programmer.zaman.now.validation.constraint.CheckPassword;

@CheckPassword(message = "Password and retype password must be same")
public class Register {

    @NotBlank(message = "Username can't blank")
    private String username;

    @NotBlank(message = "Password can't blank")
    private String password;

    @NotBlank(message = "Retype password can't blank")
    private String retypePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", retype='" + retypePassword + '\'' +
                '}';
    }
}
