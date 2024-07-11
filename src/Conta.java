public abstract class Conta {
    private int agencia;
    private int numero;
    private double saldo;

    public Conta(int agencia, int numero, double saldo){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valorSaque){
        if (valorSaque > this.saldo){
            System.out.println("Saldo insuficiente");
            return;
        }
        this.setSaldo(this.getSaldo() - valorSaque);
        System.out.println("Saque realizado com sucesso");
    }

    public void depositar(double valorDeposito){
        if (valorDeposito <= 0){
            System.out.println("Valor de depósito inválido");
            return;
        }
        this.setSaldo(this.getSaldo() + valorDeposito);
        System.out.println("Depósito realizado com sucesso");
    }

    public void transferir(double valorTransferencia, Conta contaDestino){
        if (valorTransferencia > this.saldo){
            System.out.println("Saldo insuficiente");
            return;
        }
        this.setSaldo(this.getSaldo() - valorTransferencia);
        contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferencia);
        System.out.println("Transferência realizada com sucesso");
    }
}
