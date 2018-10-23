import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WorkWithList {

    @Test
    public void workWithLists() {
        List<String> students = new ArrayList<String>();

        org.junit.jupiter.api.Assertions.assertTrue(students.isEmpty());

//        if (!students.isEmpty()){
//        }


        students.add("Natalja");
        students.add("Max");
        students.add("Roman");
        students.add("Some strange guy");

        System.out.println(students.size());
        System.out.println(students.isEmpty());

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
}
