/**
 * Cours : GEN
 * Laboratoire : Labo03
 * Elèves : Alois Christen, Nicolos Buzzi, Corentin Zeller
 * Date : 2020/03/25
 * Fichier : Redacteur.java
 */

public class Redacteur implements Runnable {


    private Controleur controleur;


    public Redacteur(Controleur controleur) {
        this.controleur = controleur;
    }

    /**
     * Comment la rédaction par le biais du controleur
     * @throws InterruptedException
     * @details Met le thread en sleep 1 ms afin de permettre au processeur
     * de reprendre la main
     */
    synchronized public void startWrite() throws InterruptedException {
        new Thread(this).start();
        Thread.sleep(1);
    }

    /**
     * signale au controleur la fin de la rédaction
     * @throws InterruptedException
     * @details Met le thread en sleep 1 ms afin de permettre au processeur
     * de reprendre la main
     */
    synchronized public void stopWrite() throws InterruptedException {
        this.controleur.stopWrite(this);
        Thread.sleep(1);
    }

    public boolean isWaiting() {
        return this.controleur.isWaiting(this);
    }

    @Override
    public void run() {
        this.controleur.startWriteFile(this);
    }
}