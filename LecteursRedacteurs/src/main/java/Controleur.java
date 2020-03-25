/**
 * Cours : GEN
 * Laboratoire : Labo03
 * Elèves : Alois Christen, Nicolos Buzzi, Corentin Zeller
 * Date : 2020/03/25
 * Fichier : Controleur.java
 */

import java.util.*;

public class Controleur {

    private Set<Lecteur> currentReaders = new HashSet<>();
    private Redacteur currentWriter;

    private Set<Redacteur> waitingWriters = new HashSet<>();
    private Set<Lecteur> waitingReaders = new HashSet<>();


//      W R I T E

    /**
     * Met un rédacteur dans la liste d'attente, et le fait attendre son tour
     *
     * @param redacteur Le rédacteur en question
     */
    synchronized void startWriteFile(Redacteur redacteur) {
        while (!(currentReaders.isEmpty() && currentWriter == null)) {
            try {
                waitingWriters.add(redacteur);
                this.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        waitingWriters.remove(redacteur);
        this.currentWriter = redacteur;
    }

    /**
     * Stop la rédaction en cours
     * @param redacteur Le rédacteur qui stop
     * @details Il faut que le rédacteur en cours soit celui passé en paramètre
     */
    synchronized public void stopWrite(Redacteur redacteur) {
        if (redacteur != currentWriter)
            return;

        currentWriter = null;
        notifyAll();
    }

    //      R E A D

    /**
     * Met le lecteur dans la liste d'attente
     * @param lecteur Un lecteur qui désire lire le document
     */
    synchronized void startReadFile(Lecteur lecteur) {
        while (!(waitingWriters.isEmpty() && currentWriter == null)) {
            try {
                waitingReaders.add(lecteur);
                this.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        waitingReaders.remove(lecteur);
        this.currentReaders.add(lecteur);
    }

    /**
     * Stop la lecture du document pour un lecteur donné
     * @param lecteur Le lecteur qui stop la lecture
     * @details Si aucun autre lecteur n'est présent, libère l'accès en écriture
     */
    synchronized public void stopRead(Lecteur lecteur) {
        currentReaders.remove(lecteur);
        if (currentReaders.isEmpty()) {
            notifyAll();
        }
    }

    // W A I T I N G
    synchronized boolean isWaiting(Lecteur lecteur) {
        return waitingReaders.contains(lecteur);
    }

    synchronized boolean isWaiting(Redacteur redacteur) {
        return waitingWriters.contains(redacteur);
    }

}
