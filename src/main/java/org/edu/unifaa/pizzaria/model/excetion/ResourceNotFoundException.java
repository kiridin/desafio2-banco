package org.edu.unifaa.pizzaria.model.excetion;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }
}
