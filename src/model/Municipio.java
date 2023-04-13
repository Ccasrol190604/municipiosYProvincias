package model;

public class Municipio {
	private int id;
	private int idProvincia;
	private int codMunicipio;
	private String nombre;
	
	/**
	 * 
	 */
	public Municipio() {
	}

	/**
	 * @param id
	 * @param idProvincia
	 * @param nombre
	 */
	public Municipio(int id, int idProvincia, int codMunicipio, String nombre) {
		this.id = id;
		this.idProvincia = idProvincia;
		this.codMunicipio = codMunicipio;
		this.nombre = nombre;
	}
	
	/**
	 * Getters y setters
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public int getCodMunicipio() {
		return codMunicipio;
	}
	public void setCodMunicipio(int codMunicipio) {
		this.codMunicipio = codMunicipio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * to String
	 */
	@Override
	public String toString() {
		return "Municipio [id=" + id + ", idProvincia=" + idProvincia + ", codMunicipio=" + codMunicipio + ", nombre="
				+ nombre + "]";
	}

}
