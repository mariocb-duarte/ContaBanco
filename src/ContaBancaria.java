import java.util.Scanner;

public class ContaBancaria {

    public static void main(String[] args) {

        String nomeCliente;
        double saldo;
        String agencia;
        int contaNumero;

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        nomeCliente = sc.nextLine();

        System.out.println("Digite o número da agência: ");
        agencia = sc.nextLine();

        System.out.println("Digite o número da conta: ");
        contaNumero = sc.nextInt();

        System.out.println("Digite o saldo inicial: ");
        saldo = sc.nextDouble();

        System.out.println("Olá "
                + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "
                + agencia + ", conta "
                + contaNumero + " e seu saldo "
                + saldo + " já está disponível para saque."
        );
    }
}
