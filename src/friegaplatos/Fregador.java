package friegaplatos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Fregador implements Runnable {

	private Bandeja bandejaSucios;
	private Bandeja bandejaLimpios;
	public Fregador(Bandeja bandejaSucios, Bandeja bandejaLimpios) {
		this.bandejaSucios = bandejaSucios;
		this.bandejaLimpios = bandejaLimpios;
	}
	@Override
	public void run() {
		Plato plato = null;
		while(!Thread.currentThread().isInterrupted()) {
			
			try {
				plato= bandejaSucios.sacarPlato();
				limpiar(plato);
				bandejaLimpios.añadirPlato(plato);
			} catch (InterruptedException e) {
				System.out.println("Me han interrumpido mientras intentaba limpiar un plato");
				return;
			}
			
			
			
			
		}
		
	}
	private void limpiar(Plato plato) throws InterruptedException {
		System.out.printf("%s: Estoy limpiando el plato %d las %s\n",
				this.getClass().getSimpleName(),plato.getId(),DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
	
		TimeUnit.SECONDS.sleep(new Random().nextInt(6)+2);
		
	}
	
	
	
}
