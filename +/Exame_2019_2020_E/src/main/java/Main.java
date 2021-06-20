import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(converteValorEmMoedas(30.64));
        TREE<Integer> tree = new TREE<>();
        tree.insert(17);
        tree.insert(5);
        tree.insert(35);
        tree.insert(2);
        tree.insert(11);
        tree.insert(9);
        tree.insert(16);
        tree.insert(7);
        tree.insert(29);
        tree.insert(38);
        System.out.println(tree.inOrderSuccessor(5));
    }

    static Map<Integer, List<String>> converteValorEmMoedas(Double valor){
        Map<Integer, List<String>> map = new TreeMap(Collections.reverseOrder());
        double[] valores = new double[]{2.0, 1.0, 0.2, 0.05, 0.01};
        String[] moedas = new String[]{"2eur", "1eur", "20cent", "5cent", "1cent"};
        int i = 0;
        valor += 0.001;
        while (i < 5) {
            int count = (int) (valor / valores[i]);
            if (count != 0) {
                if (!map.containsKey(count)) {
                    map.put(count, new ArrayList());
                }
                map.get(count).add(moedas[i]);
                valor -= valores[i] * count;
            }
            i++;
        }
        return map;
    }


    void exemplo (int a[], int n) {
        int x = n/2;
        if (n > 0){
            exemplo(a,x);
            for (int i=0; i<n; i++)
                a[i] *= 2;
        }
    }

    //a) divide o array em metade e multiplica essa metade por 2 sucessivamente multiplicando os numeros por 2
    // ou seja fica 844222.
    //b) nlog(n)

    //exercicio 4
    public Graph<String,Integer> buildGraphbyItineraries (Set<List<String>> itineraries){
        Graph<String,Integer> graph = new Graph<>(false);
        for(List<String> l : itineraries){
            for(int i = 0; i < l.size()-1; i++){
                Edge<String, Integer> edge = graph.getEdge(l.get(i), l.get(i+1));
                if(edge != null){
                    edge.setElement(edge.getElement()+1);
                }else{
                    graph.insertEdge(l.get(i), l.get(i+1), 0, graph.getDirectDistance(l.get(i), l.get(i+1)));
                }
            }
        }
        return graph;
    }




}
