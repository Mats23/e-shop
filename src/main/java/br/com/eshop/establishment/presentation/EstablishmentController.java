package br.com.eshop.establishment.presentation;

import br.com.eshop.establishment.application.form.EstablishmentForm;
import br.com.eshop.establishment.application.service.EstablishmentService;
import br.com.eshop.establishment.domain.entity.Establishment;

import br.com.eshop.insfrastructure.exception.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/establishment")
@Slf4j
public class EstablishmentController {


    @Autowired
    private EstablishmentService service;


    @PostMapping
    @ExceptionHandler()
    public ResponseEntity<Establishment> create(@RequestBody EstablishmentForm establishmentForm ) {
        try {
            return ResponseEntity.ok(service.store(establishmentForm).blockingGet());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return new ResponseEntity(new ApiError(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
