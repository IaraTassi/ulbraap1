import java.util.Scanner;

public class CalculadoraDeAposentadoria {
    public static void main(String[] args) {

        System.out.println("************** Calculadora de Aposentadoria ***************");
        try (Scanner scanner = new Scanner(System.in)) {
            // Entrada de dados
            System.out.print("Digite sua idade: ");
            int idade = Integer.parseInt(scanner.nextLine());

            System.out.print("Digite seu sexo (M para masculino, F para feminino): ");
            String sexo = scanner.nextLine().toUpperCase();

            System.out.print("Digite seus anos de contribuição: ");
            int anosContribuicao = Integer.parseInt(scanner.nextLine());

            // Validação de entrada
            if (!sexo.equals("M") && !sexo.equals("F")) {
                throw new IllegalArgumentException("Sexo inválido. Use 'M' ou 'F'.");
            }

            // Verificação de aposentadoria
            boolean podeAposentarPorIdade = podeAposentarPorIdade(idade, sexo);
            boolean podeAposentarPorContribuicao = podeAposentarPorContribuicao(anosContribuicao, sexo);

            if (podeAposentarPorIdade || podeAposentarPorContribuicao) {
                System.out.println("Você já pode se aposentar!");
            } else {
                String tempoFaltante = calcularTempoFaltante(idade, anosContribuicao, sexo);
                System.out.println("Você ainda não pode se aposentar.");
                System.out.println(tempoFaltante);
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Você deve informar números válidos para idade e anos de contribuição.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("****************** Encerra o programa. ********************");
    }

    public static boolean podeAposentarPorIdade(int idade, String sexo) {
        int idadeMinima = sexo.equals("M") ? 65 : 60;
        return idade >= idadeMinima;
    }

    public static boolean podeAposentarPorContribuicao(int anosContribuicao, String sexo) {
        int tempoContribuicaoMinimo = sexo.equals("M") ? 35 : 30;
        return anosContribuicao >= tempoContribuicaoMinimo;
    }

    public static String calcularTempoFaltante(int idade, int anosContribuicao, String sexo) {
        int idadeMinima = sexo.equals("M") ? 65 : 60;
        int tempoContribuicaoMinimo = sexo.equals("M") ? 35 : 30;

        int anosFaltantesIdade = Math.max(0, idadeMinima - idade);
        int anosFaltantesContribuicao = Math.max(0, tempoContribuicaoMinimo - anosContribuicao);

        return String.format("Faltam %d ano(s) para atingir a idade mínima. Faltam %d ano(s) para atingir o tempo de contribuição.",
                anosFaltantesIdade, anosFaltantesContribuicao);
    }
}




