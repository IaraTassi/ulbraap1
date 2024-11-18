import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaDeLoginTest {
    private SistemaDeLogin sistemaDeLogin;

    @BeforeEach
    void setUp() {
        sistemaDeLogin = new SistemaDeLogin();
    }

    @Test
    void deveTestarLoginCorreto() {
        // Arrange
        String login = "java8";
        String senha = "java8";

        // Act
        boolean resultado = sistemaDeLogin.validarLogin(login, senha);

        // Assert
        assertTrue(resultado, "O login e a senha corretos devem retornar verdadeiro.");
    }

    @Test
    void deveTestarLoginIncorretoComLoginErrado() {
        // Arrange
        String login = "wrongUser";
        String senha = "java8";

        // Act
        boolean resultado = sistemaDeLogin.validarLogin(login, senha);

        // Assert
        assertFalse(resultado, "Login errado deve retornar falso.");
    }

    @Test
    void deveTestarLoginIncorretoComSenhaErrada() {
        // Arrange
        String login = "java8";
        String senha = "wrongPassword";

        // Act
        boolean resultado = sistemaDeLogin.validarLogin(login, senha);

        // Assert
        assertFalse(resultado, "Senha errada deve retornar falso.");
    }

    @Test
    void deveTestarLoginIncorretoComAmbosErrados() {
        // Arrange
        String login = "wrongUser";
        String senha = "wrongPassword";

        // Act
        boolean resultado = sistemaDeLogin.validarLogin(login, senha);

        // Assert
        assertFalse(resultado, "Login e senha errados devem retornar falso.");
    }

    @Test
    void deveTestarLimiteDeTentativas() {
        // Arrange
        String loginIncorreto = "wrongUser";
        String senhaIncorreta = "wrongPassword";

        // Act & Assert
        sistemaDeLogin.validarLogin(loginIncorreto, senhaIncorreta); // 1ª tentativa
        sistemaDeLogin.validarLogin(loginIncorreto, senhaIncorreta); // 2ª tentativa
        sistemaDeLogin.validarLogin(loginIncorreto, senhaIncorreta); // 3ª tentativa
        boolean resultado = sistemaDeLogin.validarLogin(loginIncorreto, senhaIncorreta); // 4ª tentativa

        // Assert
        assertFalse(resultado, "Após 3 tentativas, o login deve falhar.");
    }
}

