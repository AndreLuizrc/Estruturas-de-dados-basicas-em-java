package EstruturasHibridas.Atividade1;

public class Contato {
    private String nome;
    private String telefone;
    private String email;
    private int cpf;

    public Contato(){
        this("", "", "", 0);
    }

    public Contato(String name, String telefone, String email, int cpf){
        this.nome = name;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
