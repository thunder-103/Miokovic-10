package hr.vvg.java.vjezbe.visenitnost;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class PodrskaVisenitnosti {
	
	public static void setLabelText(Label lbl, String text){ 
		
		Platform.runLater(new Runnable() { 
			
			@Override 
			public void run() { 
				
				lbl.setText(text); 
				
			} 
			
		}); 
		
	}
	
	public static void pauziraj(int sekunde) {
		
		//sekunde = sekunde * 1000;
		
		try {
			
			Thread.sleep(sekunde);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
