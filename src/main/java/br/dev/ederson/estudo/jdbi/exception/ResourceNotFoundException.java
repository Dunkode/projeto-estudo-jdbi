package br.dev.ederson.estudo.jdbi.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg){ super(msg); }
}