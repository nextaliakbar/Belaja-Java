package programmer.zaman.now.record.data;

import programmer.zaman.now.record.annotation.Valid;

public record Point(@Valid int x, @Valid int y) {

    // Compact Constructor
    public Point {
        System.out.println("Create Point");
    }

    public static final Point zero = new Point(0, 0);

    public static final Point create(int x, int y) {
        return new Point(x,y);
    }
}
