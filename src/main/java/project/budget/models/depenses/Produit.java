package project.budget.models.depenses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Produit {
    private String nom;
    private long prix;
    private Commercant commercant;
}
