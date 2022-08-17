package Programa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    private static Integer Interger;
    private static Object Conta;
    private static Programa.Conta conta;


    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
int operacao = Interger.parseInt(JOptionPane.showInputDialog("....Selecione uma opção..."+
        /*System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agencia---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operacao que deseja realizar *****");
        System.out.println("------------------------------------------------------");*/

                                   "|   Opcao 1 - Criar conta" +
                                     "|   Opcao 2 - Depositar " +
                                      "|   Opcao 3 - Sacar  " +
                                       "|   Opcao 4 - Transferir  " +
                                        "|   Opcao 5 - Listar  " +
                                           "|   Opcao 6 - Sair  "));

        switch (operacao) {
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;

            case 5:
                listarContas();
                break;

            case 6:
                JOptionPane.showMessageDialog(null,"Flw é nóis!");
                System.exit(0); // para o sistema

            default:
                JOptionPane.showMessageDialog(null,"Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        Pessoa pessoa = new Pessoa();
        //System.out.println("Você está criando uma conta\n");

       pessoa.setName(JOptionPane.showInputDialog("Nome:"));

        pessoa.setCpf(JOptionPane.showInputDialog("Cpf:"));

        pessoa.setEmail(JOptionPane.showInputDialog("email:" ));


        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        JOptionPane.showMessageDialog(null,"--- Sua conta foi criada com sucesso! ---");


        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta conta : contasBancarias) {
                if(conta.getNumeroConta() == numeroConta) {
                    conta = conta;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        int numeroConta =
                Interger.parseInt(JOptionPane.showInputDialog("Numero da conta para deposito: "));

            Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            Double valorDeposito =
                    Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar?: "));
            conta.depositar(valorDeposito);

            JOptionPane.showMessageDialog(null,"--- Valor depositato com sucesso! ---");
        }else {
            JOptionPane.showMessageDialog(null,"--- Conta não encontrada ---");
        }

        operacoes();

    }

    public static void sacar() {
        int numeroConta =
                Interger.parseInt(JOptionPane.showInputDialog("Número da conta: "));


        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            Double valorSaque =
            Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar? "));

            conta.sacar(valorSaque);
            JOptionPane.showMessageDialog(null,"--- Saque realizado com sucesso! ---");
        }else {
            JOptionPane.showMessageDialog(null,"--- Conta não encontrada ---");
        }

        operacoes();

    }

    public static void transferir() {
        int numeroContaRemetente =
                Interger.parseInt(JOptionPane.showInputDialog("Número da conta que vai enviar a transferência: "));

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            int numeroContaDestinatario =
            Interger.parseInt(JOptionPane.showInputDialog("Número da conta do destinatário: "));

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                int valor =
                Interger.parseInt(JOptionPane.showInputDialog("Valor da transferência: "));


                contaRemetente.transferencia(contaDestinatario, (double) valor);

            }else {
                JOptionPane.showMessageDialog(null,"--- A conta para depósito não foi encontrada ---");
            }

        }else {
            JOptionPane.showMessageDialog(null,"--- Conta para transferência não encontrada ---");
        }
        operacoes();
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else {
            JOptionPane.showMessageDialog(null,"--- Não há contas cadastradas ---");
        }

        operacoes();
    }
}
