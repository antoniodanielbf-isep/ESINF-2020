/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * An implementation of a priority queue using an array-based heap.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author antoniosilva
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /**
     * primary collection of priority queue entries
     */
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    public HeapPriorityQueue() {
        super();
    }

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     *
     * @param comp comparator defining the order of keys in the priority queue
     */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Creates a priority queue initialized with the respective
     * key-value pairs.  The two arrays given will be paired
     * element-by-element. They are presumed to have the same
     * length. (If not, entries will be created only up to the length of
     * the shorter of the arrays)
     *
     * @param keys   an array of the initial keys for the priority queue
     * @param values an array of the initial values for the priority queue
     */
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        for (int j = 0; j < Math.min(keys.length, values.length); j++)
            heap.add(new PQEntry<>(keys[j], values[j]));
        buildHeap();
    }

    // protected utilities
    protected int parent(int j) {
        return (j - 1) / 2;
    }     // truncating division

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    /**
     * Exchanges the entries at indices i and j of the array list.
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap property.
     */
    protected void percolateUp(int j) {
        int ind = (j - 1) / 2;
        while (ind >= 0 && super.compare(heap.get(j), heap.get(ind)) < 0) {
            swap(j, ind);
            j = ind;
            ind = (j - 1) / 2;
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap property.
     */
    protected void percolateDown(int j) {
        int indLeft = j * 2 + 1;
        int indRight = j * 2 + 2;
        boolean swaps = true;

        while (indLeft < heap.size() && swaps) {

            int smallIndex = indLeft;

            if (indRight < heap.size()) {

                if (super.compare(heap.get(indRight), heap.get(indLeft)) < 0) {

                    smallIndex = indRight;

                }

            }

            if (super.compare(heap.get(j), heap.get(smallIndex)) > 0) {

                swap(j, smallIndex);
                j = smallIndex;
                indLeft = 2 * j + 1;
                indRight = 2 * j + 2;

            } else {

                swaps = false;

            }
        }
    }

    /**
     * Performs a batch bottom-up construction of the heap in O(n) time.
     */
    protected void buildHeap() {

        int startIndex = parent(size()-1);
        for(int j=startIndex; j>=0;j--){
            percolateDown(j);
        }
    }



    // public methods

    /**
     * Returns the number of items in the priority queue.
     *
     * @return number of items
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Returns (but does not remove) an entry with minimal key.
     *
     * @return entry having a minimal key (or null if empty)
     */
    @Override
    public Entry<K, V> min() {
        try {
            return this.heap.get(0);
        }catch (IndexOutOfBoundsException ignored){
            return null;
        }
    }

    /**
     * Inserts a key-value pair and return the entry created.
     *
     * @param key   the key of the new entry
     * @param value the associated value of the new entry
     * @return the entry storing the new key-value pair
     * @throws IllegalArgumentException if the key is unacceptable for this queue
     */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        PQEntry<K,V> entry = new PQEntry<>(key,value);
        heap.add(entry);
        percolateUp(heap.size()-1);
        return entry;
    }

    /**
     * Removes and returns an entry with minimal key.
     *
     * @return the removed entry (or null if empty)
     */
    @Override
    public Entry<K, V> removeMin() {
        if(heap.size()==0){
            return null;
        }
        Entry<K,V> entry = heap.remove(0);
        percolateDown(0);
        return entry;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Heap (Key,Value) = [");
        if (heap.isEmpty()) {
            sb.append("]");
        } else {
            for (int i = 0; i < heap.size() - 1; i++) {
                sb.append(String.format("(%s,%s), ", heap.get(i).getKey(), heap.get(i).getValue()));
            }
            Entry<K, V> finalEntry = heap.get(heap.size() - 1);
            sb.append(String.format("(%s,%s)]", finalEntry.getKey(), finalEntry.getValue()));
        }
        sb.append(String.format(", size=%d", heap.size()));
        return sb.toString();
    }


    @Override
    public HeapPriorityQueue<K, V> clone() {
        HeapPriorityQueue<K,V> newHeap = new HeapPriorityQueue<>(comp);
        for(Entry<K,V> entry:heap){
            newHeap.insert(entry.getKey(), entry.getValue());
        }
        return newHeap;
    }

    //exercicio 5
    public List<V> ElemslastCompleteLevel(){
        List<V> nodes = new ArrayList<>();
        int total = 0;
        int numberNodes = 0;
        int level = 1;
        int size = this.heap.size();
        while(total < size){
            total += Math.pow(2, level-1);
            level++;
        }

        if(total != size){
            level--;
            numberNodes = (int) Math.pow(2, level-1);
        }
        int index = (int) Math.pow(2, level-1)-1;
        for(int i = index; i < numberNodes; i++){
            nodes.add(heap.get(i).getValue());
        }
        return nodes;
    }

}

