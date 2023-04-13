package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connecction.ConnectionManagerV1;
import model.Provincia;

public class ControllerProvincia {
	
	/**
	 * 
	 */
	public static List<Provincia> findAll () {
		List<Provincia> lista = new ArrayList<Provincia>();
		try {
			Statement s = (Statement) ConnectionManagerV1.getConexion().createStatement(); 
			ResultSet rs = s.executeQuery ("select * from provincia");
			
			while (rs.next()) {
				Provincia p = new Provincia();
				p.setId(rs.getInt("id"));
				p.setProvincia(rs.getString("provincia"));
			}
			
			rs.close();
			s.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return lista;
	}


}
