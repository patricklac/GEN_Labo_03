import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.fail;

public class TransfertTest {

    private Banque banqueTest;
    private Random random;

    @BeforeEach
    void setUp() {
        banqueTest = new Banque(10);
        random = new Random();
    }

    /**
     * Dans une classe de test Junit, déclencher 1000 exécutions de la classe Transfert, chacune réalisant
     * 1000 transferts, dans une banque de 10 comptes. Ne pas traiter l’accès concurrent aux comptes par
     * les threads pour l’instant
     */
    @Test
    void test1000TransfertInBanqueOf10Accounts() {
        final int NB_TRANSFERE = 1000;
        ArrayList<Transfert> transferts = new ArrayList<Transfert>();
        for (int i = 0; i < NB_TRANSFERE; ++i) {
            var transfert = new Transfert(banqueTest);
            transferts.add(transfert);
            new Thread(transfert).start();
        }

        Assertions.assertTrue(banqueTest.consistent());
    }

}
