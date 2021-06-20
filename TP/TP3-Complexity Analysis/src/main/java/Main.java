public class Main {
    public static void main(String[] args) {
        Integer a[] = {6, 1, 4, 1, 7, 3, 1, 7};
        System.out.println(mistery1(a));
        System.out.println("-------------------------------");
        int b[] = {1, 13, 17, 18, 22, 33, 35, 38};
        System.out.println(mystery2(b, 35));
        System.out.println("-------------------------------");
        System.out.println(mystery2Optimidez(b, 35));

    }

    /**
     * 1. Consider the following code:
     */
    public static <T extends Comparable<T>> int mistery1(T[] v) {
        int cont = 0;
        for (int i = 0; i < v.length; i++) {
            cont++;
            boolean sing = true;
            for (int j = i + 1; j < v.length; j++)
                if (v[i].compareTo(v[j]) == 0)
                    sing = false;
            if (!sing)
                cont--;
        }
        return cont;
    }
    /**
     * a) Explain what the mistery1 method do and show what is the result applied to the vector
     * a[8]={6,1,4,1,7,3,1,7} mystery1(a).
     */
    /*
Conta quantidade de números diferentes no array.
     */
    /**
     * b) Analyze temporal complexity following Big-Oh notation. Justify.
     */
    /*
Determinístico O(n^2)-> dois ciclos for
     */

    /**
     * 2. Consider the following method to process an ordered sequence of numbers not repeated:
     */
    public static boolean mystery2(int[] A, int value) {
        boolean flag = false;
        int count = 0;

        for (int i = 0; i < (A.length - 1); i++)
            for (int j = i + 1; j < A.length; j++) {

                if (A[i] + A[j] == value) {
                    flag = true;
                    System.out.println("pos " + i + "->" + A[i] + ", pos " + j + "->" + A[j]);
                }
            }
        System.out.println(count);
        return flag;
    }
    /**
     *a) Explain what the code above do and present the result applied to the vector
     *a[7]={1,13,17,18,22,33,35,38} and mystery2(a,35).
     */
/*
O algoritmo soma os valores dois a dois do vetor e imprime para a consola os que derem valor igual a value que é
passado por parâmetro.
 */
    /**
     * b) Validate if the mystery method is deterministic or non-deterministic and analyze temporal complexity
     * following Big-Oh notation. Justify
     */
/*
Determinístico- O(n^2)-> dois ciclos for
 */

    /**
     * c) Propose a more efficient solution.
     */
    public static boolean mystery2Optimidez(int[] a, int value) {
        boolean flag = false;
        int i = 0;

        while (i < a.length - 1) {
            if (a[i] > value || a[i + 1] > value) {
                break;
            }
            for (int j = i + 1; j < a.length; j++) {
                if ((a[i] + a[j]) == value) {
                    flag = true;
                    System.out.println("pos " + i + "->" + a[i] + ", pos " + j + "->" + a[j]);
                }
            }
            i++;
        }
        return flag;
    }

    /**
     * 3. Consider the following code and validate if the method is deterministic or non-deterministic and
     * analyse temporal complexity following Big-Oh notation. Justify.
     */
    public double power(double b, int e) {

        if (e == 0)
            return 1;
        if (e == 1)
            return b;
        if (e % 2 == 0)
            return power(b * b, e / 2);
        else
            return b * power(b * b, e / 2);
    }
    /*
    É um algoritmo não determinístico pois caso o valor de e seja 0 ou 1 o algoritmo tem complexidade O(1)
    caso não seja 0 nem 1 então a complexidade visto que o valor de e é dividido por 2 em cada chamada À funcão
    recursiva passa a a ser O(log(n))
     */
}
