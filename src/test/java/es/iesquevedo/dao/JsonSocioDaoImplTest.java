package es.iesquevedo.dao;

import es.iesquevedo.modelo.Socio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class JsonSocioDaoImplTest {
    @TempDir
    Path tempDir;



    @Test
    void remove() {

            // Crear archivo Json temporal
            String filePath = tempDir.resolve("socios.json").toFile().getAbsolutePath();
            JsonSocioDaoImpl dao = new JsonSocioDaoImpl(filePath);

            // Crear un socio ficticio y guardarlo
            Socio socio = new Socio("123", "Prueba");
            dao.save(socio);

            // Comprobar que existe antes de eliminar
            assertTrue(dao.findAll().contains(socio), "El socio debe estar antes de eliminar");

            //Llamar a remove
            dao.remove(socio);

            //Comprobar que ya no está
            assertFalse(dao.findAll().contains(socio), "El socio no debe estar después de eliminar");
        }
    }

