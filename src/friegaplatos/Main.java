package friegaplatos;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Bandeja bandejaSucios = new Bandeja();
		Bandeja bandejaLimpios= new Bandeja();
		Bandeja bandejaSecos= new Bandeja();
		Bandeja alacena= new Bandeja();
		for (int i = 0; i < 50; i++) {
			try {
				bandejaSucios.añadirPlato(new Plato(i));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Thread fregador= new Thread(new Fregador(bandejaSucios,bandejaLimpios));
		Thread secador= new Thread( new Secador(bandejaLimpios,bandejaSecos));
		Thread organizador = new Thread(new Organizador(bandejaSecos, alacena));
		
		fregador.start();
		secador.start();
		organizador.start();
		
		try {
			TimeUnit.SECONDS.sleep(20);
			System.out.println("Soy el chico del cumpleaños y os digo que vengaisala mesa");
			fregador.interrupt();
			secador.interrupt();
			organizador.interrupt();
			System.out.println("Feliz cumpleaños!!!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
