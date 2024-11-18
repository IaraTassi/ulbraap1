import java.util.Scanner;

public class CircuitoDeResistencia {
    // Método main para execução
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("******************** Circuito de Resistências ********************");
        try {
            System.out.print("\nDigite o valor da primeira resistência: ");
            double resistencia1 = scanner.nextDouble();
            System.out.print("Digite o valor da segunda resistência: ");
            double resistencia2 = scanner.nextDouble();
            System.out.print("Digite o valor da terceira resistência: ");
            double resistencia3 = scanner.nextDouble();
            System.out.print("Digite o valor da quarta resistência: ");
            double resistencia4 = scanner.nextDouble();

            // Criando o objeto da classe com as resistências fornecidas
            CircuitoDeResistencia circuito = new CircuitoDeResistencia(resistencia1, resistencia2, resistencia3, resistencia4);

            // Calculando e exibindo os resultados
            System.out.println("A resistência equivalente é: " + circuito.calcularResistenciaEquivalente() + " Ohms");
            System.out.println("A maior resistência é: " + circuito.obterMaiorResistencia() + " Ohms");
            System.out.println("A menor resistência é: " + circuito.obterMenorResistencia() + " Ohms");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro de entrada. Por favor, insira apenas valores numéricos.");
        } finally {
            scanner.close();
            System.out.print("********************* Encerra programa ***************************");
        }
    }
    private double resistencia1;
    private double resistencia2;
    private double resistencia3;
    private double resistencia4;

    public CircuitoDeResistencia(double resistencia1, double resistencia2, double resistencia3, double resistencia4) {
        if (resistencia1 <= 0 || resistencia2 <= 0 || resistencia3 <= 0 || resistencia4 <= 0) {
            throw new IllegalArgumentException("Resistências devem ser valores positivos.");
        }
        this.resistencia1 = resistencia1;
        this.resistencia2 = resistencia2;
        this.resistencia3 = resistencia3;
        this.resistencia4 = resistencia4;
    }

    // Método para calcular a resistência equivalente
    public double calcularResistenciaEquivalente() {
        return resistencia1 + resistencia2 + resistencia3 + resistencia4;
    }

    // Método para obter a maior resistência
    public double obterMaiorResistencia() {
        return Math.max(Math.max(resistencia1, resistencia2), Math.max(resistencia3, resistencia4));
    }

    // Método para obter a menor resistência
    public double obterMenorResistencia() {
        return Math.min(Math.min(resistencia1, resistencia2), Math.min(resistencia3, resistencia4));
    }


}