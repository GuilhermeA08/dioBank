public class ContaCorrente extends Conta {

    private static int SEQUENCIAL = 1;

    public ContaCorrente() {
        super.setAgencia(1);
        super.setAgencia(SEQUENCIAL++);
    }

}

