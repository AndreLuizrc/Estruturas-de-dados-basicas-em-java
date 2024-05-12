package Lista;


class Lista {
    private int[] array;
    private int n;

    public Lista() {
        this(6);
    }

    public Lista(int tamanho){
        array = new int[tamanho];
        n = 0;
    }

    public void inserirNoInicio(int valor) throws Exception {
        
        if(n >= array.length){
            throw new Exception("Vetor sem espaços vazios!");
        }

        for(int i = n; i > 0; i--){
            array[i] = array[i-1];
        }

        array[0] = valor;
        n++;
    }

    public void inserirNoFim(int valor) throws Exception {
        if(n >= array.length){
            throw new Exception("Vetor sem espaços vazios!");
        }

        array[n] = valor;
        n++;
    }

    public void inserir(int valor, int posicao) throws Exception {
        if( n >= array.length || posicao < 0 || posicao > n){
            throw new Exception("Erro ao inserir!");
        }

        for(int i = n; i > posicao; i--){
            array[i] = array[i-1];
        }

        array[posicao] = valor;
        n++;
    }

    public int removerInicio() throws Exception {

        if(n <= 0){
            throw new Exception("Sem itens para remover");
        }

        int result = array[0];

        for(int i = 0; i < n-1; i++){
            array[i] = array[i + 1];
        }

        n--;
        return result;
    }

    public int removerFim() throws Exception {

        if(n <= 0){
            throw new Exception("Sem itens para remover");
        }

        n--;
        int result = array[n];

        return result;
    }

    public int remover(int posicao) throws Exception {

        if( n >= array.length || posicao < 0 || posicao > n){
            throw new Exception("Erro ao inserir!");
        }

        int result = array[posicao];

        for(int i = posicao; i < n-1; i++){
            array[i] = array[i + 1];
        }

        n--;

        return result;
    }

    public void mostrar() throws Exception {

        if(n <= 0){
            throw new Exception("Sem itens para mostrar");
        }

        for(int i = 0; i < n; i++) {
            System.out.println(array[i] + " ");
        }
    }
}

public class ListaLinear {
    
    public static void main(String[] args) {
        
        Lista lista1 = new Lista(6);

        try{
            lista1.inserirNoFim(10);
            lista1.inserirNoFim(20);
            lista1.inserirNoInicio(5);

            lista1.mostrar();

            lista1.removerFim();
            lista1.inserir(50, 0);
            lista1.mostrar();
            lista1.removerInicio();

            lista1.mostrar();

        }catch (Exception e){
            e.printStackTrace();;
        }

    }
}