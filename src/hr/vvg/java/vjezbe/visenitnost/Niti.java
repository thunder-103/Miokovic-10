package hr.vvg.java.vjezbe.visenitnost;

import hr.vvg.java.vjezbe.glavna.JavaFXGlavna;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;

import javafx.scene.control.Label;

public class Niti implements Runnable {

	private Label labela;
	private ExecutorService servis;	
	private DateTimeFormatter formatDatuma = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

	public Niti(Label labela, ExecutorService servis) {

		this.labela = labela;
		this.servis = servis;

	}

	public void run() {
		
		while(JavaFXGlavna.upaljena){
			
			String datumVrijeme = LocalDateTime.now().format(formatDatuma);
			
			PodrskaVisenitnosti.setLabelText(labela, datumVrijeme);
			
			PodrskaVisenitnosti.pauziraj(1);
		}
		
		servis.shutdown();
	}
	
}
