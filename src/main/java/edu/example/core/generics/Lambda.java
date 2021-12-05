package edu.example.core.generics;

public class Lambda {
    void doLater(Runnable r){
        new Thread(()-> {
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){}
        }).start();
    }

    void main() {
        int i = 0;
        doLater(() -> {
            // Variable used in lambda expression should be final or effectively final
            // ошибка - к этому моменту переменная может быть 0, 1 или перестать существовать
            //i += 10;
        });
        i++;    //было бы здесь 11 иил 1 - неизвестно
    }

    void hack(){
        int[] i = {0};
        doLater(() ->{
            // теперь это компилируется, но поведение непредсказуемо
            i[0] +=10;
        });
        i[0]++;
    }

}
