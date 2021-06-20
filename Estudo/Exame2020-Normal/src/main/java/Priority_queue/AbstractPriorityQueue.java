/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Priority_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * An abstract base class to ease the implementation of the PriorityQueue interface.
 * <p>
 * The base class provides four means of support:
 * 1) It defines a PQEntry class as a concrete implementation of the
 * entry interface
 * 2) It provides an instance variable for a general Comparator and a
 * protected method, compare(a, b), that makes use of the comparator.
 * 3) It provides a boolean checkKey method that verifies that a given key
 * is appropriate for use with the comparator
 * 4) It provides an isEmpty implementation based upon the abstract size() method.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    //---------------- nested PQEntry class ----------------

    /**
     * The comparator defining the ordering of keys in the priority queue.
     */
    private Comparator<K> comp;

    // instance variable for an AbstractPriorityQueue

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     *
     * @param c comparator defining the order of keys in the priority queue
     */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    public static HeapPriorityQueue<Integer, String> mergeHeaps(HeapPriorityQueue<Integer, String> hp1,
                                                                HeapPriorityQueue<Integer, String> hp2) {
        HeapPriorityQueue<Integer, String> result = new HeapPriorityQueue<>();

        List<Entry<Integer, String>> aux = new ArrayList<>();

        hp1.heap.addAll(hp2.heap);


        for (Entry<Integer, String> entrada : hp1.heap) {
            aux.add(entrada);
        }

        Collections.sort(aux, new Comparator<Entry<Integer, String>>() {
            @Override
            public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
                if (o1.getKey() == o2.getKey()) {
                    return o1.getValue().compareTo(o2.getValue());
                }
                return o1.getKey() - o2.getKey();
            }
        });


        for (Entry<Integer, String> par : aux) {
            result.insert(par.getKey(), par.getValue());
        }
        return result;
    }

    /**
     * Method for comparing two entries according to key
     */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * Determines whether a key is valid.
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0);  // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    /**
     * Tests whether the priority queue is empty.
     *
     * @return true if the priority queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * A concrete implementation of the Entry interface to be used within
     * a PriorityQueue implementation.
     */
    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K k;  // key
        private V v;  // value

        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }

        // methods of the Entry interface
        public K getKey() {
            return k;
        }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K key) {
            k = key;
        }

        public V getValue() {
            return v;
        }

        protected void setValue(V value) {
            v = value;
        }
    } //----------- end of nested PQEntry class -----------
}

