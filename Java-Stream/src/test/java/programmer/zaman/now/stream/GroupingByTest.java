package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByTest {

    @Test
    public void testCollectiorsGroupingBy1() {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        Map<String, List<Integer>> map = list.stream()
                .collect(Collectors.groupingBy(number -> (number > 5) ? "Besar" : "Kecil"));
        System.out.println(map);

    }

    @Test
    public void testCollectiorsGroupingBy2() {
        Map<String, List<String>> map = Stream.of("Akbar", "Budi", "Fio", "Ali")
                .collect(Collectors.groupingBy(
                        name -> (name.length() > 3) ? "Panjang" : "Pendek"
                ));
        map.forEach((k, v) -> {
            System.out.println("Key: " + k + " Value: " + v);
        });

        List<String> list = map.get("Panjang").stream().toList();
        list.forEach(System.out::println);
    }
}
