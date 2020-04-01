package models.bancaire;

import java.time.LocalDate;

public interface Operation {
    LocalDate getDate();

    long getMontant();

    TypeOperation getTypeOperation();
}
