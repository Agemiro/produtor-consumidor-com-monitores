package view.threads;

import javax.swing.ImageIcon;

import view.Tela;

/**
 * @author Agemiro Alves de Sousa Neto
 */

public class Consumer extends Thread {
	private Buffer buffer;
	   
	public Consumer(Buffer b) {
		buffer = b; 
	}

	public void run() {
		int quantidadeASerConsumido = 16;
		ImageIcon apaga = new ImageIcon(getClass().getResource(""));
		Tela.completo2.setIcon(apaga);
		for(int i = 0; i < quantidadeASerConsumido; i++) {
			buffer.Get(); 
		}
		Tela.statusConsumidor.setText("STATUS: CONCLUÍDO");
        ImageIcon processoCompletoCons = new ImageIcon(getClass().getResource("/view/completo.png"));
		Tela.completo2.setIcon(processoCompletoCons);

	}
	
}
