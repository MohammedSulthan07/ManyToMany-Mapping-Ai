package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import com.hibernate.enums.Gender;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "owner_table")
public class Owner {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String state;
	@Column(name = "mobile_number", nullable = false, unique = true, length = 10)
	private String mobileNumber;
	@Column(name = "email_id", nullable = false, unique = true)
	private String emailId;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinTable(name = "owner_pet_table",
	  joinColumns=@JoinColumn(name = "owner_id",referencedColumnName = "id",nullable = false),
	  inverseJoinColumns = @JoinColumn(name = "pet_id",referencedColumnName = "id",nullable = false)
	)
	private Set<Pet> petList = new HashSet<>();
}
