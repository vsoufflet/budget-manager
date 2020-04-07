package project.budget.utils;

import project.budget.models.bancaire.CompteBancaire;

import java.time.LocalDate;
import java.util.UUID;

public class CompteBancaireUtils {

    public static CompteBancaire getBasic() {
        CompteBancaire compte = new CompteBancaire();

        compte.setId(UUID.fromString("c93dc3f2-8cbc-47c6-8bac-123fa1371e8f"));
        compte.setNom("Courant");
        compte.setSolde(-430);
        compte.setDateOuverture(LocalDate.of(2014, 7, 26));
        compte.setDateCloture(null);
        compte.setTauxInterets(0);

        return compte;
    }
}
