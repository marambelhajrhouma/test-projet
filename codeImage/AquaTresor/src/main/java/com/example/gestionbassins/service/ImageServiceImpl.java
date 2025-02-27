package com.example.gestionbassins.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.gestionbassins.entities.Bassin;
//import com.example.gestionbassins.entities.Image;
import com.example.gestionbassins.entities.ImageProjection;
import com.example.gestionbassins.repos.BassinRepository;
//import com.example.gestionbassins.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
	/*@Autowired
	ImageRepository imageRepository;

	@Autowired
	BassinService bassinService;
	
	@Autowired
	BassinRepository bassinRepository;
	
	@Override
	 public Image uplaodImage(MultipartFile file) throws IOException {
	 /*Ce code commenté est équivalent au code utilisant le design pattern Builder
	 * Image image = new Image(null, file.getOriginalFilename(),
	 file.getContentType(), file.getBytes(), null);
	 return imageRepository.save(image);*/
	/* return imageRepository.save(Image.builder()
	 .name(file.getOriginalFilename())
	 .type(file.getContentType())
	 .image(file.getBytes()).build() );
	}
	
	 @Override
	 public Image getImageDetails(Long id) throws IOException{
		 final Optional<Image> dbImage = imageRepository. findById (id);
		 return Image.builder()
		 .idImage(dbImage.get().getIdImage())
		 .name(dbImage.get().getName())
		 .type(dbImage.get().getType())
		 .image(dbImage.get().getImage()).build() ;
	 }
	 
	
	 
	 @Override
	 public ResponseEntity<byte[]> getImage(Long id) throws IOException {
	     Optional<Image> dbImage = imageRepository.findById(id);
	     return ResponseEntity
	         .ok()
	         .contentType(MediaType.valueOf(dbImage.get().getType()))
	         .body(dbImage.get().getImage());
	 }
	
	 @Override
	 public void deleteImage(Long id) {
	     Image image = imageRepository.findById(id)
	         .orElseThrow(() -> new RuntimeException("Image non trouvée avec l'ID : " + id));

	     // Dissocier l'image du bassin
	     Bassin bassin = image.getBassin();
	     if (bassin != null) {
	         bassin.getImages().remove(image);
	         image.setBassin(null);
	     }

	     // Supprimer l'image de la base de données
	     imageRepository.delete(image);
	 }
	 
	 @Override
	 public Image uplaodImageBassin(MultipartFile file, Long idB) throws IOException {
	     // Récupérer le bassin existant
	     Bassin b = bassinRepository.findById(idB)
	         .orElseThrow(() -> new RuntimeException("Bassin non trouvé avec l'ID : " + idB));

	     // Créer l'image et l'associer au bassin
	     Image image = Image.builder()
	         .name(file.getOriginalFilename())
	         .type(file.getContentType())
	         .image(file.getBytes())
	         .bassin(b) // Associer le bassin récupéré
	         .build();

	     // Sauvegarder l'image
	     return imageRepository.save(image);
	 }
	
	
	@Override
	public List<ImageProjection> getImagesParB(Long bId) {
	    return imageRepository.findImagesByBassinId(bId);
	}
	
	*/
	
	
}