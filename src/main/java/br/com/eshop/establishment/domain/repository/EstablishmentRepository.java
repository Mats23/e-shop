package br.com.eshop.establishment.domain.repository;

import br.com.eshop.establishment.domain.entity.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {


   Optional<Establishment> findByName(String name);
}
