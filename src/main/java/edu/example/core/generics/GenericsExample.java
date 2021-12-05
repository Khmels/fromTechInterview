package edu.example.core.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GenericsExample {
    <T> T genericMethod(T param){
        return param;
    }

    private void someMethod(){
        genericMethod(1);               // T=Integer
        this.<Object>genericMethod(2);  // T=Object, синтаксис требует присутствие оператора
    }

    Supplier<String> supplier = new Supplier<String>() {
        @Override
        public String get() {
            return "from Java 9";
        }
    };

    public static void main(String[] args) {
        List<String> a = new ArrayList();    //тип непредсказуем
        List<?> b = new ArrayList<String>(); //тип неважен
        List<String> c = new ArrayList<>();  //тип очевиден

        var stringVar = "From Java 10";         //имеет тип String
        //from Java 12
//        int transformed = stringVar.(
//                (@NonNull final var s) -> s.hasHCode()
//        );
    }
}
