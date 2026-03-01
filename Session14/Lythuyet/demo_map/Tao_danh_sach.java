package Session14.Lythuyet.demo_map;

import Session14.Lythuyet.Student;

import java.util.HashMap;
import java.util.Map;

public class Tao_danh_sach {
    public static void main(String[] args) {
        Map<Integer, Student> list =new HashMap<>();
        list.put(1,new Student(3,"chien","cntt4"));

        for (Map.Entry<Integer,Student> entry :list.entrySet()){
            System.out.print(entry.getValue());
        }
    }
}
