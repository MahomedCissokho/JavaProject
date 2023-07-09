import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class DictionnaryAttack extends Technique {

    public static String cryptographyDictionary(String input) {

        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");

            byte[] valueHashInByte = instance.digest(input.getBytes());
            BigInteger converterToHex = new BigInteger(1, valueHashInByte);
            String hashValueInString = converterToHex.toString(16);

            while (hashValueInString.length() < 40) {
                hashValueInString = "0" + hashValueInString;

            }

            return hashValueInString;

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);
        }

    }

    public void attackHash(String hash) {
        long startTime = System.currentTimeMillis();
        Scanner scanner;
        boolean find = false;
        // Temps écoulé

        try {
            scanner = new Scanner(new File("wordlist.txt"));
            while (scanner.hasNextLine() && !find) {
                String[] currentLine = scanner.nextLine().split(";");

                
                if (currentLine[1].equals(hash)) {
                    System.out.println();
                    System.out.println("-------------------- --------------------");
                    System.out.println();
                    System.out.println("Mot de passe [*] : " + currentLine[0]);
                    System.out.println();
                    System.out.println("Temps [*] : " + (System.currentTimeMillis() - startTime) / 1000.0 + " sec");
                    System.out.println();
                    find = true;
                }
            }
            if (!find)
                System.out.println("Mot de passe non trouve !!!");

        } catch (FileNotFoundException file) {
            System.out.println("Echec de l'ouverture du fichier ! Veuillez reessayer.");
        }

    }

    public void attackSimply(String password) {
        long debutTime = System.currentTimeMillis();
        Scanner scanner;
        boolean find = false;
        // Temps écoulé
        String hashValue = cryptographyDictionary(password);
        try {
            scanner = new Scanner(new File("wordlist.txt"));

            while (scanner.hasNextLine() && !find) {
                String[] currentLine = scanner.nextLine().split(";");

                if (hashValue.equals(currentLine[1])) {
                    System.out.println();
                    System.out.println("------------------- ---------------------");
                    System.out.println();
                    System.out.println("Temps [*] : " + (System.currentTimeMillis() - debutTime) / 1000.0 + " sec");
                    System.out.println();
                    System.out.println("Mot de passe fourni : " + currentLine[0]);
                    System.out.println();

                    find = true;
                }
            }
            if (!find)
                System.out.println("Hachage non trouve !!!");

        } catch (FileNotFoundException file) {
            System.out.println("Echec de l'ouverture du fichier ! Veuillez reessayer.");
        }
    }
}
