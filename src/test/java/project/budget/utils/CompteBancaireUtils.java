package project.budget.utils;

import project.budget.dtos.CompteBancaireRequestDto;
import project.budget.dtos.CompteBancaireResponseDto;
import project.budget.models.bancaire.CompteBancaire;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class CompteBancaireUtils {

    public static CompteBancaire getBasic() {
        return CompteBancaire.builder()
                .id(UUID.fromString("c93dc3f2-8cbc-47c6-8bac-123fa1371e8f"))
                .nom("Courant")
                .solde(-430)
                .dateOuverture(LocalDate.of(2014, 7, 26))
                .dateCloture(LocalDate.of(2020, 4, 14))
                .tauxInterets(0)
                .build();
    }

    public static CompteBancaireRequestDto getBasicRequestDto() {
        CompteBancaireRequestDto dto = new CompteBancaireRequestDto();

        dto.setNom("Courant");
        dto.setSolde(-430);
        dto.setDateOuverture(LocalDate.of(2014, 7, 26));
        dto.setDateCloture(LocalDate.of(2020, 4, 14));
        dto.setTauxInterets(0);

        return dto;
    }

    public static CompteBancaireResponseDto getBasicResponseDto() {
        return CompteBancaireResponseDto.builder()
                .id(UUID.fromString("c93dc3f2-8cbc-47c6-8bac-123fa1371e8f"))
                .nom("Courant")
                .solde(-430)
                .dateOuverture(LocalDate.of(2014, 7, 26))
                .dateCloture(LocalDate.of(2020, 4, 14))
                .tauxInterets(0)
                .build();
    }

    public static List<CompteBancaire> getList() {
        return List.of(
                CompteBancaire.builder()
                        .id(UUID.fromString("c93dc3f2-8cbc-47c6-8bac-123fa1371e8f"))
                        .nom("Courant")
                        .solde(-430)
                        .dateOuverture(LocalDate.of(2014, 7, 26))
                        .dateCloture(LocalDate.of(2020, 4, 14))
                        .tauxInterets(0)
                        .build(),
                CompteBancaire.builder()
                        .id(UUID.fromString("8c749245-3c8b-4699-8040-8333c5dd0af5"))
                        .nom("PEL")
                        .solde(7500)
                        .dateOuverture(LocalDate.of(2014, 7, 26))
                        .tauxInterets(2.5F)
                        .build()
        );
    }

    public static List<CompteBancaireResponseDto> getResponseDtoList() {
        return List.of(
                CompteBancaireResponseDto.builder()
                        .id(UUID.fromString("c93dc3f2-8cbc-47c6-8bac-123fa1371e8f"))
                        .nom("Courant")
                        .solde(-430)
                        .dateOuverture(LocalDate.of(2014, 7, 26))
                        .dateCloture(LocalDate.of(2020, 4, 14))
                        .tauxInterets(0)
                        .build(),
                CompteBancaireResponseDto.builder()
                        .id(UUID.fromString("8c749245-3c8b-4699-8040-8333c5dd0af5"))
                        .nom("PEL")
                        .solde(7500)
                        .dateOuverture(LocalDate.of(2014, 7, 26))
                        .dateCloture(LocalDate.of(2020, 4, 14))
                        .tauxInterets(2.5F)
                        .build()
        );
    }
}
