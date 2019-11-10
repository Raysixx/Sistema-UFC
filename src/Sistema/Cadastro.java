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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField Nome;
	private JTextField Idade;
	private JTextField Peso;

	/**
	 * Launch the application.
	 */
	public void AbreCadastro(Statement s) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro(s);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					//frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	
	public boolean TestaNum(String str)
	{
		try
		{
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e)
		{
			return false;
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
	public Cadastro(Statement s) {
		setTitle("Menu");
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
		
		Nome = new JTextField();
		Nome.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		Nome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setForeground(new Color(255, 255, 255));
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 18));
		
		Idade = new JTextField();
		Idade.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		Idade.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(255, 255, 255));
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		comboBox.addItem("Masculino");
		comboBox.addItem("Feminino");
		comboBox.setSelectedItem(null);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setForeground(new Color(255, 255, 255));
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 18));
		
		Peso = new JTextField();
		Peso.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		Peso.setColumns(10);
		
		JLabel lblPas = new JLabel("Pa\u00EDs");
		lblPas.setForeground(new Color(255, 255, 255));
		lblPas.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		comboBox_1.addItem("Brasil");
		comboBox_1.addItem("Estados Unidos");
		comboBox_1.addItem("Japão");
		comboBox_1.addItem("China");
		comboBox_1.addItem("México");
		comboBox_1.addItem("Canadá");
		comboBox_1.addItem("Argentina");
		comboBox_1.addItem("Inglaterra");
		comboBox_1.addItem("Chile");
		comboBox_1.setSelectedItem(null);
		
		JButton button = new JButton("Sair");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fechar();
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setAlignmentX(0.5f);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				if(TestaString(Nome.getText())==false) //Testa se nome é uma string
				{
					String nome = Nome.getText();
					if(TestaString(Idade.getText())==true) //Testa se idade é um número
					{
						if(TestaNum(Idade.getText())==true) //Testa se idade é int
						{
							int idade = Integer.parseInt(Idade.getText());
							if(idade>=18 && idade<100) //Testa se a idade está dentro dos parâmetros
							{
								if(comboBox.getSelectedItem()!=null) //Testa se o sexo foi selecionado
								{
									String sexo = (String) comboBox.getSelectedItem();	
									if(TestaString(Peso.getText())==true) //Testa se peso é um número
									{
										Double peso = Double.parseDouble(Peso.getText());
										if(comboBox_1.getSelectedItem()!=null) //Testa se o país foi selecionado
										{
											String país = (String) comboBox_1.getSelectedItem();
											ResultSet rs = s.executeQuery("select * from Codigos where num = (select max(num) from Codigos)");
											int id = rs.getInt("num");
											id++;
											s.executeUpdate("insert into Lutadores (ID, Nome, Idade, Sexo, Peso, País, Categoria) values (" + id + ", '" + nome + "', " + idade + ", '" + sexo + "', " + peso + ", '" + país + "', '" + VerificaCategoria(peso, sexo) + "');");
											s.executeUpdate("update Codigos set num = " + id + " where num = " + (id-1));
											JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
											Nome.setText("");
											Idade.setText("");
											comboBox.setSelectedItem(null);
											Peso.setText("");
											comboBox_1.setSelectedItem(null);
										}else {
											JOptionPane.showMessageDialog(null, "Selecione o País"); //Retorna que o país não foi selecionado
										}
									}else {
										JOptionPane.showMessageDialog(null, "Peso inválido"); //Retorna que peso não é um número
									}
								}else {
									JOptionPane.showMessageDialog(null, "Selecione o sexo"); //Retorna que o sexo não foi selecionado
								}
							}else {
								JOptionPane.showMessageDialog(null, "Idade fora dos parâmetros"); //Retorna que a idade está fora dos parâmetros
							}
						}else {
							JOptionPane.showMessageDialog(null, "Idade inválida"); //Retorna que idade não é int
						}
					}else {
						JOptionPane.showMessageDialog(null, "Idade inválida"); // Retorna que idade não é um número
					}
				}else {
					JOptionPane.showMessageDialog(null, "Nome inválido"); //Retorna que nome não é String
				}
				}catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.setAlignmentX(0.5f);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
							.addGap(854)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(388)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPas, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(Nome, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
										.addComponent(lblIdade, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(Idade, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
										.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(Peso, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
										.addComponent(comboBox_1, 0, 228, Short.MAX_VALUE)
										.addComponent(comboBox, 0, 228, Short.MAX_VALUE))
									.addGap(157)
									.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
							.addGap(316))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Nome, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(lblIdade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Idade, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Peso, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(lblPas, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
