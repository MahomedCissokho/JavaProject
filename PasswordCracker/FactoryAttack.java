public class FactoryAttack {

    public static Technique getInstance(String choix1, String choix2) {
        Technique maTechnique = null;
        if ((choix1.equals("1")) && (choix2.equals("a"))) {
            maTechnique = new BruteForceAttack();

        } else if ((choix1.equals("1")) && (choix2.equals("b"))) {
            maTechnique = new DictionnaryAttack();
        } else if ((choix1.equals("2")) && (choix2.equals("a"))) {
            maTechnique = new BruteForceAttack();
        } else {
            maTechnique = new DictionnaryAttack();
        }
        return maTechnique;
    }
}
