package br.com.samorvell.vendas.services;


import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    String uploadFile(MultipartFile arquivo);
}
