package cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.services;

import java.util.List;

import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.domain.Sucursal;
import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.dto.SucursalDTO;

public interface ISucursalService {
	public List<SucursalDTO> listAll();
	public void saveOne(Sucursal sucursal);
	public Sucursal findByID(int id);
	public void deleteOne(int id);
}
