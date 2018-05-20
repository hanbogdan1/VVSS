package ubir1983.repository;

import java.util.List;

import ubir1983.model.Elev;

public interface EleviRepository {
	public void addElev(Elev e);
	public List<Elev> getElevi();
	public void readElevi(String fisier);
}
