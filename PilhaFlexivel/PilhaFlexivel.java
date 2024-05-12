package PilhaFlexivel;

class Celula{
    public int elemento;
    public Celula prox;

    public Celula() {
        this(0);
    }

    public Celula(int elemento){
        this.elemento = elemento;
        this.prox = null;
    }
}

class Pilha {
    private Celula topo;

    public Pilha(){
        topo = null;
    }

    public void inserir(int valor) {

        Celula tmp = new Celula(valor);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    public int remover() throws Exception{

        if(topo == null){
            throw new Exception("Sem itens para remover");
        }

        int elemento = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;

        return elemento;
    }

    public void mostrar() {

        for( Celula i = topo; i != null; i = i.prox){
            System.out.println(i.elemento + " ");
        }
    }
}

public class PilhaFlexivel {
    
    public static void main(String[] args) {
        
        Pilha pilha = new Pilha();

        try {
            pilha.inserir(0);
            pilha.inserir(2);
            pilha.inserir(10);
            pilha.inserir(40);
            pilha.inserir(44);

            pilha.mostrar();

            pilha.remover();
            pilha.remover();

            pilha.mostrar();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
