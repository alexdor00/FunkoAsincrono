package dev.alexandru.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPConfig {
    private static final HikariConfig config = new HikariConfig();

    static {
        // Configura la URL de la base de datos, nombre de usuario y contraseña desde el archivo de propiedades.
        config.setJdbcUrl("jdbc:h2:file:./funkos");
        config.setUsername("sa");
        config.setPassword("password");

        // Configura el driver de la base de datos (en este caso, H2).
        config.setDriverClassName("org.h2.Driver");

        // Configura el tamaño máximo del pool de conexiones.
        config.setMaximumPoolSize(10);
    }

    // Crea y devuelve un DataSource de Hikari.
    public static HikariDataSource getDataSource() {
        return new HikariDataSource(config);
    }
}
