import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SistemaDeAvaliacaoTest {

    @Test
    void deveTestarCalcularAMediaCorretamente() {
        // Arrange
        double notaProva1 = 7.5;
        double notaProva2 = 8.0;
        double notaTrabalho = 9.0;

        // Act
        double media = SistemaDeAvaliacao.calcularAMedia(notaProva1, notaProva2, notaTrabalho);

        // Assert
        assertEquals(8.166666666666666, media, "A média deve ser corretamente calculada.");
    }

    @Test
    void deveTestarVerificarAMediaAprovado() {
        // Arrange
        double media = 7.5;

        // Act
        String situacao = SistemaDeAvaliacao.verificarAMedia(media);

        // Assert
        assertEquals("Aprovado", situacao, "O aluno deve ser aprovado se a média for maior ou igual a 6.");
    }

    @Test
    void deveTestarVerificarAMediaReprovado() {
        // Arrange
        double media = 5.0;

        // Act
        String situacao = SistemaDeAvaliacao.verificarAMedia(media);

        // Assert
        assertEquals("Reprovado", situacao, "O aluno deve ser reprovado se a média for menor que 6.");
    }

    @Test
    void deveTestarValidarNotasComNotasValidas() {
        // Arrange
        double notaProva1 = 8.0;
        double notaProva2 = 7.5;
        double notaTrabalho = 9.0;

        // Act
        boolean resultado = SistemaDeAvaliacao.validarAsNotas(notaProva1, notaProva2, notaTrabalho);

        // Assert
        assertTrue(resultado, "As notas válidas devem retornar 'true'.");
    }

    @Test
    void deveTestarValidarNotasComNotaInvalida() {
        // Arrange
        double notaProva1 = -1.0;
        double notaProva2 = 7.5;
        double notaTrabalho = 9.0;

        // Act
        boolean resultado = SistemaDeAvaliacao.validarAsNotas(notaProva1, notaProva2, notaTrabalho);

        // Assert
        assertFalse(resultado, "Uma nota inválida (negativa) deve retornar 'false'.");
    }

    @Test
    void deveTestarValidarNotasComNotaMaiorQueDez() {
        // Arrange
        double notaProva1 = 11.0;
        double notaProva2 = 7.5;
        double notaTrabalho = 9.0;

        // Act
        boolean resultado = SistemaDeAvaliacao.validarAsNotas(notaProva1, notaProva2, notaTrabalho);

        // Assert
        assertFalse(resultado, "Uma nota maior que 10 deve retornar 'false'.");
    }
}


