import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeAposentadoriaTest {

    @Test
    void deveTestarAposentadoriaPorIdadeHomemComIdadeSuficiente() {
        // Arrange
        int idade = 65;
        String sexo = "M";

        // Act
        boolean resultado = CalculadoraDeAposentadoria.podeAposentarPorIdade(idade, sexo);

        // Assert
        assertTrue(resultado, "Homens com 65 anos ou mais devem poder se aposentar por idade.");
    }

    @Test
    void deveTestarAposentadoriaPorIdadeHomemComIdadeInsuficiente() {
        // Arrange
        int idade = 64;
        String sexo = "M";

        // Act
        boolean resultado = CalculadoraDeAposentadoria.podeAposentarPorIdade(idade, sexo);

        // Assert
        assertFalse(resultado, "Homens com menos de 65 anos não devem poder se aposentar por idade.");
    }

    @Test
    void deveTestarAposentadoriaPorIdadeMulherComIdadeSuficiente() {
        // Arrange
        int idade = 60;
        String sexo = "F";

        // Act
        boolean resultado = CalculadoraDeAposentadoria.podeAposentarPorIdade(idade, sexo);

        // Assert
        assertTrue(resultado, "Mulheres com 60 anos ou mais devem poder se aposentar por idade.");
    }

    @Test
    void deveTestarAposentadoriaPorContribuicaoHomemComTempoSuficiente() {
        // Arrange
        int anosContribuicao = 35;
        String sexo = "M";

        // Act
        boolean resultado = CalculadoraDeAposentadoria.podeAposentarPorContribuicao(anosContribuicao, sexo);

        // Assert
        assertTrue(resultado, "Homens com 35 anos ou mais de contribuição devem poder se aposentar.");
    }

    @Test
    void deveTestarCalculoDeTempoFaltanteParaHomem() {
        // Arrange
        int idade = 60;
        int anosContribuicao = 30;
        String sexo = "M";

        // Act
        String resultado = CalculadoraDeAposentadoria.calcularTempoFaltante(idade, anosContribuicao, sexo);

        // Assert
        assertEquals(
                "Faltam 5 ano(s) para atingir a idade mínima. Faltam 5 ano(s) para atingir o tempo de contribuição.",
                resultado,
                "O cálculo de tempo faltante para homens deve ser correto."
        );
    }

    @Test
    void deveTestarCalculoDeTempoFaltanteParaMulher() {
        // Arrange
        int idade = 55;
        int anosContribuicao = 25;
        String sexo = "F";

        // Act
        String resultado = CalculadoraDeAposentadoria.calcularTempoFaltante(idade, anosContribuicao, sexo);

        // Assert
        assertEquals(
                "Faltam 5 ano(s) para atingir a idade mínima. Faltam 5 ano(s) para atingir o tempo de contribuição.",
                resultado,
                "O cálculo de tempo faltante para mulheres deve ser correto."
        );
    }
}
