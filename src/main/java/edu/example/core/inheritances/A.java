package edu.example.core.inheritances;

public class A {
    void printMe(){
        System.out.println("A");
    }
}

class B extends A{
    @Override
    void printMe(){
        System.out.println("B");
    }
}

class C extends B{
    @Override
    void printMe(){
        System.out.println("C");
    }
}

class Main{
    public static void main(String[] args) {
        A target = new B();
        Runnable methodReference = target::printMe;
        target = new C();
        //methodReference не сохраняет связь с ообновлением target
        methodReference.run();  // "B"
    }
}