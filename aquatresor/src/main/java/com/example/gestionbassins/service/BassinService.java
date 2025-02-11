package com.example.gestionbassins.service;

import java.util.List;

import com.example.gestionbassins.entities.Bassin;
import com.example.gestionbassins.entities.Categorie;

public interface BassinService {
	//ev ->b   //th -> c
	Bassin saveBassin(Bassin b);
	Bassin upadteBassin(Bassin b);
	void deleteBassin(Bassin b);
	void deleteBassinById(Long id);
	Bassin getBassin(Long id);
	List<Bassin> getAllBassins();
	
	
	List<Bassin> findByNomBassin(String nom);
	List<Bassin> findByNomBassinContains(String nom);
	List<Bassin> findByNomPrix (String nom, Double prix);
	List<Bassin> findByCategorie (Categorie c);
	List<Bassin> findByCategorieIdCategorie(Long id);
	List<Bassin> findByOrderByNomBassinAsc();
	List<Bassin> trierBassinsNomsPrix();

}
