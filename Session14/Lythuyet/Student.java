package Session14.Lythuyet;

public class Student {
        int id;
        String name;
        String className;

        public Student(int id ,String name,String className){
                this.id=id;
                this.name=name;
                this.className=className;
        }
        public void print(){
                System.out.println(id);
                System.out.println(name);
                System.out.println(className);
        }

}
