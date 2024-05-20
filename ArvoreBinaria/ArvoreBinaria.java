package ArvoreBinaria;
import ArvoreBinaria.No;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    private boolean pesquisar(int x, No i){
        boolean resp;

        if(i == null){
            resp = false;
        }else if(x == i.elemento){
            resp = true;
        }else if(x > i.elemento){
            resp = pesquisar(x, i.dir);
        }else {
            resp = pesquisar(x, i.esq);
        }

        return resp;
    }

    public boolean pesquisar(int x){
        return pesquisar(x, raiz);
    }

    private No inserir(int x, No i) throws Exception{

        if(i == null){
            i = new No(x);
        }else if( x < i.elemento){
            i.esq = inserir(x, i.esq);
        }else if(x > i.elemento){
            i.dir = inserir(x, i.dir);
        }else{
            throw new Exception("Elemento já adicionado a arvore!");
        }

        return i;
    }
    
    public void inserir(int x) throws Exception{
        raiz = inserir(x, raiz);
    }

    public void remover(int x) throws Exception{
        raiz = remover(x, raiz);
    }

    private No remover(int x, No i) throws Exception{

        if(i == null){
            throw new Exception("O item que deseja remover não existe");
        }else if(x > i.elemento){
            i.dir = remover(x, i.dir);
        }else if(x < i.elemento){
            i.esq = remover(x, i.esq);
        }else if(i.esq == null){
            i = i.dir;
        }else if(i.dir == null){
            i = i.esq;
        }else{
            i.esq = maiorEsq(i, i.esq);
        }

        return i;
    }

    private No maiorEsq(No i, No j){
        if(j.dir == null){
            i.elemento = j.elemento;
            j = j.esq;
        }else{
            j.dir = maiorEsq(i, j.dir);
        }

        return j;
    }

    public void caminharPre(){
        caminharPre(raiz);
    }

    private void caminharPre(No i){
        if(i != null){
            System.out.println(i.elemento);
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    public void caminharCentral(){
        caminharCentral(raiz);
    }

    private void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            System.out.println(i.elemento);
            caminharCentral(i.dir);
        }
    }

    public void caminharPos(){
        caminharPos(raiz);
    }

    private void caminharPos(No i){
        if(i != null){
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.println(i.elemento);
        }
    }

    public int getAltura(){
        return getAltura(raiz);
    }

    private int getAltura(No i){
        int altura;
        if(i == null){
            altura = -1;
        }else{
            int alturaEsq = getAltura(i.esq);
            int alturaDir = getAltura(i.dir);
            altura = (alturaDir > alturaEsq ? alturaDir+1 : alturaEsq+1);
        }

        return altura;
    }

    public int soma(){
        return soma(raiz);
    }

    private int soma(No i){
        int soma = 0;
        if(i != null){
            soma = i.elemento + soma(i.esq) + soma(i.dir);;
        } 

        return soma;
    }

    public int contPares(){
        return contPares(raiz);
    }

    private int contPares(No i){
        int cont = 0;
        if(i != null){
            cont = (i.elemento % 2 == 0? 1: 0) + contPares(i.esq) + contPares(i.dir);
        }

        return cont;
    }

    public boolean compare(ArvoreBinaria arvore2){
        return compare(raiz, arvore2.getRaiz());
    };

    private boolean compare(No i, No j){
        boolean resp = false;

        if(i != null && j != null){
            resp = (i.elemento == j.elemento && compare(i.esq, j.esq) && compare(i.dir, j.dir));
        }else if(i == null && j == null){
            resp = true;
        }else {
            resp = false;
        }

        return resp;
    }



    private No getRaiz(){
        return raiz;
    }
}
