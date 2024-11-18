import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircuitoDeResistenciaTest {

    @Test
    void deveTestarCalculoResistenciaEquivalente() {
        // Arrange
        CircuitoDeResistencia circuito = new CircuitoDeResistencia(5.0, 10.0, 15.0, 20.0);

        // Act
        double resistenciaEquivalente = circuito.calcularResistenciaEquivalente();

        // Assert
        assertEquals(50.0, resistenciaEquivalente, 0.01, "A resistência equivalente deve ser a soma das resistências.");
    }

    @Test
    void deveTestarMaiorResistencia() {
        // Arrange
        CircuitoDeResistencia circuito = new CircuitoDeResistencia(5.0, 10.0, 15.0, 20.0);

        // Act
        double maiorResistencia = circuito.obterMaiorResistencia();

        // Assert
        assertEquals(20.0, maiorResistencia, 0.01, "A maior resistência deve ser 20.0 Ohms.");
    }

    @Test
    void deveTestarMenorResistencia() {
        // Arrange
        CircuitoDeResistencia circuito = new CircuitoDeResistencia(5.0, 10.0, 15.0, 20.0);

        // Act
        double menorResistencia = circuito.obterMenorResistencia();

        // Assert
        assertEquals(5.0, menorResistencia, 0.01, "A menor resistência deve ser 5.0 Ohms.");
    }

    @Test
    void deveTestarResistenciaInvalidaNegativa() {
        // Arrange
        double resistencia1 = -5.0, resistencia2 = 10.0, resistencia3 = 15.0, resistencia4 = 20.0;

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new CircuitoDeResistencia(resistencia1, resistencia2, resistencia3, resistencia4)
        );
        assertEquals("Resistências devem ser valores positivos.", exception.getMessage());
    }

    @Test
    void deveTestarResistenciaInvalidaZero() {
        // Arrange
        double resistencia1 = 0.0, resistencia2 = 10.0, resistencia3 = 15.0, resistencia4 = 20.0;

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new CircuitoDeResistencia(resistencia1, resistencia2, resistencia3, resistencia4)
        );
        assertEquals("Resistências devem ser valores positivos.", exception.getMessage());
    }

    @Test
    void deveTestarResistenciasIguais() {
        // Arrange
        CircuitoDeResistencia circuito = new CircuitoDeResistencia(10.0, 10.0, 10.0, 10.0);

        // Act
        double resistenciaEquivalente = circuito.calcularResistenciaEquivalente();
        double maiorResistencia = circuito.obterMaiorResistencia();
        double menorResistencia = circuito.obterMenorResistencia();

        // Assert
        assertEquals(40.0, resistenciaEquivalente, 0.01, "A resistência equivalente deve ser 40.0 Ohms.");
        assertEquals(10.0, maiorResistencia, 0.01, "A maior resistência deve ser 10.0 Ohms.");
        assertEquals(10.0, menorResistencia, 0.01, "A menor resistência deve ser 10.0 Ohms.");
    }
}


