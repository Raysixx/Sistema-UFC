package Sistema;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Desenvolvedores extends JFrame {

	/**
	 * Launch the application.
	 */
	public void AbreDesenvolvedores(){
		EventQueue.invokeLater(() -> {
			try {
				Desenvolvedores frame = new Desenvolvedores();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public void Fechar()
	{
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent );
	}

	/**
	 * Create the frame.
	 */
	public Desenvolvedores() {
		setTitle("Desenvolvedores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		JPanel contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(
						TelaInicial.class.getResource(new TelaInicial().imgPath));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("Sair");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(e -> Fechar());
		button.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		button.setBackground(Color.LIGHT_GRAY);
		button.setAlignmentX(0.5f);
		
		JButton button_1 = new JButton("Voltar");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(e -> {
			TelaInicial t = new TelaInicial();
			t.AbrirTela(1);
			Fechar();
		});
		button_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setAlignmentX(0.5f);
		
		String texto = ("Rafael Hiago Ribeiro de Souza  RA 1811515220<br><br>"
				+ "Matheus Felipe Cachiolo  RA 1811510136<br><br>"
				+ "Adriano Dias Oliveira  RA 1811515174<br><br>"
				+ "Anderson Luiz Pelegrini  RA 1811512876");
		JLabel lblNewLabel = new JLabel("<html><div style='text-align: center;'>" + texto + "</div></html>");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 50));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
					.addGap(854)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(239)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
					.addGap(221))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
