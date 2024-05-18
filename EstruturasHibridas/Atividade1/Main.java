package EstruturasHibridas.Atividade1;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Contato contato1 = new Contato("Andre","31999999" , "andre@gmail.com", 7013332);
        Contato contato2 = new Contato("gustavo","31999999" , "andre@gmail.com", 7013332);
        Contato contato3 = new Contato("Laryssa","31999999" , "andre@gmail.com", 7013332);
        Contato contato4 = new Contato("Alline","31999999" , "andre@gmail.com", 7013332);
        Contato contato5 = new Contato("Paulo","31999999" , "andre@gmail.com", 7013332);

        try {
            agenda.insert(contato1);
            agenda.insert(contato2);
            agenda.insert(contato3);
            agenda.insert(contato4);
            agenda.insert(contato5);

            System.out.println(agenda.pesquisarNome("Andre"));
            System.out.println(agenda.pesquisarNome("Carlos"));

            System.out.println(agenda.remover("Andre"));

            System.out.println(agenda.pesquisarNome("Andre"));
            System.out.println(agenda.pesquisarNome("Alline"));


        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
