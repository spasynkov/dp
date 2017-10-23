package wrapper.decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseClassDecorator {

    private List<String> list = new ArrayList<>(
            Arrays.asList(
                    "a", "b", "c"));

    // работа с базовым классом

    public String decoratedMethod() {
        return list.stream()
                .reduce("", (previousValue, newValue) -> previousValue + newValue);
    }
}
