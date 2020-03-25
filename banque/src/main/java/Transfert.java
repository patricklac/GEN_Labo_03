import java.util.Random;

public class Transfert implements Runnable {

    private Random random;
    private int numberOfTransferToComplete;
    private final Banque banque;

    public Transfert(Banque banque) {
        if(banque == null)
            throw new IllegalArgumentException("please provide a bank");

        this.banque = banque;
        random = new Random();
        numberOfTransferToComplete = 1000;
    }

    @Override
    public void run() {
        for(int i = 0; i < numberOfTransferToComplete; ++i) {
            int montant = random.nextInt(100);
            int crediteur = random.nextInt(banque.getNbComptes());
            int debiteur = random.nextInt(banque.getNbComptes());
            banque.transfert(debiteur, crediteur, montant);
        }
    }
}
