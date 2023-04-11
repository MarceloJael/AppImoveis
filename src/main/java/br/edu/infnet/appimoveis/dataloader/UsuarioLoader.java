package br.edu.infnet.appimoveis.dataloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appimoveis.model.service.UsuarioService;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {
	
    @Autowired
    private UsuarioService usuarioService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String arq = "usuario.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    Usuario usuario = new Usuario();
                    usuario.setId(Integer.valueOf(campos[0]));
                    usuario.setNome(campos[1]);
                    usuario.setSenha(campos[2]);
                    usuario.setEmail(campos[3]);
                    usuario.setTelefone(campos[4]);
                    usuario.setCep(campos[5]);
                    usuario.setLogradouro(campos[6]);
                    usuario.setBairro(campos[7]);
                    usuario.setLocalidade(campos[8]);
                    usuario.setUf(campos[9]);
                    usuario.setCargo(campos[10]);
                    usuarioService.incluir(usuario);
                    System.out.println("A inclusão da usuario "+usuario.getId()+" foi realizada com sucesso.");

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
