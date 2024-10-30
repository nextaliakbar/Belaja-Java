package programmer.zaman.now.sealed.data;

public sealed interface SayHello permits Human, Dog, Cat{
    void sayHello();
}
