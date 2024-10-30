package programmer.zaman.now.validation.data;

import jakarta.validation.constraints.NotBlank;
import programmer.zaman.now.validation.constraint.CheckPasswordParamater;

public class UserService {

    @CheckPasswordParamater(
            passwordParam = 1,
            retypePasswordParam = 2
    )
    public void register(@NotBlank(message = "Username can't blank") String username,
                         @NotBlank(message = "Password can't blank") String password,
                         @NotBlank(message = "Retype can't blank") String retypePassowrd) {
        // To Do Register
    }
}
