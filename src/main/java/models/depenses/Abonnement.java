package models.depenses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import models.bancaire.MoyenPaiement;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Abonnement extends Depense {

    Contrat contrat;

    @Override
    MoyenPaiement getMoyenPaiement() {
        return MoyenPaiement.PRELEVEMENT;
    }

    @Override
    Periodicite getPeriodicite() {
        return Periodicite.MENSUELLE;
    }
}
