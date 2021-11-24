import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class TelaFichaList extends JFrame {

	private JPanel contentPane;
	private FichaRepo fichaRepo;
	private JTable tblFicha;
	
	
	public TelaFichaList(FichaRepo fichaRepo) {
		this.fichaRepo = fichaRepo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTelaCriar = new JButton("Criar");
		btnTelaCriar.setIcon(new ImageIcon("C:\\eclipse-workspace\\Rpgwin\\img\\adicionar-usuario (1).png"));
		btnTelaCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFichaCad telaFichaCad = new TelaFichaCad(fichaRepo);
				telaFichaCad.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						listarPersonagens();
					}
				});
				telaFichaCad.setVisible(true);
			}
		});
		btnTelaCriar.setBounds(633, 171, 122, 31);
		contentPane.add(btnTelaCriar);
		
		JScrollPane scrFicha = new JScrollPane();
		scrFicha.setViewportBorder(UIManager.getBorder("InternalFrame.border"));
		scrFicha.setBounds(126, 171, 506, 204);
		contentPane.add(scrFicha);
		
		tblFicha = new JTable();
		tblFicha.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblFicha.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Sexo", "Classe", "HP", "Origem"
			}
		));
		scrFicha.setViewportView(tblFicha);
		
		JLabel label = new JLabel("New label");
		scrFicha.setColumnHeaderView(label);
		
		JLabel lblNewLabel = new JLabel("Lista de Jogadores RPGWIN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 30, 787, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\eclipse-workspace\\Rpgwin\\img\\rpg.png"));
		lblNewLabel_1.setBounds(365, 53, 64, 107);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRemove = new JButton("Remover");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int id = (int) tblFicha.getModel().getValueAt(tblFicha.getSelectedRow(), 0);
					
					int confirm = JOptionPane.showConfirmDialog(btnRemove, "Deseja Realmente o Item?");
					if(confirm == 0) {
						JOptionPane.showMessageDialog(btnRemove, "Personagem Removido");
						fichaRepo.excluir(id);
						
					}
					
					listarPersonagens();
				} catch (Exception b) {
					JOptionPane.showMessageDialog(null, "Selecione um Personagem Para a Remoção!");
				}
			}
		});
		btnRemove.setIcon(new ImageIcon("C:\\eclipse-workspace\\Rpgwin\\img\\retirar.png"));
		btnRemove.setBounds(633, 213, 122, 31);
		contentPane.add(btnRemove);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					int id = (int) tblFicha.getModel().getValueAt(tblFicha.getSelectedRow(), 0);
					TelaFichaEditar telaFichaEditar = new TelaFichaEditar(fichaRepo, id);
					telaFichaEditar.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							listarPersonagens();
						}
						
					});
					telaFichaEditar.setVisible(true);
				}catch (Exception b) {
					JOptionPane.showMessageDialog(null, "Selecione um Personagem Para a Edição!");
				}
				
				
				
				
				
			}
			
		});
		btnEditar.setIcon(new ImageIcon("C:\\eclipse-workspace\\Rpgwin\\img\\registro.png"));
		btnEditar.setBounds(633, 266, 122, 31);
		contentPane.add(btnEditar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\eclipse-workspace\\Rpgwin\\img\\dung1.gif"));
		lblNewLabel_2.setBounds(0, 0, 787, 458);
		contentPane.add(lblNewLabel_2);
		
		this.listarPersonagens();
		
		
	}
	public void listarPersonagens() {
		ArrayList<Personagem> personagens = this.fichaRepo.listar();
		DefaultTableModel model = (DefaultTableModel) tblFicha.getModel();
		model.setRowCount(0);
		for(Personagem personagem: personagens) {
			
			model.addRow(new Object [] {
					personagem.getId(),
					personagem.getNome(),
					personagem.getSexo(),
					personagem.getClasse(),
					personagem.getHp(),
					personagem.getOrigem()
					
			});
		}
		
	}
}
