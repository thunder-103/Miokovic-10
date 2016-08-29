package hr.vvg.java.vjezbe.visenitnost;

import hr.vvg.java.vjezbe.baza.BazaPodataka;
import hr.vvg.java.vjezbe.glavna.JavaFXGlavna;

import java.util.concurrent.ExecutorService;

import javafx.scene.control.Label;

public class NitiBrojKnjiga implements Runnable {
	
	private Label labela;
	private ExecutorService servis;	

	public NitiBrojKnjiga(Label labela, ExecutorService servis) {

		this.labela = labela;
		this.servis = servis;

	}

	public void run() {
		
		while(JavaFXGlavna.upaljena){
			
			Integer brojPosudbiKnjiga = 0;
			
			try {
				
				brojPosudbiKnjiga = BazaPodataka.dohvatiBrojPosudjenihKnjiga();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			PodrskaVisenitnosti.setLabelText(labela, brojPosudbiKnjiga.toString());
			PodrskaVisenitnosti.pauziraj(1);
		}
		
		servis.shutdown();
	}

}
