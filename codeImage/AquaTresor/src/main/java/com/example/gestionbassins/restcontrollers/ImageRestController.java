package com.example.gestionbassins.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//import com.example.gestionbassins.entities.Image;
import com.example.gestionbassins.entities.ImageProjection;
//import com.example.gestionbassins.repos.ImageRepository;
import com.example.gestionbassins.service.BassinService;
import com.example.gestionbassins.service.ImageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	
	/*@Autowired
	ImageService imageService ;
	
	@Autowired
	BassinService bassinService;
	
	@Autowired
	ImageRepository imageRepository;
	
	@RequestMapping(value = "/upload" , method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}
	
	//faire ajouter une image à un bassin bien définit!
	@PostMapping(value = "/uploadImageB/{idB}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idB") Long idB)
			throws IOException {
		return imageService.uplaodImageBassin(file, idB);
	}*/

	

	//retourne la liste des images d'un bassin
	/*@RequestMapping(value = "/getImagesB/{idB}", method = RequestMethod.GET)
	public List<Image> getImagesBassin(@PathVariable("idB") Long idB) throws IOException {
		return imageService.getImagesParB(idB);
	}*/
	
	/*
	@RequestMapping(value = "/getImagesB/{idB}", method = RequestMethod.GET)
	public List<ImageProjection> getImagesBassin(@PathVariable("idB") Long idB) throws IOException {
	    return imageRepository.findImagesByBassinId(idB);
	}*/
	
	/*@RequestMapping(value = "/getImagesB/{idB}", method = RequestMethod.GET)
	public List<ImageProjection> getImagesBassin(@PathVariable("idB") Long idB) throws IOException {
	    return imageService.getImagesParB(idB);
	}
	
	
	
	@RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id) ;
	}
		
	/*
	@RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException{
		return imageService.getImage(id);
	}*/
	/*@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
	    return imageService.getImage(id);
	}
		
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
	    imageService.deleteImage(id);
	}
	
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}
	
	*/
}