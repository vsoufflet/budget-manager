package project.budget.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import project.budget.models.bancaire.CompteBancaire;
import project.budget.repositories.CompteBancaireRepository;

@Service
public class CompteBancaireService {

    private Logger logger = LoggerFactory.getLogger(CompteBancaireService.class);

    private UuidService uuidService;
    private CompteBancaireRepository repository;

    public CompteBancaireService(UuidService uuidService, CompteBancaireRepository repository) {
        this.uuidService = uuidService;
        this.repository = repository;
    }

    public CompteBancaire create(CompteBancaire compte) {
        compte.setId(uuidService.generateUuid());
        repository.create(compte);
        return compte;
    }
}
