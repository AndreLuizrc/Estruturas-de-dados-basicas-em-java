package AVL;

public class No {
    public int elemento;
    public No esq,dir;
    public int nivel;

    public No(int elemento) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
        this.nivel = 1;
    }

    public void setNivel() {
        this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
    }

    public int getNivel(No i){
        return (i == null)? 0  : i.nivel;
    }
}
