package dev.alexandru.service.funko;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import dev.alexandru.models.Funko;

public interface FunkoService {
    CompletableFuture<Funko> save(Funko funko);
    CompletableFuture<Funko> findById(Long id);
    CompletableFuture<List<Funko>> findAll();
    CompletableFuture<List<Funko>> findByNombre(String pattern);
    CompletableFuture<Void> delete(Long id);

    CompletableFuture<Void> backup(String path) throws CustomException;
    CompletableFuture<Void> importFromCSV(String path) throws CustomException;

    void scheduleCacheCleanup();
}
