package kg.java.testtodo.exceptions;

public class EntityNotFoundException extends Exception
{
    public EntityNotFoundException() {
        super("entity not found");
    }
}
