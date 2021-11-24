import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

public class TelaFichaCad extends JFrame {

	private JPanel contentPane;
	private FichaRepo fichaRepo;
	private JTextField txtNome;
	private JTextField txtSexo;
	private JTextField txtClasse;
	private JTextField txtOrigem;
	private JTextField txtHp;
	
	public TelaFichaCad(FichaRepo fichaRepo) {
		
		this.fichaRepo = fichaRepo;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 768, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ficha De Personagem");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 35));
		lblNewLabel.setBounds(10, 11, 732, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBackground(SystemColor.textHighlight);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(10, 97, 67, 20);
		contentPane.add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(SystemColor.text);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSexo.setBounds(170, 97, 67, 20);
		contentPane.add(lblSexo);
		
		JLabel lblClasse = new JLabel("Classe:");
		lblClasse.setForeground(SystemColor.text);
		lblClasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClasse.setBounds(330, 97, 67, 20);
		contentPane.add(lblClasse);
		
		JLabel lblHp = new JLabel("HP:");
		lblHp.setForeground(SystemColor.text);
		lblHp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHp.setBounds(491, 97, 38, 20);
		contentPane.add(lblHp);
		
		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setForeground(SystemColor.text);
		lblOrigem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrigem.setBounds(592, 97, 67, 20);
		contentPane.add(lblOrigem);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 128, 150, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(170, 128, 150, 20);
		contentPane.add(txtSexo);
		
		txtClasse = new JTextField();
		txtClasse.setColumns(10);
		txtClasse.setBounds(330, 128, 150, 20);
		contentPane.add(txtClasse);
		
		txtOrigem = new JTextField();
		txtOrigem.setColumns(10);
		txtOrigem.setBounds(592, 128, 150, 20);
		contentPane.add(txtOrigem);
		
		txtHp = new JTextField();
		txtHp.setColumns(10);
		txtHp.setBounds(491, 128, 79, 20);
		contentPane.add(txtHp);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBackground(Color.ORANGE);
		btnCriar.setForeground(Color.BLUE);
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Personagem personagem = new Personagem();
				personagem.setNome(txtNome.getText());
				personagem.setSexo(txtSexo.getText());
				personagem.setClasse(txtClasse.getText());
				personagem.setHp(Integer.parseInt(txtHp.getText()));
				personagem.setOrigem(txtOrigem.getText());					
				if(txtNome.getText() .equals("")|| txtSexo.getText() .equals("") ||txtClasse.getText() .equals("") || txtHp.getText() .equals(null) || txtOrigem.getText() .equals("")) {
				JOptionPane.showMessageDialog(null, "Favor Preencher Todas as informações do Personagem Nome");
				}
				else { fichaRepo.cadastrar(personagem);
				JOptionPane.showMessageDialog(btnCriar, "Personagem cadastrado com sucesso!");
				dispose();}	
			}
		});
		
		btnCriar.setBounds(10, 195, 89, 23);
		contentPane.add(btnCriar);
		
		JLabel lblinc1 = new JLabel("");
		lblinc1.setIcon(new ImageIcon("C:\\Users\\leandro.pereira\\eclipse-workspace\\Rpgwin\\img\\potion (2).png"));
		lblinc1.setBounds(526, 97, 46, 30);
		contentPane.add(lblinc1);
		
		JLabel lblnc2 = new JLabel("");
		lblnc2.setIcon(new ImageIcon("C:\\Users\\leandro.pereira\\eclipse-workspace\\Rpgwin\\img\\globo-terrestre.png"));
		lblnc2.setBounds(656, 95, 46, 32);
		contentPane.add(lblnc2);
		
		JLabel lblnc3 = new JLabel("");
		lblnc3.setIcon(new ImageIcon("C:\\Users\\leandro.pereira\\eclipse-workspace\\Rpgwin\\img\\sexo (1).png"));
		lblnc3.setBounds(217, 97, 46, 30);
		contentPane.add(lblnc3);
		
		JLabel lblnc4 = new JLabel("");
		lblnc4.setIcon(new ImageIcon("C:\\Users\\leandro.pereira\\eclipse-workspace\\Rpgwin\\img\\helmet.png"));
		lblnc4.setBounds(389, 95, 46, 32);
		contentPane.add(lblnc4);
		
		JLabel lblnc5 = new JLabel("");
		lblnc5.setIcon(new ImageIcon("C:\\Users\\leandro.pereira\\eclipse-workspace\\Rpgwin\\img\\pergaminho.png"));
		lblnc5.setBounds(68, 95, 46, 32);
		contentPane.add(lblnc5);
		
		JLabel lblnc6 = new JLabel("New label");
		lblnc6.setIcon(new ImageIcon("C:\\eclipse-workspace\\Rpgwin\\img\\e619260a9a2aa8dfa91654e9906ba0b1.gif"));
		lblnc6.setBounds(486, 159, 266, 290);
		contentPane.add(lblnc6);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\eclipse-workspace\\Rpgwin\\img\\c0d38c518fdbf6012e0475bb7a0598a5.gif"));
		lblNewLabel_1.setBounds(260, 168, 185, 239);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\eclipse-workspace\\Rpgwin\\img\\back.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 752, 449);
		contentPane.add(lblNewLabel_2);
	}
}
