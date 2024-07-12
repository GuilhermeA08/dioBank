import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Banco {
    private String nome;
    private List<Cliente> clientes;

    public Banco(String nome){
        this.nome = nome;
        this.clientes = new ArrayList<Cliente>();
    }

    public void abrirConta(){
        System.out.printf("Bem vindo ao banco %s%n", this.getNome());
        System.out.println("Informe seu CPF para abrir uma conta: ");

        try{
            Scanner scanner = new Scanner(System.in);

            String cpf = scanner.nextLine();
            Cliente cliente = this.getClientByCpf(cpf);

            if (cliente == null){
                System.out.println("Cliente não encontrado");
                System.out.println("Deseja cadastrar um novo cliente? (s/n)");

                String resposta = scanner.nextLine();
                if (resposta.equals("n")){
                    System.out.println("Operação cancelada");
                    return;
                }
                cliente = this.cadastrarCliente(cpf);
            }

            System.out.printf("Ola %s, qual tipo de conta deseja abrir?%n", cliente.getNome());
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Poupança");

            int opcao = scanner.nextInt();

            if (opcao == 1){
                ContaCorrente contaCorrente = new ContaCorrente();
                cliente.getContas().add(contaCorrente);
                System.out.printf("Conta corrente criada com sucesso!%nAgência: %d%nNúmero: %d%n", contaCorrente.getAgencia(), contaCorrente.getNumero());
            } else if (opcao == 2){
                ContaPoupanca contaPoupanca = new ContaPoupanca();
                cliente.getContas().add(contaPoupanca);
                System.out.printf("Conta poupança criada com sucesso!%nAgência: %d%nNúmero: %d%n", contaPoupanca.getAgencia(), contaPoupanca.getNumero());
            } else {
                System.out.println("Opção inválida");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public Cliente getClientByCpf(String cpf){
        Cliente.verificarCpf(cpf);

        for (Cliente cliente : this.getClientes()){
            if (cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public Cliente cadastrarCliente(String cpf){
        System.out.println("Informe o nome do cliente: ");
        try{
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.nextLine();
            Cliente cliente = new Cliente(nome, cpf);
            this.clientes.add(cliente);
            return cliente;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
