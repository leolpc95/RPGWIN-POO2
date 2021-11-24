import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
* <UNIÃO METROPOLITANA DE EDUCAÇÃO E CULTURA>
* <BACHARELADO EM SISTEMAS DE INFORMAÇÃO>
* <PROGRAMAÇÃO ORIENTADA A OBJETOS II>
* <PROF. PABLO RICARDO ROXO SILVA>
* <ALUNOS: LEANDRO PEREIRA COSTA || ADRIEL ERNESTO>
*/
public class Ficha extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha frame = new Ficha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Ficha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start Game");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BD bd = new BD();
				bd.conectar();				
				FichaRepo fichaRepo = new FichaRepo(bd);
				TelaFichaList telaFichaList = new TelaFichaList(fichaRepo);
				telaFichaList.setVisible(true);		
			}
		});
		btnStart.setBackground(Color.GREEN);
		btnStart.setBounds(310, 443, 102, 39);
		contentPane.add(btnStart);	
		JLabel lblNewLabel = new JLabel("Bem Vindo ao RPGWIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 771, 32);
		contentPane.add(lblNewLabel);	
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\eclipse-workspace\\Rpgwin\\img\\ezgif.com-gif-maker (1).gif"));
		lblNewLabel_1.setBounds(0, 0, 781, 670);
		contentPane.add(lblNewLabel_1);
	}
}
