/**
 * Cours : GEN
 * Laboratoire : Labo03
 * Elèves : Alois Christen, Nicolos Buzzi, Corentin Zeller
 * Date : 2020/03/25
 * Fichier : Lecteur.java
 */

public class Lecteur implements Runnable {


    private Controleur controleur;


    public Lecteur(Controleur controleur) {
        this.controleur = controleur;
    }

    /**
     * Comment la lecture par le biais du controleur
     * @throws InterruptedException
     * @details Met le thread en sleep 1 ms afin de permettre au processeur
     * de reprendre la main
     */
    synchronized public void startRead() throws InterruptedException {
        new Thread(this).start();
        Thread.sleep(1);
    }

    /**
     * Signale au controleur la fin de notre lecture
     * @throws InterruptedException
     * @details Met le thread en sleep 1 ms afin de permettre au processeur
     * de reprendre la main
     */
    synchronized public void stopRead() throws InterruptedException {
        this.controleur.stopRead(this);
        Thread.sleep(1);
    }

    public boolean isWaiting() {
        return this.controleur.isWaiting(this);
    }

    @Override
    public void run() {
        this.controleur.startReadFile(this);
    }
}