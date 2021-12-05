package edu.example.core.functional;

@FunctionalInterface
public interface FuncInterface {
    String toString();
    void callback();
    default void extraAction(){};
}

//@FunctionalInterface
abstract class NonFunctional{
    abstract void callback();
}
