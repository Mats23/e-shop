package br.com.eshop.establishment.application.service;

import br.com.eshop.establishment.application.form.EstablishmentForm;
import br.com.eshop.establishment.application.mapper.EstablishmentMapper;
import br.com.eshop.establishment.domain.entity.Establishment;
import br.com.eshop.establishment.domain.repository.EstablishmentRepository;
import br.com.eshop.insfrastructure.exception.EstablishmentExistException;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstablishmentServiceImpl implements EstablishmentService {

    @Autowired
    EstablishmentRepository establishmentRepository;



    @Override
    public Single<Establishment> store(EstablishmentForm establishmentForm) {

         return Single.create((singleSubscriber) -> {
             Establishment establishment = EstablishmentMapper.INSTANCE.formToEntity(establishmentForm);
             if (this.establishmentRepository.findByName(establishment.getName()).isEmpty()) {
                 singleSubscriber.onSuccess(this.establishmentRepository.save(establishment));
             } else {
                 singleSubscriber.onError(new EstablishmentExistException());
             }
         });

    }
}
