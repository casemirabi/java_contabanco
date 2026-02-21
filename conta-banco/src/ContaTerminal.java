//Formaro simplificado

import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);


        System.out.println("Por favor, digite o número da agencia: ");
        String agencia = scanner.nextLine();

        System.out.println("Por favor, digite o número da conta: ");
        int numeroConta = Integer.parseInt(scanner.nextLine());

        System.out.println("Por favor, digite o nome do cliente");
        String nomeCliente = scanner.nextLine();
         
        System.out.println("Por favor, digite o saldo: ");
        double saldo = Double.parseDouble(scanner.nextLine());

        String mensagem = "Olá " . concat(nomeCliente)
        .concat(", obrigado por criar uma conta em nosso banco, sua agência é: " )
        .concat(agencia)
        .concat(", conta ")
        .concat(String.valueOf(numeroConta))
        .concat(". ")
        .concat(nomeCliente)
        .concat(" o seu saldo é: R$")
        .concat(String.format(Locale.US, "%.2f", saldo))
        .concat(", e já está disponível para saque!");

        System.out.println();
        System.out.println(mensagem);

        scanner.close();
    }
}
