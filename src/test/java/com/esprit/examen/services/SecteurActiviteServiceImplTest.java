package com.esprit.examen.services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActiviteServiceImplTest {
	
	
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(SecteurActiviteServiceImplTest.class);

	
	
	
	@Autowired
	SecteurActiviteRepository secteurActiviteRepository ;
	
	@Autowired
	ISecteurActiviteService iSecteurActiviteService ;
	
	
	
	//Add Mission Test 
		@Test(timeout = DEFAULT_TIMEOUT)
		public void testaddSecteurActivite() {
			SecteurActivite secteurActivite = new SecteurActivite("secteurActiviteTest","secteurActiviteTest");
			iSecteurActiviteService.addSecteurActivite(secteurActivite);
		    assertNotNull(secteurActivite.getIdSecteurActivite());
		    l.info("Mission added successfuly ");
		}
		
		
		 //Count missions a make sure the return is  not null
		@Test
		public void testcountSecteurActivite() {
		long nbrms = secteurActiviteRepository.count();
		assertNotNull(nbrms);
		l.info("Le Nombre des secteurActivite est :");
		l.info(nbrms);
		}
		
		
		
		
		// Make sure the Database is not Nulls
		@Test
		public void testRetrieveAllSecteurActivite() {
			List<SecteurActivite> listSecteurActivite = iSecteurActiviteService.retrieveAllSecteurActivite();
			assertThat(listSecteurActivite).size().isGreaterThan(0);
			iSecteurActiviteService.retrieveAllSecteurActivite();
		}
		
		
		
		
		//delete a mission (id=2).
		@Test
		public void testDeleteSecteurActivite() {
			SecteurActivite o = new SecteurActivite("aaaaa", "bbbbb");
			SecteurActivite savedSecteurActivite= iSecteurActiviteService.addSecteurActivite(o);
			iSecteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
			assertNull(iSecteurActiviteService.retrieveSecteurActivite(savedSecteurActivite.getIdSecteurActivite()));
		}
				

	
}
