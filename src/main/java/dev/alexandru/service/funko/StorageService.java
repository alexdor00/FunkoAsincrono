package dev.alexandru.service.funko;

public interface StorageService {
    CompletableFuture<Void> exportToJson(List<Funko> data, String path);
    CompletableFuture<List<Funko>> importFromCSV(String path);
}
