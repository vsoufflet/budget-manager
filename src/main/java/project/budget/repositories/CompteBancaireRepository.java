package project.budget.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import project.budget.models.bancaire.CompteBancaire;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class CompteBancaireRepository {

    private Logger logger = LoggerFactory.getLogger(CompteBancaireRepository.class);

    private NamedParameterJdbcTemplate jdbcTemplate;

    public CompteBancaireRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(CompteBancaire compte) {
        String request = "INSERT INTO comptes_bancaires " +
                "(id, nom, solde, date_ouverture, date_cloture, taux_interets) " +
                "VALUES " +
                "(:id, :nom, :solde, :dateOuverture, :dateCloture, :tauxInterets)";
        try {
            jdbcTemplate.update(request, new BeanPropertySqlParameterSource(compte));
        } catch (Exception e) {
            logger.error("Erreur lors de la création du compte [{}]", compte.toString(), e);
            throw e;
        }
    }

    public CompteBancaire get(UUID compteBancaireId) {
        String request = "SELECT * " +
                "FROM comptes_bancaires " +
                "WHERE " +
                "id = :id";
        try {
            return jdbcTemplate.queryForObject(request, Map.of("id", compteBancaireId), new BeanPropertyRowMapper<>(CompteBancaire.class));
        } catch (EmptyResultDataAccessException e) {
            logger.error("Aucun résultat correspondant au compte {}", compteBancaireId.toString(), e);
            throw e;
        } catch (IncorrectResultSizeDataAccessException e) {
            logger.error("Plusieurs résultats correspondant au compte {}", compteBancaireId.toString(), e);
            throw e;
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération du compte {}", compteBancaireId.toString(), e);
            throw e;
        }
    }

    public void delete(UUID compteBancaireId) {
        String request = "DELETE FROM comptes_bancaires WHERE id = :id";
        try {
            jdbcTemplate.update(request, Map.of("id", compteBancaireId));
        } catch (EmptyResultDataAccessException e) {
            logger.error("Aucun résultat correspondant au compte {}", compteBancaireId.toString(), e);
            throw e;
        } catch (IncorrectResultSizeDataAccessException e) {
            logger.error("Plusieurs résultats correspondant au compte {}", compteBancaireId.toString(), e);
            throw e;
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération du compte {}", compteBancaireId.toString(), e);
            throw e;
        }
    }

    public List<CompteBancaire> getAll() {
        String request = "SELECT * FROM comptes_bancaires";
        return jdbcTemplate.query(request, new BeanPropertyRowMapper<>(CompteBancaire.class));
    }
}
