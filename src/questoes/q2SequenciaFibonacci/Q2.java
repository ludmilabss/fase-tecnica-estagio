package questoes.q2SequenciaFibonacci;

import java.util.Scanner;

public class Q2 {

    public static boolean isFibonacci(int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        int prev = 0, current = 1;
        while (current < n) {
            int next = prev + current;
            prev = current;
            current = next;
        }

        return current == n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Insira um número: ");
        int number = sc.nextInt();

        if (isFibonacci(number)) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " não pertence à sequência de Fibonacci.");
        }

        sc.close();
    }
}
