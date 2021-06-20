import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<String>();
        nomes.add("Bob");
        nomes.add("Mary");
        nomes.add("Steve");
        nomes.add("Derek");
        nomes.add("Mary");
        nomes.add("Derek");
        nomes.add("Joe");
        nomes.add("Derek");
        nomes.add("Nicole");
        nomes.add("Mary");

        List<String> apelidos = new ArrayList<String>();
        apelidos.add("Jones");
        apelidos.add("Ford");
        apelidos.add("Akers");
        apelidos.add("Smith");
        apelidos.add("Giles");
        apelidos.add("Smith");
        apelidos.add("Caiu");
        apelidos.add("Jones");
        apelidos.add("Jones");
        apelidos.add("Stepp");

        System.out.println(commonFirstName(nomes, apelidos));
        Integer[] keys = {3,5,9,6,8,20,10,12,18};
        String[] values = {"3","5","9","6","8","20","10","12","18"};
        HeapPriorityQueue<String, Integer> heap = new HeapPriorityQueue(keys, values);
        for(Entry<String, Integer> num : heap.heap) System.out.println(num.getValue());
        System.out.println(heap.getElemsLevel2(3));
    }

    //exercicio 1
    public static String commonFirstName(List<String> names, List<String> nicknames) {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        for (int i = 0, j = 0; i < names.size() && j < nicknames.size(); i++, j++) {
            if (!map.containsKey(names.get(i))) {
                Set<String> l = new HashSet<String>();
                l.add(nicknames.get(j));
                map.put(names.get(i), l);
            } else {
                map.get(names.get(i)).add(nicknames.get(j));
            }
        }

        int biggest = 0;
        String result = "";
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > biggest) {
                biggest = entry.getValue().size();
                result = entry.getKey();
            }
        }
        return result;
    }

    //exercicio 2
    public static int mistery(Integer[] a, int n, Integer x) {

        if (a[n - 1] < x)
            return n;

        if (a[0] >= x)
            return 0;

        int l = 0, u = n - 1;
        while (l < u) {
            int m = (l + u) / 2;
            if (a[m] < x)
                l = m + 1;
            else
                u = m;
        }
        return l;
    }

    //a)
    //b) log(n)

    //exercicio 3 feito na classe TREE


}
