package cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.domain.Sucursal;
import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.repository.SucursalRepository;


@Service
public class SucursalService implements ISucursalService {

	@Autowired
	private SucursalRepository sucursalRepository;
	
	
	@Override
	@ModelAttribute("sucursals")
	public List<SucursalDTO> listAll() {
		
		return sucursalRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	
	public SucursalDTO convertToDTO(Sucursal sucursal) {
		SucursalDTO scDTO = new SucursalDTO();
		scDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
		scDTO.setNomSucursal(sucursal.getNom());
		scDTO.setPaisSucursal(sucursal.getPais());
		return scDTO;
		
	}

	@Override
	public void saveOne(Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}

	@Override
	public Sucursal findByID(int id) {
		return sucursalRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteOne(int id) {
		sucursalRepository.deleteById(id);

	}

}
