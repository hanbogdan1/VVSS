package ubir1983;

import static org.junit.Assert.*;

import ubir1983.model.Nota;

import ubir1983.utils.Constants;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ubir1983.controller.NoteController;

public class AddNotaTest {
	
	private NoteController ctrl;
	
	@Before
	public void init(){
		ctrl = new NoteController();
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void test1() throws Exception {
		int size = ctrl.getNote().size();
		Nota nota = new Nota(1, "Sport", 1);
		try {
			ctrl.addNota(nota);
			assertEquals(ctrl.getNote().size(), size + 1);
		}
		catch (Exception x ){
			assert false;
		}

	}

	@Test
	public void test2() throws Exception {
		try{
			Nota nota = new Nota(0, "Informatica", 11);
			ctrl.addNota(nota);
			assert false;
		}
		catch (Exception ex){
			assert  true;
		}

	}
	
	@Test
	public void test3() throws Exception {
		expectedEx.expect(Exception.class);
		expectedEx.expectMessage(Constants.invalidNrmatricol);
		Nota nota = new Nota(1001, "Informatica", 10);
		ctrl.addNota(nota);
	}
	
	@Test
	public void test4() throws Exception {
		expectedEx.expect(Exception.class);
		expectedEx.expectMessage(Constants.invalidMateria);
		Nota nota = new Nota(1, "Info", 10);
		ctrl.addNota(nota);
	}

	@Test
	public void test5() throws Exception {
		expectedEx.expect(Exception.class);
		expectedEx.expectMessage(Constants.invalidMateria);
		Nota nota = new Nota(1, "Informatica.......123", 10);
		ctrl.addNota(nota);
	}
	
	@Test
	public void test6() throws Exception {
		try{
			Nota nota = new Nota(1, "Informatica", 11);
			ctrl.addNota(nota);
			assert false;
		}
		catch (Exception ex){
			assert  true;
		}
	}
	
	@Test
	public void test7() throws Exception {
		expectedEx.expect(Exception.class);
		expectedEx.expectMessage(Constants.invalidNota);
		Nota nota = new Nota(1, "Informatica", 0);
		ctrl.addNota(nota);
	}
	
	@Test
	public void test8() throws Exception {
		int size = ctrl.getNote().size();
		Nota nota = new Nota(1000, "Matematica", 10);
		ctrl.addNota(nota);
		assertEquals(ctrl.getNote().size(), size + 1);
	}
	
	@Test
	public void test9() throws Exception {
		int size = ctrl.getNote().size();
		Nota nota = new Nota(999, "Matematica", 10);
		ctrl.addNota(nota);
		assertEquals(ctrl.getNote().size(), size + 1);
	}
	
	@Test
	public void test10() throws Exception {
		int size = ctrl.getNote().size();
		Nota nota = new Nota(1, "Informatica", 2);
		ctrl.addNota(nota);
		assertEquals(ctrl.getNote().size(), size + 1);
	}
}
