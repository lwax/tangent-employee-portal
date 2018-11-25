package za.co.tangentsolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.tangentsolutions.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}