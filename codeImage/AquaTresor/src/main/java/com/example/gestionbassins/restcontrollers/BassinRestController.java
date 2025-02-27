package com.example.gestionbassins.restcontrollers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbassins.dto.BassinDTO;
import com.example.gestionbassins.entities.Bassin;
import com.example.gestionbassins.entities.ImageBassin;
import com.example.gestionbassins.service.BassinService;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BassinRestController {

    @Autowired
    BassinService bassinService; 

    // Get all events
   @RequestMapping(path="all", method=RequestMethod.GET)
    public List<Bassin> getAllBassins() {
        return bassinService.getAllBassins();
    }
    
   
    @RequestMapping(value="getbyid/{idBassin}", method=RequestMethod.GET)
    public Bassin getBassinById(@PathVariable("idBassin") Long id) {
        return bassinService.getBassin(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addbassin")
    public Bassin createBassin(@RequestBody Bassin bassin) {
   	 System.out.println(bassin);
       System.out.println("Received prixBassin: " + bassin.getPrix()); // Debugging
       return bassinService.saveBassin(bassin);
   }
    
    @PutMapping("/updatebassin/{idBassin}")
    public Bassin updateBassin(@PathVariable("idBassin") Long idBassin, @RequestBody Bassin bassin) {
    	bassin.setIdBassin(idBassin); // Set the ID to ensure the correct event is updated
        return bassinService.updateBassin(bassin);
    }

    @DeleteMapping("deletebassin/{idBassin}")
    public ResponseEntity<?> deleteBassin(@PathVariable("idBassin") Long idBassin) {
        try {
            bassinService.deleteBassinById(idBassin);
            return ResponseEntity.ok().build(); // Return 200 OK on success
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error deleting bassin: " + e.getMessage());
        }
    }
    
    //Affiche la liste des bassin appartient à une catégorie 
    @RequestMapping(value="/Categories/{idCategorie}", method=RequestMethod.GET)
    public List<Bassin> getBassinByCategorieId(@PathVariable("idCategorie") Long idCategorie) {
        return bassinService.findByCategorieIdCategorie(idCategorie);
    }
    
    @RequestMapping(value="/bassinByName/{nom}",method = RequestMethod.GET)
    public List<Bassin> findByNomBassinContains(@PathVariable("nom") String nom) {
    	return bassinService.findByNomBassinContains(nom);
    }
    
    //code ImageBassin
   /* @PostMapping("/bassins/{bassinId}/addImage")
    public ResponseEntity<?> addImageToBassin(@PathVariable Long idImageBassin, @RequestBody ImageBassin imageBassin) {
        Bassin updatedBassin = bassinService.addImageToBassin(idImageBassin, imageBassin);
        return ResponseEntity.ok(updatedBassin);
    }*/
    
   
    
}

