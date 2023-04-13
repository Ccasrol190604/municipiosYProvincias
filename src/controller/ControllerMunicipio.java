package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connecction.ConnectionManagerV1;
import model.Municipio;

public class ControllerMunicipio {
	
	/**
	 * 
	 */
	public static List<Municipio> filterByNombre (String filtro) {
		List<Municipio> lista = new ArrayList<Municipio>();
		try {
			Statement s = (Statement) ConnectionManagerV1.getConexion().createStatement(); 
			ResultSet rs = s.executeQuery ("select * from municipio where nombre like '%" + filtro + "%'");
			
			while (rs.next()) {
				Municipio m = new Municipio();
				m.setId(rs.getInt("id"));
				m.setIdProvincia(rs.getInt("idProvincia"));
				m.setCodMunicipio(rs.getInt("codMunicipio"));
				m.setNombre(rs.getString("nombre"));
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

	
	
	/**
	 * 
	 */
	public static int modificar (Municipio m) {		
		int registrosAfectados = 0;
		try {
			PreparedStatement ps = ConnectionManagerV1.getConexion().prepareStatement(
					"update municipio set nombre = ?, idProvincia = ? where id = ?");
			ps.setString(1, m.getNombre());
			ps.setInt(2, m.getIdProvincia());
			ps.setInt(3, m.getId());
			registrosAfectados = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return registrosAfectados;		
	}
}
