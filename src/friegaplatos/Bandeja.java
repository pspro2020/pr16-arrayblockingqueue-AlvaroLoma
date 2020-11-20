package friegaplatos;

import java.util.concurrent.ArrayBlockingQueue;

public class Bandeja {
	
	private static final int CAPACIDAD_BANDEJA=50;
	
	private final ArrayBlockingQueue<Plato> bandeja= new ArrayBlockingQueue<>(CAPACIDAD_BANDEJA);

	
	public void añadirPlato(Plato plato) throws InterruptedException {
		bandeja.put(plato);
	}
	
	public Plato sacarPlato() throws InterruptedException {
		Plato plato = bandeja.take();
		return plato;
	}
}
