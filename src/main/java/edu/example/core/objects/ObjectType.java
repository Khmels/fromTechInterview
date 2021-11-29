package edu.example.core.objects;

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

        System.out.println(a+" "+i+" "+j);


    }
}
