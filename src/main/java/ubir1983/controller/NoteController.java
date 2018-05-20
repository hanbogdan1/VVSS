package ubir1983.controller;

import java.util.HashMap;
import java.util.List;

import ubir1983.model.Corigent;
import ubir1983.model.Elev;
import ubir1983.model.Medie;
import ubir1983.model.Nota;
import ubir1983.repository.ClasaRepository;
import ubir1983.repository.ClasaRepositoryMock;
import ubir1983.repository.EleviRepository;
import ubir1983.repository.EleviRepositoryMock;
import ubir1983.repository.NoteRepository;
import ubir1983.repository.NoteRepositoryMock;
import ubir1983.utils.ClasaException;

public class NoteController {
	private NoteRepository note;
	private ClasaRepository clasa;
	private EleviRepository elevi;

	public NoteController() {
		note = new NoteRepositoryMock();
		clasa = new ClasaRepositoryMock();
		elevi = new EleviRepositoryMock();
	}
	
	public void addNota(Nota nota) throws ClasaException {
		if (nota.getNota() > 10)
			throw new ClasaException("dasd");
		note.addNota(nota);
	}
	
	public void addElev(Elev elev) {
		elevi.addElev(elev);
	}
	
	public void creeazaClasa(List<Elev> elevi, List<Nota> note) {
		clasa.creazaClasa(elevi, note);
	}
	
	public List<Medie> calculeazaMedii() throws ClasaException {
			return clasa.calculeazaMedii();
		
	}
	
	public List<Nota> getNote() {
		return note.getNote();
	}
	
	public List<Elev> getElevi() {
		return elevi.getElevi();
	}
	
	public HashMap<Elev, HashMap<String, List<Double>>> getClasa() {
		return clasa.getClasa();
	}
	
	public void afiseazaClasa() {
		clasa.afiseazaClasa();
	}
	
	public void readElevi(String fisier) {
		elevi.readElevi(fisier);
	}
	
	public void readNote(String fisier) {
		note.readNote(fisier);
	}
	
	public List<Corigent> getCorigenti() {
		return clasa.getCorigenti();
	}
}
