package project.budget.models.depenses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.budget.models.bancaire.MoyenPaiement;
import project.budget.models.bancaire.Operation;
import project.budget.models.bancaire.TypeOperation;

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
