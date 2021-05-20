package com.mt.FoodApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.FoodApp.exception.NGONotFoundException;
import com.mt.FoodApp.model.NGO;
import com.mt.FoodApp.service.NGOService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ngo")
public class NGOController {
	
	@Autowired
	private NGOService ngoService;

	@GetMapping("/getNGOs")
	public ResponseEntity<List<NGO>> getNGOs() {
		List<NGO> ngos = ngoService.findAllNGOs();
		return new ResponseEntity<List<NGO>>(ngos, HttpStatus.OK);
	}

	@GetMapping("/getNGOById/{id}")
	public ResponseEntity<NGO> getNGOs(@PathVariable("id") long id) {
		Optional<NGO> ngo = ngoService.findById(id);
		if (ngo.get() == null) {
			throw new NGONotFoundException("NGO was not found.");
		}
		return new ResponseEntity<NGO>(ngo.get(), HttpStatus.OK);
	}

	@PostMapping("/addNgo")
	public ResponseEntity<NGO> addNgo(@Valid @RequestBody NGO inputNgo) {
		NGO user = ngoService.addNGO(inputNgo);
		return new ResponseEntity<NGO>(user, HttpStatus.CREATED);
	}

	@PutMapping("/updateNgo")
	public ResponseEntity<NGO> updateNgo(@Valid @RequestBody NGO inputNgo) {
		NGO ngo = ngoService.updateNGO(inputNgo);
		return new ResponseEntity<NGO>(ngo, HttpStatus.OK);
	}

	@DeleteMapping("/deleteNgo/{id}")
	public ResponseEntity<?> deleteNgo(@PathVariable("id") long id) {
		ngoService.deleteNGO(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
