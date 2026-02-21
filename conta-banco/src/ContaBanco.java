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
 *
 * ============================================================
 */

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ContaBanco {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int numero = lerInteiro(sc, "Por favor, digite o número da Conta: ");
            String agencia = lerTexto(sc, "Por favor, digite o número da Agência (ex: 067-8): ");
            String nomeCliente = lerTexto(sc, "Por favor, digite o nome do Cliente: ");
            double saldo = lerDecimal(sc, "Por favor, digite o saldo: ");

            // Formata o saldo em padrão BR (R$ 1.234,56)
            Locale localeBR = new Locale("pt", "BR");
            NumberFormat brl = NumberFormat.getCurrencyInstance(localeBR);
            String saldoFormatado = brl.format(saldo);

            String mensagem = String.format(
                    "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %s já está disponível para saque.",
                    nomeCliente, agencia, numero, saldoFormatado
            );

            System.out.println();
            System.out.println(mensagem);
        }
    }

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

    private static double lerDecimal(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String entrada = sc.nextLine().trim();

            // Aceita "237.48" ou "237,48"
            entrada = entrada.replace(",", ".");

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
}
