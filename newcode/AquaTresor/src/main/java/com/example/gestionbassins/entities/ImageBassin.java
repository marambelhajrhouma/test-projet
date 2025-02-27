package com.example.gestionbassins.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageBassin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImageBassin;

    private String nameImage;
    private String typeImage;

    private String imagePath; // Stocke le chemin de l'image

    @ManyToOne
    @JoinColumn(name = "BASSIN_ID")
    @JsonBackReference
    private Bassin bassin;
}