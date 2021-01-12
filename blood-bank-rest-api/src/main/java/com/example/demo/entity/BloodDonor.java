package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
	private int donorId;
	private String donorName;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;
	private int donorAge;
	private String donorGender;
	private String bloodGroup;
	private String location;
	private long phoneNumber;
	private String emailAddr;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate lastDonated;
	private String donationCamp;
	
	
}
