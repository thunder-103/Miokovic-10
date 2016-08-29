package hr.vvg.java.vjezbe.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import hr.vvg.java.vjezbe.glavna.JavaFXGlavna;
import hr.vvg.java.vjezbe.visenitnost.Niti;
import hr.vvg.java.vjezbe.visenitnost.NitiBrojCasopisa;
import hr.vvg.java.vjezbe.visenitnost.NitiBrojKnjiga;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class GlavnaController {
	
	@FXML 
	private Label labelaDatum = new Label(); 
	
	@FXML 
	private Label labelaCasopis = new Label(); 
	
	@FXML 
	private Label labelaKnjiga = new Label(); 

	
	public void initialize() {
		
		ExecutorService servisNiti = Executors.newCachedThreadPool();
		
		Niti nitDV = new Niti(labelaDatum, servisNiti);
		
		servisNiti.execute(nitDV);
		
		ExecutorService servisPosudbaCasopisa = Executors.newCachedThreadPool();
		
		NitiBrojCasopisa nitPC = new NitiBrojCasopisa(labelaCasopis, servisPosudbaCasopisa);
		
		servisPosudbaCasopisa.execute(nitPC);
		
		
		ExecutorService servisPosudbaKnjiga = Executors.newCachedThreadPool();
		
		NitiBrojKnjiga nitPK = new NitiBrojKnjiga(labelaKnjiga, servisPosudbaKnjiga);	
		
		servisPosudbaKnjiga.execute(nitPK);
		

	}
	
	public void prikaziKnjige() { 
		
		try { 
			BorderPane knjigePane = (BorderPane) 
				FXMLLoader.load(JavaFXGlavna.class 
						.getResource("../javafx/knjige.fxml")); 
			JavaFXGlavna.setCenterPane(knjigePane); 
			} catch (Exception e) { 
				e.printStackTrace(); 
				} 
		}
	
	public void prikaziCasopise() { 
		
		try { 
			BorderPane casopisiPane = (BorderPane) 
				FXMLLoader.load(JavaFXGlavna.class 
						.getResource("../javafx/casopisi.fxml")); 
			JavaFXGlavna.setCenterPane(casopisiPane); 
			} catch (Exception e) { 
				e.printStackTrace(); 
				} 
		}
	
	public void prikaziClanove() { 
		
		try { 
			BorderPane clanoviPane = (BorderPane) 
				FXMLLoader.load(JavaFXGlavna.class 
						.getResource("../javafx/clanovi.fxml")); 
			JavaFXGlavna.setCenterPane(clanoviPane); 
			} catch (Exception e) { 
				e.printStackTrace(); 
				} 
		}
	
	public void dodajKnjige() { 
		
		try { 
			
			BorderPane knjigePane = (BorderPane) FXMLLoader
					.load(JavaFXGlavna.class .getResource("../javafx/knjigaUredi.fxml")); 
			
			JavaFXGlavna.setCenterPane(knjigePane); 
			
		} 
		
		catch (Exception e) { 
			
			e.printStackTrace(); 
			
		} 
		
	}
	
	public void dodajCasopis() { 
		
		try { 
			
			BorderPane casopisiPane = (BorderPane) FXMLLoader
					.load(JavaFXGlavna.class .getResource("../javafx/casopisUredi.fxml")); 
			
			JavaFXGlavna.setCenterPane(casopisiPane); 
			
		} 
		
		catch (Exception e) { 
			
			e.printStackTrace(); 
			
		} 
		
	}
	
	public void dodajClana() { 
		
		try { 
			
			BorderPane clanoviPane = (BorderPane) FXMLLoader
					.load(JavaFXGlavna.class .getResource("../javafx/clanUredi.fxml")); 
			
			JavaFXGlavna.setCenterPane(clanoviPane); 
			
		} 
		
		catch (Exception e) { 
			
			e.printStackTrace(); 
			
		} 
		
	}
	
	public void prikaziPosudbuKnjiga() { 
		
		try { 
			BorderPane knjigePane = (BorderPane) 
				FXMLLoader.load(JavaFXGlavna.class 
						.getResource("../javafx/posudbaKnjiga.fxml")); 
			JavaFXGlavna.setCenterPane(knjigePane); 
			} catch (Exception e) { 
				e.printStackTrace(); 
				} 
		}
	
	public void prikaziPosudbuCasopisa() { 
		
		try { 
			BorderPane knjigePane = (BorderPane) 
				FXMLLoader.load(JavaFXGlavna.class 
						.getResource("../javafx/posudbaCasopisa.fxml")); 
			JavaFXGlavna.setCenterPane(knjigePane); 
			} catch (Exception e) { 
				e.printStackTrace(); 
				} 
		}
	
	

}
