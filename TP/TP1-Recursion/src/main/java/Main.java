public class Main {
    public static void main(String[] args) {

    }

    public static int calcSum(int x, int y) {
        if (y == 0) {
            return x;
        }
        return calcSum(x + 1, y - 1);
    }

    public static String convertIntegerBinary(Integer d) {
        if (d < 2) {
            return d.toString();
        }
        Integer quotient = d / 2;
        Integer rest = d % 2;
        return convertIntegerBinary(quotient) + rest.toString();
    }


    public static int calcFactorial(int i) {
        if (i == 1) {
            return 1;
        }
        return calcFactorial(i - 1) * i;
    }

    public static int calcDifference(int x, int y) {
        if (x == y) {
            return 0;
        }
        return 1 + calcDifference(x, y - 1);
    }

    public static int calcProduct(int x, int y) {
        if (y == 0) {
            return 0;
        }
        return x + calcProduct(x, y - 1);
    }

    public static boolean checkIfIsPrime(int i) {
        return isPrime(i, 2);
    }

    private static boolean isPrime(int d, int i) {
        if (i > Math.sqrt(d)) { //maior que a raiz do nº
            return true;
        }
        if (d % i == 0) {
            return false;
        }
        return isPrime(d, i + 1);
    }

    public static boolean checkIfIsPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }
        return checkIfIsPalindrome(word.substring(1, word.length() - 1));

    }
}
