package Sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ListaCompleta extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void AbreLista(Statement s) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCompleta frame = new ListaCompleta(s);
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

	/**
	 * Create the frame.
	 */
	public ListaCompleta(Statement s) {
		setTitle("Lista dos Lutadores");
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
		
		JButton button = new JButton("Sair");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fechar();
			}
		});
		button.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		button.setBackground(Color.LIGHT_GRAY);
		button.setAlignmentX(0.5f);
		
		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.AbreMenu();
				Fechar();
			}
		});
		button_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setAlignmentX(0.5f);
		
		JButton btnConsultar = new JButton("Carregar dados");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				ResultSet rs = s.executeQuery("Select * from Lutadores;");
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnConsultar.setBackground(Color.LIGHT_GRAY);
		btnConsultar.setAlignmentX(0.5f);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setViewportBorder(BorderFactory.createEmptyBorder());
		
		table = new JTable();
		table.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		table.setOpaque(false);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setOpaque(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addGap(283)
					.addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addGap(336)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1862, Short.MAX_VALUE)
					.addGap(13))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addGap(14))
		);
		contentPane.setLayout(gl_contentPane);
	}
}