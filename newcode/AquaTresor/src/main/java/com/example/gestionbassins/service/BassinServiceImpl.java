package com.example.gestionbassins.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.gestionbassins.dto.BassinDTO;
//import com.example.gestionbassins.dto.ImageDTO;
import com.example.gestionbassins.entities.Bassin;
import com.example.gestionbassins.entities.Categorie;
//import com.example.gestionbassins.entities.Image;
import com.example.gestionbassins.entities.ImageBassin;
import com.example.gestionbassins.repos.BassinRepository;
//import com.example.gestionbassins.repos.ImageRepository;



@Service
public class BassinServiceImpl implements BassinService{

	@Autowired
	BassinRepository bassinRepository;
	
	/*@Autowired
	ImageRepository imageRepository;*/
	
	@Autowired
	ImageBassinService imageBassinService;
	
	//@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public Bassin saveBassin(Bassin b) {
		
		return bassinRepository.save(b) ;
	}

	/*  Maram
	@Override
	public Bassin upadteBassin(Bassin b) {
		return bassinRepository.save(b) ;
	}
	*/
	
	
	
	/*@Override
	public Bassin upadteBassin(Bassin b) {
	    // Récupérer le bassin existant
	    Bassin existingBassin = bassinRepository.findById(b.getIdBassin())
	        .orElseThrow(() -> new RuntimeException("Bassin non trouvé avec l'ID : " + b.getIdBassin()));

	    // Mettre à jour les propriétés du bassin
	    existingBassin.setNomBassin(b.getNomBassin());
	    existingBassin.setDescription(b.getDescription());
	    existingBassin.setPrix(b.getPrix());
	    existingBassin.setMateriau(b.getMateriau());
	    existingBassin.setCouleur(b.getCouleur());
	    existingBassin.setDimensions(b.getDimensions());
	    existingBassin.setDisponible(b.isDisponible());
	    existingBassin.setStock(b.getStock());
	    existingBassin.setCategorie(b.getCategorie());

	    // Gérer la collection d'images
	    if (b.getImages() != null) {
	        // Supprimer les images orphelines
	        existingBassin.getImages().clear();

	        // Ajouter les nouvelles images
	        for (Image image : b.getImages()) {
	            image.setBassin(existingBassin); // Associer l'image au bassin
	            existingBassin.getImages().add(image);
	        }
	    }

	    // Sauvegarder le bassin mis à jour
	    return bassinRepository.save(existingBassin);
	}*/
	
	
	@Override
	public Bassin getBassin(Long id) {
	    return bassinRepository.findByIdWithImages(id)
	        .orElseThrow(() -> new RuntimeException("Bassin non trouvé avec l'ID : " + id));
	}
	
	/**
	 * ************
	 * *******/
	
	
	/*
	@Override
	public Evenement upadteEvenement(Evenement ev) {
		//Long oldEvImageId = this.getEvenement(ev.getIdEvenement()).getImage().getIdImage();
		//Long newEvImageId = ev.getImage().getIdImage();
		Evenement evUpdated = evenementRepository.save(ev);
		//if (oldEvImageId != newEvImageId)  // si l'image a été modifiée
			//imageRepository.deleteById(oldEvImageId);
		
		return evUpdated;
	}*/

	@Override
	public void deleteBassin(Bassin b) {
		bassinRepository.delete(b) ;	
	}
	
	
/**** Maram
 * 
 * 
	@Override
	public void deleteBassinById(Long id) {
	    Bassin b = getBassin(id);
	    if (b == null) {
	        throw new RuntimeException("Bassin not found with ID: " + id);
	    }

	    // Delete associated images
	    if (b.getImages() != null && !b.getImages().isEmpty()) {
	        imageRepository.deleteAll(b.getImages());
	    }

	    // Delete the bassin
	    bassinRepository.deleteById(id);
	}
	@Override
	public Bassin getBassin(Long id) {
		return bassinRepository.findById(id).get() ;
	}
	*/

	@Override
	public List<Bassin> getAllBassins() {
		return bassinRepository.findAll() ;
	}

	
	//new
	@Override
	public List<Bassin> findByNomBassin(String nom) {
		
		return bassinRepository.findByNomBassin(nom);
	}

	@Override
	public List<Bassin> findByNomBassinContains(String nom) {
		// TODO Auto-generated method stub
		return bassinRepository.findByNomBassinContains(nom);
	}

	@Override
	public List<Bassin> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bassin> findByCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return bassinRepository.findByCategorie(c);
	}

	@Override
	public List<Bassin> findByCategorieIdCategorie(Long id) {
		// TODO Auto-generated method stub
		return bassinRepository.findByCategorieIdCategorie(id);
	}

	@Override
	public List<Bassin> findByOrderByNomBassinAsc() {
		// TODO Auto-generated method stub
		return bassinRepository.findByOrderByNomBassinAsc();
	}

	@Override
	public List<Bassin> trierBassinsNomsPrix() {
		// TODO Auto-generated method stub
		return bassinRepository.trierBassinNomPrix();
	}

	
	/*public BassinDTO toBassinDTO(Bassin bassin) {
	    BassinDTO dto = new BassinDTO();
	    dto.setIdBassin(bassin.getIdBassin());
	    dto.setNomBassin(bassin.getNomBassin());
	    dto.setDescription(bassin.getDescription());
	    dto.setPrix(bassin.getPrix());
	    dto.setMateriau(bassin.getMateriau());
	    dto.setCouleur(bassin.getCouleur());
	    dto.setDimensions(bassin.getDimensions());
	    dto.setDisponible(bassin.isDisponible());
	    dto.setStock(bassin.getStock());

	    List<ImageDTO> imageDTOs = bassin.getImages().stream()
	        .map(image -> {
	            ImageDTO imageDTO = new ImageDTO();
	            imageDTO.setIdImage(image.getIdImage());
	            imageDTO.setName(image.getName());
	            imageDTO.setType(image.getType());
	            return imageDTO;
	        })
	        .collect(Collectors.toList());

	    dto.setImages(imageDTOs);
	    return dto;
	}*/
	
	
	
	
	/************Code ImageBassin*/
	// Ajouter une image à un bassin existant
    public Bassin addImageToBassin(Long bassinId, ImageBassin imageBassin) {
        Bassin bassin = bassinRepository.findById(bassinId).orElse(null);
        if (bassin != null) {
            imageBassin.setBassin(bassin);
            imageBassinService.saveImageBassin(imageBassin);
            bassin.getImagesBassin().add(imageBassin);
            return bassinRepository.save(bassin);
        }
        return null;
    }
	
	@Override
	public void deleteBassinById(Long id) {
	    /*Bassin b = getBassin(id);
	    if (b == null) {
	        throw new RuntimeException("Bassin non trouvé avec l'ID : " + id);
	    }

	    // Supprimer les images associées
	    if (b.getImages() != null && !b.getImages().isEmpty()) {
	        imageRepository.deleteAll(b.getImages());
	    }

	    // Supprimer le bassin
	    bassinRepository.deleteById(id);*/
	}
}
