package hr.vvg.java.vjezbe.visenitnost;

import hr.vvg.java.vjezbe.baza.BazaPodataka;
import hr.vvg.java.vjezbe.glavna.JavaFXGlavna;
import java.util.concurrent.ExecutorService;

import javafx.scene.control.Label;

public class NitiBrojCasopisa implements Runnable{

	private Label labela;
	private ExecutorService servis;	

	public NitiBrojCasopisa(Label labela, ExecutorService servis) {

		this.labela = labela;
		this.servis = servis;

	}

	public void run() {
		
		while(JavaFXGlavna.upaljena){
			
			Integer brojPosudbiCasopisa = 0;
			
			try {
				
				brojPosudbiCasopisa = BazaPodataka.dohvatiBrojPosudjenihCasopisa();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			PodrskaVisenitnosti.setLabelText(labela, brojPosudbiCasopisa.toString());
			PodrskaVisenitnosti.pauziraj(1);
		}
		
		servis.shutdown();
	}
}
