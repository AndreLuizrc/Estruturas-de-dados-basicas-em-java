package FilaFlexivel;

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

class Fila{
    private Celula primeiro, ultimo;

    public Fila() {
        primeiro = new Celula();
        ultimo = primeiro;
    }


    public void inserir(int elemento) throws Exception {

        ultimo.prox = new Celula(elemento);;
        ultimo = ultimo.prox;

    }

    public int remover() throws Exception {

        if(ultimo == primeiro){
            throw new Exception("Sem itens para remover");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int result = primeiro.elemento;

        tmp.prox = null;
        tmp = null;

        return result;
    }

    public void mostrar() {
        
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.println(i.elemento + " ");
        }
    }

}

public class FilaFlexivel {
    
    public static void main(String[] args) {
        Fila fila = new Fila();

        try {
            fila.inserir(0);
            fila.inserir(10);
            fila.inserir(20);
            fila.inserir(43);

            fila.mostrar();

            fila.remover();
            fila.remover();

            fila.mostrar();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}

