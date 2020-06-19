package br.com.eshop.establishment.application.mapper;

import br.com.eshop.establishment.application.dto.EstablishmentDTO;
import br.com.eshop.establishment.application.form.EstablishmentForm;
import br.com.eshop.establishment.domain.entity.Establishment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstablishmentMapper {

    EstablishmentMapper INSTANCE = Mappers.getMapper(EstablishmentMapper.class);


    EstablishmentDTO entityToDto(Establishment establishment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    Establishment formToEntity(EstablishmentForm establishmentForm);
}
