package project.budget.models.depenses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.budget.models.bancaire.MoyenPaiement;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Achat extends Depense {

    private MoyenPaiement moyenPaiement;

    @Override
    Periodicite getPeriodicite() {
        return Periodicite.PONCTUELLE;
    }
}
