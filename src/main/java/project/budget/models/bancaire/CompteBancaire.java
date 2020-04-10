package project.budget.models.bancaire;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

