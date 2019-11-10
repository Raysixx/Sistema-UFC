package Sistema;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;
import java.awt.Component;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class História extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void AbreHistoria() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					História frame = new História();
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
	public História() {
		setTitle("Hist\u00F3ria");
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fechar();
			}
		});
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		button.setBackground(Color.LIGHT_GRAY);
		button.setAlignmentX(0.5f);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial t = new TelaInicial();
				t.AbrirTela(1);
				Fechar();
			}
		});
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setAlignmentX(0.5f);
		
		String texto = "Criado em 1993 como uma organização profissional de artes marciais mistas (MMA), o UFC® revolucionou a indústria da luta e hoje se destaca tanto como uma marca global premium de esporte quanto como uma empresa de produção de conteúdo e o maior  provedor de eventos Pay-Per-View (PPV) do mundo.<br><br> "
				+ "O UFC segue uma história e uma tradição ricas de MMA competitivo que remonta ao Pancrácio, uma luta introduzida nos Jogos Olímpicos gregos no ano de 648 a.C. Há cerca de 80 anos, uma forma brasileira de MMA conhecida como Vale-Tudo despertou o interesse local pelo esporte. O UFC então introduziu o MMA organizado e sancionado nos Estados Unidos. <br><br> "
				+ "O objetivo era encontrar o \"campeão supremo de luta\" (Ultimate Fighting Champion) organizando um torneio de uma noite com os melhores atletas das diversas modalidades de artes marciais, Incluindo caratê, jiu-jítsu, boxe, kickboxing, grappling, wrestling, sumô e outros esportes de combate. O vencedor do torneio seria coroado o campeão.<br><br> "
				+ "Em janeiro de 2001, sob o novo comando da Zuffa, LLC e guiada pela liderança dos prorpiestários Frank Fertitta III, Lorenzo Fertitta e Dana White, a marca UFC reestruturou o MMA, trasformando-o em um esporte de combate altamente organizado, sancionado e controlado. Com sede em Las Vegas e uma rede de funcionários espalhada pelo mundo, o UFC produz anualmente mais de 40 eventos ao vivo, que constantemente lotam algumas das mais prestigiadas arenas do planeta.<br><br> "
				+ "A programação do UFC é transmitida para 	mais de 165 países e territórios, via mais de 60 parceiros globais, para mais de 1,1 bilhão de residências em 40 línguas diferentes. O UFC tem a maior concentração de millennials (com idades entre 18 e 34 anos) em sua base de fãs, com 40% em comparação com as principais propriedades esportivas.<br><br> "
				+ "Em dezembro de 2013,o UFC lançou o UFC FIGHT PASS®, um serviço de assinatura digital de transmissão de eventos ao vivo, milhares de lutas on-demand e conteúdo exclusivo para fãs de todo o mundo, posicionando a extraordinária rede digital como o principal destino para fãs de luta.<br><br> "
				+ "Ao longo dos anos, o UFC vem buscando constantamente os mais altos níveis de segurança e qualidade em todos os aspectos do esporte. A organização tem procurado desfazer os estereótipos de gênero e estabelecer novos padrões para a saúde e o bem-estar dos lutadores, e foi a primeira organização de esporte de combate a fornecer a seus atletas cobertura de seguro contra acidentes relacionados a treinamento.<br><br> "
				+ "Em um compromisso ainda maior com a saúde a segurança de seus atletas, o UFC firmou uma parceria com a USADA (Agência Antidoping dos Estados Unidos) para lançar um programa antidoping histórico e abrangente em julho de 2015. Um dos primeiros do tipo em esportes de combate, o programa do UFC permite à USADA administrar, de forma independente, testes aleatórios dentro e fora de competição em seus atletas o ano todo.<br><br> "
				+ "Em julho de 2015, o UFC apresentou a primeira Política de Equipamento do Atleta e o KIT de Luta do UFC. O vestuário criado em parceria com a Reebok, fornecedora exclusiva do UFC no mundo, foi criado para melhorar ainda mais a aparência da marca e oferecer aos atletas equipamentos de alta qualidade desenvolvidos especificamente para lutadores de MMA.<br><br> "
				+ "Em dezembro do mesmo ano, o UFC deu início às obras de seu novo campus corporativo global em Las Vegas, que inclui o Instituto de Performance do UFC (UFC Performance Institute), focado no fornecimento das melhores instalações de treinamento de MMA, para apoiar o desenvolvimento científico de atletas e treinadores, prevenir lesões e dar suporte à recuperação, ao tratamento e à reabilitação de lutadores profissionais.<br><br> "
				+ "Em fevereiro de 2016, o UFC anunciou o prolongamento por mais cinco anos de sua parceria com a Cleveland Clinic, além de uma contribuição de um milhão de dólares, para continuar apoiando o Professional Fighters Brain Health Study (Estudo da Saúde do Cérebro de Lutadores Profissionais). O estudo tem como foco o desenvolvimento de métodos para detectar os sinais mais precoces e sutis de lesão cerebral em atletas expostos a traumas cranianos, assim como detectar quais indivíduos estão mais sujeitos a desenvolver distúrbios neurológicos crônicos.<br><br> "
				+ "Em agosto de 2016, o UFC foi comprado pela Endeavor, líder global de esportes, entretenimento e moda, junto com os parceiros estratégicos Silver Lake Partners e KKR, no que virou a maior aquisição financeira da história de uma propriedade esportiva.";
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		int font;
		if(width==1920 && height==1080)
		{
			font = 19;
		} else {
			if(width==1440 && height==900)
			{
				font = 15;
			} else {
				if(width==1400 && height==1050)
				{
					font = 17;
				} else {
					font = 13;
				}
			}
		}
		JLabel lblNewLabel = new JLabel("<html><div style='text-align: center;'>" + texto + "</div></html>");
		lblNewLabel.setLocale(new Locale("pt", "BR"));
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, font));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
							.addGap(844)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
