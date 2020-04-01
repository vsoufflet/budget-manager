package models.bancaire;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CompteBancaire {
    private String nom;
    private long solde;
    private List<Operation> operations;
    private LocalDate dateOuverture;
    private LocalDate dateCloture;
    private float tauxInterets;
}
