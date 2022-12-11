package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexionsql.conexionsql;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JPanel contentPane;
	private JTextField cedula;
	private JTextField nombre;
	private JTextField sueldo;
	private JTextField apellido;

	/**
	 * Launch the application.
	 */
	Connection conexion = null;
	PreparedStatement  ps = null;
	ResultSet rs = null;
	private JTextField id;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(getBackground());
		conexion = conexionsql.conectar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 500, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula de identidad");
		lblNewLabel.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(86, 84, 109, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(116, 118, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1_1.setBounds(116, 161, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Sueldo");
		lblNewLabel_1_1_1.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1_1_1.setBounds(116, 200, 46, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CRUD PROGRAMACION: DATOS DE PERSONAS");
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setFont(new Font("Britannic Bold", Font.PLAIN, 22));
		lblNewLabel_1_1_2.setBounds(37, 11, 447, 24);
		panel.add(lblNewLabel_1_1_2);
		
		cedula = new JTextField();
		cedula.setBounds(86, 98, 109, 20);
		panel.add(cedula);
		cedula.setColumns(10);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(86, 135, 109, 20);
		panel.add(nombre);
		
		sueldo = new JTextField();
		sueldo.setColumns(10);
		sueldo.setBounds(86, 215, 109, 20);
		panel.add(sueldo);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(86, 176, 109, 20);
		panel.add(apellido);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarCasillas();
			}
		});
		btnNuevo.setBounds(318, 97, 99, 23);
		panel.add(btnNuevo);
		
		JButton btnActualizar = new JButton("Modificar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosActualizar();
				LimpiarCasillas();
			}
		});
		btnActualizar.setBounds(318, 214, 99, 23);
		panel.add(btnActualizar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosNuevos();
				LimpiarCasillas();
			}
		});
		btnGuardar.setBounds(318, 134, 99, 23);
		panel.add(btnGuardar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosBorrar();
				LimpiarCasillas();
			}
		});
		btnBorrar.setBounds(318, 175, 99, 23);
		panel.add(btnBorrar);
		
		id = new JTextField();
		id.setBounds(140, 46, 211, 20);
		panel.add(id);
		id.setColumns(10);
		
		JLabel ID = new JLabel("ID del Registro");
		ID.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		ID.setForeground(new Color(255, 255, 0));
		ID.setBounds(39, 49, 109, 14);
		panel.add(ID);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosBuscar();
			}
		});
		btnNewButton.setBounds(377, 45, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblElvisRamos = new JLabel("Elvis Ramos\r\n");
		lblElvisRamos.setForeground(new Color(255, 255, 255));
		lblElvisRamos.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblElvisRamos.setBounds(220, 259, 79, 14);
		panel.add(lblElvisRamos);
	}
	
	public void LimpiarCasillas() {
		cedula.setText("");
		nombre.setText("");
		sueldo.setText("");
		apellido.setText("");
		id.setText("");
	}
	
	
	public void DatosNuevos() {
		try {
			ps = conexion.prepareStatement("Insert into datos (cedula,nombre,apellido,sueldo) values (?,?,?,?)");
			
			ps.setString(1, cedula.getText());
			ps.setString(2, nombre.getText());
			ps.setString(3, apellido.getText());
			ps.setDouble(4, Double.parseDouble(sueldo.getText()));
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Registro de datos Exitoso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Registro de datos Fallido, Error: "+e.getMessage());
		}
	}
	
	public void DatosBuscar() {
		try {
			
			ps = conexion.prepareStatement("Select cedula,nombre,apellido,sueldo from datos where idDatos=?");
			
			ps.setString(1, id.getText());
			
			rs= ps.executeQuery();
			
			if(rs.next()) {
				cedula.setText(rs.getString("cedula"));
				nombre.setText(rs.getString("nombre"));
				apellido.setText(rs.getString("apellido"));
				sueldo.setText(rs.getString("sueldo"));
			}else {
			
			JOptionPane.showMessageDialog(null, "Registro no encontrado");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error al acceder a la base de datos, Error: "+e.getMessage());
		}
	}
	
	
	public void DatosActualizar() {
		try {
			
			ps = conexion.prepareStatement("UPDATE datos SET cedula=?,nombre=?,apellido=?,sueldo=? where idDatos=?");
			
			
			ps.setString(1, cedula.getText());
			ps.setString(2, nombre.getText());
			ps.setString(3, apellido.getText());
			ps.setDouble(4, Double.parseDouble(sueldo.getText()));
			ps.setString(5, id.getText());
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Modificacion de datos Exitosa");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Modificacion de datos Fallida, Error: "+e.getMessage());
		}
	}
	
	public void DatosBorrar() {
		try {
			
			ps = conexion.prepareStatement("Delete from datos where idDatos=?");
			
			ps.setString(1, id.getText());
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro, Error: "+e.getMessage());
		}
	}
	
}
