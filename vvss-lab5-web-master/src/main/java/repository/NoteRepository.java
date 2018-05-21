package repository;


import model.Nota;

import java.util.List;

public interface NoteRepository {
	
	public void addNota(Nota nota) throws Exception;
	public List<Nota> getNote(); 

}
