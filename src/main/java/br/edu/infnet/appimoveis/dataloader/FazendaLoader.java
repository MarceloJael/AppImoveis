package br.edu.infnet.appimoveis.dataloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appimoveis.model.service.FazendaService;
import br.edu.infnet.appimoveis.models.domain.Fazenda;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Order(5)
@Component
public class FazendaLoader implements ApplicationRunner {
	
    @Autowired
    private FazendaService fazendaService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String arq = "fazenda.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    		
                    Usuario usuario = new Usuario();
                    usuario.setId(1);

                    Fazenda fazenda = new Fazenda();
                    fazenda.setTipo(campos[7]);
                    fazenda.setEstabulo(Boolean.valueOf(campos[4]));
                    fazenda.setHectares(Integer.valueOf(campos[5]));
                    fazenda.setTipoplantacao(campos[6]);
                    fazendaService.incluir(fazenda);
                    System.out.println("A inclusão da fazenda "+fazenda.getId()+" foi realizada com sucesso.");

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
