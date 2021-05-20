package com.mt.FoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.FoodApp.model.NGO;
import com.mt.FoodApp.repository.NGORepository;

@Service
public class NGOService {
	@Autowired
	private NGORepository ngoRepository;

	public NGOService(NGORepository ngoRepository) {
		this.ngoRepository = ngoRepository;
	}

	public NGO addNGO(NGO ngo) {
		return ngoRepository.save(ngo);
	}

	public NGO updateNGO(NGO ngo) {
		Optional<NGO> existingNGO = ngoRepository.findById(ngo.getId());
		if (ngo.getName() != null)
			existingNGO.get().setName(ngo.getName());
		if (ngo.getAddress() != null)
			existingNGO.get().setAddress(ngo.getAddress());
		if (ngo.getPinCode() != 0)
			existingNGO.get().setPinCode(ngo.getPinCode());
		if (ngo.getPhoneNumber() != null)
			existingNGO.get().setPhoneNumber(ngo.getPhoneNumber());
		if (ngo.getCity() != null)
			existingNGO.get().setCity(ngo.getCity());
		return ngoRepository.save(existingNGO.get());
	}

	public Optional<NGO> findById(Long id) {
		return ngoRepository.findById(id);
	}

	public List<NGO> findAllNGOs() {
		return ngoRepository.findAll();
	}

	public void deleteNGO(Long id) {
		ngoRepository.deleteById(id);
	}
}
