package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "blood_donors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BloodDonor {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int donorId;
	private String donorName;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;
	private int donorAge;
	private String donorGender;
	private String bloodGroup;
	private String location;
	private String phoneNumber;
	private String emailAddr;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate lastDonated;
	private String donationCampName;
	
	// Many-to-one relationship with DonationCamp for Join operations
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "donor_fk",referencedColumnName = "donationCampName")
	@JsonIgnore
	
	private DonationCamp donationCamp;
	
	
}
