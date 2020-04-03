package project.budget.models.depenses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.budget.models.bancaire.TypeCommerce;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Commercant {
    private String nom;
    private String localisation;
    private TypeCommerce typeCommerce;
}
