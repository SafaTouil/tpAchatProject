package com.esprit.examen.services;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {
	
	@Autowired
	IOperateurService op;

		
	@Autowired
	OperateurRepository operateurRepository ;
	
	private static final Logger l = LogManager.getLogger(OperateurServiceImplTest.class);

	
	@Test()
	public void testRetrieveAllOperateur () { //Done
		
		List<Operateur> listOperateurs = op.retrieveAllOperateurs();
		assertThat(listOperateurs).size().isGreaterThan(0);
		op.retrieveAllOperateurs();
	}
	
	@Test
	public void testaddOperateur() { //Done

		Operateur o = new Operateur("testNom4", "testPrenom4"); //null, "Safa", "Touil", "123", null
	    Assertions.assertNotNull(o, "Champ vide !!"); //Vérifier si les champs vides
	    op.addOperateur(o); //Ajouter alors l'opérateur
	    l.info("operateur ajouté avec succès ");
			
	}
	
	@Test
	public void testdeleteOperateur() { //Done

		long id = 2;
		op.deleteOperateur(id);
			
	}
	
	@Test
	public void testretrieveOperateur() { //Done
    
		Operateur o = op.retrieveOperateur(Long.valueOf(2));
		assertNotNull(o);
		l.info("retrieveOperateur :" + o);
			
	}
} 

