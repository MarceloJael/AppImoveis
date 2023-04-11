package br.edu.infnet.appimoveis.dataloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appimoveis.model.service.CasaService;
import br.edu.infnet.appimoveis.models.domain.Casa;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Order(3)
@Component
public class CasaLoader implements ApplicationRunner {
	
    @Autowired
    private CasaService casaService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String arq = "casa.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    
                    Usuario usuario = new Usuario();
                    usuario.setId(1);

                    Casa casa = new Casa();
                    casa.setTipo(campos[7]);
                    casa.setQuintal(Boolean.valueOf(campos[4]));
                    casa.setTamanho(Integer.valueOf(campos[5]));
                    casa.setCor(campos[6]);
                    casaService.incluir(casa);
                    System.out.println("A inclusão da casa "+casa.getId()+" foi realizada com sucesso.");

                    linha = leitura.readLine();
                }
                leitura.close();
                fileR.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("A inclusão foi um sucesso.");
        }
    }

}
