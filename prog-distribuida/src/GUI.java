import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Scanner;

public class GUI implements Serializable {
    private static Scanner sc = new Scanner(System.in);

    public static void principalMenu(ServerInterface server, int idClient) throws RemoteException {
        int idGroup = 0, idMember = idClient;
        String nameGroup, memberNickname;
        boolean menu = true;
        while (menu) {
            System.out.println("Escolha uma das opções.");
            System.out.println("1. Criar novo grupo\n"
                    + "2. Entrar em um grupo\n"
                    + "3. Sair de um grupo\n"
                    + "4. Enviar mensagem a um grupo \n"
                    + "5. Sair");
            System.out.println("Digite a opção:");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("\t_______________CRIAR GRUPO_______________");
                    System.out.println("Insira o nome do grupo: ");
                    nameGroup=sc.next();

                    System.out.println("Insira seu apelido no grupo: ");
                    memberNickname=sc.next();

                    server.createGroup(nameGroup, new Member(memberNickname, idMember));

                    System.out.println("Grupo criado por "+idMember+"!");
                    System.out.println("\t---------------------------------------------------");
                        
                    break;

                case 2:
                    System.out.println("\t_______________ENTRAR EM UM GRUPO_______________");
                    System.out.printf("Insira o ID do grupo: ");
                    idGroup=sc.nextInt();

                    System.out.printf("Insira seu apelido no grupo: ");
                    memberNickname=sc.next();

                    server.addMember(idGroup, new Member(memberNickname, idMember));

                    System.out.println("Entrou no grupo!");
                    System.out.println("\t---------------------------------------------------");
                    break;

                case 3:
                    System.out.println("\t_______________SAIR DE UM GRUPO_______________");
                    System.out.printf("Insira o ID do grupo: ");
                    idGroup=sc.nextInt();

                    server.removeMember(idGroup, idMember);

                    System.out.println("Saiu do grupo!");
                    System.out.println("\t---------------------------------------------------");

                    break;
                
                case 4:
                    System.out.println("\t_______________ENVIAR MENSAGEM_______________");
                    System.out.printf("Insira o ID do grupo: ");
                    idGroup=sc.nextInt();

                    System.out.printf("Insira o ID do membro: ");
                    idMember=sc.nextInt();

                    server.sendMessage(idGroup, idMember);

                    System.out.println("Mensagem enviada!");
                    System.out.println("\t---------------------------------------------------");
                    break;

                case 5:
                    System.out.println("Saindo... ");
                    menu = false;
                    break;
            }

        }
    }
}
