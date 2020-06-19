package br.com.eshop.establishment.application.service;

import br.com.eshop.establishment.application.form.EstablishmentForm;
import br.com.eshop.establishment.domain.entity.Establishment;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import org.springframework.stereotype.Service;

@Service
public interface EstablishmentService {

    Single<Establishment> store(EstablishmentForm establishmentForm);
}
