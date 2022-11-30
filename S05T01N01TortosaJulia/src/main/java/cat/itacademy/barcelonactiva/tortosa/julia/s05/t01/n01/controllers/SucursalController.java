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

import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.domain.Sucursal;
import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.dto.SucursalDTO;
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
		List<SucursalDTO> llistatSucursals = sucursalService.listAll();
		model.addAttribute("Titol", "Llista de Sucursals");
		model.addAttribute("sucursals", llistatSucursals);
		return "/sucursal/list";
	}
	
	@GetMapping("/add")
	public String create(Model model) {
		Sucursal sucursal = new Sucursal();
		model.addAttribute("titol", "Formulari: Nova sucursal");
		model.addAttribute("sucursal", sucursal);
		return "/sucursal/create";
	}
	
	@PostMapping("/save")
	public String save(Sucursal sucursal) {
		System.out.println(sucursal);
		sucursalService.saveOne(sucursal);
		System.out.println(sucursal);
		return "redirect:/sucursal/";
	}
	
	@GetMapping("/update/{pk_SucursalID}")
	public String edit(@PathVariable("pk_SucursalID") int pk_SucursalID, Model model) {
		Sucursal sucursal = sucursalService.findByID(pk_SucursalID);
		model.addAttribute("sucursal", sucursal);
		System.out.println(sucursal);
		return "/sucursal/edit";
	}
	
	@GetMapping("/delete/{pk_SucursalID}")
	public String remove(@PathVariable int pk_SucursalID) {
		sucursalService.deleteOne(pk_SucursalID);
		return "redirect:/sucursal/";
	}
}
