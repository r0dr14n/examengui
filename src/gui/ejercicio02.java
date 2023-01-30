package gui;

import java.awt.EventQueue;
import clases.Autocar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class ejercicio02 extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtMarca;
	private JTextField txtKilometros;
	private JTextField txtModelo;
	private ArrayList <Autocar> listaAutocar;
	private JTable textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio02 frame = new ejercicio02();
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
	public ejercicio02() {
		Autocar a;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][][][][][][grow][][][grow][grow][grow][grow]", "[][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Matrícula:");
		contentPane.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		txtMatricula = new JTextField();
		contentPane.add(txtMatricula, "cell 1 0 4 1,growx");
		txtMatricula.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		txtMarca = new JTextField();
		contentPane.add(txtMarca, "cell 1 1 4 1,growx");
		txtMarca.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Modelo:");
		contentPane.add(lblNewLabel_3, "cell 6 1,alignx right");
		
		txtModelo = new JTextField();
		contentPane.add(txtModelo, "cell 7 1 7 1,growx");
		txtModelo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Kilómetros:");
		contentPane.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		txtKilometros = new JTextField();
		contentPane.add(txtKilometros, "cell 1 2 4 1,growx");
		txtKilometros.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Plazas:");
		contentPane.add(lblNewLabel_4, "cell 6 2,alignx right");
		
		JSpinner spnPlazas = new JSpinner();
		spnPlazas.setModel(new SpinnerNumberModel(30, 1, 80, 1));
		contentPane.add(spnPlazas, "cell 7 2 4 1,growx");
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String matricula=txtMatricula.getText();
				String marca=txtMarca.getText();
				String modelo=txtModelo.getText();
				int kilometros=Integer.parseInt(txtKilometros.getText());
				int num_plazas=30;
				
				Autocar a = new Autocar(matricula, marca, modelo, kilometros, num_plazas);
				
				if (listaAutocar.contains(a)==false) {
					listaAutocar.add(a);
				} else {
					JOptionPane.showMessageDialog(null, 
							"Ya existe un autocar igual",
							"Autocar ya existe", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnInsertar, "cell 2 4 2 1");
		
		
		textArea = new JTable();
		textArea.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Matr\u00EDcula", "Marca", "Modelo", "Kilometros", "Num_Plazas"
			}
		));
		contentPane.add(textArea, "cell 0 6 15 2,grow");
		
		JButton btnMostrar = new JButton("Mostrar Datos");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) 					textArea.getModel();
				for (Autocar a : listaAutocar) {
						Object fila [] = {
								a.getMatricula(), a.getMarca(), a.getModelo(), a.getKilometros(), a.getNum_plazas(),
						};
						modelo.addRow(fila);
			}
		}
	});
		contentPane.add(btnMostrar, "cell 5 4 2 1");
		
	}

}
