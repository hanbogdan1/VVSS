package ubir1983;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import ubir1983.model.Corigent;
import ubir1983.model.Elev;
import ubir1983.model.Nota;

import org.junit.Before;
import org.junit.Test;

import ubir1983.utils.ClasaException;

import ubir1983.controller.NoteController;


public class GetCorigentiTest {
	
	private NoteController ctrl;

	@Before
	public void setUp() throws Exception {
		ctrl = new NoteController();
	}

	@Test
	public void test1() throws ClasaException {
		List<Elev> elevi = new LinkedList<Elev>();
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		elevi.add(e1);
		elevi.add(e2);
		List<Nota> note = new LinkedList<Nota>();
		Nota n1 = new Nota(1,"Materie1", 2);
		Nota n2 = new Nota(1,"Materie1", 6);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 5);
		Nota n7 = new Nota(2,"Materie1", 3);
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
		assertEquals(corigenti.size(),2);
	}

	@Test
	public void test2() throws ClasaException {
		ctrl.creeazaClasa(new LinkedList<Elev>(), new LinkedList<Nota>());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),0);
	}

	/*
	@Test
	public void test3() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		Nota n1 = new Nota(1,"Materie1", 10);
		Nota n2 = new Nota(1,"Materie1", 7);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 5);
		Nota n7 = new Nota(2,"Materie2", 3);
		Nota n8 = new Nota(2,"Materie1", 7);
		ctrl.addNota(n1);
		ctrl.addNota(n2);
		ctrl.addNota(n3);
		ctrl.addNota(n4);
		ctrl.addNota(n5);
		ctrl.addNota(n6);
		ctrl.addNota(n7);
		ctrl.addNota(n8);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),1);
	}
	
	@Test
	public void test4() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		Nota n1 = new Nota(1,"Materie1", 1);
		Nota n2 = new Nota(1,"Materie1", 7);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 5);
		Nota n7 = new Nota(2,"Materie2", 3);
		Nota n8 = new Nota(2,"Materie1", 7);
		ctrl.addNota(n1);
		ctrl.addNota(n2);
		ctrl.addNota(n3);
		ctrl.addNota(n4);
		ctrl.addNota(n5);
		ctrl.addNota(n6);
		ctrl.addNota(n7);
		ctrl.addNota(n8);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.get(1).getNrMaterii(), corigenti.get(0).getNrMaterii());
	}
	
	@Test
	public void test5() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		Nota n1 = new Nota(1,"Materie1", 1);
		Nota n2 = new Nota(1,"Materie1", 7);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 5);
		Nota n7 = new Nota(2,"Materie2", 3);
		Nota n8 = new Nota(2,"Materie1", 4);
		ctrl.addNota(n1);
		ctrl.addNota(n2);
		ctrl.addNota(n3);
		ctrl.addNota(n4);
		ctrl.addNota(n5);
		ctrl.addNota(n6);
		ctrl.addNota(n7);
		ctrl.addNota(n8);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.get(1).getNrMaterii()+1, corigenti.get(0).getNrMaterii());
	}
	
	@Test
	public void test6() throws ClasaException {
		//Elev e1 = new Elev(1, "Elev1");
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),0);
	}
	*/
}
