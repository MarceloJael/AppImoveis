package br.edu.infnet.appimoveis.dataloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appimoveis.model.service.ClienteService;
import br.edu.infnet.appimoveis.models.domain.Cliente;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Order(2)
@Component
public class ClienteLoader implements ApplicationRunner {
	
    @Autowired
    private ClienteService clienteService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String arq = "cliente.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    
                    Usuario usuario = new Usuario();
                    usuario.setId(Integer.valueOf(campos[0]));
                    
                    Cliente cliente = new Cliente();
                    cliente.setId(Integer.valueOf(campos[1]));
                    cliente.setNome(campos[2]);
                    cliente.setCpf(campos[3]);
                    cliente.setEmail(campos[4]);
                    cliente.setUsuario(usuario);
                    clienteService.incluir(cliente);
                    System.out.println("A inclusão da cliente "+cliente.getId()+" foi realizada com sucesso.");

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