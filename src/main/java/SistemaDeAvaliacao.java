import javax.swing.JOptionPane;

public class SistemaDeAvaliacao {

    public static void main(String[] args) {

        try {
            // Entrada de dados com JOptionPane
            String notaDaProva1Str = JOptionPane.showInputDialog("Digite a nota da primeira prova: ");
            double notaDaProva1 = Double.parseDouble(notaDaProva1Str);

            String notaDaProva2Str = JOptionPane.showInputDialog("Digite a nota da segunda prova: ");
            double notaDaProva2 = Double.parseDouble(notaDaProva2Str);

            String notaDoTrabalhoStr = JOptionPane.showInputDialog("Digite a nota do trabalho: ");
            double notaDoTrabalho = Double.parseDouble(notaDoTrabalhoStr);

            // Validar as notas
            if (!validarAsNotas(notaDaProva1, notaDaProva2, notaDoTrabalho)) {
                JOptionPane.showMessageDialog(null, "Erro: As notas devem ser entre 0 e 10.");
                return;
            }

            // Calcular a média
            double media = calcularAMedia(notaDaProva1, notaDaProva2, notaDoTrabalho);

            // Verificar se o aluno foi aprovado ou reprovado
            String verificarAMedia = verificarAMedia(media);

            // Exibir a média e verificar a media do aluno
            JOptionPane.showMessageDialog(null, String.format("Média: %s\nSituação: %s", media, verificarAMedia));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Certifique-se de digitar valores numéricos válidos.");
        }
    }

    // Método para calcular a média
    public static double calcularAMedia(double notaDaProva1, double notaDaProva2, double notaDoTrabalho) {
        return (notaDaProva1 + notaDaProva2 + notaDoTrabalho) / 3;
    }

    // Método para verificar a media do aluno
    public static String verificarAMedia(double media) {
        return media >= 6 ? "Aprovado" : "Reprovado";
    }

    // Método para validar as notas
    public static boolean validarAsNotas(double notaDaProva1, double notaDaProva2, double notaDoTrabalho) {
        return notaDaProva1 >= 0 && notaDaProva2 >= 0 && notaDoTrabalho >= 0 &&
                notaDaProva1 <= 10 && notaDaProva2 <= 10 && notaDoTrabalho <= 10;
    }

}

