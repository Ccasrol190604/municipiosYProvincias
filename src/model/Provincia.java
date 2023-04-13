package model;

public class Provincia {
	private int id;
	private String provincia;
	
	/**
	 * 
	 */
	public Provincia() {
	}

	/**
	 * @param id
	 * @param provincia
	 */
	public Provincia(int id, String provincia) {
		this.id = id;
		this.provincia = provincia;
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	/**
	 * to String
	 */
	@Override
	public String toString() {
		return "Provincia [id=" + id + ", provincia=" + provincia + "]";
	}
	
	

}
