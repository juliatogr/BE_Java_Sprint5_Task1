package cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.dto;

import java.util.Arrays;
import java.util.Optional;


import lombok.Data;

@Data
public class SucursalDTO {

	private int pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	
	private String[] paisos = {
			
			"Albània", "Alemanya", "Andorra", "Armènia", "àustria", "Azerbaidjan",
			"Bèlgica", "Bielorrúsia", "Bòsnia i Hercegovina", "Bulgària",
			"Croàcia", "Dinamarca",
			"Eslovàquia", "Eslovènia", "Espanya", "Estònia",
			"Finlàndia", "França", "Geòrgia", "Grècia", "Hongria",
			"Irlanda", "Islàndia", "Itàlia", "Kazakhstan",
			"Letònia", "Liechenstein", "Lituània", "Luxemburg",
			"Macedònia del Nord", "Malta", "Moldàvia", "Mònaco", "Montenegro",
			"Noruega", "Països Baixos", "Polònia", "Portugal",
			"Regne Unit", "República Txeca", "Rumania", "Rússia",
			"San Marino", "Sèrbia", "Suècia", "Suïssa",
			"Turquia", "Txipre", "Ucraïna", "Ciutat del Vaticà"
	};
	
	public SucursalDTO() {
	}
	
	public SucursalDTO(String nom, String pais) {
		this.nomSucursal = nom;
		this.paisSucursal = pais;
	}
	
	public int getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(int pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}
	
	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
		
		if (isUE()) {
			this.tipusSucursal = "UE";
		} else {
			this.tipusSucursal = "Fora UE";
		}
	}
	
	private boolean isUE() {
		boolean isUE = false;
		Optional<String> optPais = Arrays.stream(paisos).filter(p->p.equals(this.paisSucursal)).findAny();
		
		if (optPais.isPresent()) {
			isUE = true;
		} 
		return isUE;
	}

//	public String getTipusSucursal() {
//		return tipusSucursal;
//	}
//
//	public void setTipusSucursal(String tipusSucursal) {
//		this.tipusSucursal = tipusSucursal;
//	}
	
	
	@Override
	public String toString() {
		return "Sucursal [id=" + pk_SucursalID + ", nom=" + nomSucursal + ", pais=" + paisSucursal + "]";
	}
	
	
}
