package edu.example.core.loops;

public class Labels {
    public static void main(String[] args) {
        boolean flag = true;

        outerLoop:
        while (flag){
            for (;;){
                // переходим на следующий шаг внешнего цикла while
                if (flag) continue outerLoop;
            }
        }

        overNestedIfs:
        if (flag){
            if(flag){
                System.out.println();
            } else {
                if (flag) break overNestedIfs;
            }
        }

        someCodeSection:
        {
            boolean x = true;
            if (x) break someCodeSection;
            //недостижимо в случае x==true;
        }

        wholeIfElse:
        if (true) justIf: {
            // можно использовать только wholeIfElse и justIf
            break wholeIfElse;
        } else justElse: {
            // можно использовать только wholeIfElse и justElse
            break wholeIfElse;
        }
    }
}
