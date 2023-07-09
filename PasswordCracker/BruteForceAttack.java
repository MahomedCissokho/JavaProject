
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class BruteForceAttack extends Technique {

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
        long debutTime = System.currentTimeMillis();
        int minLength = 1; // Minimum length of combinations
        int maxLength = 5; // Maximum length of combinations

        for (int length = minLength; length <= maxLength; length++) {
            generateCombinationsHash(hash, "", length, debutTime);
        }
    }

    public void attackSimply(String password) {
        final long debutTime = System.currentTimeMillis() ;
        String hash = cryptographyDictionary(password);
        int minLength = 1; // Minimum length of combinations
        int maxLength = 5; // Maximum length of combinations

        for (int length = minLength; length <= maxLength; length++) {
            generateCombinationsHash(hash, "", length, debutTime);
        }
    }

    private static void generateCombinationsHash(String hash, String combination, int length, long startTime) {

        if (combination.length() == length) {
            String result = combination;
            String hashedResult = cryptographyDictionary(result);
            if (hashedResult.equals(hash)) {
                System.out.println();
                System.out.println("-------------------- ---------------------");
                System.out.println();
                System.out.println("Votre mot de passe est : " + result);
                System.out.println("[*] Temps : " + (System.currentTimeMillis() - startTime)/1000.0 + " sec \n");
            }
        } else {
            for (char c = 'a'; c <= 'z'; c++) {
                generateCombinationsHash(hash, combination + c, length, startTime);
            }
        }
    }
}
