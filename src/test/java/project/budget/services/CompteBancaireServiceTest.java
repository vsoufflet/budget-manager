package project.budget.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.budget.models.bancaire.CompteBancaire;
import project.budget.repositories.CompteBancaireRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static project.budget.utils.CompteBancaireUtils.getBasic;

@ExtendWith(MockitoExtension.class)
class CompteBancaireServiceTest {

    @Mock
    private UuidService uuidService;

    @Mock
    private CompteBancaireRepository repository;

    @InjectMocks
    private CompteBancaireService service;

    @Test
    void create() {
        CompteBancaire compte = getBasic();

        UUID uuid = UUID.randomUUID();
        when(uuidService.generateUuid()).thenReturn(uuid);

        doNothing().when(repository).create(any());

        CompteBancaire actual = service.create(compte);

        assertThat(actual.getId()).isEqualTo(uuid);
        verify(uuidService).generateUuid();
        verify(repository).create(compte);
    }
}
