package edu.example.core.importVar;

import edu.example.core.objects.A;
import static edu.example.core.importVar.Letters.A;

public class Test {

    void test(){
        A letterVariable = new A();
        var enumElement = A;
    }
}

