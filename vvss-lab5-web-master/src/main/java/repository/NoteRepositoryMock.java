package repository;


import model.Constants;
import model.Nota;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class NoteRepositoryMock implements NoteRepository{
	private List<Nota> note;
	
	public NoteRepositoryMock() {
		note = new LinkedList<Nota>();
	}

	public void addNota(Nota nota) throws Exception {
		// TODO Auto-generated method stub
		if(!validareNota(nota))
			return;
		this.note.add(nota);
	}

	private boolean validareNota(Nota nota) throws Exception {
		// TODO Auto-generated method stub
		if(nota.getMaterie().length() < 5 || nota.getMaterie().length() > 20)
			throw new Exception(Constants.invalidMateria);
		if(nota.getNrmatricol() < Constants.minNrmatricol || nota.getNrmatricol() > Constants.maxNrmatricol)
			throw new Exception(Constants.invalidNrmatricol);
		if(nota.getNota() < Constants.minNota || nota.getNota() > Constants.maxNota)
			throw new Exception(Constants.invalidNota);
		if(nota.getNota() != (int)nota.getNota())
			throw new Exception(Constants.invalidNota);
		if(nota.getNrmatricol() != (int)nota.getNrmatricol())
			throw new Exception(Constants.invalidNrmatricol);
		return true;
	}

	public List<Nota> getNote() {
		// TODO Auto-generated method stub
		return note;
	}

}
