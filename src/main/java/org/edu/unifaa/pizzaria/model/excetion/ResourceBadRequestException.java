package org.edu.unifaa.pizzaria.model.excetion;

public class ResourceBadRequestException extends RuntimeException {
    
    public ResourceBadRequestException(String mensagem){
        super(mensagem);
    }
}
