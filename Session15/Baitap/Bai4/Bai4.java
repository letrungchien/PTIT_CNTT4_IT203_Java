package Session15.Baitap.Bai4;

import java.util.PriorityQueue;
import java.util.Comparator;

class EmergencyPatient {

    private String id;
    private String name;
    private int priority;
    private long arrivalOrder;

    public EmergencyPatient(String id, String name, int priority, long arrivalOrder) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.arrivalOrder = arrivalOrder;
    }

    public int getPriority() {
        return priority;
    }

    public long getArrivalOrder() {
        return arrivalOrder;
    }

    @Override
    public String toString() {
        String level = (priority == 1) ? "CẤP CỨU" : "THƯỜNG";
        return id + " - " + name + " - " + level;
    }
}

class EmergencyQueue {

    private PriorityQueue<EmergencyPatient> queue;
    private long counter = 0;

    public EmergencyQueue() {

        queue = new PriorityQueue<>(new Comparator<EmergencyPatient>() {
            @Override
            public int compare(EmergencyPatient p1, EmergencyPatient p2) {

                if (p1.getPriority() != p2.getPriority()) {
                    return Integer.compare(p1.getPriority(), p2.getPriority());
                }

                return Long.compare(p1.getArrivalOrder(), p2.getArrivalOrder());
            }
        });
    }

    public void addPatient(String id, String name, int priority) {
        counter++;
        EmergencyPatient patient =
                new EmergencyPatient(id, name, priority, counter);
        queue.offer(patient);
    }

    public EmergencyPatient callNextPatient() {
        return queue.poll();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Danh sách rỗng.");
        } else {
            for (EmergencyPatient p : queue) {
                System.out.println(p);
            }
        }
    }
}

public class Bai4 {

    public static void main(String[] args) {

        EmergencyQueue emergencyQueue = new EmergencyQueue();

        emergencyQueue.addPatient("P01", "Nguyễn Văn A", 2);
        emergencyQueue.addPatient("P02", "Trần Thị B", 1);
        emergencyQueue.addPatient("P03", "Lê Văn C", 2);
        emergencyQueue.addPatient("P04", "Phạm Thị D", 1);

        System.out.println("===== Thứ tự được khám =====");

        EmergencyPatient patient;
        while ((patient = emergencyQueue.callNextPatient()) != null) {
            System.out.println(patient);
        }
    }
}