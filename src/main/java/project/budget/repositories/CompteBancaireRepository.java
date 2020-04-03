package project.budget.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import project.budget.models.bancaire.CompteBancaire;

@Repository
public class CompteBancaireRepository {

    private Logger logger = LoggerFactory.getLogger(CompteBancaireRepository.class);

    private NamedParameterJdbcTemplate jdbcTemplate;

    public CompteBancaireRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(CompteBancaire compte) {

        String request = "INSERT INTO budget.comptes_bancaires " +
                "(id, nom, solde, date_ouverture, date_cloture, taux_interets) " +
                "VALUES " +
                "(:id, :nom, :solde, :dateOuverture, :dateCloture, :tauxInterets)";

        try {
            jdbcTemplate.update(request, new BeanPropertySqlParameterSource(compte));
        } catch (Exception e) {
            logger.error("Erreur lors de la création du compte [{}]", compte.toString(), e);
        }
    }
}
