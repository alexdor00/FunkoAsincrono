package dev.alexandru.repositories.funko;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import dev.alexandru.models.Funko;

public interface FunkoRepository {
    CompletableFuture<Funko> save(Funko funko);
    CompletableFuture<Funko> findById(Long id);
    CompletableFuture<List<Funko>> findAll();
    CompletableFuture<List<Funko>> findByNombre(String pattern);
    CompletableFuture<Void> delete(Long id);
}
