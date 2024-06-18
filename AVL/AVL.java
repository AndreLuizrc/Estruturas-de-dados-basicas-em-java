package AVL;

public class AVL {
    private No raiz;

    public AVL(){
        raiz = null;
    }

    public void inserir(int x) throws Exception{
        raiz = inserir(x, raiz);
    }

    private No inserir(int x, No i) throws Exception{

        if(i == null){
            i = new No(x);
        }else if(x < i.elemento){
            i.esq = inserir(x, i.esq);
        }else if(x > i.elemento){
            i.dir = inserir(x, i.dir);
        }else{
            throw new Exception("Elemento já presente na árvore!");
        }

        return balancear(i);
    }

    private No balancear(No i) throws Exception{
        if(i != null){
            int fator = i.getNivel(i.dir) - i.getNivel(i.esq);

            //Math.abs retorna o valor de fator apenas se ele for positivo, praticamente mesma coisa de fazer if(fator >= 0 && fator <= 1);
            if(Math.abs(fator) <= 1){
                i.setNivel();
            }else if(fator == 2){
                int fatorFilhoDir = i.getNivel(i.dir.dir) - i.getNivel(i.dir.esq);

                if(fatorFilhoDir == -1){
                    i.dir = rotacionarDir(i.dir);
                }

                i = rotacionarEsq(i);
            }else if(fator == -2){
                int fatorFilhoEsq = i.getNivel(i.esq.esq) - i.getNivel(i.esq.dir);

                if(fatorFilhoEsq == 1){
                    i.esq = rotacionarEsq(i.esq);
                }

                i = rotacionarDir(i);
            }else{
                throw new Exception("Erro ao balancear!");
            }

        }
        
        return i;
    }

    private No rotacionarDir(No i){
        No noEsq = i.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = i;
        i.esq = noEsqDir;
        i.setNivel();
        noEsq.setNivel();

        return noEsq;
    }

    private No rotacionarEsq(No i){
        No noDir = i.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = i;
        i.dir = noDirEsq;

        i.setNivel();
        noDir.setNivel();

        return noDir;
    }
}
