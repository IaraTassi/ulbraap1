import java.util.Scanner;

public class SistemaDeLogin {

    // Método main para execução
    public static void main(String[] args) {
        SistemaDeLogin sistema = new SistemaDeLogin();
        sistema.acessarSistema();
    }

    private static final String LOGIN_CORRETO = "java8";
    private static final String SENHA_CORRETA = "java8";
    protected int tentativas;

    public SistemaDeLogin() {
        this.tentativas = 0;
    }

    // Método para validar o login e senha
    public boolean validarLogin(String login, String senha) {
        return LOGIN_CORRETO.equals(login) && SENHA_CORRETA.equals(senha);
    }

    // Método principal para controle do login
    public void acessarSistema() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("****************** Sistema de Login  **********************");
        try {
            while (tentativas < 3) {
                System.out.print("Digite seu login: ");
                String login = scanner.nextLine();
                System.out.print("Digite sua senha: ");
                String senha = scanner.nextLine();

                if (validarLogin(login, senha)) {
                    System.out.println("Login realizado com sucesso!");
                    return;
                } else {
                    tentativas++;
                    int tentativasRestantes = 3 - tentativas;
                    if (tentativasRestantes > 0) {
                        System.out.println("Login ou senha incorretos. Você tem " + tentativasRestantes + " tentativas restantes.");
                    } else {
                        System.out.println("Número máximo de tentativas atingido. Acesso bloqueado.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
        System.out.println("**************** Encerra o programa. **********************");
    }
}
