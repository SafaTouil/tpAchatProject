package com.esprit.examen.services;

import java.util.List;
import com.esprit.examen.entities.Operateur;


public interface IOperateurService {

	List<Operateur> retrieveAllOperateurs(); //Done

	Operateur addOperateur(Operateur o); //Done

	void deleteOperateur(Long id); //Done

	Operateur updateOperateur(Operateur o);

	Operateur retrieveOperateur(Long id);

}
