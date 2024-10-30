package programmer.zaman.now.util;

import programmer.zaman.now.annotation.NotBlank;
import programmer.zaman.now.data.LoginRequest;
import programmer.zaman.now.error.BlankException;
import programmer.zaman.now.error.ValidationException;

import java.lang.reflect.Field;

public class ValidationUtil {
    public static void validateChecked(LoginRequest loginRequest) throws ValidationException, NullPointerException{
        if(loginRequest.username() == null) {
            throw new NullPointerException("Username is null");
        } else if(loginRequest.username().isBlank()) {
            throw new ValidationException("Username is blank");
        }  else if(loginRequest.password().isBlank()) {
            throw new ValidationException("Password is blank");
        } else if(loginRequest.password() == null) {
            throw new NullPointerException("Password is null");
        }
    }

//  Runtime exception tidak wajib mendeklarasikan throws
    public static void validateRuntime(LoginRequest loginRequest){
        if(loginRequest.username() == null) {
            throw new NullPointerException("Username is null");
        } else if(loginRequest.username().isBlank()) {
            throw new BlankException("Username is blank");
        }  else if(loginRequest.password().isBlank()) {
            throw new BlankException("Password is blank");
        } else if(loginRequest.password() == null) {
            throw new NullPointerException("Password is null");
        }
    }

    public static void validateRefelction(Object object) {
        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            if(field.getAnnotation(NotBlank.class) != null) {
                // Validate
                try {
                    String value = (String) field.get(object);
                    if(value == null || value.isBlank()) {
                        throw new BlankException("Field " + field.getName() + " is blank");
                    } else {
                        System.out.println("Successfully validated field " + field.getName() + " with value " + value);
                    }
                } catch(IllegalAccessException exception) {
                    System.out.println("Tidak bisa mengakses Field"+field.getName());
                }
            }
        }
    }
}
