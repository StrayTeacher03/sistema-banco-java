package banco.model;

public class Cliente {
    private String nome, cpf, telefone;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    String getName() {

        return nome;
    }

    void setName(String nome) {
        this.nome = nome;
    }
    
    String getCpf() {

        return cpf;
    }

    void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    String getTelefone() {

        return telefone;
    }
    
    void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente[nome: "+nome+", cpf: "+cpf+", telefone: "+telefone+"]";
    }

}
