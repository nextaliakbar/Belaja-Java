package programmer.zaman.now.application;

import programmer.zaman.now.data.LoginRequest;
import programmer.zaman.now.error.ValidationException;
import programmer.zaman.now.util.ValidationUtil;

public class ValidationApp {
    public static void main(String[] args) {
        LoginRequest loginRequest1 = new LoginRequest("aliakbar123", "12345678");

        try {
            ValidationUtil.validateChecked(loginRequest1);
            System.out.println("Validation passed");
        } catch(ValidationException | NullPointerException ex) {
            System.out.println("Validation not valid: " + ex.getMessage());
        } finally {
            System.out.println("Selalu di eksekusi");
        }

//      Jika error maka program selanjutnya tidak akan dieksekusi
        LoginRequest loginRequest2 = new LoginRequest(null, "12345678");
        ValidationUtil.validateRuntime(loginRequest2);
        System.out.println("Sukses");
    }
}
