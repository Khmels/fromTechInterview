package edu.example.core.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObjectType {
    public static void main(String[] args) {
        //---------------------- Разница между примитивными типами данных и ссылочными---------------------

        /*
        Примитивные типы у себя внутри хранят значение, а ссылочные – ссылку на объект.
        Примитивные типы – это int, char, boolean и ещё немного,
         ссылочные типы – это все остальные, и образуются они с помощью классов.
         */

        //---------------------- Wrapper classes

        /*
        provides the mechanism to convert primitive into object and object into primitive.
         */

        /* Purpose
        Change the value in Method: Java supports only call by value.
                                    So, if we pass a primitive value, it will not change the original value.
                                    But, if we convert the primitive value in an object, it will change the original value.

        Serialization:              We need to convert the objects into streams to perform the serialization.

        Synchronization:            Java synchronization works with objects in Multithreading.

        java.util package:          The java.util package provides the utility classes to deal with objects.

        Collection Framework:       Java collection framework works with objects only.
                                    All classes of the collection framework deal with objects only.
         */

        //---------------------- Autoboxing: Primitive to Wrapper

        //Converting int into Integer
        int a=20;
                                            /// IDEA: Unnecessary boxing 'Integer.valueOf(a)'
        Integer i=Integer.valueOf(a);   //converting int into Integer explicitly
        Integer j=a;                    //autoboxing, now compiler will write Integer.valueOf(a) internally
        Integer k=j;                    //autoboxing, now compiler will write Integer.valueOf(a) internally


        System.out.println(a +", "+i+", "+j+ ", " + k); //out:  20 20 20

        //---------------------- Unboxing: Wrapper to Primitive

        //Converting Integer to int
        Integer b=new Integer(3);     /// IDEA: Unnecessary boxing 'new Integer(3)'
                                            /// 'Integer(int)' is deprecated

        int x=b.intValue();             //converting Integer to int explicitly
        int y=b;                        //unboxing, now compiler will write a.intValue() internally



        //----------------------- will it be compiled
        //List<Object> someList = new ArrayList<String>();  // no
        Object[] arr =new String[10];                       // yes
        List<Object> someList = Collections.singletonList(new ArrayList<String>());

        //----------------------- how to create immutable object?
        /*
        Creating an Immutable Object: to create an immutable object you need to follow some simple rules:
                Don't add any setter method
                Declare all fields final and private
                If a field is a mutable object create defensive copies of it for getter methods
                If a mutable object passed to the constructor must be assigned to a field create a defensive copy of it
                Don't allow subclasses to override methods.
         */


    }
}
