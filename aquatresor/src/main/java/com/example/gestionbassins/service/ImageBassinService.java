package com.example.gestionbassins.service;

import com.example.gestionbassins.entities.ImageBassin;
import com.example.gestionbassins.repos.ImageBassinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageBassinService {

    @Autowired
    private ImageBassinRepository imageBassinRepository;

    public ImageBassin saveImageBassin(ImageBassin imageBassin) {
        return imageBassinRepository.save(imageBassin);
    }

    public void deleteImageBassin(Long id) {
        imageBassinRepository.deleteById(id);
    }

    public ImageBassin getImageBassinById(Long id) {
        return imageBassinRepository.findById(id).orElse(null);
    }
}