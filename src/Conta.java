import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo;

    public Conta(){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0;
    }

    public void sacar(double valorSaque){
        try {
            this.debitarSaldo(valorSaque);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Saque realizado com sucesso");
    }

    public void depositar(double valorDeposito){
        try {
            this.creditarSaldo(valorDeposito);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Depósito realizado com sucesso");
    }

    public void transferir(double valorTransferencia, Conta contaDestino){
        try {
            this.debitarSaldo(valorTransferencia);
            contaDestino.creditarSaldo(valorTransferencia);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Transferência realizada com sucesso");
    }

    private void debitarSaldo(double valor){
        if (valor > this.saldo && valor <= 0){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.setSaldo(this.getSaldo() - valor);
    }

    private void creditarSaldo(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("Não é possível creditar valores negativos ou nulos");
        }
        this.setSaldo(this.getSaldo() + valor);
    }

    public void imprimirExtrato(){
        System.out.println("Ag/Conta: " + this.getAgencia() + "/" + this.getNumero() + " Saldo: R$" + this.getSaldo());
    }
}
