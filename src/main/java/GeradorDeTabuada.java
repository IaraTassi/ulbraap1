import java.util.Scanner;

public class GeradorDeTabuada {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("****************** Gerador de tabuada *********************");
        try {
            System.out.print("Digite um número para gerar a tabuada: ");
            int numero = scanner.nextInt();

            if (numero < 0) {
                throw new IllegalArgumentException("Número deve ser maior ou igual a zero.");
            }

            gerarTabuada(numero);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("****************** Encerra o programa. *********************");
        }
    }

    public static void gerarTabuada(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número deve ser maior ou igual a zero.");
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}





