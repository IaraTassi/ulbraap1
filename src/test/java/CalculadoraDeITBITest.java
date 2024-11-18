import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeITBITest {

    @Test
    void deveTestarCalculoITBIComValorDeTransacaoMaior() {
        // Arrange
        double valorDaTransacao = 500_000.0;
        double valorVenal = 450_000.0;
        double percentualITBI = 2.0;

        // Act
        double resultado = CalculadoraDeITBI.calcularITBI(valorDaTransacao, valorVenal, percentualITBI);

        // Assert
        assertEquals(10_000.0, resultado, 0.01, "O imposto deve ser calculado com base no valor da transação.");
    }

    @Test
    void deveTestarCalculoITBIComValorVenalMaior() {
        // Arrange
        double valorDaTransacao = 300_000.0;
        double valorVenal = 400_000.0;
        double percentualITBI = 3.0;

        // Act
        double resultado = CalculadoraDeITBI.calcularITBI(valorVenal, valorDaTransacao, percentualITBI);

        // Assert
        assertEquals(12_000.0, resultado, 0.01, "O imposto deve ser calculado com base no valor venal.");
    }

    @Test
    void deveTestarValoresNegativos() {
        // Arrange
        double valorDaTransacao = -100_000.0;
        double valorVenal = 200_000.0;
        double percentualITBI = 2.0;

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CalculadoraDeITBI.calcularITBI(valorDaTransacao, valorVenal, percentualITBI)
        );
        assertEquals("Valores inválidos. Verifique os dados.", exception.getMessage());
    }

    @Test
    void deveTestarPercentualITBIMaiorQueCem() {
        // Arrange
        double valorDaTransacao = 300_000.0;
        double valorVenal = 250_000.0;
        double percentualITBI = 110.0;

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CalculadoraDeITBI.calcularITBI(valorDaTransacao, valorVenal, percentualITBI)
        );
        assertEquals("Valores inválidos. Verifique os dados.", exception.getMessage());
    }

    @Test
    void deveTestarCalculoITBIComPercentualZero() {
        // Arrange
        double valorDaTransacao = 400_000.0;
        double valorVenal = 380_000.0;
        double percentualITBI = 0.0;

        // Act
        double resultado = CalculadoraDeITBI.calcularITBI(valorDaTransacao, valorVenal, percentualITBI);

        // Assert
        assertEquals(0.0, resultado, 0.01, "Com percentual de ITBI zero, o imposto deve ser zero.");
    }

    @Test
    void deveTestarCalculoITBIComValoresIguais() {
        // Arrange
        double valorDaTransacao = 350_000.0;
        double valorVenal = 350_000.0;
        double percentualITBI = 1.5;

        // Act
        double resultado = CalculadoraDeITBI.calcularITBI(valorDaTransacao, valorVenal, percentualITBI);

        // Assert
        assertEquals(5_250.0, resultado, 0.01, "Com valores iguais, o cálculo deve funcionar corretamente.");
    }
}



