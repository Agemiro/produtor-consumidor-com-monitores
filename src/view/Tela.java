package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.threads.Buffer;
import view.threads.Consumer;
import view.threads.Producer;

/**
 * @author Agemiro Alves de Sousa Neto
 */

public class Tela extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botaoStart; 
	public static JLabel prateleira, produtor, consumidor, esteira1, esteira2, cesta, sacola, tamanho, completo1, completo2, 
	statusProdutor, statusConsumidor, quantAtualBuffer, fundo;
	public static JLabel[] frutas = new JLabel[8];
	private JComboBox<String> TamanhoMaxBuffer;

	public Tela() {
		setTitle("Produtor/Consumidor com uso de Monitor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1366,768);
		setLocationRelativeTo(null);
		setLayout(null);
		botaoStart();
		comboBox();
		imagensDaTela();
	}
	
	public void exibir() {
		setVisible(true);
	}
	
	public void comboBox() {
		tamanho = new JLabel("Escolha o tamanho máximo do Buffer");
		tamanho.setFont(new Font("Arial", Font.BOLD, 15));
		tamanho.setBounds(530, 30, 290, 28);
		add(tamanho);
		
		String[] tamanhos = {"2", "4", "8"};

		TamanhoMaxBuffer = new JComboBox<String>(tamanhos);
		TamanhoMaxBuffer.setBounds(628, 60, 80, 28);
	
		add(TamanhoMaxBuffer);
	}
	
	public void imagensDaTela() {
		frutas[0] = new JLabel(new ImageIcon());
		frutas[0].setBounds(600, 146, 55, 46);
		add(frutas[0]);
		
		frutas[1] = new JLabel(new ImageIcon());
		frutas[1].setBounds(674, 146, 55, 46);
		add(frutas[1]);
		
		frutas[2] = new JLabel(new ImageIcon());
		frutas[2].setBounds(600, 230, 55, 46);
		add(frutas[2]);
		
		frutas[3] = new JLabel(new ImageIcon());
		frutas[3].setBounds(674, 230, 55, 46);
		add(frutas[3]);
		
		frutas[4] = new JLabel(new ImageIcon());
		frutas[4].setBounds(600, 314, 55, 46);
		add(frutas[4]);
		
		frutas[5] = new JLabel(new ImageIcon());
		frutas[5].setBounds(674, 314, 55, 46);
		add(frutas[5]);
		
		frutas[6] = new JLabel(new ImageIcon());
		frutas[6].setBounds(590, 368, 55, 46);
		add(frutas[6]);
		
		frutas[7] = new JLabel(new ImageIcon());
		frutas[7].setBounds(684, 368, 55, 46);
		add(frutas[7]);
		
		completo1 = new JLabel();
		completo1.setBounds(120, 215, 283, 284);
		add(completo1);
		
		completo2 = new JLabel();
		completo2.setBounds(930, 215, 283, 284);
		add(completo2);
		
		quantAtualBuffer = new JLabel("Quantidade de produtos atual no Buffer: 0 (VAZIO)");
		quantAtualBuffer.setBounds(484, 480, 360, 15);
		quantAtualBuffer.setFont(new Font("Arial", Font.BOLD, 15));
		quantAtualBuffer.setForeground(Color.BLACK);
		add(quantAtualBuffer);
		
		statusProdutor = new JLabel();
		statusProdutor.setBounds(170, 40, 215, 320);
		statusProdutor.setFont(new Font("Arial", Font.BOLD, 15));
		statusProdutor.setForeground(Color.BLACK);
		add(statusProdutor);
		
		statusConsumidor = new JLabel();
		statusConsumidor.setBounds(950, 40, 215, 320);
		statusConsumidor.setFont(new Font("Arial", Font.BOLD, 15));
		statusConsumidor.setForeground(Color.BLACK);
		add(statusConsumidor);
		
		cesta = new JLabel(new ImageIcon(getClass().getResource("cesta.png")));
		cesta.setBounds(220, 326, 80, 90);
		add(cesta);
		
		sacola = new JLabel(new ImageIcon(getClass().getResource("sacola_compra.png")));
		sacola.setBounds(736, 326, 80, 90);
		add(sacola);
		
		esteira1 = new JLabel(new ImageIcon(getClass().getResource("esteira1.png")));
		esteira1.setBounds(200, 348, 400, 172);
		add(esteira1);
		
		esteira2 = new JLabel(new ImageIcon(getClass().getResource("esteira1.png")));
		esteira2.setBounds(723, 348, 400, 172);
		add(esteira2);
		
		prateleira = new JLabel(new ImageIcon(getClass().getResource("prateleira_vazia.png")));
		prateleira.setBounds(505, 100, 316, 370);
		add(prateleira);
		
		produtor = new JLabel(new ImageIcon(getClass().getResource("agricultor.png")));
		produtor.setBounds(120, 215, 229, 340);
		add(produtor);
		
		consumidor = new JLabel(new ImageIcon(getClass().getResource("consumidor.png")));
		consumidor.setBounds(950, 210, 216, 346);
		add(consumidor);	
		
		fundo = new JLabel(new ImageIcon(getClass().getResource("fundo.png")));
		fundo.setBounds(0, 465, 1366, 268);
		add(fundo);
	}
	
	public void botaoStart() {
		botaoStart = new JButton("Iniciar", new ImageIcon(getClass().getResource("icone_startt.png")));
		//20 = da esquerda pra direita; 20 = de cima pra baixo; 100 = largura; 35 = altura.
		botaoStart.setBounds(30, 20, 100, 40);
		botaoStart.setToolTipText("Clique aqui para iniciar");
		botaoStart.setForeground(Color.WHITE);
		botaoStart.setBackground(Color.BLACK);
		add(botaoStart);
		botaoStart.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub			
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub		
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String tamanho = (String) TamanhoMaxBuffer.getSelectedItem();
				
				Buffer buffer = new Buffer(Integer.parseInt(tamanho)); 
			    Producer produtor = new Producer(buffer);
			    Consumer consumidor = new Consumer(buffer);

			    produtor.start();
			    consumidor.start();
			}
		});
	}
	
}
