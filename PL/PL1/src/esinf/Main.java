package esinf;

public class Main {
    public static void main(String[] args) {

    }

    public static String sameString(String word) {
        if (word.length() == 0) {
            return "";
        }
        return word.substring(0, word.length() - 1) + word.charAt(word.length() - 1) + "";
    }

    //ou
 /*   public static String sameString(String word) {
        if (word.length() == 0) {
            return "";
        }
        return word.charAt(0) + "" + sameString(word.substring(1));
    }
  */
    public static String inverseString(String word) {
        if (word.length() == 0) {
            return "";
        }
        return word.charAt(word.length() - 1) + "" + inverseString(word.substring(0, word.length() - 1));
    }

    public static int findMax(int[] array, int index) {
        if (index > 0) {
            return Math.max(array[index], index - 1);
        } else {
            return array[0];
        }
    }

    public static int mdc(int a, int b) {
        int x = Integer.max(a, b);
        int y = Integer.min(a, b);
        if (x % y == 0) {
            return y;
        }
        return mdc(y, x % y);
    }

    public static int convertToInteger(String word, int acm) {
        if (word.length() == 0) {
            return acm;
        }
        int n = Integer.parseInt("" + word.charAt(0));
        return convertToInteger(word.substring(1), acm * 10 + n);
    }

    public static boolean isNumberPalindrome(int num) {
        if (num < 10) {
            return true;
        }
        int digitoDireito = num % 10;    //resto da divisão por 10
        int digitos = (int) Math.log10(num);
        int potenciaBase10 = (int) Math.pow(10, digitos);
        int digitoEsquerdo = num / potenciaBase10;

        if (digitoDireito != digitoEsquerdo) {
            return false;
        }

        int nn = num - digitoEsquerdo * potenciaBase10; //remove esquerda;
        nn = nn / 10;                  //remove direita;

        return isNumberPalindrome(nn);

    }

    public static int sumArrayBiDimensional(int[][] vetor, int inicio) {
        throw new UnsupportedOperationException();

    }
}
