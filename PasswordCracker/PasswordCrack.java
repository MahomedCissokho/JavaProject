import java.util.Scanner;

public class PasswordCrack {
    
    public static void main(String[] args) {
        String reponse ;
        Technique maTechnique;
        String choice;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("\n***************** PASSWORD CR@CKER Vous souhaite la Bienvenue *****************");
            System.out.println("1. Cassage de mot de passe simple");
            System.out.println("2. Cassage de Hash ");
            System.out.print("Veuillez faire votre choix : ");
            choice = sc.nextLine();
            System.out.println();

            switch (choice) {
                case "1": {
                    System.out.println("a. Technique par brute force");
                    System.out.println("b. Technique du dictionnaire");
                    System.out.print("Veuillez faire votre choix : ");
                    String choice1 = sc.nextLine();
                    System.out.println();


                    switch (choice1) {
                        case "a": {
                            System.out.print("Veuillez saisir votre mot de passe : ");
                            String password = sc.nextLine();
                            maTechnique = FactoryAttack.getInstance(choice, choice1);
                            maTechnique.attackSimply(password);
                            
                            break;
                        }
                        case "b": {
                            System.out.print("Veuillez saisir votre mot de passe : ");
                            String password = sc.nextLine();
                            maTechnique = FactoryAttack.getInstance(choice, choice1);
                            maTechnique.attackSimply(password);
                            
                            break;
                        }
                        default: {
                            System.out.println("Il n'y a que deux possibilites a ou b !!\n");
                            break;
                        }
                    }
                    break;
                }
                case "2": {
                    System.out.println("a. Technique par brute force");
                    System.out.println("b. Technique du dictionnaire");
                    System.out.print("Veuillez faire votre choix : ");
                    String choice1 = sc.nextLine();
                    System.out.println();


                    switch (choice1) {
                        case "a": {
                            System.out.print("Veuillez saisir le hash : ");
                            String hash = sc.nextLine();
                            maTechnique = FactoryAttack.getInstance(choice, choice1);
                            maTechnique.attackHash(hash);
                            
                            break;
                        }
                        case "b": {
                            System.out.print("Veuillez saisir le hash : ");
                            String hash = sc.nextLine();
                            maTechnique = FactoryAttack.getInstance(choice, choice1);
                            maTechnique.attackHash(hash);
                            
                            break;
                        }
                        default: {
                            System.out.println("Il n'y a que deux possibilites a ou b !!\n");
                            break;
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Choix invalide !\n");
                    break;
                }
            }
            System.out.print("Souhaitez-vous Continuer -- Tapez Oui/Nom : ");
            reponse = sc.nextLine();
            System.out.println();

        }while(reponse.equalsIgnoreCase("Oui")) ;
        
        if(!reponse.equalsIgnoreCase("Oui")) 
            System.out.println("\n Au revoir et A Bientot !");

        sc.close();
    }
}