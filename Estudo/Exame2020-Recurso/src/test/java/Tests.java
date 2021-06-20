import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Tests {
    @Test
    void commonFirstNameTest1() {
        List<String> names = new ArrayList<>();
        names.add("Bob");
        names.add("Mary");
        names.add("Steve");
        names.add("Derek");
        names.add("Mary");
        names.add("Derek");
        names.add("Joe");
        names.add("Derek");
        names.add("Nicole");
        names.add("Mary");

        List<String> nickNames = new ArrayList<>();
        nickNames.add("Jones");
        nickNames.add("Ford");
        nickNames.add("Akers");
        nickNames.add("Smith");
        nickNames.add("Giles");
        nickNames.add("Smith");
        nickNames.add("Caiu");
        nickNames.add("Jones");
        nickNames.add("Jones");
        nickNames.add("Stepp");
        assertEquals("Mary", Main.commonFirstName(names, nickNames));
    }

    @Test
    void commonFirstNameTest2() {
        List<String> names = new ArrayList<>();
        names.add("Bob");
        names.add("Mary");
        names.add("Steve");
        names.add("Derek");
        names.add("Mary");
        names.add("Derek");
        names.add("Joe");
        names.add("Derek");
        names.add("Nicole");
        names.add("Mary");

        List<String> nickNames = new ArrayList<>();
        nickNames.add("Jones");
        nickNames.add("Ford");
        nickNames.add("Akers");
        nickNames.add("Smith");
        nickNames.add("Giles");
        nickNames.add("ry");
        nickNames.add("Caiu");
        nickNames.add("rr");
        nickNames.add("Jones");
        nickNames.add("Ford");
        assertEquals("Derek", Main.commonFirstName(names, nickNames));
    }
}