package Sistema;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void AbreMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					//frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Fechar()
	{
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent );
	}
	
	Statement s = null;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Menu");
		s = ConexãoBanco.IniciarBanco(s);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 768);
		contentPane = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Image img = Toolkit.getDefaultToolkit().getImage(
						TelaInicial.class.getResource("/Imagem/Ufc.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCadastrarLutador = new JButton("Cadastrar lutador");
		btnCadastrarLutador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro c = new Cadastro(s);
				c.AbreCadastro(s);
				Fechar();
			}
		});
		btnCadastrarLutador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrarLutador.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnCadastrarLutador.setBackground(Color.LIGHT_GRAY);
		btnCadastrarLutador.setAlignmentX(0.5f);
		
		JButton btnVerTodosLutadores = new JButton("Lista de todos lutadores");
		btnVerTodosLutadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaCompleta l = new ListaCompleta(s);
				l.AbreLista(s);
				Fechar();
			}
		});
		btnVerTodosLutadores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerTodosLutadores.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnVerTodosLutadores.setBackground(Color.LIGHT_GRAY);
		btnVerTodosLutadores.setAlignmentX(0.5f);
		
		JButton btnListaPorCategoria = new JButton("Lista por categoria");
		btnListaPorCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaEspecifica le = new ListaEspecifica(s);
				le.AbreLista(s);
				Fechar();
			}
		});
		btnListaPorCategoria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListaPorCategoria.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnListaPorCategoria.setBackground(Color.LIGHT_GRAY);
		btnListaPorCategoria.setAlignmentX(0.5f);
		
		JLabel label = new JLabel("Ultimate Fighting Championship", SwingConstants.CENTER);
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 58));
		
		JButton btnVerificarPeso = new JButton("Verificar categoria");
		btnVerificarPeso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerificarCategoria v = new VerificarCategoria();
				v.abreVerificarCategoria();
				Fechar();
			}
		});
		btnVerificarPeso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerificarPeso.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnVerificarPeso.setBackground(Color.LIGHT_GRAY);
		btnVerificarPeso.setAlignmentX(0.5f);
		
		JButton button = new JButton("Sair");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fechar();
			}
		});
		button.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		button.setBackground(Color.LIGHT_GRAY);
		button.setAlignmentX(0.5f);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(1099, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addGap(0))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
					.addGap(66))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(533)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVerificarPeso, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
						.addComponent(btnListaPorCategoria, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
						.addComponent(btnVerTodosLutadores, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
						.addComponent(btnCadastrarLutador, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
					.addGap(566))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(113)
					.addComponent(btnCadastrarLutador, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(btnVerTodosLutadores, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnListaPorCategoria, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(btnVerificarPeso, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
