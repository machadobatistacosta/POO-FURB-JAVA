import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfUF;
	private JTextField tfRenda;
	private ArrayList<Contribuinte> contribuentes = new ArrayList<>();
	private HashMap<String, Contribuinte> contriHash = new HashMap<>();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtParticipacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do contribuinte:");
		lblNewLabel.setBounds(10, 0, 136, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(122, -3, 222, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(10, 25, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(41, 22, 86, 20);
		frame.getContentPane().add(tfCPF);
		tfCPF.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Estado (UF):");
		lblNewLabel_1_1.setBounds(10, 54, 78, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		tfUF = new JTextField();
		tfUF.setColumns(10);
		tfUF.setBounds(98, 51, 86, 20);
		frame.getContentPane().add(tfUF);
		
		JLabel lblNewLabel_1_2 = new JLabel("Renda Anual R$:");
		lblNewLabel_1_2.setBounds(10, 89, 99, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		tfRenda = new JTextField();
		tfRenda.setColumns(10);
		tfRenda.setBounds(150, 86, 86, 20);
		frame.getContentPane().add(tfRenda);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contribuinte contribuinte = new Contribuinte();
				contribuinte.setNome(tfNome.getText());
				contribuinte.setCPF(tfCPF.getText());
				contribuinte.setUF(tfUF.getText());
				contribuinte.setRendaAnual(Double.parseDouble(tfRenda.getText()));
				double imposto = contribuinte.getImposto();
				String s =  "O contribuinte " + contribuinte.getNome() + " CPF:" + contribuinte.getCPF()
				+ " ira pagar de imposto" + imposto;
				JOptionPane.showMessageDialog(frame, s);
				contribuentes.add(contribuinte);
			}
		});
		btnNewButton.setBounds(160, 117, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 178, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorConsulta = Double.parseDouble(textField.getText());
                for (Contribuinte c: contribuentes) {
                    if (c.getImposto() > valorConsulta) {
                    	String str;
                        str = "O contribuinte "+c.getNome()
                        + " CPF:"+c.getCPF()
                        + " paga de imposto R$"+c.getImposto();
                        JOptionPane.showMessageDialog(frame, str);
                        break;
                    }
                }
			}
		});
		btnNewButton_1.setBounds(10, 209, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
			
		});
		btnNewButton_2.setBounds(122, 209, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 178, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtParticipacao = new JTextField();
		txtParticipacao.setBounds(290, 178, 86, 20);
		frame.getContentPane().add(txtParticipacao);
		txtParticipacao.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Participa\u00E7\u00E3o");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double impostoSC, impostoPR, impostoRS, impostoTotal;
				impostoSC=impostoPR=impostoRS=impostoTotal=0;
				for (Contribuinte c : contribuentes) {
					if (c.getUF().equals("SC")) {
						impostoSC += c.getImposto();
					}else if (c.getUF().equals("PR")) {
						impostoPR += c.getImposto();
					}else if (c.getUF().equals("RS")) {
						impostoRS += c.getImposto();
					}
					impostoTotal += c.getImposto();
				}
				String str = "Participação % de cada estado\n";
				str += "\n SC"+impostoSC+" = "+(impostoSC/impostoTotal*100)+"%";
				str += "\n SC"+impostoPR+" = "+(impostoSC/impostoTotal*100)+"%";
				str += "\n SC"+impostoRS+" = "+(impostoSC/impostoTotal*100)+"%";
				str += "\n Total="+impostoTotal;
				JOptionPane.showMessageDialog(frame, str);
			}
			
		});
		btnNewButton_3.setBounds(287, 209, 116, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}
