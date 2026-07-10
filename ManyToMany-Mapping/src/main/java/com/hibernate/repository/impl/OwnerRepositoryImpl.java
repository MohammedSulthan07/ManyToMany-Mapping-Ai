package com.hibernate.repository.impl;

import java.util.List;
import java.util.Objects;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.config.DatabaseConfig;
import com.hibernate.entity.Owner;
import com.hibernate.entity.Pet;
import com.hibernate.repository.OwnerRepository;

public class OwnerRepositoryImpl implements OwnerRepository {
	private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

	@Override
	public void saveOwner(Owner owner) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(owner);
			transaction.commit();
		}
	}

	@Override
	public Owner findOwner(int ownerId) {
		try (Session session = sessionFactory.openSession()) {
			return session.find(Owner.class, ownerId);
		}
	}

	@Override
	public Owner findOwnerWithPet(int ownerId) {
		try (Session session = sessionFactory.openSession()) {
			Owner owner = session.find(Owner.class, ownerId);
			if (Objects.nonNull(owner)) {
				Hibernate.initialize(owner.getPetList());
			}
			System.out.println(owner);
			return owner;
		}
	}

	@Override
	public void updatePetDetails(int ownerId, int petId, String petName) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Owner owner = session.find(Owner.class, ownerId);
			if (Objects.nonNull(owner)) {
				owner.getPetList()
						.stream()
						.filter(pet -> pet.getId() == petId)
						.findFirst()
						.ifPresent(pet -> pet.setName(petName));
				session.merge(owner);
			}
			transaction.commit();
		}
	}

	@Override
	public void deleteOwner(int ownerId) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Owner owner = session.find(Owner.class, ownerId);
			if (Objects.nonNull(owner)) {
				owner.getPetList().stream().filter(pet -> pet.getOwnerList().size()==1).forEach(owner.getPetList()::remove);
				session.merge(owner);
				transaction.commit();
			}
		}
	}

	@Override
	public void addPet(int ownerId, Pet pet) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Owner owner = session.find(Owner.class, ownerId);
			if (Objects.nonNull(owner)) {
				owner.getPetList().add(pet);
				session.persist(owner);
			}
			transaction.commit();
		}
	}

	@Override
	public void removePet(int ownerId, int petId) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Owner owner = session.find(Owner.class, ownerId);
			if (Objects.nonNull(owner)) {
				owner.getPetList().stream().filter(pet -> pet.getId()==petId).filter(pet -> pet.getOwnerList().size()==1).findFirst().ifPresent(owner.getPetList()::remove);
				owner.getPetList().removeIf(pet -> pet.getId()==petId);
				session.persist(owner);
			}
			transaction.commit();
		}
	}

	@Override
	public void addCoOwner(int petId, Owner owner) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Pet pet = session.find(Pet.class, petId);
			if (Objects.nonNull(owner)) {
				pet.getOwnerList().add(owner);
				session.merge(pet);
			}
			transaction.commit();
		}
	}

	@Override
	public List<Owner> findAllOwners() {
		String hql="SELECT o FROM Owner o";
		try (Session session = sessionFactory.openSession()) {
			return session.createSelectionQuery(hql, Owner.class).getResultList();

			}
		}
	}

