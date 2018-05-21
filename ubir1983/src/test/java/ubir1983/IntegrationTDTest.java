package ubir1983;

import ubir1983.controller.NoteController;
import ubir1983.model.Corigent;
import ubir1983.model.Elev;
import ubir1983.model.Medie;
import ubir1983.model.Nota;
import ubir1983.utils.ClasaException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntegrationTDTest {

	NoteController ctrl;
	
	@Before
	public void setUp() throws Exception {
		ctrl = new NoteController();
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void test1() throws ClasaException {
		//P->A
		Nota nota = new Nota(1000, "Matematica", 10);
		int size = ctrl.getNote().size();
		ctrl.addNota(nota);
		assertEquals(ctrl.getNote().size(), size + 1);
	}

	@Test
	public void test2() throws ClasaException {
		//P->A->B A-valid B-valid
		Elev e1 = new Elev(1, "Elev1");
		ctrl.addElev(e1);
		Nota nota = new Nota(1, "Materie1", 10);
		int size = ctrl.getNote().size();
		ctrl.addNota(nota);
		assertEquals(size + 1, ctrl.getNote().size());
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Medie> rezultate = ctrl.calculeazaMedii();
		assertEquals(1, rezultate.size());
	}

	@Test
	public void test3() throws ClasaException {
		//P->A->B->C A-valid B-valid C-valid
		Elev e1 = new Elev(1, "Elev1");
		ctrl.addElev(e1);
		Nota nota = new Nota(1, "Materie1", 10);
		int size = ctrl.getNote().size();
		ctrl.addNota(nota);
		assertEquals(size + 1, ctrl.getNote().size());
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Medie> rezultate = ctrl.calculeazaMedii();
		assertEquals(1, rezultate.size());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),1);
	}

	/*
	@Test
	public void test5() throws ClasaException {
		//P->B->A A-invalid B-valid
		Elev e1 = new Elev(1, "Elev1");
		ctrl.addElev(e1);
		Nota nota = new Nota(1, "Desena", 10);
		ctrl.addNota(nota);
		assertEquals(1, ctrl.getNote().size());
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Medie> rezultate = ctrl.calculeazaMedii();
		assertEquals(1, rezultate.size());
		expectedEx.expect(ClasaException.class);
		expectedEx.expectMessage(Constants.invalidMateria);
		Nota nota1 = new Nota(1, "Isto", 5);
		ctrl.addNota(nota1);
		
	}
	
	@Test
	public void test6() throws ClasaException {
		//P->B->A A-valid B-invalid
		expectedEx.expect(ClasaException.class);
		expectedEx.expectMessage(Constants.emptyRepository);
		ctrl.calculeazaMedii();
		Nota nota = new Nota(1000, "Desena", 10);
		ctrl.addNota(nota);
		assertEquals(1, ctrl.getNote().size());
	}

	@Test
	public void test8() throws ClasaException {
		//P->B->A->C B-invalid A-valid C-valid
		expectedEx.expect(ClasaException.class);
		expectedEx.expectMessage(Constants.emptyRepository);
		//List<Medie> rezultate = ctrl.calculeazaMedii();
		Elev e1 = new Elev(1, "Elev1");
		ctrl.addElev(e1);
		Nota nota = new Nota(1, "Desena", 10);
		ctrl.addNota(nota);
		assertEquals(1, ctrl.getNote().size());
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),0);
	}
	
	@Test
	public void test9() throws ClasaException {
		//P->B->A->C B-valid A-invalid C-valid
		Elev e1 = new Elev(1, "Elev1");
		ctrl.addElev(e1);
		Nota nota = new Nota(1, "Desena", 10);
		ctrl.addNota(nota);
		assertEquals(1, ctrl.getNote().size());
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Medie> rezultate = ctrl.calculeazaMedii();
		assertEquals(1, rezultate.size());
		expectedEx.expect(ClasaException.class);
		expectedEx.expectMessage(Constants.invalidMateria);
		Nota nota1 = new Nota(1, "Isto", 5);
		ctrl.addNota(nota1);
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),0);
	}
	*/
	/*@Test
	public void test10() {
		//P->B->A->C B-valid A-valid C-invalid
	}
	*/
}
