package br.edu.infnet.appimoveis.dataloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appimoveis.model.service.ApartamentoService;
import br.edu.infnet.appimoveis.models.domain.Apartamento;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Order(4)
@Component
public class ApartamentoLoader implements ApplicationRunner {
	
    @Autowired
    private ApartamentoService apartamentoService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String arq = "apartamento.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    Usuario usuario = new Usuario();
                    usuario.setId(1);

                    Apartamento apartamento = new Apartamento();
                    apartamento.setTipo(campos[7]);
                    apartamento.setSalaofesta(Boolean.valueOf(campos[4]));
                    apartamento.setAndar(Integer.valueOf(campos[5]));
                    apartamento.setCor(campos[6]);
                    apartamentoService.incluir(apartamento);
                    System.out.println("A inclusão da apartamento "+apartamento.getId()+" foi realizada com sucesso.");

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
