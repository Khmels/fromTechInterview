package edu.example.core.overriding;

public class Overrriding {
    // сигнатуры foo в порядке убывания приоритета
    void foo (long a, Object b) {}       //фаза 1: только upcasting по обоим параметрам
    void foo (Integer a, Object b) {}    //фаза 2: для первого параметра понадобиться boxing
    void foo (int a, Object... b) {}     //фаза 3: vararg
    void foo (long a, Object... b) {}    //фаза 4: vararg, но метод менее специфичный - long шире, чем int

    void bar (Integer a, int b) {}
    void bar (Integer a, Object b) {}

    void baz (Object a, Long b) {}

    void test() {
        foo((int)42, "Это будет Object"); // эти параметры удовлетворяют всем трем фазам, используется первая
        //bar(1,2);       //оба метода из фазы 2 (нужен боксинг для первого аргумента), int не подтип Object
        //baz(1, 2);// int -> Integer -> Object работает, int -> long -> Long не работает
    }
}
