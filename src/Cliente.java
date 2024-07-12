import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cliente {
    private String nome;
    private String cpf;
    private List<Conta> contas;

    public static void verificarCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos");
        }
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.setCpf(cpf);
        this.contas = new ArrayList<Conta>();
    }

    public void setCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos");
        }
        this.cpf = cpf;
    }

    public void pushConta(Conta conta) {
        this.contas.add(conta);
    }

    public void popConta(Conta conta) {
        this.contas.remove(conta);
    }
}
