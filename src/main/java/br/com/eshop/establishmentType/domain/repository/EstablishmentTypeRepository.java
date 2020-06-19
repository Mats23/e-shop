package br.com.eshop.establishmentType.domain.repository;

import br.com.eshop.establishmentType.domain.entity.EstablishmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentTypeRepository extends JpaRepository<EstablishmentType, Long> {
}
