package Sistema;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextPane;
import java.util.Locale;

public class VerificarCategoria extends JFrame {

	private final JTextField Peso;

	/**
	 * Launch the application.
	 */
	public void abreVerificarCategoria() {
		EventQueue.invokeLater(() -> {
			try {
				VerificarCategoria frame = new VerificarCategoria();
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
	
	public String VerificaCategoria(double peso, String sexo)
	{
		if(sexo.equals("Masculino")) //Testa se é homem
		{
			if(peso>0 && peso<56.7) //Testa peso Mosca masculino
			{
				return "Mosca";
			}else {
				if(peso>=56.7 && peso<61.2) //Testa peso Galo masculino
				{
					return "Galo";
				}else {
					if(peso>=61.2 && peso<65.7) //Testa peso Pena masculino
					{
						return "Pena";
					}else {
						if(peso>=65.7 && peso<70.3) //Testa peso Leve masculino
						{
							return "Leve";
						}else {
							if(peso>=70.3 && peso<77.1) //Testa peso Meio-Médio masculino
							{
								return "Meio-Médio";
							}else {
								if(peso>=77.1 && peso <83.9) //Testa peso Médio masculino
								{
									return "Médio";
								}else {
									if(peso>=83.9 && peso<92.9) //Testa peso Meio-Pesado masculino
									{
										return "Meio-Pesado";
									}else {
											return "Pesado";
									}
								}
							}
						}
					}
				}
			}
		}else {
			if(peso>0 && peso<52) //Testa peso Palha feminino
			{
				return "Palha";
			}else {
				if(peso>=52 && peso<52.2) //Testa peso Mosca feminino
				{
					return "Mosca";
				}else {
					if(peso>=52.2 && peso<61.1) //Testa peso Galo feminino
					{
						return "Galo";
					}else {
							return "Pena";
					}
				}
			}
		}
	}
	
	public boolean TestaString(String str)
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}catch(NumberFormatException e)
		{
			return false;
		}
	}

	public double Pesos(String categoria, String sexo)
	{
		if(sexo.equals("Masculino"))
		{
			if(categoria.equals("Galo"))
			{
				return 56.8;
			}
			if(categoria.equals("Pena"))
			{
				return 61.3;
			}
			if(categoria.equals("Leve"))
			{
				return 65.8;
			}
			if(categoria.equals("Meio-Médio"))
			{
				return 70.4;
			}
			if(categoria.equals("Médio"))
			{
				return 77.2;
			}
			if(categoria.equals("Meio-Pesado"))
			{
				return 84;
			}
			if(categoria.equals("Pesado"))
			{
				return 93;
			}
			else
			{
				return 0;
			}
		}
		else
		{
			if(categoria.equals("Mosca"))
			{
				return 52.1;
			}
			if(categoria.equals("Galo"))
			{
				return 52.3;
			}
			if(categoria.equals("Pena"))
			{
				return 61.2;
			}
			else
			{
				return 0;
			}
		}
	}
	
	/**
	 * Create the frame.
	 */
	public VerificarCategoria() {
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
		button.addActionListener(arg0 -> Fechar());
		button.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		button.setBackground(Color.LIGHT_GRAY);
		button.setAlignmentX(0.5f);
		
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
		comboBox.setName("Sexo");
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		comboBox.addItem("Masculino");
		comboBox.addItem("Feminino");
		comboBox.setSelectedItem(null);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBackground(Color.LIGHT_GRAY);
		comboBox_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		comboBox_1.addItem("Mosca");
		comboBox_1.addItem("Galo");
		comboBox_1.addItem("Pena");
		comboBox_1.addItem("Leve");
		comboBox_1.addItem("Meio-Médio");
		comboBox_1.addItem("Médio");
		comboBox_1.addItem("Meio-Pesado");
		comboBox_1.addItem("Pesado");
		comboBox_1.setSelectedItem(null);
		
		JLabel label = new JLabel("Sexo");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		Peso = new JTextField();
		Peso.setLocale(new Locale("pt", "BR"));
		Peso.setBackground(Color.LIGHT_GRAY);
		Peso.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		Peso.setColumns(10);
		
		JLabel label_1 = new JLabel("Peso");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		JTextPane Categoria = new JTextPane();
		Categoria.setEditable(false);
		Categoria.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Categoria.setBackground(Color.LIGHT_GRAY);
		Categoria.setBorder(new CompoundBorder());
		Categoria.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		StyledDocument doc = Categoria.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		JButton btnVerificar = new JButton("Verificar categoria");
		btnVerificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerificar.addActionListener(e -> {
			if(TestaString(Peso.getText()))
			{
				double peso = Double.parseDouble(Peso.getText());
				if(comboBox.getSelectedItem()!=null)
				{
					String sexo = (String) comboBox.getSelectedItem();
					Categoria.setText(VerificaCategoria(peso, sexo));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Selecione o sexo");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Peso inválido");
			}
		});
		btnVerificar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnVerificar.setBackground(Color.LIGHT_GRAY);
		btnVerificar.setAlignmentX(0.5f);
		
		JButton btnVerificarQuantoFalta = new JButton("Verificar quanto falta");
		btnVerificarQuantoFalta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerificarQuantoFalta.addActionListener(e -> {
			if(TestaString(Peso.getText()))
			{
				double peso = Double.parseDouble(Peso.getText());
				if(comboBox.getSelectedItem()!=null)
				{
					String sexo = (String) comboBox.getSelectedItem();
					if(comboBox_1.getSelectedItem()!=null)
					{
					String categoriadesejada = (String) comboBox_1.getSelectedItem();
					if(Pesos(categoriadesejada, sexo)>peso)
					{
						double pesonecessario = Pesos(categoriadesejada, sexo)-peso;
						String peson = String.format("%.2f",pesonecessario);
						Categoria.setText(peson);
					}
					else
					{
						if(sexo.equals("Feminino") && (categoriadesejada.equals("Leve")||categoriadesejada.equals("Meio-Médio")||categoriadesejada.equals("Médio")||categoriadesejada.equals("Meio-Pesado")||categoriadesejada.equals("Pesado")))
						{
							Categoria.setText("");
						}
						else
						{
						Categoria.setText("Já possui peso o suficiente para esta categoria");
						}
					}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Selecione o sexo");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Peso inválido");
			}
		});
		btnVerificarQuantoFalta.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnVerificarQuantoFalta.setBackground(Color.LIGHT_GRAY);
		btnVerificarQuantoFalta.setAlignmentX(0.5f);
		
		JLabel lblCategoriaDesejada = new JLabel("Categoria desejada");
		lblCategoriaDesejada.setForeground(Color.WHITE);
		lblCategoriaDesejada.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addGap(855)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(298)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(comboBox, 0, 228, Short.MAX_VALUE)
											.addGap(7))
										.addComponent(btnVerificar, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
									.addGap(127))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 356, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(Peso, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
									.addGap(300))
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnVerificarQuantoFalta, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
									.addGap(65)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCategoriaDesejada, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
										.addComponent(comboBox_1, Alignment.TRAILING, 0, 228, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(179)
							.addComponent(Categoria, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
							.addGap(481)))
					.addGap(146))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(214)
					.addComponent(lblCategoriaDesejada, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(comboBox_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVerificarQuantoFalta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVerificar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(Peso, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
					.addGap(34)
					.addComponent(Categoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
