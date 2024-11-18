import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraDeDesconto {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("*************** Calculadora de Desconto **********************");
        try {
            System.out.print("\nDigite o valor do produto: R$ ");
            double valorDoProduto = scanner.nextDouble();
            System.out.print("Digite a porcentagem (%) de desconto do produto: ");
            double porcentagemDeDesconto = scanner.nextDouble();

            double valorFinalDoProduto = calcularDesconto(valorDoProduto, porcentagemDeDesconto);
            System.out.printf("Valor do desconto: R$ %.2f%n", valorDoProduto - valorFinalDoProduto);
            System.out.printf("Valor final do produto: R$ %.2f%n", valorFinalDoProduto);
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de digitar números.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("*************** Programa encerrado. **************************");
        }
    }

    public static double calcularDesconto(double valorDoProduto, double porcentagemDoProduto) {
        if (valorDoProduto < 0) {
            throw new IllegalArgumentException("O valor do produto não pode ser negativo.");
        }
        if (porcentagemDoProduto < 0 || porcentagemDoProduto > 100) {
            throw new IllegalArgumentException("A porcentagem de desconto deve estar entre 0 e 100.");
        }

        double valorDoDesconto = (valorDoProduto * porcentagemDoProduto) / 100;
        return valorDoProduto - valorDoDesconto;
    }
}





