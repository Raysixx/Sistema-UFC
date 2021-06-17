package Sistema;

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
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ListaEspecifica extends JFrame {

	private final JTable table;

	/**
	 * Launch the application.
	 */
	public void AbreLista(Statement s) {
		EventQueue.invokeLater(() -> {
			try {
				ListaEspecifica frame = new ListaEspecifica(s);
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
	public ListaEspecifica(Statement s) {
		setTitle("Lista Específica");
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
		
		JButton button_1 = new JButton("Voltar");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(e -> {
			Menu m = new Menu();
			m.AbreMenu();
			Fechar();
		});
		button_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setAlignmentX(0.5f);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		comboBox.addItem("Mosca");
		comboBox.addItem("Galo");
		comboBox.addItem("Pena");
		comboBox.addItem("Leve");
		comboBox.addItem("Meio-Médio");
		comboBox.addItem("Médio");
		comboBox.addItem("Meio-Pesado");
		comboBox.addItem("Pesado");
		comboBox.setSelectedItem(null);
		
		JButton btnConsultar = new JButton("Carregar dados");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(comboBox.getSelectedItem()!=null)
					{
						String categoria = (String) comboBox.getSelectedItem();
				ResultSet rs = s.executeQuery("Select * from Lutadores where Categoria = '" + categoria + "';");
				table.setModel(DbUtils.resultSetToTableModel(rs));
					}
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
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton button = new JButton("Sair");
		button.addActionListener(arg0 -> Fechar());
		button.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		button.setBackground(Color.LIGHT_GRAY);
		button.setAlignmentX(0.5f);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
							.addGap(169)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(279)
							.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(680, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1301, Short.MAX_VALUE)
					.addGap(14))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
							.addGap(14))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
}