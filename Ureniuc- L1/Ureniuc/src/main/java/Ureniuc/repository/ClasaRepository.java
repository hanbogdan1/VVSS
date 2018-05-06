package Ureniuc.repository;

import java.util.HashMap;
import java.util.List;

import Ureniuc.utils.ClasaException;

import Ureniuc.model.Corigent;
import Ureniuc.model.Elev;
import Ureniuc.model.Medie;
import Ureniuc.model.Nota;

public interface ClasaRepository {
	
	public void creazaClasa(List<Elev> elevi, List<Nota> note);
	public HashMap<Elev, HashMap<String, List<Double>>> getClasa();
	public List<Medie> calculeazaMedii() throws ClasaException;
	public void afiseazaClasa();
	public List<Corigent> getCorigenti();
}
