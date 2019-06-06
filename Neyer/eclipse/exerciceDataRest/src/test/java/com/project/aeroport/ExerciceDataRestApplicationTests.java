package com.project.aeroport;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.controller.exeController;
import com.project.entities.Cours;
import com.project.entities.Professeur;
import com.project.repository.CoursRepository;
import com.project.repository.ProfesseurRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciceDataRestApplicationTests {

	private static Professeur p = new Professeur();
	private static Cours c = new Cours();
	private static long id = 0;
	
	
	
	@Mock
	private ProfesseurRepository professeurRepositoryMock;
	
	@Mock
	private CoursRepository coursRepositoryMock;
	
	@Captor
	private ArgumentCaptor<Cours> coursCapteur;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	 @InjectMocks
	 private exeController target;
	 
	 @Before
	 public void setUp() {
		 MockitoAnnotations.initMocks(this);
	 }
	 

	
	@Test
	public void deleteCoursTest() {
		
		// When
	    target.deleteCours(id, c);

	    // Then
	    verify(coursRepositoryMock).delete(id);
		
	}
	
	@Test
	public void deleteProfTest() {
		
		// When
	    target.deleteProf(id, p);

	    // Then
	    verify(professeurRepositoryMock).delete(id);
		
	}
	
	@Test
	public void createCoursTest() {
		
		// When
	    target.createCours(c);

	    // Then
	    verify(coursRepositoryMock).save(c);
		
	}
	
	@Test
	public void createProfTest() {
		
		// When
	    target.createProf(p);

	    // Then
	    verify(professeurRepositoryMock).save(p);
		
	}
	
	@Test
	public void updateCoursByIdTest() {
		
		// When
	    target.updateCoursById(id, c);

	    // Then
	    verify(coursRepositoryMock).save(c);
		
	}
	
	@Test
	public void updateProfByIdTest() {
		
		// When
	    target.updateProfById(id, p);

	    // Then
	    verify(professeurRepositoryMock).save(p);
		
	}
	
	
}
