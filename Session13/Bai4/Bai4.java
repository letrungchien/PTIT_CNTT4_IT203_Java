package Session13.Bai4;



import java.util.LinkedList;

public class Bai4 {

    static class EmergencyRoom {

        LinkedList<String> linkedList = new LinkedList<>();

        public boolean patientCheckIn(String name){
            return linkedList.add(name);
        }

        public void emergencyCheckIn(String name){
            linkedList.addFirst(name);
        }

        public void treatPatient(){
            if (linkedList.isEmpty()) {
                System.out.println("Không có bệnh nhân nào");
                return;
            }

            String patient = linkedList.removeFirst();
            System.out.println("Đang điều trị: " + patient);
        }
    }

    public static void main(String[] args) {

        EmergencyRoom em = new EmergencyRoom();
        em.patientCheckIn("A");
        em.patientCheckIn("B");
        em.emergencyCheckIn("C");

        em.treatPatient();
        em.treatPatient();
        em.treatPatient();
    }
}