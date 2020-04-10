package project.budget.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class CompteBancaireResponseDto {

    @JsonProperty("id")
    @NotNull
    private UUID id;

    @JsonProperty("nom")
    @NotNull
    private String nom;

    @JsonProperty("solde")
    @NotNull
    private long solde;

    @JsonProperty("date_ouverture")
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dateOuverture;

    @JsonProperty("date_cloture")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dateCloture;

    @JsonProperty("taux_interets")
    @NotNull
    private float tauxInterets;
}
