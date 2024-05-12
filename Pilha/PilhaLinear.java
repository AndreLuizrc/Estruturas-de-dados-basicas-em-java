package Pilha;

class Pilha {
    private int array[];
    private int topo;

    public Pilha() {
        this(6);
    }

    public Pilha(int tamanho){
        array = new int[tamanho];
        topo = 0;
    }

    public void inserir(int valor) throws Exception{

        if(topo >= array.length){
            throw new Exception("Sem espaço disponível");
        }

        array[topo] = valor;
        topo++;
    }

    public void remover() throws Exception{

        if(topo <= 0){
            throw new Exception("Sem itens para remover");
        }

        topo--;
    }

    public void mostrar() {

        for(int i = 0; i < topo; i++){
            System.out.print(array[i] + " ");
        }
    }
}

public class PilhaLinear {
    
    public static void main(String[] args) {
        
        Pilha pilha = new Pilha(6);

        try {
            pilha.inserir(0);
            pilha.inserir(24);
            pilha.inserir(10);
            pilha.mostrar();

            pilha.remover();
            pilha.remover();
            pilha.mostrar();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }
}
