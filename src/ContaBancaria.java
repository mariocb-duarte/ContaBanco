import java.text.DecimalFormat;
import java.util.Scanner;

public class ContaBancaria {
    private String nomeCliente;
    private double saldo;
    private String agencia;
    private int contaNumero;

    public ContaBancaria(String nomeCliente, String agencia, int contaNumero, double saldo) {
        this.agencia = agencia;
        this.contaNumero = contaNumero;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public int getContaNumero() {
        return contaNumero;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Mutio bem, " + nomeCliente + "! Depósito realizado com SUCESSO!!");
        System.out.println("Você depositou R$ " + formatarValor(valor) + " a sua conta.");
        exibirSaldo();
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Tudo certo, " + nomeCliente + "! Saque realizado com SUCESSO!!");
            System.out.println("Você sacou R$ " + formatarValor(valor) + " da sua conta.");
            exibirSaldo();
        } else {
            System.out.println("Ops, " + nomeCliente + "! No momento você não possui saldo suficiente para realizar essa operação.");
            exibirSaldo();
        }
    }

    public void exibirSaldo() {
        System.out.println("Saldo atual R$: " + formatarValor(saldo));
    }

    private String formatarValor(double valor) {
        DecimalFormat formatador = new DecimalFormat("#0.00");
        return formatador.format(valor);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        String nome = sc.nextLine();

        System.out.println("Digite o número da agência: ");
        String agencia = sc.nextLine();

        System.out.println("Digite o número da conta: ");
        int conta = sc.nextInt();

        System.out.println("Digite o saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        ContaBancaria contaBancaria = new ContaBancaria(nome, agencia, conta, saldoInicial);

        int opcao;
        do {

            System.out.println("\nCliente: " + contaBancaria.getNomeCliente());
            System.out.println("Agência: " + contaBancaria.getAgencia());
            System.out.println("Conta: " + contaBancaria.getContaNumero());


            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver saldo");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = sc.nextDouble();
                    contaBancaria.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = sc.nextDouble();
                    contaBancaria.sacar(valorSaque);
                    break;
                case 3:
                    contaBancaria.exibirSaldo();
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
