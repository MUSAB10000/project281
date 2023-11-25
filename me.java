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
        if (a % p != 0) {
            int d = (b * b - 4 * a * c) % p;
            int y = (4 * a + b);
            int[] solutions = new int[2];

            if (d % p == 0) {
                System.out.println("y=0");
            } else {
                if (modularExponentiation(d, (p - 1) / 2, p) != 1) {
                    System.out.println("NO SOLUTION");
                } else {
                    solutions[0] = (int) ((-b + convertToPerfectSquare(d, p))/*
                                                                              * can do more simple by using Math.squr(d)
                                                                              */ * modInverse(2 * a, p)) % p;
                    solutions[1] = (int) ((-b - convertToPerfectSquare(d, p))/*
                                                                              * can do more simple by using Math.squr(d)
                                                                              */ * modInverse(2 * a, p)) % p;

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

    private static int modularExponentiation(int base, int power, int mod) {
        if (mod == 1) {
            return 0;
        }

        long result = 1;
        base = base % mod;
        while (power > 0) {
            if (power % 2 == 1) {
                result = (result * base) % mod;
            }
            power = power / 2;
            base = (base * base) % mod;
        }
        return (int) result;
    }

    private static int convertToPerfectSquare(int d, int p) {
        for (int x = 0; x < p; x++) {
            int temp = (x * x) % p;
            if (temp == d) {
                return x;
            }
        }
        return -1;
    }
}
