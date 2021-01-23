package com.example.demo.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BloodDonor;


@Repository
public interface BloodDonorRepository extends JpaRepository<BloodDonor, Integer>{

	@Query(value = "SELECT * FROM blood_donors where lastDonated<=(:requiredDate - interval 6 month) and bloodGroup LIKE :bloodGroup and location LIKE :location", nativeQuery = true)
	List<BloodDonor> findSpecificDonors(@Param("requiredDate") @DateTimeFormat(iso = ISO.DATE) LocalDate requiredDate, @Param("bloodGroup") String bloodGroup, @Param("location") String location);
	
	@Query(value = "select e.* from (select a.* from (select * from blood_donors) a RIGHT JOIN (select * from donation_camps where id=:campId) b on b.donationCampName=a.donationCampName) e", nativeQuery = true)
	List<BloodDonor> findDonorsUnderCamp( @Param("campId") int campId);
	
	@Query(value = "SELECT DISTINCT location from blood_donors", nativeQuery = true)
	List<String> findAllDonorLocations();
}
