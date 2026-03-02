package Session15.Baitap.Bai5;

import java.util.*;

class TreatmentStep {
    private String description;
    private String time;

    public TreatmentStep(String description, String time) {
        this.description = description;
        this.time = time;
    }

    @Override
    public String toString() {
        return time + " - " + description;
    }
}

class Patient {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Tuổi: " + age;
    }
}

class EmergencyCase {
    private Patient patient;
    private Stack<TreatmentStep> steps;

    public EmergencyCase(Patient patient) {
        this.patient = patient;
        this.steps = new Stack<>();
    }

    public void addStep(TreatmentStep step) {
        steps.push(step);
        System.out.println(" Thêm bước: " + step);
    }

    public TreatmentStep undoStep() {
        if (!steps.isEmpty()) {
            TreatmentStep removed = steps.pop();
            System.out.println("↩ Undo bước: " + removed);
            return removed;
        }
        System.out.println(" Không có bước để undo!");
        return null;
    }

    public void displaySteps() {
        System.out.println("Các bước xử lý:");
        for (TreatmentStep step : steps) {
            System.out.println(step);
        }
    }

    public Patient getPatient() {
        return patient;
    }
}

class EmergencyCaseQueue {
    private Queue<EmergencyCase> cases = new LinkedList<>();

    public void addCase(EmergencyCase c) {
        cases.offer(c);
        System.out.println("Thêm vào hàng chờ: " + c.getPatient());
    }

    public EmergencyCase getNextCase() {
        if (!cases.isEmpty()) {
            EmergencyCase next = cases.poll();
            System.out.println(" Đang xử lý: " + next.getPatient());
            return next;
        }
        System.out.println(" Không còn bệnh nhân!");
        return null;
    }
}

public class Bai5 {
    public static void main(String[] args) {

        EmergencyCaseQueue queue = new EmergencyCaseQueue();

        EmergencyCase case1 = new EmergencyCase(
                new Patient("Nguyễn Văn A", 30));
        EmergencyCase case2 = new EmergencyCase(
                new Patient("Trần Thị B", 25));


        queue.addCase(case1);
        queue.addCase(case2);

        EmergencyCase current = queue.getNextCase();
        if (current != null) {
            current.addStep(new TreatmentStep("Tiếp nhận", "08:00"));
            current.addStep(new TreatmentStep("Chẩn đoán", "08:05"));
            current.addStep(new TreatmentStep("Điều trị", "08:10"));

            current.displaySteps();


            current.undoStep();

            current.displaySteps();
        }
    }
}
