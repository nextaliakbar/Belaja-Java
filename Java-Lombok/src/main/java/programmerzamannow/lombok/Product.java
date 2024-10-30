package programmerzamannow.lombok;


import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"price"})
//@NoArgsConstructor -> jika terdapat field yang final maka tidak dapat membuat NoArgsConstructor
public class Product {

    private final String id;

    private String name;

    private Long price;
}
