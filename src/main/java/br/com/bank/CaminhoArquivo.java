package br.com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import javax.persistence.Id;

import org.mockito.internal.matchers.NotNull;

public class CaminhoArquivo {


    private Path diretorio;

    private Path arquivo;

    private CaminhoArquivo(Path diretorio, Path arquivo) {
        super();
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
        return arquivo;
    }
    //public boolean assertNotNull() {
        //if(id == null){
            //throw new idInvalida();
        //}
    //}

    /**
     * @param id
     * @return
     */
    public static CaminhoArquivo getInstance(Integer id) {
        String nomeDoDiretorio = "/tmp/";
        String localDoArquivo; 
        int s = 1;
        String nomeCompleto;
        if(id == null){
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        for(int i = 1; i <= id; i++){
            if(i <= 1000){
                s = 1;
            }
            else if (i % 1000 == 1){
                s++;
            }           
        }
        localDoArquivo = nomeDoDiretorio + Integer.toString(s);
        nomeCompleto = localDoArquivo + '/' + id;
        return new CaminhoArquivo(Paths.get(localDoArquivo), Paths.get(nomeCompleto));
         
    }


    }



