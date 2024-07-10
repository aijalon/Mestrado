package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import lista3.Condicionamento;
import lista3.InversaoMatrizLU;
import lista3.MatrizHilbert;
import lista3.Metodos;

public class TelaInicial {
	private MatrizHilbert criaMatriz;
	private Metodos metodos = new Metodos();
	private JLabel coringa = new JLabel("Eliminação de Gauss com substituição regressiva");
	private InversaoMatrizLU inversao = new InversaoMatrizLU();
	private StringBuilder sb = new StringBuilder();
	private Condicionamento verificaCondicionamento = new Condicionamento();

	private JTextField textFielda;
	private JTextArea textAreaa = new JTextArea();
	private JTextArea textAreab = new JTextArea();
	private JTextArea textAreac = new JTextArea();
	private JTextArea textAread = new JTextArea();
	private JTextArea textAreae = new JTextArea();
	private JTextArea textAreaf = new JTextArea();
	private JTextArea textAreag = new JTextArea();
	private JTextArea textAreaex2 = new JTextArea();
	private JTextArea textAreacond = new JTextArea();

	private JTextField textFieldb;
	private JTextField textFieldc;
	private JTextField textFieldd;
	private JTextField textFielde;
	private JTextField toleranciae;
	private JTextField iteracoese;
	private JTextField textFieldf;
	private JTextField toleranciaf;
	private JTextField iteracoesf;
	private JTextField textFieldg;
	private JTextField toleranciag;
	private JTextField iteracoesg;
	private JTextField omegag;
	private JTextField textField;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void telainicial() {
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel header = new JPanel();
		header.setBorder(null);

		jFrame.getContentPane().add(header, BorderLayout.NORTH);
		GridBagLayout gbl_header = new GridBagLayout();
		gbl_header.columnWidths = new int[]{194, 751, 0, 0};
		gbl_header.rowHeights = new int[]{0, 176, 28, 0, 0};
		gbl_header.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_header.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		header.setLayout(gbl_header);
		ImageIcon originalIconPPGMC = new ImageIcon(TelaInicial.class.getResource("/img/ppgmc.png"));

		Image originalImagePPGMC = originalIconPPGMC.getImage();
		Image imagemPpgmcRedimensionada = originalImagePPGMC.getScaledInstance(121, 78, Image.SCALE_SMOOTH);
		ImageIcon ppgmcRedimensionada = new ImageIcon(imagemPpgmcRedimensionada);
		Border margem = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		ImageIcon originalIconUESC = new ImageIcon(TelaInicial.class.getResource("/img/logo_UESC.png"));

		Image originalImageUESC = originalIconUESC.getImage();
		Image imagemUescredimensionada = originalImageUESC.getScaledInstance(59, 76, Image.SCALE_SMOOTH);
		ImageIcon uescRedimensionada = new ImageIcon(imagemUescredimensionada);

		JLabel logoPPGMC = new JLabel("");

		logoPPGMC.setIcon(ppgmcRedimensionada);
		logoPPGMC.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_logoPPGMC = new GridBagConstraints();
		gbc_logoPPGMC.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_logoPPGMC.insets = new Insets(0, 0, 5, 5);
		gbc_logoPPGMC.gridx = 0;
		gbc_logoPPGMC.gridy = 1;
		header.add(logoPPGMC, gbc_logoPPGMC);

		JLabel PPGMC = new JLabel("<html>\r\n<body style=\"display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; font-family: Arial, sans-serif;\">\r\n    <div style=\"text-align: center;\">\r\n        Programa de Pós-Graduação em Modelagem Computacional em Ciência e Tecnologia\r\n    </div>\r\n</body>\r\n</html>");
		PPGMC.setBorder(margem);

		PPGMC.setHorizontalAlignment(SwingConstants.RIGHT);
		PPGMC.setFont(new Font("Arial", Font.BOLD, 28));
		GridBagConstraints gbc_PPGMC = new GridBagConstraints();
		gbc_PPGMC.fill = GridBagConstraints.HORIZONTAL;
		gbc_PPGMC.insets = new Insets(0, 0, 5, 5);
		gbc_PPGMC.gridx = 1;
		gbc_PPGMC.gridy = 1;
		header.add(PPGMC, gbc_PPGMC);

		JLabel logoUESC = new JLabel("");

		logoUESC.setIcon(uescRedimensionada);
		GridBagConstraints gbc_logoUESC = new GridBagConstraints();
		gbc_logoUESC.insets = new Insets(0, 0, 5, 0);
		gbc_logoUESC.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_logoUESC.gridx = 2;
		gbc_logoUESC.gridy = 1;
		header.add(logoUESC, gbc_logoUESC);

		JLabel lblNewLabel = new JLabel("Discentes: Aijalon Junior e Hellen Borba");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		header.add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 66));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		header.add(panel_1, gbc_panel_1);

		coringa.setForeground(new Color(255, 255, 255));
		coringa.setFont(new Font("Arial", Font.PLAIN, 24));
		coringa.setBackground(new Color(255, 255, 255));
		panel_1.add(coringa);

		JPanel footer = new JPanel();
		footer.setBackground(new Color(0, 0, 66));
		jFrame.getContentPane().add(footer, BorderLayout.SOUTH);

		JLabel endereco = new JLabel("<html>\r\n<body style=\"display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; font-family: Arial, sans-serif;\">\r\n    <div style=\"text-align: center;\">\r\n        UNIVERSIDADE ESTADUAL DE SANTA CRUZ<br>\r\nCampus Soane Nazaré de Andrade, Rodovia Jorge Amado, km 16, Bairro Salobrinho.<br>\r\nCEP 45662-900. Ilhéus-Bahia\r\n    </div>\r\n</body>\r\n</html>");
		endereco.setFont(new Font("Arial", Font.PLAIN, 16));
		endereco.setForeground(new Color(255, 255, 255));
		footer.add(endereco);

		final JPanel panel = new JPanel();
		jFrame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));

		JPanel letraa = new JPanel();
		panel.add(letraa, "name_227544468005700");
		letraa.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Informe o tamanho da matriz de Hilbert:");
		lblNewLabel_1.setBounds(13, 12, 231, 14);
		letraa.add(lblNewLabel_1);

		textFielda = new JTextField();
		textFielda.setBounds(248, 9, 96, 20);
		letraa.add(textFielda);
		textFielda.setColumns(10);

		JButton oka = new JButton("ok");
		oka.setBounds(348, 7, 57, 23);
		oka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criaMatriz = new MatrizHilbert(Integer.parseInt(textFielda.getText()));
				metodos.desempenhoGaussEliminacao((criaMatriz.matrizHilbert()));
				textAreaa.setText(metodos.texto());
			}
		});
		letraa.add(oka);
		JScrollPane scrollPane = new JScrollPane(textAreaa,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		scrollPane.setBounds(13, 37, 1154, 568);
		letraa.add(scrollPane);

		textAreaa.setBounds(13, 37, 1154, 568);

		JPanel letrab = new JPanel();
		panel.add(letrab, "name_227583055766100");
		letrab.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane(textAreab,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setBounds(13, 37, 1154, 568);
		letrab.add(scrollPane_1);

		scrollPane_1.setViewportView(textAreab);
		textAreab.setEditable(false);

		JLabel lblNewLabel_1_1 = new JLabel("Informe o tamanho da matriz de Hilbert:");
		lblNewLabel_1_1.setBounds(13, 12, 231, 14);
		letrab.add(lblNewLabel_1_1);

		textFieldb = new JTextField();
		textFieldb.setBounds(248, 9, 96, 20);
		letrab.add(textFieldb);
		textFieldb.setColumns(10);

		JButton okb = new JButton("ok");
		okb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criaMatriz = new MatrizHilbert(Integer.parseInt(textFieldb.getText()));
				metodos.desempenhoPivoteamentoParcial(criaMatriz.matrizHilbert());
				textAreab.setText(metodos.texto());
			}
		});
		okb.setBounds(348, 7, 57, 23);
		letrab.add(okb);

		JPanel letrac = new JPanel();
		panel.add(letrac, "name_227585830119600");
		letrac.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Informe o tamanho da matriz de Hilbert:");
		lblNewLabel_2.setBounds(13, 12, 231, 14);
		letrac.add(lblNewLabel_2);

		textFieldc = new JTextField();
		textFieldc.setBounds(248, 9, 96, 20);
		letrac.add(textFieldc);
		textFieldc.setColumns(10);

		JButton okc = new JButton("ok");
		okc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criaMatriz = new MatrizHilbert(Integer.parseInt(textFieldc.getText()));
				metodos.desempenhoPivoteamentoParcialEscala(criaMatriz.matrizHilbert());
				textAreac.setText(metodos.texto());
			}
		});
		okc.setBounds(348, 7, 57, 23);
		letrac.add(okc);

		JScrollPane scrollPane_2 = new JScrollPane(textAreac,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_2.setBounds(13, 37, 1154, 568);
		letrac.add(scrollPane_2);

		textAreac.setEditable(false);
		scrollPane_2.setViewportView(textAreac);

		JPanel letrad = new JPanel();
		panel.add(letrad, "name_227588983284700");
		letrad.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Informe o tamanho da matriz de Hilbert:");
		lblNewLabel_3.setBounds(13, 12, 231, 14);
		letrad.add(lblNewLabel_3);

		textFieldd = new JTextField();
		textFieldd.setBounds(248, 9, 96, 20);
		letrad.add(textFieldd);
		textFieldd.setColumns(10);

		JButton btnNewButtond = new JButton("ok");
		btnNewButtond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criaMatriz = new MatrizHilbert(Integer.parseInt(textFieldd.getText()));
				metodos.desempenhoPivoteamentoTotal(criaMatriz.matrizHilbert());
				textAread.setText(metodos.texto());
			}
		});
		btnNewButtond.setBounds(348, 7, 57, 23);
		letrad.add(btnNewButtond);

		JScrollPane scrollPane_3 = new JScrollPane(textAread,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_3.setBounds(13, 37, 1154, 568);
		letrad.add(scrollPane_3);

		textAread.setEditable(false);
		scrollPane_3.setViewportView(textAread);

		JPanel letrae = new JPanel();
		panel.add(letrae, "name_227594559031500");
		letrae.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Informe o tamanho da matriz de Hilbert:");
		lblNewLabel_4.setBounds(13, 12, 231, 14);
		letrae.add(lblNewLabel_4);

		textFielde = new JTextField();
		textFielde.setBounds(248, 9, 96, 20);
		letrae.add(textFielde);
		textFielde.setColumns(10);

		JButton btnNewButtone = new JButton("ok");
		btnNewButtone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criaMatriz = new MatrizHilbert(Integer.parseInt(textFielde.getText()));
				boolean convergiu = metodos.desempenhoJacobi(criaMatriz.matrizHilbert(), Double.parseDouble(toleranciae.getText()), Integer.parseInt(iteracoese.getText()));
				textAreae.setText(metodos.texto());
				if(!convergiu) {
					highlightLine(textAreae, 3+Integer.parseInt(textFielde.getText()));
				}
			}
		});
		btnNewButtone.setBounds(797, 8, 89, 23);
		letrae.add(btnNewButtone);

		JLabel lblNewLabel_5 = new JLabel("Tolerância (0.00001):");
		lblNewLabel_5.setBounds(354, 12, 122, 14);
		letrae.add(lblNewLabel_5);

		toleranciae = new JTextField();
		toleranciae.setBounds(486, 9, 96, 20);
		letrae.add(toleranciae);
		toleranciae.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Interações:");
		lblNewLabel_6.setBounds(592, 12, 89, 14);
		letrae.add(lblNewLabel_6);

		iteracoese = new JTextField();
		iteracoese.setBounds(691, 9, 96, 20);
		letrae.add(iteracoese);
		iteracoese.setColumns(10);

		JScrollPane scrollPane_4 = new JScrollPane(textAreae,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_4.setBounds(13, 37, 1154, 568);
		letrae.add(scrollPane_4);

		scrollPane_4.setViewportView(textAreae);

		JPanel letraf = new JPanel();
		panel.add(letraf, "name_227596990323400");
		letraf.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Informe o tamanho da matriz de Hilbert:");
		lblNewLabel_7.setBounds(13, 12, 231, 14);
		letraf.add(lblNewLabel_7);

		textFieldf = new JTextField();
		textFieldf.setBounds(248, 9, 96, 20);
		letraf.add(textFieldf);
		textFieldf.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Tolerância (0.00001):");
		lblNewLabel_8.setBounds(354, 12, 122, 14);
		letraf.add(lblNewLabel_8);

		toleranciaf = new JTextField();
		toleranciaf.setBounds(486, 9, 96, 20);
		letraf.add(toleranciaf);
		toleranciaf.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Interações:");
		lblNewLabel_9.setBounds(592, 12, 89, 14);
		letraf.add(lblNewLabel_9);

		iteracoesf = new JTextField();
		iteracoesf.setBounds(691, 9, 96, 20);
		letraf.add(iteracoesf);
		iteracoesf.setColumns(10);

		JButton btnNewButtonf = new JButton("ok");
		btnNewButtonf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criaMatriz = new MatrizHilbert(Integer.parseInt(textFieldf.getText()));
				boolean convergiu = metodos.desempenhoGaussSeidel(criaMatriz.matrizHilbert(), Double.parseDouble(toleranciaf.getText()), Integer.parseInt(iteracoesf.getText()));
				textAreaf.setText(metodos.texto());
				if(!convergiu) {
					highlightLine(textAreaf, 3+Integer.parseInt(textFieldf.getText()));
				}
			}
		});
		btnNewButtonf.setBounds(797, 8, 89, 23);
		letraf.add(btnNewButtonf);

		JScrollPane scrollPane_5 = new JScrollPane(textAreaf,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_5.setBounds(13, 37, 1154, 568);
		letraf.add(scrollPane_5);

		textAreaf.setEditable(false);
		scrollPane_5.setViewportView(textAreaf);

		JPanel letrag = new JPanel();
		panel.add(letrag, "name_227601222429500");
		letrag.setLayout(null);

		JLabel lblNewLabel_10 = new JLabel("Informe o tamanho da matriz de Hilbert:");
		lblNewLabel_10.setBounds(13, 12, 231, 14);
		letrag.add(lblNewLabel_10);

		textFieldg = new JTextField();
		textFieldg.setBounds(248, 9, 96, 20);
		letrag.add(textFieldg);
		textFieldg.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Tolerância (0.00001):");
		lblNewLabel_11.setBounds(354, 12, 122, 14);
		letrag.add(lblNewLabel_11);

		toleranciag = new JTextField();
		toleranciag.setBounds(486, 9, 96, 20);
		letrag.add(toleranciag);
		toleranciag.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Interações:");
		lblNewLabel_12.setBounds(592, 12, 89, 14);
		letrag.add(lblNewLabel_12);

		iteracoesg = new JTextField();
		iteracoesg.setBounds(691, 9, 96, 20);
		letrag.add(iteracoesg);
		iteracoesg.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Ômega:");
		lblNewLabel_13.setBounds(797, 12, 61, 14);
		letrag.add(lblNewLabel_13);

		omegag = new JTextField();
		omegag.setBounds(868, 9, 96, 20);
		letrag.add(omegag);
		omegag.setColumns(10);

		JButton btnNewButtong = new JButton("ok");
		btnNewButtong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criaMatriz = new MatrizHilbert(Integer.parseInt(textFieldg.getText()));
				boolean convergiu = metodos.desempenhoSobreRelaxamento(criaMatriz.matrizHilbert(), Double.parseDouble(omegag.getText()), Double.parseDouble(toleranciag.getText()), Integer.parseInt(iteracoesg.getText()));
				textAreag.setText(metodos.texto());
				if(!convergiu) {
					highlightLine(textAreag, 3+Integer.parseInt(textFieldg.getText()));
				}
			}
		});
		btnNewButtong.setBounds(974, 8, 89, 23);
		letrag.add(btnNewButtong);

		JScrollPane scrollPane_6 = new JScrollPane(textAreag,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_6.setBounds(13, 37, 1154, 568);
		letrag.add(scrollPane_6);

		textAreag.setEditable(false);
		scrollPane_6.setViewportView(textAreag);

		JPanel ex2 = new JPanel();
		panel.add(ex2, "name_227690320337700");
		ex2.setLayout(null);

		JScrollPane scrollPane_7 = new JScrollPane(textAreaex2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_7.setBounds(13, 37, 1154, 568);
		ex2.add(scrollPane_7);

		scrollPane_7.setViewportView(textAreaex2);
		
		final JPanel condicionamento = new JPanel();
		panel.add(condicionamento, "name_431149905373200");
		condicionamento.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("Informe o tamanho da matriz de Hilbert:");
		lblNewLabel_14.setBounds(13, 12, 231, 14);
		condicionamento.add(lblNewLabel_14);
		
		textField = new JTextField();
		textField.setBounds(248, 9, 96, 20);
		condicionamento.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criaMatriz = new MatrizHilbert(Integer.parseInt(textField.getText()));
				
				String retorno = verificaCondicionamento.analisarMatrizHilbert(criaMatriz.matrizHilbert());
				textAreacond.setText(retorno);
			}
		});
		btnNewButton.setBounds(348, 7, 57, 23);
		condicionamento.add(btnNewButton);
		
		JScrollPane scrollPane_8 = new JScrollPane(textAreacond,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_8.setBounds(13, 37, 1154, 568);
		condicionamento.add(scrollPane_8);
		
		scrollPane_8.setViewportView(textAreacond);

		JMenuBar menuBar = new JMenuBar();
		jFrame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Exercício 1");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);

		JMenuItem gaussSubstituicaoRegressiva = new JMenuItem("Gauss com substituição regressiva");
		gaussSubstituicaoRegressiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coringa.setText("Eliminação de Gauss com substituição regressiva");
				panel.removeAll();
				panel.add(letraa);
				panel.repaint();
				panel.revalidate();
			}
		});
		gaussSubstituicaoRegressiva.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu.add(gaussSubstituicaoRegressiva);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Gauss pivoteamento parcial");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coringa.setText("Eliminação de Gauss com pivotamento parcial");
				panel.removeAll();
				panel.add(letrab);
				panel.repaint();
				panel.revalidate();
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Gauss pivoteamento parcial com escala\r\n");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coringa.setText("Eliminação de Gauss com pivotamento parcial com escala");
				panel.removeAll();
				panel.add(letrac);
				panel.repaint();
				panel.revalidate();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Gauss pivoteamento total");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coringa.setText("Eliminação de Gauss com pivotamento total");
				panel.removeAll();
				panel.add(letrad);
				panel.repaint();
				panel.revalidate();
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Jacobi");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coringa.setText("Método de Jacobi");
				panel.removeAll();
				panel.add(letrae);
				panel.repaint();
				panel.revalidate();
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Gauss-Seidel");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coringa.setText("Método de Gauss-Seidel");
				panel.removeAll();
				panel.add(letraf);
				panel.repaint();
				panel.revalidate();
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Sobre-Relaxamento");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coringa.setText("Método de Sobre-relaxamento");
				panel.removeAll();
				panel.add(letrag);
				panel.repaint();
				panel.revalidate();
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItem_7);

		JMenu mnNewMenu_1 = new JMenu("Exercício 2");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Decomposição LU");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coringa.setText("Decomposição LU");
				sb.setLength(0);
				panel.removeAll();
				panel.add(ex2);
				panel.repaint();
				panel.revalidate();

				double[][] A = {
						{10, 2, -1},
						{-3, -6, 2},
						{1, 1, 5}
				};

				double[][] B = {
						{1, 4, 9, 16},
						{4, 9, 16, 25},
						{9, 16, 25, 36},
						{16, 25, 36, 49}
				};

				double[][] inversaA = inversao.calcularInversa(A);
				double[][] inversaB = inversao.calcularInversa(B);


		        sb.append("Inversa da matriz A: \n \n");
		        for (double[] linha : inversaA) {
		            sb.append(Arrays.toString(linha));
		            sb.append("\n");
		        }

		        sb.append("\n Inversa da matriz B: \n \n");
		        for (double[] linha : inversaB) {
		        	 sb.append(Arrays.toString(linha));
		        	 sb.append("\n");
		        }
		        
		        boolean resultadoA = inversao.verificaIdentidade(A, inversaA);
		        boolean resultadoB = inversao.verificaIdentidade(B, inversaB);
		        
		        
		        sb.append("\n Resultado para A*A^-1 = I: " + resultadoA+ "\n");
		        sb.append("Resultado para B*B^-1 = I: " + resultadoB );
		        
		        textAreaex2.setText(sb.toString());
		        
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("Condicionamento");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Verificar Matriz");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coringa.setText("Condicionamento da Matriz");
				panel.removeAll();
				panel.add(condicionamento);
				panel.repaint();
				panel.revalidate();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);

		jFrame.setTitle("Projeto - Métodos Numéricos");
		jFrame.setResizable(false);
		jFrame.setSize(1191, 1014);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
	}

	private void highlightLine(JTextArea textArea, int lineNumber) {
		try {
			int start = textArea.getLineStartOffset(lineNumber);
			int end = textArea.getLineEndOffset(lineNumber);

			Highlighter highlighter = textArea.getHighlighter();
			Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);

			highlighter.addHighlight(start, end, painter);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
}
