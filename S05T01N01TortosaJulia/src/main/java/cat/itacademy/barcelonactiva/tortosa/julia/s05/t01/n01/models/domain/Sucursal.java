package cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.domain;

import javax.persistence.*;

@Entity
@Table(name = "sucursals")
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int pk_SucursalID;
	
	@Column(name = "nom", unique = true, nullable = false)
	private String nomSucursal;
	
	@Column(name = "pais", unique = true, nullable = false)
	private String paisSucursal;
	
	public Sucursal() {
	}
	
	public Sucursal(String nom, String pais) {
		this.nomSucursal = nom;
		this.paisSucursal = pais;
	}	
	
	public int getId() {
		return pk_SucursalID;
	}

	public String getNom() {
		return nomSucursal;
	}
	
	public void setNom(String nom) {
		this.nomSucursal = nom;
	}
	
	public String getPais() {
		return paisSucursal;
	}
	
	public void setQuantitatQuilos(String pais) {
		this.paisSucursal = pais;
	}

	@Override
	public String toString() {
		return "Sucursal [id=" + pk_SucursalID + ", nom=" + nomSucursal + ", pais=" + paisSucursal + "]";
	}
	
	
}
