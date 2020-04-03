package project.budget.models.bancaire;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CompteBancaire {
    private UUID id;
    private String nom;
    private long solde;
    private LocalDate dateOuverture;
    private LocalDate dateCloture;
    private float tauxInterets;
}
