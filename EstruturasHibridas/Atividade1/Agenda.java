package EstruturasHibridas.Atividade1;

public class Agenda {
    private No raiz;

    public Agenda(){
        raiz = null;
        try {
            raiz = createNo('M', raiz);
            raiz = createNo('G', raiz);
            raiz = createNo('A', raiz);
            raiz = createNo('I', raiz);
            raiz = createNo('B', raiz);
            raiz = createNo('S', raiz);
            raiz = createNo('C', raiz);
            raiz = createNo('D', raiz);
            raiz = createNo('Z', raiz);
            raiz = createNo('T', raiz);
            raiz = createNo('Q', raiz);
            raiz = createNo('R', raiz);
            raiz = createNo('U', raiz);
            raiz = createNo('V', raiz);
            raiz = createNo('P', raiz);
            raiz = createNo('J', raiz);
            raiz = createNo('H', raiz);
            raiz = createNo('E', raiz);
            raiz = createNo('F', raiz);
            raiz = createNo('W', raiz);
            raiz = createNo('O', raiz);
            raiz = createNo('Y', raiz);
            raiz = createNo('N', raiz);
            raiz = createNo('K', raiz);
            raiz = createNo('L', raiz);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private No createNo(char letra, No i) throws Exception{

        if(i == null){
            i = new No(letra);
        }else if( letra < i.letra){
            i.esq = createNo(letra, i.esq);
        }else if(letra > i.letra){
            i.dir = createNo(letra, i.dir);
        }else{
            throw new Exception("Elemento já adicionado a arvore");
        }

        return i;
    }

    public void insert(Contato contato) throws Exception{
        char inicial = contato.getNome().charAt(0);
        insert(contato, Character.toUpperCase(inicial), raiz);
    }

    private void insert(Contato contato, char inicial, No i) throws Exception{

        if(i == null){
            throw new Exception("Nome invalido");
        }
        
        if(inicial == i.letra){
            i.insert(contato);
        }else if( inicial < i.letra){
            insert(contato, inicial, i.esq);
        }else {
            insert(contato, inicial, i.dir);
        }
    }

    public String remover(String nome) throws Exception{
        char inicial = nome.charAt(0);
        return remover(nome,Character.toUpperCase(inicial), raiz);
    }

    private String remover(String nome,char inicial, No i) throws Exception{

        String resp;
        if(i == null){
            throw new Exception("Não é um nome valido");
        }

        if(inicial == i.letra){
            //System.out.println("Achou o no");
            resp = i.remover(nome);
        }else if( inicial < i.letra){
           resp = remover(nome, inicial, i.esq);
        }else{
            resp = remover(nome, inicial, i.dir);
        }

        return resp;
    }

    public boolean pesquisarNome(String nome) throws Exception{
        char inicial = nome.charAt(0);
        return pesquisarNome(nome,Character.toUpperCase(inicial), raiz);
    }

    private boolean pesquisarNome(String nome,char inicial, No i) throws Exception{
        
        boolean resp;
        if(i == null){
            throw new Exception("Nome invalido");
        }

        if(inicial == i.letra){
           resp = i.pesquisarNome(nome);
        }else if( inicial < i.letra){
           resp = pesquisarNome(nome, inicial, i.esq);
        }else {
            resp = pesquisarNome(nome, inicial, i.dir);
        }

        return resp;
    }
}
