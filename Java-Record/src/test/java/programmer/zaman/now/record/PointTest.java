package programmer.zaman.now.record;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.record.data.Line;
import programmer.zaman.now.record.data.Point;

public class PointTest {

    @Test
    void testCompactConstructor() {
        Point point = new Point(0,0);
        System.out.println(point);
    }

    @Test
    void testStaticMember() {
        Assertions.assertEquals(0, Point.zero.x());
        Assertions.assertEquals(0, Point.zero.y());

        Point point = Point.create(10, 20);
        Assertions.assertEquals(10, point.x());
        Assertions.assertEquals(20, point.y());
    }

    public void printObject1(Object object) {
        if(object instanceof Point) {
            Point point = (Point) object;
            System.out.println(point.x());
            System.out.println(point.y());
        } else {
            System.out.println("Object is not a Point");
        }
    }

    @Test
    void testBeforeRecordPatterns() {
        printObject1(new Point(10,20));
    }

    public void printObject2(Object object) {
        if(object instanceof Point(int x, int y)) {
            System.out.println(x);
            System.out.println(y);
        } else {
            System.out.println("Object is not a Point");
        }
    }

    @Test
    void testAfterRecordPatterns() {
        printObject2(new Point(10,20));
    }

    public void printObject3(Object object) {
        if(object instanceof Line(Point(int x, int y), Point end)) {
            System.out.println("Line Point");
            System.out.println("x : " + x);
            System.out.println("y : " + y);
            System.out.println("End : " + end);
        } else if(object instanceof Point(int x, int y)) {
            System.out.println("Point");
            System.out.println("x : " + x);
            System.out.println("y : " + y);
        } else {
            System.out.println("Object is not a Line and Point");
        }
    }

    @Test
    void testLineRecordPattern() {
        printObject3(new Line(new Point(10,20), new Point(10, 20)));
    }

}
