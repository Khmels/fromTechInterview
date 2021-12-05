package edu.example.core.inheritances;

public class NonInheritable {
    private NonInheritable() {}

    public static class SomeClass extends NonInheritable{}
}

class SubClass extends NonInheritable.SomeClass{
    // технически, это налседние NonInheritable. Ошибок нет
}
