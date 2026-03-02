package Session15.Baitap.Bai6;

import java.util.*;

class Patient {
    String id;
    String name;
    int age;
    String gender;

    public Patient(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + age + " - " + gender;
    }
}

class PatientWaitingQueue {
    Queue<Patient> waitingQueue = new LinkedList<>();
    int totalPatients = 0;

    public void addPatient(Patient p) {
        waitingQueue.offer(p);
        totalPatients++;
    }

    public Patient callNext() {
        if (!waitingQueue.isEmpty()) {
            totalPatients--;
            return waitingQueue.poll();
        }
        return null;
    }
}

class EditAction {
    String description;
    String editedBy;
    String editTime;

    public EditAction(String description, String editedBy, String editTime) {
        this.description = description;
        this.editedBy = editedBy;
        this.editTime = editTime;
    }

    @Override
    public String toString() {
        return editTime + " - " + editedBy + ": " + description;
    }
}

class MedicalRecordHistory {
    Stack<EditAction> editStack = new Stack<>();
    String recordId;

    public MedicalRecordHistory(String recordId) {
        this.recordId = recordId;
    }

    public void addEdit(EditAction action) {
        editStack.push(action);
    }

    public EditAction undoEdit() {
        if (!editStack.isEmpty()) {
            return editStack.pop();
        }
        return null;
    }
}

class Ticket {
    int ticketNumber;
    String issuedTime;

    public Ticket(int ticketNumber, String issuedTime) {
        this.ticketNumber = ticketNumber;
        this.issuedTime = issuedTime;
    }

    @Override
    public String toString() {
        return "Số: " + ticketNumber + " - " + issuedTime;
    }
}

class TicketSystem {
    Queue<Ticket> ticketQueue = new LinkedList<>();
    int currentNumber = 0;

    public void issueTicket(String time) {
        currentNumber++;
        ticketQueue.offer(new Ticket(currentNumber, time));
    }

    public Ticket callNext() {
        return ticketQueue.poll();
    }
}

class InputAction {
    String fieldName;
    String oldValue;
    String newValue;
    String actionTime;

    public InputAction(String fieldName, String oldValue, String newValue, String actionTime) {
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.actionTime = actionTime;
    }

    @Override
    public String toString() {
        return actionTime + " | " + fieldName + ": " + oldValue + " -> " + newValue;
    }
}

class UndoManager {
    Stack<InputAction> undoStack = new Stack<>();
    int maxUndoSteps;

    public UndoManager(int maxUndoSteps) {
        this.maxUndoSteps = maxUndoSteps;
    }

    public void addAction(InputAction action) {
        if (undoStack.size() >= maxUndoSteps) {
            undoStack.remove(0);
        }
        undoStack.push(action);
    }

    public InputAction undo() {
        if (!undoStack.isEmpty()) {
            return undoStack.pop();
        }
        return null;
    }
}

public class Bai6 {
    public static void main(String[] args) {

        System.out.println("===== BỆNH NHÂN CHỜ KHÁM =====");
        PatientWaitingQueue waitingQueue = new PatientWaitingQueue();

        waitingQueue.addPatient(new Patient("P01", "Nguyễn Văn A", 30, "Nam"));
        waitingQueue.addPatient(new Patient("P02", "Trần Thị B", 25, "Nữ"));

        System.out.println("Gọi khám: " + waitingQueue.callNext());
        System.out.println("Gọi khám: " + waitingQueue.callNext());

        System.out.println("\n===== LỊCH SỬ BỆNH ÁN =====");
        MedicalRecordHistory history = new MedicalRecordHistory("R001");

        history.addEdit(new EditAction("Thêm chẩn đoán", "BS Minh", "08:00"));
        history.addEdit(new EditAction("Cập nhật thuốc", "BS Lan", "08:10"));

        System.out.println("Undo chỉnh sửa: " + history.undoEdit());

        System.out.println("\n===== HỆ THỐNG GỌI SỐ =====");
        TicketSystem ticketSystem = new TicketSystem();

        ticketSystem.issueTicket("08:00");
        ticketSystem.issueTicket("08:01");

        System.out.println("Đang gọi: " + ticketSystem.callNext());
        System.out.println("Đang gọi: " + ticketSystem.callNext());

        System.out.println("\n===== UNDO NHẬP LIỆU =====");
        UndoManager undoManager = new UndoManager(5);

        undoManager.addAction(new InputAction("Họ tên", "Nguyễn A", "Nguyễn Văn A", "08:20"));
        undoManager.addAction(new InputAction("Tuổi", "29", "30", "08:21"));

        System.out.println("Hoàn tác: " + undoManager.undo());
        System.out.println("Hoàn tác: " + undoManager.undo());
    }
}