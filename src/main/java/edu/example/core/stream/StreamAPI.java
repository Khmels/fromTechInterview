package edu.example.core.stream;

import java.util.ArrayList;
import java.util.Optional;

public class StreamAPI {
    public static void main(String[] args) {
        UserExamle u1 = new UserExamle(1L,"Tom", "T@gmail.com", 29, true);
        UserExamle u2 = new UserExamle(2L,"Sam", "S@gmail.com", 30, true);
        UserExamle u3 = new UserExamle(3L,"Bob", "B@gmail.com", 31, false);
        UserExamle u4 = new UserExamle(4L,"Nick", "N@gmail.com", 32, true);
        UserExamle u5 = new UserExamle(5L,"John", "J@gmail.com", 33, true);
        UserExamle u6 = new UserExamle(6L,"Will", "W@gmail.com", 34, true);
        UserExamle u7 = new UserExamle(7L,"Jack", "Ja@gmail.com", 33, true);

        ArrayList<UserExamle> listOfUsers = new ArrayList<>();
        listOfUsers.add(u1);
        listOfUsers.add(u2);
        listOfUsers.add(u3);
        listOfUsers.add(u4);
        listOfUsers.add(u5);
        listOfUsers.add(u6);
        listOfUsers.add(u7);

        Optional<UserExamle> userMax = listOfUsers
                .stream()
                .findFirst();

        if(userMax.isPresent()) {
            System.out.println("userMax = " + userMax.get().toString());
        }
        else{
            System.out.println("something went wrong");
        }

    }
}
