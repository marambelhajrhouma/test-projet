package com.example.gestionbassins.restcontrollers;

import com.example.gestionbassins.entities.ImageBassin;
import com.example.gestionbassins.service.ImageBassinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imagesBassin")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageBassinRestController {

    @Autowired
    private ImageBassinService imageBassinService;

    @PostMapping("/add")
    public ResponseEntity<ImageBassin> addImageBassin(@RequestBody ImageBassin imageBassin) {
        ImageBassin savedImageBassin = imageBassinService.saveImageBassin(imageBassin);
        return ResponseEntity.ok(savedImageBassin);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteImageBassin(@PathVariable Long id) {
        imageBassinService.deleteImageBassin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ImageBassin> getImageBassinById(@PathVariable Long id) {
        ImageBassin imageBassin = imageBassinService.getImageBassinById(id);
        return ResponseEntity.ok(imageBassin);
    }
}