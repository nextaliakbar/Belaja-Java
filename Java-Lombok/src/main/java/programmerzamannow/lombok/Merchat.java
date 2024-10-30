package programmerzamannow.lombok;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Merchat {

    private final String id;

    private String name;
}
