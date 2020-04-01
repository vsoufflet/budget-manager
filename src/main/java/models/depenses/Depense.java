package models.depenses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import models.bancaire.MoyenPaiement;
import models.bancaire.Operation;
import models.bancaire.TypeOperation;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class Depense implements Operation {
    private LocalDate date;
    private long montant;
    private Categorie categorie;
    private String adresseFacture;

    abstract MoyenPaiement getMoyenPaiement();

    abstract Periodicite getPeriodicite();

    @Override
    public TypeOperation getTypeOperation() {
        return TypeOperation.DEPENSE;
    }
}
