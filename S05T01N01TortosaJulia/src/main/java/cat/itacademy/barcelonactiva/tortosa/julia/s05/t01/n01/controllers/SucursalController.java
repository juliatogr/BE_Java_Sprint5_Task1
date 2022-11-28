package cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.domain.Sucursal;
import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.services.ISucursalService;
import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.repository.SucursalRepository;



@Controller
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	private ISucursalService sucursalService;
	
	@Autowired
	SucursalRepository sucursalRepository;

	@GetMapping("/")
	public String listAll(Model model) {
		List<Sucursal> llistatSucursals = sucursalService.listAll();
		model.addAttribute("Titol", "Llista de Sucursals");
		model.addAttribute("sucursals", llistatSucursals);
		return "/sucursal/list";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		Sucursal sucursal = new Sucursal();
		model.addAttribute("Titol", "Formulari: Nova sucursal");
		model.addAttribute("sucursal", sucursal);
		return "/sucursal/create";
	}
	
	@PostMapping("/save")
	public String save(Sucursal sucursal) {
		System.out.println(sucursal.getId());
		sucursalService.saveOne(sucursal);
		return "redirect:/sucursal/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Sucursal sucursal = sucursalService.findByID(id);
		model.addAttribute("sucursal", sucursal);
		return "/sucursal/edit";
	}
	
	@GetMapping("/remove/{id}")
	public String remove(@PathVariable int id) {
		sucursalService.deleteOne(id);
		return "redirect:/sucursal/";
	}
		
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
		Sucursal sucursalData = sucursalRepository.findById(sucursal.getId()).get();

		if (sucursalData != null) {
			Sucursal _sucursal = sucursalData;
			_sucursal.setNom(sucursal.getNom());
			_sucursal.setPais(sucursal.getPais());
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
