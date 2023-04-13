package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import controller.ControllerMunicipio;
import controller.ControllerProvincia;
import model.Municipio;
import model.Provincia;

import java.awt.Insets;
import java.util.List;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class VentanaMunicipiosYProvincias {

	private JFrame frame;
	private JTextField jtfMunicipio;
	private JTextField jtfNombre;
	JComboBox<Provincia> jcbProvincia;
	JComboBox<Municipio> jcbMunicipio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMunicipiosYProvincias window = new VentanaMunicipiosYProvincias();
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
	public VentanaMunicipiosYProvincias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 631, 261);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		jtfMunicipio = new JTextField();
		GridBagConstraints gbc_jtfMunicipio = new GridBagConstraints();
		gbc_jtfMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_jtfMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfMunicipio.gridx = 0;
		gbc_jtfMunicipio.gridy = 0;
		frame.getContentPane().add(jtfMunicipio, gbc_jtfMunicipio);
		jtfMunicipio.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMunicipios();
			}
		});
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 0;
		frame.getContentPane().add(btnFiltrar, gbc_btnFiltrar);
		
		jcbMunicipio = new JComboBox();
		jcbMunicipio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMunicipios();
			}
		});
		GridBagConstraints gbc_jcbMunicipio = new GridBagConstraints();
		gbc_jcbMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMunicipio.gridx = 0;
		gbc_jcbMunicipio.gridy = 1;
		frame.getContentPane().add(jcbMunicipio, gbc_jcbMunicipio);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMunicipio();
			}
		});
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionar.gridx = 1;
		gbc_btnSeleccionar.gridy = 1;
		frame.getContentPane().add(btnSeleccionar, gbc_btnSeleccionar);
		
		JLabel lblTitulo = new JLabel("Municipio Seleccionado:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 2;
		frame.getContentPane().add(lblTitulo, gbc_lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNombre = new JLabel("Nombre municipio:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panel.add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 0;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia del municipio:");
		lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.anchor = GridBagConstraints.EAST;
		gbc_lblProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvincia.gridx = 0;
		gbc_lblProvincia.gridy = 1;
		panel.add(lblProvincia, gbc_lblProvincia);
		
		jcbProvincia = new JComboBox();
		GridBagConstraints gbc_jcbProvincia = new GridBagConstraints();
		gbc_jcbProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvincia.gridx = 1;
		gbc_jcbProvincia.gridy = 1;
		panel.add(jcbProvincia, gbc_jcbProvincia);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarMunicipio();
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 2;
		panel.add(btnGuardar, gbc_btnGuardar);
	}
	
	/**
	 * 
	 */
	private void cargarMunicipios () {
		List<Municipio> municipiosFiltrados = ControllerMunicipio.filterByNombre(this.jtfMunicipio.getText());
		
		this.jcbMunicipio.removeAllItems();
		
		for (Municipio m : municipiosFiltrados) {
			this.jcbMunicipio.addItem(m);
		}
	}
	
	
	/**
	 * 
	 */
	private void seleccionarMunicipio() {
		// Obtengo el muncipio, desde la lista del JComboBox
		Municipio m = (Municipio) this.jcbMunicipio.getSelectedItem();
		
		this.jtfNombre.setText(m.getNombre());
		
		for (int i = 0; i < this.jcbProvincia.getItemCount(); i++) {
			if (this.jcbProvincia.getItemAt(i).getId() == m.getIdProvincia()) {
				this.jcbProvincia.setSelectedIndex(i);
			}
		}
	}
	
	
	/**
	 * 
	 */
	private void guardarMunicipio() {
		Municipio m = (Municipio) this.jcbMunicipio.getSelectedItem();
		
		m.setNombre(this.jtfNombre.getText());
		m.setIdProvincia(((Provincia) this.jcbProvincia.getSelectedItem()).getId());
		
		try {
			ControllerMunicipio.modificar(m);
			JOptionPane.showMessageDialog(null, "Modificado correctamente");
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error, no ha podido modificarse");
			ex.printStackTrace();
		}
	}
	

}
