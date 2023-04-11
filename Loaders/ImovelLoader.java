package br.edu.infnet.appimoveis.dataloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appimoveis.model.service.ImovelService;
import br.edu.infnet.appimoveis.models.domain.Imovel;

@Order(6)
@Component
public class ImovelLoader implements ApplicationRunner {
	
    @Autowired
    private ImovelService imovelService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String arq = "imovel.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    
                    Imovel imovel = new Imovel();
                    imovel.setId(Integer.valueOf(campos[0]));
                    imovel.setCodigo(campos[1]);
                    imovel.setValor(Float.valueOf(campos[2]));
                    imovel.setProntaentrega(campos[3]);
                    imovelService.incluir(imovel);
                    System.out.println("A inclusão da imovel "+imovel.getId()+" foi realizada com sucesso.");

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