package view.threads;

import javax.swing.ImageIcon;

import view.Tela;

/**
 * @author Agemiro Alves de Sousa Neto
 */

public class Buffer extends Thread{

	private char [] buffer;
	private int count = 0, in = 0, out = 0;

	public Buffer(int size){
		buffer = new char[size];
	}

	public synchronized void Put(char c) {
		while(count == buffer.length) {
			try { 
				Tela.statusProdutor.setText("STATUS: Fila de espera");
	         	Tela.quantAtualBuffer.setText("Quantidade de produtos atual no Buffer: "+count +" (CHEIO)");
				ImageIcon addImagemProd = new ImageIcon(getClass().getResource("/view/agricultorPretoBranco.png"));
				Tela.produtor.setIcon(addImagemProd);
            	wait(); 
            }
            catch (InterruptedException e) { } 
            finally { } 
        } 
		Tela.statusConsumidor.setText("STATUS: Fila de espera");
		ImageIcon addImagemCons = new ImageIcon(getClass().getResource("/view/consumidoPretoBrancor.png"));
		Tela.consumidor.setIcon(addImagemCons);

		Tela.statusProdutor.setText("STATUS: Acessando o Buffer");
		ImageIcon addImagemProd = new ImageIcon(getClass().getResource("/view/agricultor.png"));
		Tela.produtor.setIcon(addImagemProd);
        try {
        	buffer[in] = c; 
			int numFrut = in;
            in = (in + 1) % buffer.length; 
            count++; 
			sleep(1000);
			if(count < buffer.length+1) {
				while(Tela.cesta.getX() < 500) {
					try {
						Tela.cesta.setBounds(Tela.cesta.getX()+2, 326, 80, 90);
						sleep(7);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
	         	Tela.quantAtualBuffer.setText("Quantidade de produtos atual no Buffer: "+count);
				ImageIcon addImagemFruta = new ImageIcon(getClass().getResource("/view/fruta"+ ++numFrut +".png"));
				Tela.frutas[numFrut-1].setIcon(addImagemFruta);
			}
			Tela.cesta.setBounds(220, 326, 80, 90);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        notify();
	}
	    
	public synchronized char Get() {
		 while (count == 0) {
			 try { 
				 Tela.statusConsumidor.setText("STATUS: Fila de espera");
		         Tela.quantAtualBuffer.setText("Quantidade de produtos atual no Buffer: "+count +" (VAZIO)");
				 ImageIcon addImagemCons = new ImageIcon(getClass().getResource("/view/consumidoPretoBrancor.png"));
				 Tela.consumidor.setIcon(addImagemCons);
            	 wait(); }
             catch (InterruptedException e) { } 
             finally { } 
         } 
		 
		 Tela.statusConsumidor.setText("STATUS: Acessando o Buffer");
		 ImageIcon addImagemCons = new ImageIcon(getClass().getResource("/view/consumidor.png"));
		 Tela.consumidor.setIcon(addImagemCons);
         char c = buffer[out]; 
		 int numFrut = out;
		 try {
		     out = (out + 1) % buffer.length;
		     count--;
	         sleep(1000);
	         if(count >= 0) {
					while(Tela.sacola.getX() < 1030) {
						try {
							Tela.sacola.setBounds(Tela.sacola.getX()+2, 326, 80, 90);
							sleep(7);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
		         	Tela.quantAtualBuffer.setText("Quantidade de produtos atual no Buffer: "+count);
					ImageIcon addImagemFruta = new ImageIcon(getClass().getResource(""));
					Tela.frutas[numFrut].setIcon(addImagemFruta);
				}
				Tela.sacola.setBounds(736, 326, 80, 90);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }		 
         notify(); 
         return c;
	}
	
}
