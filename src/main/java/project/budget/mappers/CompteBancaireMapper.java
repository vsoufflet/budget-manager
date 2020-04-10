package project.budget.mappers;

import org.springframework.stereotype.Component;
import project.budget.dtos.CompteBancaireRequestDto;
import project.budget.dtos.CompteBancaireResponseDto;
import project.budget.models.bancaire.CompteBancaire;

@Component
public class CompteBancaireMapper implements Mapper<CompteBancaireRequestDto, CompteBancaire, CompteBancaireResponseDto> {

    @Override
    public CompteBancaire toEntity(CompteBancaireRequestDto inputDto) {
        return CompteBancaire.builder()
                .nom(inputDto.getNom())
                .solde(inputDto.getSolde())
                .dateOuverture(inputDto.getDateOuverture())
                .dateCloture(inputDto.getDateCloture())
                .tauxInterets(inputDto.getTauxInterets())
                .build();
    }

    @Override
    public CompteBancaireResponseDto toDto(CompteBancaire entity) {
        return CompteBancaireResponseDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .solde(entity.getSolde())
                .dateOuverture(entity.getDateOuverture())
                .dateCloture(entity.getDateCloture())
                .tauxInterets(entity.getTauxInterets())
                .build();
    }
}
