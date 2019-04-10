package main;

import gui.MainFrame;

import java.awt.Dimension;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class PetsRus {
	
	
	
	public static void main(String[] args) {
		
		//for å kunne skape et objekt inn i et objekt må vi først definere den
		//Leverandor leverandor; 
		// her skaper jeg nytt objekt av fish som heter fishen
		//Fisk fishen= new Fisk("superfisk",123,150,new Leverandor("Kamil","as","asdasd",12312,"asdadsa","123123123"),"Fishahah","isk",10);
	//System.out.println(Fisk.getAntLevendeProdukter());
	
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			
			//oppretter objektet av klassen MainFrame som vi kaller mFrame
			MainFrame mFrame= new MainFrame();
			//her setter jeg logikk som gjør at programmer lukkes når vi lukker vinduet 
			mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			// her skal jeg sette størrelse på framen 
			mFrame.setSize(new Dimension(800,600));
			//her setter jeg synligheten på framen
			mFrame.setVisible(true);
			
		}
	});
	}

}