package banco;
import java.util.Scanner;
import banco.modelo.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true; // controla se a aplicação continua rodando

        while (rodando) {
            // Simulação de login
            System.out.println("=== Bem-vindo ao Banco Digital ===");
            System.out.print("Digite seu nome de usuário: ");
            String usuario = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            // Cliente fixo para simulação
            Cliente cliente = new Cliente("Zezinho");

            // Verificação simples de login (usuário: Zezinho, senha: 1234)
            if (usuario.equals("Zezinho") && senha.equals("1234")) {
                System.out.println("Login realizado com sucesso!\n");
                System.out.println("Escolha o tipo de conta:");
                System.out.println("1 - Conta Corrente");
                System.out.println("2 - Conta Poupança");
                int tipoConta = scanner.nextInt();

                Conta conta;
                if (tipoConta == 1) {
                    conta = new ContaCorrente(cliente);
                } else if (tipoConta == 2) {
                    conta = new ContaPoupanca(cliente);
                } else {
                    System.out.println("Tipo de conta inválido. Usando Conta Corrente por padrão.");
                    conta = new ContaCorrente(cliente);
                }

                // Depósito inicial
                conta.depositar(1000.00);

                int opcao;
                // Menu de operações bancárias
                do {
                    System.out.println("\nEscolha uma opção:");
                    System.out.println("1 - Consultar saldo");
                    System.out.println("2 - Depositar");
                    System.out.println("3 - Sacar");
                    System.out.println("4 - Pagar boletos");
                    System.out.println("5 - Sair");
                    System.out.print("Opção: ");
                    opcao = scanner.nextInt();

                    switch (opcao) {
                        case 1:
                            conta.imprimirExtrato();
                            break;
                        case 2:
                            System.out.print("Digite o valor para depositar: ");
                            double valorDeposito = scanner.nextDouble();
                            conta.depositar(valorDeposito);
                            System.out.println("Depósito realizado!");
                            break;
                        case 3:
                            System.out.print("Digite o valor para sacar: ");
                            double valorSaque = scanner.nextDouble();
                            if (conta.sacar(valorSaque)) {
                                System.out.println("Saque realizado!");
                            } else {
                                System.out.println("Saldo insuficiente!");
                            }
                            break;
                        case 4:
                            System.out.print("Digite o valor do boleto: ");
                            double valorBoleto = scanner.nextDouble();
                            if (conta.pagarBoletos(valorBoleto)) {
                                System.out.println("Boleto pago com sucesso!");
                            } else {
                                System.out.println("Saldo insuficiente para pagar o boleto!");
                            }
                            break;
                        case 5:
                            System.out.println("Fazendo logout...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while (opcao != 5);

            } else {
                System.out.println("Usuário ou senha incorretos.");
            }

            // pergunta se quer voltar para o login
            System.out.print("\nDeseja voltar para o login? (s/n): ");
            scanner.nextLine(); // consumir quebra de linha
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                rodando = false;
                System.out.println("Encerrando aplicação...");
            }
        }

        scanner.close();
    }
}