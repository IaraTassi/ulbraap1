import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeradorDeTabuadaTest {

    @Test
    void deveTestarGerarTabuadaValida() {
        // Arrange
        int numero = 5;

        // Act
        StringBuilder resultado = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            resultado.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
        }

        // Assert
        assertEquals(
                "5 x 1 = 5\n5 x 2 = 10\n5 x 3 = 15\n5 x 4 = 20\n5 x 5 = 25\n5 x 6 = 30\n5 x 7 = 35\n5 x 8 = 40\n5 x 9 = 45\n5 x 10 = 50\n",
                resultado.toString(), "A tabuada do número 5 deve ser gerada corretamente.");
    }

    @Test
    void deveTestarNumeroNegativoLancandoExcecao() {
        // Arrange
        int numeroNegativo = -1;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                GeradorDeTabuada.gerarTabuada(numeroNegativo)
        );
        assertEquals("Número deve ser maior ou igual a zero.", exception.getMessage(), "Deve lançar uma exceção quando o número for negativo.");
    }

    @Test
    void deveTestarTabuadaZero() {
        // Arrange
        int numero = 0;

        // Act
        StringBuilder resultado = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            resultado.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
        }

        // Assert
        assertEquals(
                "0 x 1 = 0\n0 x 2 = 0\n0 x 3 = 0\n0 x 4 = 0\n0 x 5 = 0\n0 x 6 = 0\n0 x 7 = 0\n0 x 8 = 0\n0 x 9 = 0\n0 x 10 = 0\n",
                resultado.toString(), "A tabuada do número 0 deve ser gerada corretamente.");
    }

    @Test
    void deveTestarTabuadaNumeroMaiorQueDez() {
        // Arrange
        int numero = 12;

        // Act
        StringBuilder resultado = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            resultado.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
        }

        // Assert
        assertEquals(
                "12 x 1 = 12\n12 x 2 = 24\n12 x 3 = 36\n12 x 4 = 48\n12 x 5 = 60\n12 x 6 = 72\n12 x 7 = 84\n12 x 8 = 96\n12 x 9 = 108\n12 x 10 = 120\n",
                resultado.toString(), "A tabuada do número 12 deve ser gerada corretamente.");
    }

    @Test
    void deveTestarExcecaoEntradaNaoNumerica() {
        // Arrange
        String inputNaoNumerico = "abc";

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            int numero = Integer.parseInt(inputNaoNumerico);
            GeradorDeTabuada.gerarTabuada(numero);
        });
        assertTrue(exception instanceof NumberFormatException, "Deve lançar NumberFormatException quando o input não for numérico.");
    }
}


