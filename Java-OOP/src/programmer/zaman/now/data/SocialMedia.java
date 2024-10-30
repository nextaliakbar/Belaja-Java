package programmer.zaman.now.data;

class SocialMedia {
    public String username;
    public String password;

    final void login() {

    };

}

final class Facebook extends SocialMedia{
//    void login(); Tidak bisa karena method bersifat final
}
/*
Tidak bisa karena class parent bersifat final
class FakeFacebook extends Facebook{

}

 */
