package project.budget.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import project.budget.models.bancaire.CompteBancaire;
import project.budget.repositories.CompteBancaireRepository;

import java.util.List;
import java.util.UUID;

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

    public CompteBancaire get(UUID compteId) {
        return repository.get(compteId);
    }

    public void delete(UUID compteId) {
        repository.delete(compteId);
    }

    public List<CompteBancaire> getAll() {
        return repository.getAll();
    }
}
