import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * ============================================================
 * Projeto: ContaBanco (ContaTerminal)
 * Autor: Bianca Casemira
 * Data: 2026
 * Descrição:
 * Programa Java que simula a criação de uma conta bancária
 * via terminal. O sistema solicita dados do usuário,
 * valida as entradas e exibe uma mensagem final formatada.
 *
 * Funcionalidades:
 * ✔ Leitura de dados via terminal
 * ✔ Validação de entradas
 * ✔ Formatação monetária em Real (R$)
 * ✔ Código organizado e reutilizável
 *
 * Tecnologias:
 * - Java 17+
 * - Scanner (entrada de dados)
 * - NumberFormat (formatação monetária)
 * ============================================================
 */
public class ContaBanco {

    private static final Locale LOCALE_BR = new Locale("pt", "BR");

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numeroConta = lerInteiro(sc, "Por favor, digite o número da Conta: ");
        String agencia = lerAgencia(sc, "Por favor, digite o número da Agência (ex: 067-8): ");
        String nomeCliente = lerTexto(sc, "Por favor, digite o nome do Cliente: ");
        double saldo = lerDecimal(sc, "Por favor, digite o saldo: ");

        // Formata o saldo no padrão BR (R$ 1.234,56)
        NumberFormat brl = NumberFormat.getCurrencyInstance(LOCALE_BR);
        String saldoFormatado = brl.format(saldo);

        // Mensagem final (o String.format mantém o texto legível)
        String mensagem = String.format(
                "Olá %s, obrigado por criar uma conta em nosso banco! " +
                "Sua agência é %s, conta %d e seu saldo %s já está disponível para saque.",
                nomeCliente, agencia, numeroConta, saldoFormatado
        );

        System.out.println();
        System.out.println(mensagem);
    }

    /**
     * Lê um texto não vazio.
     */
    private static String lerTexto(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String valor = sc.nextLine().trim();

            if (!valor.isEmpty()) {
                return valor;
            }

            System.out.println("Entrada inválida. Tente novamente.");
        }
    }

    /**
     * Lê um inteiro positivo.
     */
    private static int lerInteiro(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = sc.nextLine().trim();

            try {
                int valor = Integer.parseInt(entrada);

                if (valor > 0) {
                    return valor;
                }

                System.out.println("O número deve ser maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
            }
        }
    }

    /**
     * Lê um decimal (aceita vírgula ou ponto) e não permite valores negativos.
     */
    private static double lerDecimal(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = sc.nextLine().trim().replace(",", ".");

            try {
                double valor = Double.parseDouble(entrada);

                if (valor >= 0) {
                    return valor;
                }

                System.out.println("O saldo não pode ser negativo.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um valor decimal (ex: 237.48 ou 237,48).");
            }
        }
    }

    /**
     * Lê e valida a agência.
     * Padrão aceito: "067-8" (3 dígitos, hífen, 1 dígito).
     */
    private static String lerAgencia(Scanner sc, String prompt) {
        while (true) {
            String agencia = lerTexto(sc, prompt);

            // Exemplo simples e comum em exercícios: 3 dígitos + "-" + 1 dígito
            if (agencia.matches("\\d{3}-\\d")) {
                return agencia;
            }

            System.out.println("Agência inválida. Use o formato 067-8.");
        }
    }
}