package edu.example.core.overriding;

public class Base {
    static void prinMe() {
        System.out.println("Base");
    }
}

class Child extends Base {
    static void prinMe() {
        System.out.println("Child");
    }

}

class C{
    public static void main(String[] args) {
        Base instanceB = new Child();
        // Static member 'edu.example.core.overriding.Base.prinMe()' accessed via instance reference
        instanceB.prinMe(); // хоть объект и Child, напечатается "Base"
    }
}