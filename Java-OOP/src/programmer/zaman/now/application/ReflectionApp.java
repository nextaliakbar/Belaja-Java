package programmer.zaman.now.application;

import programmer.zaman.now.data.CreateUserRequest;
import programmer.zaman.now.util.ValidationUtil;

public class ReflectionApp {
    public static void main(String[] args) {
        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("Ali");
        request.setPassword("123456");
        request.setName("Ali Akbar Rafsanjani");
        request.setEmail("ali@gmail.com");
        ValidationUtil.validateRefelction(request);
    }
}
