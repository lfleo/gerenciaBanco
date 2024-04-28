package com.mycompany.gerenciabanco;
import java.util.Scanner; // Importação de pacote

class ContaBancaria {
    public String nome;
    public String sobrenome;
    public String cpf;
    public double saldo;
    
    public ContaBancaria (String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0; // SALDO INICIAL ZERO
    }
    
    public double consultarSaldo() { // CONSULTAR SALDO
        return saldo;
    }
    
    public void depositar(double valor) { // DEPOSITO
        saldo += valor; // Incremento de valor
        System.out.println("Deposito de R$ " + valor + " realizado com sucesso.");
    }
    
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo =- valor; // Retirada de saldo
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("SALDO INSUFICIENTE. Voce nao tem saldo suficiente para saque.");
        }
    }
    
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in); // Recebimento de dados do usuário
        int opcao;
        
        do {
            System.out.println("\n###### Menu de opcoes ######");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Realizar Deposito");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Encerrar");
            System.out.println("Escolha uma opcao");
            opcao = scanner.nextInt(); // Números inteiros
            
            switch(opcao) {
                case 1:
                    System.out.println("Saldo: R$ " + consultarSaldo());
                    break;
                    
                case 2:
                    System.out.println("Digite o valor do deposito ");
                    double valorDeposito = scanner.nextDouble(); // Armazenando novo valor a variável
                    depositar(valorDeposito); // Chama o valor Depoistar para fazer a soma
                    break;
                    
                case 3:
                    System.out.println("Digite o valor do Saque");
                    double ValorSaque = scanner.nextDouble();
                    sacar(ValorSaque);
                    break;
                    
                case 4:
                    System.out.println("Encerrando...");
                    break;
                    
                default:
                    System.out.println("Insira uma opção valida por favor.");
            }
            
        } while (opcao != 4);
    }
    
}

public class gerenciaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-Vindo ao seu Banco");
        
        System.out.println("\nInsira seu nome: ");
        String nome = scanner.nextLine(); // Recebendo dados do nome do usuário
        
        System.out.println("Insira seu sobrenome: ");
        String sobrenome = scanner.nextLine(); // Recebendo dados do sobrenome do usuário
        
        System.out.println("Insira seu CPF: ");
        String cpf = scanner.nextLine();
        
        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);
        
        conta.exibirMenu();
        
        System.out.println("Servico encerrado.");
        scanner.close();
    }
    
}