package ubir1983.repository;

import java.util.List;

import ubir1983.utils.ClasaException;

import ubir1983.model.Nota;

public interface NoteRepository {
	
	public void addNota(Nota nota) throws ClasaException;
	public List<Nota> getNote(); 
	public void readNote(String fisier);
	
}
