import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CalculadoraDeITBI {
    public static void main(String[] args) {
        try {
            double valorDaTransacao = obterOValor("Digite o valor de transação do imóvel: R$ ");
            double valorVenal = obterOValor("Digite o valor venal do imóvel: R$ ");
            double percentualITBI = obterOValor("Digite a porcentagem do ITBI: ");

            double impostoITBI = calcularITBI(valorDaTransacao, valorVenal, percentualITBI);

            // Formatar o resultado no padrão brasileiro
            String impostoFormatado = formatarValor(impostoITBI);
            JOptionPane.showMessageDialog(null, "O imposto ITBI a ser pago é: " + impostoFormatado);
        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro: Certifique-se de digitar valores numéricos válidos.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    private static double obterOValor(String mensagem) throws ParseException {
        String valorStr = JOptionPane.showInputDialog(mensagem);
        if (valorStr == null || valorStr.trim().isEmpty()) {
            throw new IllegalArgumentException("O valor informado não pode ser vazio.");
        }

        // Configurar formato brasileiro para interpretar o número
        NumberFormat format = NumberFormat.getInstance(new Locale("pt", "br"));
        return format.parse(valorStr).doubleValue();
    }

    private static String formatarValor(double valor) {
        // Configurar formato brasileiro para exibir o número
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "br"));
        return format.format(valor);
    }

    public static double calcularITBI(double valorDaTransacao, double valorVenal, double percentualITBI) {
        if (valorDaTransacao < 0 || valorVenal < 0 || percentualITBI < 0 || percentualITBI > 100) {
            throw new IllegalArgumentException("Valores inválidos. Verifique os dados.");
        }
        double valorBase = Math.max(valorDaTransacao, valorVenal);
        return valorBase * (percentualITBI / 100);
    }
}

