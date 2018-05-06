package Ureniuc.repository;

import java.util.List;

import Ureniuc.utils.ClasaException;

import Ureniuc.model.Nota;

public interface NoteRepository {
	
	public void addNota(Nota nota) throws ClasaException;
	public List<Nota> getNote(); 
	public void readNote(String fisier);
	
}
