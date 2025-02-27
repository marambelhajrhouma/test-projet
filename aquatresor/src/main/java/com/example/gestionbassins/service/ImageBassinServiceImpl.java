package com.example.gestionbassins.service;

import com.example.gestionbassins.entities.ImageBassin;
import com.example.gestionbassins.repos.ImageBassinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ImageBassinServiceImpl implements ImageBassinService {

	private final String uploadDir = "C:/shared/images/"; 
	
    @Autowired
    private ImageBassinRepository imageBassinRepository;

    @Override
    public ImageBassin saveImage(ImageBassin imageBassin) {
        return imageBassinRepository.save(imageBassin);
    }

    @Override
    public List<ImageBassin> getImagesByBassin(Long idBassin) {
        return imageBassinRepository.findByBassinIdBassin(idBassin);
    }
    
    public void deleteImage(Long idImage) {
        ImageBassin imageBassin = imageBassinRepository.findById(idImage)
                .orElseThrow(() -> new RuntimeException("Image non trouvée avec l'ID : " + idImage));

        // 📌 Récupérer le chemin du fichier
        String filePath = uploadDir + imageBassin.getImagePath();

        try {
            // 📌 Supprimer le fichier du disque si présent
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                Files.delete(path);
                System.out.println("✅ Fichier supprimé : " + filePath);
            } else {
                System.out.println("⚠️ Fichier introuvable : " + filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la suppression du fichier : " + filePath, e);
        }

        // 📌 Supprimer l'entrée en base de données
        imageBassinRepository.delete(imageBassin);
    }
}
