package dev.alexandru;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Configurar los componentes necesarios: DatabaseManager, IdGenerator, FunkoRepository, etc.

        // Ejemplos de casos correctos
        CompletableFuture<Funko> saveResult = funkService.save(new Funko());
        Funko savedFunko = saveResult.get();

        CompletableFuture<Funko> findResult = funkService.findById(savedFunko.getId());
        Funko foundFunko = findResult.get();

        CompletableFuture<List<Funko>> allFunkosResult = funkService.findAll();
        List<Funko> allFunkos = allFunkosResult.get();

        CompletableFuture<List<Funko>> findByNombreResult = funkService.findByNombre("Marvel");
        List<Funko> marvelFunkos = findByNombreResult.get();

        CompletableFuture<Void> backupResult = funkService.backup("/path/to/backup.json");
        backupResult.get();

        CompletableFuture<Void> importResult = funkService.importFromCSV("/path/to/import.csv");
        importResult.get();

        // Ejemplos de casos incorrectos (manejo de excepciones personalizadas)
        try {
            CompletableFuture<Void> invalidBackup = funkService.backup("invalid-path.json");
            invalidBackup.get();
        } catch (CustomException ex) {
            System.err.println("Error al realizar la copia de seguridad: " + ex.getMessage());
        }

        try {
            CompletableFuture<Void> invalidImport = funkService.importFromCSV("non-existent-file.csv");
            invalidImport.get();
        } catch (CustomException ex) {
            System.err.println("Error al importar desde CSV: " + ex.getMessage());
        }

        // Ejemplos de consultas asíncronas
        CompletableFuture<Funko> mostExpensiveFunko = funkService.findMostExpensiveFunko();
        CompletableFuture<Double> averagePrice = funkService.calculateAveragePrice();
        CompletableFuture<List<Funko>> funkosByModel = funkService.groupFunkosByModel();
        CompletableFuture<List<FunkoCount>> funkosPerModel = funkService.countFunkosPerModel();
        CompletableFuture<List<Funko>> funkosReleasedIn2023 = funkService.findFunkosReleasedInYear(2023);
        CompletableFuture<Long> stitchFunkosCount = funkService.countFunkosByNombre("Stitch");
        CompletableFuture<List<Funko>> stitchFunkos = funkService.findFunkosByNombre("Stitch");

        // Obtener resultados de las consultas
        try {
            Funko mostExpensive = mostExpensiveFunko.get(5, TimeUnit.SECONDS);
            System.out.println("Funko más caro: " + mostExpensive);

            Double avgPrice = averagePrice.get(5, TimeUnit.SECONDS);
            System.out.println("Media de precio de Funkos: " + avgPrice);

            List<Funko> groupedFunkos = funkosByModel.get(5, TimeUnit.SECONDS);
            System.out.println("Funkos agrupados por modelos: " + groupedFunkos);

            List<FunkoCount> funkosCounts = funkosPerModel.get(5, TimeUnit.SECONDS);
            System.out.println("Número de funkos por modelo: " + funkosCounts);

            List<Funko> funkosIn2023 = funkosReleasedIn2023.get(5, TimeUnit.SECONDS);
            System.out.println("Funkos lanzados en 2023: " + funkosIn2023);

            Long stitchCount = stitchFunkosCount.get(5, TimeUnit.SECONDS);
            System.out.println("Número de Funkos de Stitch: " + stitchCount);

            List<Funko> stitchList = stitchFunkos.get(5, TimeUnit.SECONDS);
            System.out.println("Listado de Funkos de Stitch: " + stitchList);
        } catch (TimeoutException ex) {
            System.err.println("Error al obtener resultados de consultas: " + ex.getMessage());
        }
    }
}
