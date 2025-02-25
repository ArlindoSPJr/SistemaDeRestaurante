package com.restaurante.restaurante.model.service;

import com.restaurante.restaurante.model.entities.Imagem;
import com.restaurante.restaurante.model.repositories.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository imagemRepository;

    public Imagem salvarImagem(MultipartFile imagem) throws IOException {
        Imagem imagemSalva = new Imagem();
        imagemSalva.setNome(imagem.getOriginalFilename());
        imagemSalva.setDados(imagem.getBytes());
        return imagemRepository.save(imagemSalva);
    }

    public Optional<Imagem> obterImagem(Long id) {
        return imagemRepository.findById(id);
    }
}
