package friegaplatos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Secador implements Runnable {
	
	private Bandeja bandejaLimpios;
	private Bandeja bandejaSecos;
	public Secador(Bandeja bandejaLimpios, Bandeja bandejaSecos) {
		this.bandejaLimpios = bandejaLimpios;
		this.bandejaSecos = bandejaSecos;
	}
	@Override
	public void run() {
		Plato plato=null;
		while (!Thread.currentThread().isInterrupted()) {
			
			try {
				plato= bandejaLimpios.sacarPlato();
				secarPlato(plato);
				bandejaSecos.añadirPlato(plato);
			} catch (InterruptedException e) {
				System.out.println("Me han interrumpido mientras secaba el plato");
				return;
			}
			
		
		}
		
	}
	private void secarPlato(Plato plato) throws InterruptedException {
		System.out.printf("%s: Estoy secando el plato %d las %s\n",
				this.getClass().getSimpleName(),plato.getId(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
	
		TimeUnit.SECONDS.sleep(new Random().nextInt(5)+3);
	}

}
