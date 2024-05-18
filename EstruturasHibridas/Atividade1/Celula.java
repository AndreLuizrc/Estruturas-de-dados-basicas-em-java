package EstruturasHibridas.Atividade1;

public class Celula {
    public Contato contato;
    public Celula prox;

    public Celula(){
        this.contato = new Contato();
        this.prox = null;
    }

    public Celula(Contato contato){
        this.contato = contato;
        this.prox = null;
    }
}
