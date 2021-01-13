package com.example.demo.entity;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "donation_camps")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DonationCamp {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Id
	private String donationCampName;
	private String location;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate campDate;
	
	// One-to-many relationship for join operations. 
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "camp_fk", referencedColumnName = "donationCampName")
//	private List<BloodDonor> bloodDonors = new ArrayList<>();
}
