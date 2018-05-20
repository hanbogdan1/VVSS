package ubir1983.repository;

import java.util.HashMap;
import java.util.List;

import ubir1983.utils.ClasaException;

import ubir1983.model.Corigent;
import ubir1983.model.Elev;
import ubir1983.model.Medie;
import ubir1983.model.Nota;

public interface ClasaRepository {
	
	public void creazaClasa(List<Elev> elevi, List<Nota> note);
	public HashMap<Elev, HashMap<String, List<Double>>> getClasa();
	public List<Medie> calculeazaMedii() throws ClasaException;
	public void afiseazaClasa();
	public List<Corigent> getCorigenti();
}
