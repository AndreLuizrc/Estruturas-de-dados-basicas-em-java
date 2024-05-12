package ListaFlexivelDupla;

class Celula{
    public int elemento;
    public Celula ant;
    public Celula prox;

    public Celula() {
        this(0);
    }

    public Celula(int elemento){
        this.elemento = elemento;
        this.ant = null;
        this.prox = null;
    }
}

class Lista{
    private Celula primeiro, ultimo;

    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void inserirInicio(int elemento) {

        Celula tmp = new Celula(elemento);

        tmp.ant = primeiro;
        tmp.prox = primeiro.prox; 
        primeiro.prox = tmp;

        if(ultimo == primeiro){
            ultimo = tmp;
        }else {
            tmp.prox.ant = tmp;
        }

        tmp = null;
    }

    public void inserirFim(int elemento) throws Exception {

        Celula tmp = new Celula(elemento);


        ultimo.prox = tmp;
        tmp.ant = ultimo;
        ultimo = tmp;

        tmp = null;

    }

    public int removerInicio() throws Exception {

        if(ultimo == primeiro){
            throw new Exception("Sem itens para remover");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int result = primeiro.elemento;

        tmp.prox = null;
        primeiro.ant = null;
        tmp = null;

        return result;
    }

    public int removerFim() throws Exception {

        if(ultimo == primeiro){
            throw new Exception("Sem itens para remover");
        }

        Celula i;

        for(i = primeiro.prox; i.prox != ultimo; i = i.prox);

        int result = ultimo.elemento;
        i.prox = null;
        ultimo.ant = null;
        ultimo = i;
        i = null;

        return result;
        
    }

    public void inserir(int valor, int posicao) throws Exception{
        int tamanho = tamanho();

        if(posicao < 0 || posicao > tamanho){
            throw new Exception("Posicao fora dos limites");
        }else if (posicao == 0) {
            inserirInicio(valor);
        }else if (posicao == tamanho) {
            inserirFim(valor);
        } else {
            Celula i = primeiro;
    
            for(int j = 0; j < posicao; j++, i = i.prox);
    
            Celula tmp = new Celula(valor);
            tmp.prox = i.prox;
            i.prox.ant = tmp;
            i.prox = tmp;
            tmp.ant = i;
            tmp = i = null;
        }

    }

    public int remover(int posicao) throws Exception {
        int tamanho = tamanho();
        int result;

        if(posicao < 0 || posicao > tamanho){
            throw new Exception("Posicao fora dos limites");
        }else if (posicao == 0) {
            result = removerInicio();
        }else if (posicao == tamanho) {
            result = removerFim();
        } else {

            Celula i = primeiro;

            for(int j = 0; j < posicao; j++, i = i.prox);

            Celula tmp = i.prox; // vai apontar pro elemento que quero remover
            result = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox.ant = tmp.ant;
            tmp.prox = null;
            tmp.ant = null;

            i = tmp = null;

        }

        return result;
        
    }

    public int tamanho() {
        int tamanho = 0;
        for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
        return tamanho;
    }

    public void mostrar() {
        
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.println(i.elemento + " ");
        }
    }

}

public class ListaFlexivelDupla {
    
    public static void main(String[] args) {
        Lista lista = new Lista();

        try {
            lista.inserirFim(10);
            lista.inserirFim(20);
            lista.inserirInicio(5);

            lista.mostrar();

            lista.remover(1);
            lista.inserir(50, 0);
            lista.mostrar();
            lista.removerInicio();

            lista.mostrar();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
