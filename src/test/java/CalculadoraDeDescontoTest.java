import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeDescontoTest {

    @Test
    void deveTestarCalculoDeDescontoValido() {
        // Arrange
        double valorDoProduto = 100.0;
        double porcentagemDeDesconto = 10.0;

        // Act
        double resultado = CalculadoraDeDesconto.calcularDesconto(valorDoProduto, porcentagemDeDesconto);

        // Assert
        assertEquals(90.0, resultado, 0.01, "O desconto de 10% sobre R$100 deve resultar em R$90.");
    }

    @Test
    void deveTestarValorDoProdutoNegativo() {
        // Arrange
        double valorDoProduto = -50.0;
        double porcentagemDeDesconto = 10.0;

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CalculadoraDeDesconto.calcularDesconto(valorDoProduto, porcentagemDeDesconto)
        );
        assertEquals("O valor do produto não pode ser negativo.", exception.getMessage());
    }

    @Test
    void deveTestarPorcentagemDeDescontoNegativa() {
        // Arrange
        double valorDoProduto = 100.0;
        double porcentagemDeDesconto = -5.0;

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CalculadoraDeDesconto.calcularDesconto(valorDoProduto, porcentagemDeDesconto)
        );
        assertEquals("A porcentagem de desconto deve estar entre 0 e 100.", exception.getMessage());
    }

    @Test
    void deveTestarPorcentagemDeDescontoAcimaDeCem() {
        // Arrange
        double valorDoProduto = 100.0;
        double porcentagemDeDesconto = 120.0;

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CalculadoraDeDesconto.calcularDesconto(valorDoProduto, porcentagemDeDesconto)
        );
        assertEquals("A porcentagem de desconto deve estar entre 0 e 100.", exception.getMessage());
    }

    @Test
    void deveTestarCalculoDeDescontoZeroPorcento() {
        // Arrange
        double valorDoProduto = 200.0;
        double porcentagemDeDesconto = 0.0;

        // Act
        double resultado = CalculadoraDeDesconto.calcularDesconto(valorDoProduto, porcentagemDeDesconto);

        // Assert
        assertEquals(200.0, resultado, 0.01, "Com desconto de 0%, o valor final deve ser igual ao original.");
    }

    @Test
    void deveTestarCalculoDeDescontoCemPorcento() {
        // Arrange
        double valorDoProduto = 250.0;
        double porcentagemDeDesconto = 100.0;

        // Act
        double resultado = CalculadoraDeDesconto.calcularDesconto(valorDoProduto, porcentagemDeDesconto);

        // Assert
        assertEquals(0.0, resultado, 0.01, "Com desconto de 100%, o valor final deve ser R$0.");
    }
}


