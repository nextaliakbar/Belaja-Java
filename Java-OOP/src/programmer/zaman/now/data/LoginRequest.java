package programmer.zaman.now.data;

public record LoginRequest(String username, String password) {

    public LoginRequest {
        System.out.println("Membuat Compact Constructor");
    }

//  Overloading contructor record
    public LoginRequest(String username) {
        this(username, null);
    }

    public LoginRequest() {
        this(null, null);
    }

}
