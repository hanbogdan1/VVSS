package controller;


import model.Nota;
import repository.NoteRepository;
import repository.NoteRepositoryMock;

import java.util.HashMap;
import java.util.List;

public class NoteController {
	private NoteRepository note;

	public NoteController() {
		note = new NoteRepositoryMock();
	}
	
	public void addNota(Nota nota) throws Exception {
		note.addNota(nota);
	}
	
	public List<Nota> getNote() {
		return note.getNote();
	}
	


}
