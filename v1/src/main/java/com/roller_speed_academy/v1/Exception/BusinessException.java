package com.roller_speed_academy.v1.Exception;

/**
 * Excepción para validaciones de negocio
 * Aplica el principio de Responsabilidad Única (SRP) - SOLID
 */
public class BusinessException extends RuntimeException {
    
    public BusinessException(String message) {
        super(message);
    }
    
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
