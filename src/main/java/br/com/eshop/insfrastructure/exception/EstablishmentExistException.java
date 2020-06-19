package br.com.eshop.insfrastructure.exception;

import br.com.eshop.insfrastructure.constants.Constants;

public class EstablishmentExistException extends Exception {
    private String msg;
    public EstablishmentExistException() {
        this.msg = Constants.ESTABLISHMENT_FOUND;
    }
    @Override
    public String getMessage() {
        return Constants.ESTABLISHMENT_FOUND;
    }
}
