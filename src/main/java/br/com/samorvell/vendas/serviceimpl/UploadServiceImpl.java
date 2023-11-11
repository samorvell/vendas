package br.com.samorvell.vendas.serviceimpl;

import br.com.samorvell.vendas.services.UploadService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadServiceImpl implements UploadService {

    @Override
    public String uploadFile(MultipartFile arquivo) {
        /*Qual intuito aqui?
        Copiar o arquivo recebido via requisção para uma pasta definida e
        retornar o caminho dele. Se der qualquer erro, retornar NULL*/
        try{
            System.out.println("DEBUG - "+ arquivo.getOriginalFilename());
            String caminho = "/home/samorvell/Imagens/teste";
            Path path = Paths.get(caminho, File.separator + arquivo.getOriginalFilename());
            Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("DEBUG - Arquivo copiado...");
            return path.toString();

        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }
}
