package com.example.gestionbassins.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImage;
	
	private String name;
	
	private String type;
	
	@Column(name = "IMAGE", length = 4048576)
	@Lob
	@JsonProperty(access = JsonProperty.Access.READ_ONLY) // Ignorer ce champ lors de la sérialisation
	
	private byte[] image;
	
	

	@ManyToOne
    @JoinColumn(name = "BASSIN_ID") 
	@JsonIgnore
    private Bassin bassin;
	
	
}




