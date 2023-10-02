package kg.java.testtodo.exceptions;

public class EntityDuplicateExceptions extends Exception{
    public EntityDuplicateExceptions() {
        super("entity exist");
    }
}
