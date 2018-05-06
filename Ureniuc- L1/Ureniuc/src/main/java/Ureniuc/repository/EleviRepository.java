package Ureniuc.repository;

import java.util.List;

import Ureniuc.model.Elev;

public interface EleviRepository {
	public void addElev(Elev e);
	public List<Elev> getElevi();
	public void readElevi(String fisier);
}
