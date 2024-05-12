package Fila;

class Fila {
    private int[] array;
    private int primeiro;
    private int ultimo;

    public Fila() {
        this(6);
    }

    public Fila(int tamanho){
        array = new int[tamanho + 1];
        primeiro = ultimo = 0;
    }

    public void inserir(int valor) throws Exception {

        if(((ultimo + 1) % array.length) == primeiro){
            throw new Exception("Sem espaço disponivel");
        }

        array[ultimo] = valor;
        ultimo = (ultimo + 1) % array.length;
    }

    public int remover() throws Exception {

        if(ultimo == primeiro){
            throw new Exception("Sem valores para remover");
        }

        int result = array[primeiro];

        primeiro = (primeiro + 1) % array.length;

        return result;

    }

    public void mostrar() {

        for(int i = primeiro; i != ultimo; i = ((i + 1) % array.length)){
            System.out.println(array[i] + " ");
        }
    }
}

public class FilaLinear {
    
    public static void main(String[] args) {
        
        Fila fila = new Fila(6);

        try{
            fila.inserir(10);
            fila.inserir(23);
            fila.mostrar();
            
            fila.inserir(56);
            fila.inserir(22);
            fila.remover();

            fila.mostrar();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
