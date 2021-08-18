package view.threads;

import javax.swing.ImageIcon;

import view.Tela;

/**
 * @author Agemiro Alves de Sousa Neto
 */

public class Producer extends Thread{
	private Buffer buffer;
    
	public Producer(Buffer b) { 
		buffer = b; 
	}
	public void run() {
		int quantidadeASerProzuzido = 16;
		ImageIcon apaga = new ImageIcon(getClass().getResource(""));
		Tela.completo1.setIcon(apaga);
		for(int i = 0; i < quantidadeASerProzuzido; i++) {
			buffer.Put((char)('A'+ i%26 )); 
		}
		Tela.statusProdutor.setText("STATUS: CONCLUÍDO");
		ImageIcon processoCompletoProd = new ImageIcon(getClass().getResource("/view/completo.png"));
		Tela.completo1.setIcon(processoCompletoProd);
	}

}
