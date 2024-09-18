package questoes.q5InverterCaracteres;

import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a string a ser invertida: ");
        String s = sc.nextLine();

        String reversed = inverterString(s);

        System.out.println("String invertida: " + reversed);
    }

    public static String inverterString(String s) {
        char[] caracteres = s.toCharArray();
        int esquerda = 0;
        int direita = caracteres.length - 1;

        while (esquerda < direita) {
            char aux = caracteres[esquerda];
            caracteres[esquerda] = caracteres[direita];
            caracteres[direita] = aux;
            esquerda++;
            direita--;
        }
        return new String(caracteres);
    }
}
