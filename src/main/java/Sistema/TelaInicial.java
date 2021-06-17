package Sistema;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

public class TelaInicial extends JFrame {

	String imgPath = "/Ufc.jpg";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TelaInicial frame = new TelaInicial();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public void AbrirTela(int verifica)
	{
		if(verifica==1)
		{
			EventQueue.invokeLater(() -> {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}
	
	public void Fechar()
	{
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent );
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setTitle("Tela Inicial");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		JPanel contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(
						TelaInicial.class.getResource(new TelaInicial().imgPath));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblVerso = new JLabel("Versão 1.0");
		lblVerso.setForeground(Color.WHITE);
		lblVerso.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblUltimateFightingChampionship = new JLabel("Ultimate Fighting Championship", SwingConstants.CENTER);
		lblUltimateFightingChampionship.setForeground(Color.GRAY);
		lblUltimateFightingChampionship.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 58));
		
		JButton btnSair = new JButton("Sair");
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.addActionListener(e -> Fechar());
		btnSair.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnSair.setBackground(new Color(192, 192, 192));
		btnSair.setAlignmentX(0.5f);
		
		JButton btnHistriaEDesenvolvedores = new JButton("História do UFC");
		btnHistriaEDesenvolvedores.addActionListener(e -> {
			Historia h = new Historia();
			h.AbreHistoria();
			Fechar();
		});
		btnHistriaEDesenvolvedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHistriaEDesenvolvedores.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnHistriaEDesenvolvedores.setBackground(Color.LIGHT_GRAY);
		btnHistriaEDesenvolvedores.setAlignmentX(0.5f);
		
		JButton btnDesenvolvedores = new JButton("Desenvolvedores");
		btnDesenvolvedores.addActionListener(e -> {
			Desenvolvedores d = new Desenvolvedores();
			d.AbreDesenvolvedores();
			Fechar();
		});
		btnDesenvolvedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDesenvolvedores.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnDesenvolvedores.setBackground(Color.LIGHT_GRAY);
		btnDesenvolvedores.setAlignmentX(0.5f);
		
		JButton btnNewButton = new JButton("Entrar no sistema");
		btnNewButton.addActionListener(e -> {
				Menu m = new Menu();
				m.AbreMenu();
				Fechar();
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblVerso, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(161)
							.addComponent(btnHistriaEDesenvolvedores, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
							.addComponent(btnDesenvolvedores, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
							.addGap(150)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUltimateFightingChampionship, GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
							.addGap(58))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(550)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(585)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(98)
					.addComponent(lblUltimateFightingChampionship, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(lblVerso))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDesenvolvedores, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnHistriaEDesenvolvedores, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
