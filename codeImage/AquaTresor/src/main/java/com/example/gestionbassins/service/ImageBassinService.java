package com.example.gestionbassins.service;

import com.example.gestionbassins.entities.ImageBassin;

import java.util.List;

public interface ImageBassinService {
    ImageBassin saveImage(ImageBassin imageBassin);
    List<ImageBassin> getImagesByBassin(Long idBassin);
    void deleteImage(Long idImage);
}
