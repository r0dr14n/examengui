package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ejercicio01 extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio01 frame = new ejercicio01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ejercicio01() {
		setTitle("Calculadora envíos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][94.00,grow][][][]", "[][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Calculadora de Envíos");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel, "cell 0 0 7 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Ciudad Origen:");
		contentPane.add(lblNewLabel_1, "cell 2 1,alignx trailing");
		
		txtOrigen = new JTextField();
		contentPane.add(txtOrigen, "cell 3 1 3 1,growx");
		txtOrigen.setColumns(10);
		
		JRadioButton rdbtnNacional1 = new JRadioButton("Nacional");
		rdbtnNacional1.setSelected(true);
		buttonGroup.add(rdbtnNacional1);
		contentPane.add(rdbtnNacional1, "cell 3 2");
		
		JRadioButton rdbtnExtranjero1 = new JRadioButton("Extranjero");
		buttonGroup.add(rdbtnExtranjero1);
		contentPane.add(rdbtnExtranjero1, "cell 4 2");
		
		JLabel lblNewLabel_2 = new JLabel("Ciudad Destino:");
		contentPane.add(lblNewLabel_2, "cell 2 3,alignx trailing");
		
		txtDestino = new JTextField();
		contentPane.add(txtDestino, "cell 3 3 3 1,growx");
		txtDestino.setColumns(10);
		
		JRadioButton rdbtnNacional2 = new JRadioButton("Nacional");
		rdbtnNacional2.setSelected(true);
		buttonGroup_1.add(rdbtnNacional2);
		contentPane.add(rdbtnNacional2, "cell 3 4");
		
		JRadioButton rdbtnExtranjero2 = new JRadioButton("Extranjero");
		buttonGroup_1.add(rdbtnExtranjero2);
		contentPane.add(rdbtnExtranjero2, "cell 4 4");
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de envío:");
		contentPane.add(lblNewLabel_3, "cell 2 5,alignx left");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paq 10 - Antes de las 10 h", "Paq 14 - Antes de las 14 h", "Paq 24 - Al día siguiente"}));
		contentPane.add(comboBox, "cell 3 5 3 1,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Peso:");
		contentPane.add(lblNewLabel_4, "cell 2 6");
		
		JTextField txtPeso = new JTextField();
		contentPane.add(txtPeso, "flowx,cell 3 6,growx");
		
		JButton btnCalcularPrecio = new JButton("Calcular Precio");
		btnCalcularPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String origen = txtOrigen.getText();
				String destino = txtDestino.getText();
				double importe=0;
				String tipos="";
				double recargo=0;
				double peso= Double.parseDouble(txtPeso.getText());
				
				
				
				String tipo = (String) comboBox.getSelectedItem();
				
				if (tipo=="0") {
					tipos="Paq 10 - Antes de las 10 h";
				}
				else if (tipo=="1") {
					tipos="Paq 14 - Antes de las 14 h";
				}
				else {
					tipos="Paq 24 - Al dia siguiente";
				}
				
				if (txtOrigen.getText()==null || txtOrigen.getText().isBlank()
						|| txtDestino.getText()==null || txtDestino.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Faltan datos");
					return;
				}
					
				
				if (rdbtnNacional1.isSelected()) {
					if (rdbtnNacional2.isSelected()) {
						
						importe=4;
						if (peso>=10) {
							importe=importe+3.5;
						}
						else if (peso>=20) {
							importe=importe+7;
						}
						else if (peso>=30) {
							importe=importe+10.5;
						}
						else if (peso>=40) {
							importe=importe+14;
						}
						
						
						if (tipo=="Paq 10 - Antes de las 10 h") {
							importe=importe+5;
						}
						else if (tipo=="Paq 14 - Antes de las 14 h") {
							importe=importe+2;
						}
						
						JOptionPane.showMessageDialog(null,"Origen: "+origen+" "
								+ "\nDestino: "+destino+"\nTipo: "+tipos+
								"\nPeso: "+txtPeso.getText()+"\nImporte: "+importe+"€");
						
					}
					else {
						
						importe=7;
						if (peso>=10) {
							importe=importe+3.5;
						}
						else if (peso>=20) {
							importe=importe+7;
						}
						else if (peso>=30) {
							importe=importe+10.5;
						}
						else if (peso>=40) {
							importe=importe+14;
						}
						
						
						if (tipo=="Paq 10 - Antes de las 10 h") {
							importe=importe+5;
						}
						else if (tipo=="Paq 14 - Antes de las 14 h") {
							importe=importe+2;
						}
						
						JOptionPane.showMessageDialog(null,"Origen: "+origen+" "
								+ "\nDestino: "+destino+"\nTipo: "+tipos+
								"\nPeso: "+txtPeso.getText()+"\nImporte: "+importe+"€");
						
					}
				}
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Kg");
		contentPane.add(lblNewLabel_5, "cell 4 6");
		contentPane.add(btnCalcularPrecio, "cell 3 7");
			
		
	}
}
