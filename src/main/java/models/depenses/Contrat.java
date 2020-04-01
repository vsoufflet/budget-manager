package models.depenses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Contrat {
    private String label;
    private LocalDate souscription;
    private LocalDate finEngagement;
    private LocalDate resiliation;
}
