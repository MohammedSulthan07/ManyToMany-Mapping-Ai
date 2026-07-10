package com.hibernate.entity;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.hibernate.enums.Gender;
import com.hibernate.enums.PetType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pet_table")
public class Pet {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate birthDate;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private PetType type;

	@ManyToMany(mappedBy = "petList")
	private Set<Owner> ownerList = new HashSet<>();

}

