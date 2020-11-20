package friegaplatos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Organizador implements Runnable{
	private Bandeja bandejaSecos;
	private Bandeja alacena;
	public Organizador(Bandeja bandejaSecos, Bandeja alacena) {

		this.bandejaSecos = bandejaSecos;
		this.alacena = alacena;
	}
	@Override
	public void run() {
		Plato plato = null;
		
		while(!Thread.currentThread().isInterrupted()) {
			
			try {
				plato=bandejaSecos.sacarPlato();
				colocarPlato(plato);
				alacena.añadirPlato(plato);
			} catch (InterruptedException e) {
				System.out.println("Me han interrumpido sacando en lpato de la bandeja");
				return;
			}
			
			
			
		}
		
	}
	private void colocarPlato(Plato plato) throws InterruptedException {
		System.out.printf("%s: Estoy colocando el plato %d en la alacena las %s\n",
				this.getClass().getSimpleName(),plato.getId(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
	
		TimeUnit.SECONDS.sleep(new Random().nextInt(3));
		
	}

}
