package models.depenses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import models.bancaire.MoyenPaiement;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Achat extends Depense {

    private MoyenPaiement moyenPaiement;
    private List<Produit> produits;

    @Override
    Periodicite getPeriodicite() {
        return Periodicite.PONCTUELLE;
    }
}
