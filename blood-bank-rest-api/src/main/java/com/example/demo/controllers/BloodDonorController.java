package com.example.demo.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.BloodDonorsList;
import com.example.demo.services.BloodDonorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/donors")
public class BloodDonorController {

	@Autowired
	private BloodDonorService service;
	
	@GetMapping(path = "/")
	public BloodDonorsList findAllDonors() {
		return this.service.findAllDonors();
	}
	
	@PostMapping(path = "/newDonor")
	public BloodDonor addNewDonor(@RequestBody BloodDonor bloodDonor) {
		return this.service.saveDonor(bloodDonor);
	}
	
	@PutMapping(path = "/updateDonor")
	public BloodDonor updateDonor(@RequestParam(name = "donorId") int id, @RequestBody BloodDonor bloodDonor) {
		BloodDonor existingDonor = this.service.findDonorById(id);
		
		String donorName = bloodDonor.getDonorName();
		LocalDate dateOfBirth = bloodDonor.getDateOfBirth();
		int donorAge = bloodDonor.getDonorAge();
		String donorGender = bloodDonor.getDonorGender();
		String bloodGroup = bloodDonor.getBloodGroup();
		String location = bloodDonor.getLocation();
		String phoneNumber = bloodDonor.getPhoneNumber();
		String emailAddr = bloodDonor.getEmailAddr();
		LocalDate lastDonated = bloodDonor.getLastDonated();
		
		if(existingDonor != null) {
			existingDonor.setDonorName(donorName);
			existingDonor.setDateOfBirth(dateOfBirth);
			existingDonor.setDonorAge(donorAge);
			existingDonor.setDonorGender(donorGender);
			existingDonor.setBloodGroup(bloodGroup);
			existingDonor.setLocation(location);
			existingDonor.setPhoneNumber(phoneNumber);
			existingDonor.setEmailAddr(emailAddr);
			existingDonor.setLastDonated(lastDonated);
		}
		
		return this.service.saveDonor(existingDonor);
	}
	
	@PostMapping(path = "/")
	public BloodDonorsList findSpecificDonors(@RequestParam(name = "date") @DateTimeFormat(iso = ISO.DATE) LocalDate requiredDate, @RequestParam(name = "bg") String bloodGroup, @RequestParam(name = "loc") String location) {
		return this.service.findSpecificDonors(requiredDate, bloodGroup, location);
	}
}
