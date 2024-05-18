package ArvoreBinaria;
import ArvoreBinaria.ArvoreBinaria;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore1 = new ArvoreBinaria();
        ArvoreBinaria arvore2 = new ArvoreBinaria();

        try {
            arvore1.inserir(10);
            arvore1.inserir(20);
            arvore1.inserir(8);
            arvore1.inserir(3);
            arvore1.inserir(9);
            arvore1.inserir(13);

            arvore1.caminharCentral();

            int altura  = arvore1.getAltura();
            System.out.println(altura);

            System.out.println(arvore1.soma());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
