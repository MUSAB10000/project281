import java.util.Scanner;

public class me {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value for a: ");
        int a = scanner.nextInt();

        System.out.println("Enter the value for b: ");
        int b = scanner.nextInt();

        System.out.println("Enter the value for c: ");
        int c = scanner.nextInt();

        System.out.println("Enter the value for p: ");
        int p = scanner.nextInt();

        int d = (b * b - 4 * a * c) % p;
        if (d < 0) {
            d += p;
        }

        int[] solutions = new int[2];

        if (modularExponentiation(d, (p - 1) / 2, p) != 1) {
            System.out.println("NO SOLUTION");
        } else {
            solutions[0] = (int) ((-b + Math.sqrt(d)) * modInverse(2 * a, p)) % p;
            solutions[1] = (int) ((-b - Math.sqrt(d)) * modInverse(2 * a, p)) % p;

            if (solutions[0] < 0) {
                solutions[0] += p;
            }
            if (solutions[1] < 0) {
                solutions[1] += p;
            }

            System.out.println("Solutions:");
            System.out.print("x { " + solutions[0] + ",");
            System.out.println(solutions[1] + "}");
        }
    }

    private static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return 1;
    }

    private static int modularExponentiation(int base, int exponent, int mod) {
        int result = 1;
        base = base % mod;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            exponent >>= 1;
            base = (base * base) % mod;
        }
        return result;
    }

    private static int findYValue(int d, int p) {
        int y = 1;
        while (true) {
            int temp = (y * y) % p;
            if (temp == d) {
                return y;
            }
            y++;
        }
    }
}
