
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        /**
         * declaration et initialisation des variables
         * fileReader permet d'effectuer une lecture dans le fichier
         */

        int port = 8081;
        String password, line;
        boolean isCorrectPassword = false;
        int nbaffiche = 1;
        String finalResponse = null;
        File file = new File("dictionary.txt");

        BufferedReader fileReader = new BufferedReader(new FileReader(file.getAbsolutePath()));

        do {
            try {
                /**
                 * Le client cree une connexion vers le serveur
                 */
                Socket clientSocket = new Socket(InetAddress.getLocalHost(), port);

                /**
                 * Creation des flux d'entree et de sortie
                 */

                OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
                InputStreamReader reader = new InputStreamReader(clientSocket.getInputStream());

                /**
                 * On genere le mot de passe en faisant une lecture dans le dictionnaire
                 */

                password = fileReader.readLine();

                /**
                 * Recuperation mot de passe client et envoi vers le serveur de la requete http
                 */

                writer.write("GET /index1.php?password=" + password + " HTTP/1.1\r\n");
                writer.write("Host: " + InetAddress.getLocalHost().getHostName() + " \r\n");
                writer.write("\r\n");
                writer.flush();

                /**
                 * Lecture de la reponse du serveur et affichage
                 */

                if (nbaffiche == 1) {
                    nbaffiche = 0;
                    System.out.println(
                            "\n ---------------- Traitement en cours de la reponse du serveur ---------------\n");
                }

                BufferedReader streamReader = new BufferedReader(reader);

                while ((line = streamReader.readLine()) != null) {
                    if (line.contains("true")) {
                        isCorrectPassword = true;
                        finalResponse = streamReader.readLine();
                        break;
                    }
                    finalResponse = line;
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } while (!isCorrectPassword && fileReader.ready());

        System.out.println(finalResponse);
        fileReader.close();
    }
}