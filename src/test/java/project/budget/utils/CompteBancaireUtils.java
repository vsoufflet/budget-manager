package project.budget.utils;

import project.budget.models.bancaire.CompteBancaire;

import java.time.LocalDate;
import java.util.UUID;

public class CompteBancaireUtils {

    public static CompteBancaire getBasic() {
        return CompteBancaire.builder()
                .id(UUID.fromString("c93dc3f2-8cbc-47c6-8bac-123fa1371e8f"))
                .nom("Courant")
                .solde(-430)
                .dateOuverture(LocalDate.of(2014, 7, 26))
                .dateCloture(null)
                .tauxInterets(0)
                .build();
    }
}
