package com.roller_speed_academy.v1.Exception;

/**
 * Excepción personalizada para recursos no encontrados
 * Aplica el principio de Responsabilidad Única (SRP) - SOLID
 */
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
