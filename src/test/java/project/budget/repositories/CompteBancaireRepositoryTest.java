package project.budget.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import project.budget.AppConfiguration;
import project.budget.models.bancaire.CompteBancaire;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static project.budget.utils.CompteBancaireUtils.getBasic;
import static project.budget.utils.CompteBancaireUtils.getList;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {AppConfiguration.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
class CompteBancaireRepositoryTest {

    @Autowired
    private CompteBancaireRepository repository;

    @Test
    void create_ok() {
        CompteBancaire compte = getBasic();
        repository.create(compte);

        CompteBancaire fromDB = repository.get(compte.getId());
        assertEquals(compte, fromDB);
    }

    @Test
    void create_ko() {
        CompteBancaire compte = getBasic();
        compte.setId(null);

        Assertions.assertThatExceptionOfType(DataAccessException.class)
                .isThrownBy(() -> repository.create(compte));
    }

    @Test
    void delete_ok() {
        CompteBancaire compte = getBasic();
        repository.create(compte);

        assertThat(repository.get(compte.getId())).isEqualTo(compte);

        repository.delete(compte.getId());

        assertThatExceptionOfType(EmptyResultDataAccessException.class)
                .isThrownBy(() -> repository.get(compte.getId()));
    }

    @Test
    void getAll_ok() {
        List<CompteBancaire> comptes = getList();
        comptes.forEach(c -> repository.create(c));

        List<CompteBancaire> actual = repository.getAll();

        assertThat(actual).isEqualTo(comptes);
    }
}
