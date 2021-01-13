package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.BloodDonorsList;
import com.example.demo.repos.BloodDonorRepository;

@Service
public class BloodDonorService {

	@Autowired
	private BloodDonorRepository repo;

	public BloodDonor saveDonor(BloodDonor bloodDonor) {
		return this.repo.save(bloodDonor);
	}

	public BloodDonorsList findAllDonors() {
		BloodDonorsList donorsList = new BloodDonorsList();
		donorsList.setDonorsList(this.repo.findAll());
		return donorsList;
	}

	public BloodDonor findDonorById(int id) {
		// Throws NoSuchElementException if Donor not present
		return this.repo.findById(id).get();
	}

	public void deleteDonor(int id) {
		this.repo.deleteById(id);
	}


}
