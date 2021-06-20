import graphbase.Graph;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] C = {1, 2, 4, 6, 8, 10, 12, 14};
        System.out.println(misteryComTracagem(C, C.length, 10));


        Graph<String, String> g = new Graph<>(false);
    }

    /**
     * 1. Escreva um método que recebe como parâmetros duas listas de strings, uma das quais é uma lista de nomes e a outra é a
     * correspondente lista dos apelidos, e retorna o primeiro nome associado ao maior número de apelidos distintos. Considere
     * as duas seguintes listas:
     * nomes: [Bob, Mary, Steve, Derek, Mary, Derek, Joe, Derek, Nicole, Mary]
     * apelidos: [Jones, Ford, Akers, Smith, Giles, Smith, Caiu, Jones, Jones, Stepp]
     * Ao primeiro nome (índice 0, lista nomes) corresponde o primeiro apelido (índice 0, lista apelidos); ao nome no índice 1
     * corresponde o apelido no índice 1; e assim sucessivamente, ou seja, ambas as listas têm o mesmo comprimento.
     * Para as listas acima o método deve devolver "Mary" pois Mary tem associado três apelidos (Ford, Giles e Stepp), e todos os
     * outros nomes estão associados apenas a um ou dois apelidos distintos.
     * Considere a seguinte assinatura
     * public static String commonFirstName(List<String> names, List<String> nicknames)
     * Nota: Será valorizada uma resolução o mais eficiente possível e com o menor número de estruturas de dados
     */
    public static String commonFirstName(List<String> names, List<String> nicknames) {

        if (names.size() != nicknames.size()) {
            throw new IllegalArgumentException("Different Size");
        }
        boolean find = false;
        int maxOcorrencias = 0;
        String maisRepetido = "";
        int ocorrencias = 0;
        List<String> temp = new ArrayList<>();
        while (!find) {


            for (int i = 0; i < names.size(); i++) {
                ocorrencias = 0;
                temp = new ArrayList<>();
                for (int j = i; j < names.size(); j++) {
                    if (names.get(i).equalsIgnoreCase(names.get(j))) {
                        ocorrencias++;
                        if (temp.contains(nicknames.get(j))) {
                            ocorrencias--;
                        }
                        temp.add(nicknames.get(j));
                    }
                }

                if (ocorrencias > maxOcorrencias) {
                    maxOcorrencias = ocorrencias;
                    maisRepetido = names.get(i);
                    find = true;

                }
            }

        }
        return maisRepetido;
    }

    /**
     * 2. Considere a seguinte função recebe um vetor ordenado de inteiros
     */
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

    /**
     * a) Explique sucintamente o que o método mistery faz e diga qual o resultado quando invocado
     * Integer[] C = {1,2,4,6,8,10,12,14};
     * mistery (C, C.length, 10);
     */
    /*
Se Como a primeira condição e a segunda não se verificam ou seja nem o elemento
a[n-1] é menor que x nem a[0] >=x então o algoritmo inicia um ciclo while onde para o valor inicial de l =0
enquanto ele for menor que u que neste caso será 7 este irá somar o valor contido em l com u
e posteriormente irá dividir esse valor por dois a caso o valor de a[m] seja inferior a x
então o valor de l passa ao valor correspondente à versão seguinte do array senão o u =m
no final retorna o valor de l.
Nesta situação retorna 5:

     */
    public static int misteryComTracagem(Integer[] a, int n, Integer x) {

        if (a[n - 1] < x)
            return n;

        if (a[0] >= x)
            return 0;

        int l = 0, u = n - 1;
        while (l < u) {
            boolean condition = (l < u);
            System.out.println(l + " <" + u + " ?=" + condition);
            int m = (l + u) / 2;
            System.out.println(m);
            if (a[m] < x) {
                boolean c2 = (a[m] < x);
                System.out.println("a[m] < x ? " + c2);
                l = m + 1;
                System.out.println("l= " + l);
            } else {
                u = m;
                System.out.println("u=" + u);

            }
            System.out.println("l= " + l);
            System.out.println("----------------------------");
        }
        return l;
    }

    /**
     * b) Analise o algoritmo quanto à sua complexidade temporal, utilizando a notação Big-Oh. Justifique adequadamente.
     */
    /*
    O algoritmo é não determinístico pois depende do input caso a[n-1]<x ou a[0]>=x a complexidade será de O(1),
    ou seja sendo este o melhor caso e no pior caso será ter de percorrer o ciclo while n vezes O(n) o que já depende
    do tamanho do array e do seu conteúdo.
     */

}
