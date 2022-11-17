package cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.domain.Sucursal;
import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.repository.SucursalRepository;



@RestController
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	SucursalRepository sucursalRepository;

	@GetMapping("/getAll")
	public ResponseEntity<List<Sucursal>> getAllSucursals() {
		try {
			List<Sucursal> sucursals = new ArrayList<Sucursal>();
		
			sucursalRepository.findAll().forEach(sucursals::add);
		
			return new ResponseEntity<>(sucursals, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Sucursal> getSucursalById(@PathVariable(name = "id") int id) {
	Optional<Sucursal> sucursalData = sucursalRepository.findById(id);
	
		if (sucursalData.isPresent()) {
			return new ResponseEntity<>(sucursalData.get(), HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/add")
	public ResponseEntity<Sucursal> createSucursal(@RequestBody Sucursal sucursal) {
		try {
			Sucursal _sucursal = sucursalRepository
					.save(new Sucursal(sucursal.getNom(), sucursal.getPais()));
			return new ResponseEntity<>(_sucursal, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
  }

	@PutMapping("/update")
	public ResponseEntity<Sucursal> updateSucursal(@RequestBody Sucursal sucursal) {
		Sucursal sucursalData = sucursalRepository.findSucursalByNomSucursal(sucursal.getNom());

		if (sucursalData != null) {
			Sucursal _sucursal = sucursalData;
			_sucursal.setNom(sucursal.getNom());
			_sucursal.setQuantitatQuilos(sucursal.getPais());
			return new ResponseEntity<>(sucursalRepository.save(_sucursal), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteSucursal(@PathVariable("id") int id) {
		try {
			sucursalRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
