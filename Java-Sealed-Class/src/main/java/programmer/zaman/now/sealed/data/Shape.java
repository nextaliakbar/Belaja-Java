package programmer.zaman.now.sealed.data;

public sealed interface Shape permits Circle, Rectangle, Triangle {

    Long area();
}
