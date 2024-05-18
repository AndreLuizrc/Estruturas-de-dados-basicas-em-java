package EstruturasHibridas.Atividade1;

public class No {
    public char letra;
    public No esq,dir;
    public Celula primeiro,ultimo;

    public No(){

    }

    public No(char letra){
        this.letra = letra;
        this.esq = null;
        this.dir = null;
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public void insert(Contato contato){
        ultimo.prox = new Celula(contato);
        ultimo = ultimo.prox;
    }

    public String remover(String nome) throws Exception{


        Celula i = primeiro;
        int cont_posicao = 0;
        String resp = "";
        
        while(i != null){
            if(i.contato.getNome().equals(nome) == true){
                Celula j = primeiro;
                for(int k = 0; k < cont_posicao - 1; k++, j = j.prox);
        
                resp = i.contato.getNome();
                //System.out.println(j.contato.getNome());
                j.prox = i.prox;
                i.prox = null;
                i = j = null;
            }else{
                i = i.prox;
                cont_posicao++;
            }
        }

        
        if(resp.equals("") == false){
            return resp;
        }else{
            throw new Exception("O item solicitado não foi encontrado!");
        }

    }

    public boolean pesquisarNome(String nome){

        Celula i = primeiro;
        boolean resp = false;
        
        while(i != null){
            if(i.contato.getNome().equals(nome) == true){
                resp = true;
                i = ultimo.prox;
            }else{
                i = i.prox;
            }
        }

        return resp;
    }
}
