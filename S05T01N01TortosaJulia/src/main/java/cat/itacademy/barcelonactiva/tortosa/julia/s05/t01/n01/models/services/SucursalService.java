package cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.domain.Sucursal;
import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.repository.SucursalRepository;


@Service
public class SucursalService implements ISucursalService {

	@Autowired
	private SucursalRepository sucursalRepository;
	
	@Override
	public List<Sucursal> listAll() {
		
		return (List<Sucursal>) sucursalRepository.findAll();
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
