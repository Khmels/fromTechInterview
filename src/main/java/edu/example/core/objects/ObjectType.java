package edu.example.core.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

        //---------------------- Autoboxing
        /*
        Autoboxing происходит:
            a1 При присвоении значения примитивного типа переменной соответствующего класса-обёртки.
            a2 При передаче примитивного типа в параметр метода, ожидающего соответствующий ему класс-обёртку.

         */

        //--До JDK5
        Integer iOb = new Integer(7);     //IDEA: Unnecessary boxing 'new Integer(7)'
                                                //IDEA: 'Integer(int)' is deprecated
        Double dOb = new Double(7.0);
        Character cOb = new Character('a');
        Boolean bOb = new Boolean(true);

        method(new Integer(7));  // a1

        //--После JDK5
        Integer iOb5 = 8;
        Double dOb5 = 7.0;
        Character cOb5 = 'a';
        Boolean bOb5 = true;

        method(8);                // a2

        //---------------------- Unboxing
        /*
        Unboxing происходит:
            При присвоении экземпляра класса-обёртки переменной соответствующего примитивного типа.
            В выражениях, в которых один или оба аргумента являются экземплярами классов-обёрток (кроме операции == и !=).
            При передаче объекта класса-обёртки в метод, ожидающий соответствующий примитивный тип.
         */

        //--- u1. При присвоении

        //--До JDK 5
        int iu = iOb.intValue();
        double du = dOb.doubleValue();
        char cu = cOb.charValue();
        boolean bu = bOb.booleanValue();

        //--Начиная с JDK 5
        int iu5 = iOb;
        double du5 = dOb;
        char cu5 = cOb;
        boolean bu5 = bOb;

        //--- u2. В выражениях

        // Так как арифметические операторы и операторы сравнения (исключение == и !=) применяются только к примитивным типам,
        // приходилось делать распаковку вручную, что заметно снижало читабельность выражений, делая их громоздкими, и кода в целом.
        Integer iOb1 = new Integer(5);
        Integer iOb2 = new Integer(7);
        System.out.println(iOb1.intValue() > iOb2.intValue());

        // Благодаря автораспаковке, мы смело можем писать выражения, не используя методы конвертации.
        // Теперь за этим следит компилятор Java.
        System.out.println(iOb1 > iOb2);
        System.out.println(iOb1 + iOb2);
        System.out.println("---------------------");

        // При сравнении классов-обёрток оператором == или !=,
        // происходит сравнение по ссылкам, а не по значениям и может возникнуть путаница.

        Integer iObCache1 = 100;
        Integer iObCache2 = 100;
        System.out.println(iObCache1 == iObCache2);     // true

        Integer iObCache3 = new Integer(120);
        Integer iObCache4 = new Integer(120);
        System.out.println(iObCache3 == iObCache4);     // false

        Integer iObCache5 = 200;
        Integer iObCache6 = 200;
        System.out.println(iObCache5 == iObCache6);     // false

        Integer iObCache7 = Integer.valueOf(200);   //The Integer class wraps a value of the primitive type int in an object.
        Integer iObCache8 = Integer.valueOf(200);
        System.out.println(iObCache7 == iObCache8);     // false

        Integer iObCache9 = Integer.valueOf(200);   //The Integer class wraps a value of the primitive type int in an object.
        Integer iObCache10 = Integer.valueOf(200);
        System.out.printf("iObCache9.equal(iObCache10): %s%n", iObCache5.equals(iObCache6));
        System.out.println("---------------------");

        /*
        В теретьем случае фактически вызывается статичный метод java.lang.Integer.valueOf(int),
        который сравнивает с значения integer cache от -128 до 127 (верхнюю границу можно изменять).

        IntegerCache инициализируется во время загрузки класса и при повторном использовании достает их из integer cache
        (набор инициализированных и готовых к использованию объектов).

        Во втором происходит явное создание объектов, следовательно они имеют разные ссылки.
        */

        //--- u3. При передачи в метод

        Integer iObMethod  = 10;
        method(iObMethod);

        methodPrimitive(iObMethod); // если есть и int, и Integer, то вызовется метод с Integer

        //! Так же следует помнить, что автоупаковка и автораспаковка не работает для массивов.

        Integer[] iObs = new Integer[] {5, 10, 50, 2, 7};
        methodArray(iObs); // Ошибка компиляции
        //IDEA: Change 1st parameter of method 'methodArray' from 'int...' to 'Integer[]'
        System.out.println("---------------------");

        //--- Плохая производительность

        // Классы-обертки неизменяемые, поэтому при каждой автоупаковке (за исключением значений из pool)
        // создается новый объект, что может привести к неразумному расходу памяти.
        System.out.println("sumBeforeInclusive(10) = " + sumBeforeInclusive(10));


        //----------------------- will it be compiled?
        //List<Object> someList = new ArrayList<String>();  // no
        Object[] arr =new String[10];                       // yes
        List<Object> someList = Collections.singletonList(new ArrayList<String>());
        System.out.println("---------------------");

        //----------------------- how to create immutable object?
        /*
        Creating an Immutable Object: to create an immutable object you need to follow some simple rules:
                Don't add any setter method
                Declare all fields final and private
                If a field is a mutable object create defensive copies of it for getter methods
                If a mutable object passed to the constructor must be assigned to a field create a defensive copy of it
                Don't allow subclasses to override methods.
         */

        //----------------------- отличие сокращенных и обычных операторов
        var varX= 2;
        varX += 0.5;
        // нет проблем, но значение не изменилось! (varX==2)
        System.out.println("varX = " + varX);

        // Required type: int  Provided: double
        //x = x + 0.5;

        // полная запись раскрывает проблему:
        // x - целое число, при downcasting - потеряется информация,
        // тип должен быть приведен явно
        x = (int) (x + 0.5);

        //----------------------- Лишает ли var строгой типизации?

        var fortyTwo = 42.0; // тип float или double? не самое лучшее применение var
        //fortyTwo = "42";    // контроль типов остается

        var map = new HashMap<String, List<String>>(); //запись короче, инфо остается
        var list = new ArrayList<>(); // скомпилирует, как ArrayList<Object>

        // не скомпилируется  - недостаточно информации
        //IDEA: Cannot infer type: 'var' on variable without initializer

            //var unknownType;

        //IDEA: Cannot infer type: variable initializer is 'null'

            //var anyNullableType = null;
    }

    private static void methodArray(Integer[] iObs) {
        System.out.println("Integer[]");
    }

    public static void methodArray(int ... i) {
        System.out.println("int[]");
    }

    public static void method(Integer iOb) {
        System.out.println("Integer:" + iOb);
    }

    public static void methodPrimitive(int i) {
        System.out.println("int");
    }

    public static void methodPrimitive(Integer iOb) { //Будет вызван данный метод
        System.out.println("Integer");
    }

    public static Integer sumBeforeInclusive(Integer number) {
        Integer iOb = number;
        if (number > 1) iOb += sumBeforeInclusive(number - 1);
        return iOb;
    }



}
