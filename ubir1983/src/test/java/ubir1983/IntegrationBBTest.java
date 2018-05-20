package ubir1983;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

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


public class IntegrationBBTest {

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
		//P->B
		List<Elev> elevi  = new LinkedList<Elev>();
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		elevi.add(e1);
		elevi.add(e2);
		List<Nota> note = new LinkedList<Nota>();
		Nota n1 = new Nota(1,"Materie1", 10);
		Nota n2 = new Nota(2,"Materie1", 7);
		note.add(n1);
		note.add(n2);
		ctrl.creeazaClasa(elevi, note);
		List<Medie> rezultate = ctrl.calculeazaMedii();
		for(Medie m : rezultate)
			if(m.getElev().getNrmatricol() == 2)
				assertEquals(m.getMedie(),7.0,0.0001);
	}

	@Test
	public void test3() throws ClasaException {
		//P->C
		List<Elev> elevi  = new LinkedList<Elev>();
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		elevi.add(e1);
		elevi.add(e2);
		List<Nota> note = new LinkedList<Nota>();
		Nota n1 = new Nota(1,"Materie1", 1);
		Nota n2 = new Nota(1,"Materie1", 7);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 5);
		Nota n7 = new Nota(2,"Materie2", 3);
		Nota n8 = new Nota(2,"Materie1", 4);
		note.add(n1);
		note.add(n2);
		note.add(n3);
		note.add(n4);
		note.add(n5);
		note.add(n6);
		note.add(n7);
		note.add(n8);
		ctrl.creeazaClasa(elevi, note);
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.get(1).getNrMaterii() + 1, corigenti.get(0).getNrMaterii());
	}

	@Test
	public void test4() throws ClasaException {
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
}
