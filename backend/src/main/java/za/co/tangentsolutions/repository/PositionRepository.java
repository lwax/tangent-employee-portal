
package za.co.tangentsolutions.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import za.co.tangentsolutions.model.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
}