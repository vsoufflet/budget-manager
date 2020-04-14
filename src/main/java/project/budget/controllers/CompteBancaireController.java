package project.budget.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.budget.dtos.CompteBancaireRequestDto;
import project.budget.dtos.CompteBancaireResponseDto;
import project.budget.mappers.CompteBancaireMapper;
import project.budget.models.bancaire.CompteBancaire;
import project.budget.services.CompteBancaireService;

import java.util.List;
import java.util.UUID;

@RestController
public class CompteBancaireController {

    private final CompteBancaireService service;
    private final CompteBancaireMapper mapper;

    public CompteBancaireController(CompteBancaireService service, CompteBancaireMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping(value = "/comptes")
    public CompteBancaireResponseDto create(@RequestBody CompteBancaireRequestDto dto) {
        CompteBancaire compte = mapper.toEntity(dto);
        CompteBancaire created = service.create(compte);
        return mapper.toDto(created);
    }

    @GetMapping("/comptes/{id}")
    public CompteBancaireResponseDto get(@PathVariable("id") UUID compteId) {
        return mapper.toDto(service.get(compteId));
    }

    @DeleteMapping("/comptes/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID compteId) {
        service.delete(compteId);
    }

    @GetMapping("/comptes")
    public List<CompteBancaireResponseDto> getAll() {
        return mapper.toDtos(service.getAll());
    }
}
