package project.budget.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidService {

    public UUID generateUuid() {
        return UUID.randomUUID();
    }
}
