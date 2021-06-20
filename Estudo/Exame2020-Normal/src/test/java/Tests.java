import Priority_queue.AbstractPriorityQueue;
import Priority_queue.HeapPriorityQueue;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Tests {

    @Test
    void mergeListsTest() {
        List<Pair<String, Integer>> A = new ArrayList<>();
        A.add(new Pair("A", 2));
        A.add(new Pair("A", 2));
        A.add(new Pair("A", 6));

        List<Pair<String, Integer>> B = new ArrayList<>();
        B.add(new Pair("B", 1));
        B.add(new Pair("B", 1));
        B.add(new Pair("B", 2));
        B.add(new Pair("B", 3));
        B.add(new Pair("B", 4));
        B.add(new Pair("B", 4));
        B.add(new Pair("B", 5));

        List<Pair<String, Integer>> expected = new ArrayList<>();
        expected.add(new Pair("B", 1));
        expected.add(new Pair("B", 1));
        expected.add(new Pair("A", 2));
        expected.add(new Pair("B", 2));
        expected.add(new Pair("A", 2));
        expected.add(new Pair("B", 3));
        expected.add(new Pair("B", 4));
        expected.add(new Pair("B", 4));
        expected.add(new Pair("B", 5));
        expected.add(new Pair("A", 6));

        assertEquals(expected.toString(), Main.mergeLists(A, B).toString());
    }

    @Test
    void mergeHeapsTest() {
        HeapPriorityQueue<Integer, String> hp1 = new HeapPriorityQueue<>();
        hp1.insert(1, "um");
        hp1.insert(2, "dois");

        HeapPriorityQueue<Integer, String> hp2 = new HeapPriorityQueue<>();
        hp2.insert(0, "zero");
        hp2.insert(1, "aum");

        HeapPriorityQueue<Integer, String> expected = new HeapPriorityQueue<>();
        expected.insert(0, "zero");
        expected.insert(1, "aum");
        expected.insert(1, "um");
        expected.insert(2, "dois");

        assertEquals(expected.toString(), AbstractPriorityQueue.mergeHeaps(hp1, hp2).toString());
    }
}

