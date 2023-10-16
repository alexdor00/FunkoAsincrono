package dev.alexandru.models;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Funko {
    private Long id;
    private UUID cod;
    private Long MyId;
    private String nombre;
    private String modelo;
    private BigDecimal precio;
    private LocalDate fecha_lanzamiento;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
