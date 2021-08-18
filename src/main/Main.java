package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import view.Tela;

/**
 * @author Agemiro Alves de Sousa Neto
 */

public class Main {

	public static void main(String[] args) {
		try {
			
	    	for (LookAndFeelInfo info: UIManager.getInstalledLookAndFeels ()) {
	        	if ("Nimbus".equals (info.getName ())) {
	            	UIManager.setLookAndFeel (info.getClassName ());
	            	break;
	        	}
	    	}
	    	
		} catch (Exception e) {
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			
		}
		
		Tela tela = new Tela();
		tela.exibir();
	}

}
