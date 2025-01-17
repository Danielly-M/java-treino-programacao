package br.com.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNotNull;


class CaminhoArquivoTest {

    @Test
    //@Disabled
    public void deve_montar_caminho_para_arquivo() {

        CaminhoArquivo caminhoArquivo = CaminhoArquivo.getInstance(1);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/1"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/2"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(1000);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/1000"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(1500);
        assertEquals(Paths.get("/tmp/2"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/2/1500"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2000);
        assertEquals(Paths.get("/tmp/2"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/2/2000"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2001);
        assertEquals(Paths.get("/tmp/3"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/3/2001"), caminhoArquivo.getArquivo());

        //caminhoArquivo = CaminhoArquivo.getInstance(null);
        //assertEquals(Paths.get(isNotNull()), caminhoArquivo.getDiretorio());
        //assertNull(CaminhoArquivo.getInstance(null);
    }

    @Test
    public void testGetInstanceWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            CaminhoArquivo.getInstance(null);
        });
    }

}
