package edu.example.core.interfaces;

interface A {
    default int foo() {return 1;}
}

interface B {
    default int foo() {return 2;}
}

class C implements A,B{
    @Override
    public int foo(){
        return B.super.foo();
    }
}