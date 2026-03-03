package Mini;

import java.util.*;

/* =========================
   ENTITY: PET
   ========================= */
class Pet {
    private String id;
    private String name;
    private String species;
    private int age;
    private double price;

    public Pet(String id, String name, String species, int age, double price) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + species + " | " + age + " | " + price;
    }
}

/* =========================
   ENTITY: CUSTOMER
   ========================= */
class Customer {
    private String customerId;
    private String name;
    private String phone;
    private List<Pet> ownedPets = new ArrayList<>();

    public Customer(String customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    public String getCustomerId() { return customerId; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return customerId + " | " + name + " | " + phone;
    }
}

/* =========================
   GENERIC MANAGER
   ========================= */
class Manager<T> {
    protected List<T> list = new ArrayList<>();

    public void add(T obj) {
        list.add(obj);
    }

    public void remove(T obj) {
        list.remove(obj);
    }

    public void displayAll() {
        for (T obj : list) {
            System.out.println(obj);
        }
    }

    public List<T> getList() {
        return list;
    }
}

/* =========================
   PET MANAGER (List)
   ========================= */
class PetManager extends Manager<Pet> {

    public Pet findById(String id) {
        for (Pet p : list) {
            if (p.getId().equalsIgnoreCase(id))
                return p;
        }
        return null;
    }

    public boolean removeById(String id) {
        Iterator<Pet> it = list.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            if (p.getId().equalsIgnoreCase(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}

/* =========================
   CUSTOMER MANAGER (Map + Set)
   ========================= */
class CustomerManager {
    private Map<String, Customer> customerMap = new HashMap<>();
    private Set<String> phoneSet = new HashSet<>();

    public boolean addCustomer(Customer c) {
        if (customerMap.containsKey(c.getCustomerId()) ||
                phoneSet.contains(c.getPhone())) {
            return false;
        }
        customerMap.put(c.getCustomerId(), c);
        phoneSet.add(c.getPhone());
        return true;
    }

    public Customer findById(String id) {
        return customerMap.get(id);
    }

    public void displayAll() {
        for (Customer c : customerMap.values()) {
            System.out.println(c);
        }
    }
}

/* =========================
   SPA SERVICE (Queue)
   ========================= */
class SpaService {
    private Queue<Pet> spaQueue = new LinkedList<>();

    public void addToQueue(Pet p) {
        spaQueue.offer(p);
    }

    public void processNext() {
        if (spaQueue.isEmpty()) {
            System.out.println("Không có thú cưng nào đang chờ.");
        } else {
            System.out.println("Đang phục vụ: " + spaQueue.poll());
        }
    }

    public void displayQueue() {
        System.out.println("Danh sách chờ SPA:");
        for (Pet p : spaQueue) {
            System.out.println(p);
        }
    }
}

/* =========================
   ACTIVITY LOG (Stack)
   ========================= */
class ActivityLog {
    private Stack<String> logStack = new Stack<>();

    public void log(String action) {
        logStack.push(action);
    }

    public void undo() {
        if (logStack.isEmpty()) {
            System.out.println("Không có thao tác nào để undo.");
        } else {
            System.out.println("Undo: " + logStack.pop());
        }
    }

    public void displayLog() {
        System.out.println("=== Nhật ký ===");
        for (String s : logStack) {
            System.out.println(s);
        }
    }
}

/* =========================
   MAIN PROGRAM
   ========================= */
public class PetKingdomApp {

    static Scanner sc = new Scanner(System.in);
    static PetManager petManager = new PetManager();
    static CustomerManager customerManager = new CustomerManager();
    static SpaService spaService = new SpaService();
    static ActivityLog activityLog = new ActivityLog();

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addPet();
                case 2 -> displayPets();
                case 3 -> findPet();
                case 4 -> removePet();
                case 5 -> addCustomer();
                case 6 -> findCustomer();
                case 7 -> addToSpa();
                case 8 -> processSpa();
                case 9 -> activityLog.undo();
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (choice != 0);
    }

    static void menu() {
        System.out.println("\n=== PET KINGDOM ===");
        System.out.println("1. Thêm thú cưng");
        System.out.println("2. Hiển thị thú cưng");
        System.out.println("3. Tìm thú cưng theo ID");
        System.out.println("4. Xóa thú cưng");
        System.out.println("5. Đăng ký khách hàng");
        System.out.println("6. Tìm khách hàng");
        System.out.println("7. Thêm thú cưng vào SPA");
        System.out.println("8. Xử lý SPA");
        System.out.println("9. Undo thao tác gần nhất");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");
    }

    static void addPet() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Tên: ");
        String name = sc.nextLine();
        System.out.print("Loài: ");
        String species = sc.nextLine();
        System.out.print("Tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Giá: ");
        double price = Double.parseDouble(sc.nextLine());

        Pet p = new Pet(id, name, species, age, price);
        petManager.add(p);
        activityLog.log("Đã thêm thú cưng: " + id);
    }

    static void displayPets() {
        petManager.displayAll();
    }

    static void findPet() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        Pet p = petManager.findById(id);
        System.out.println(p != null ? p : "Không tìm thấy.");
    }

    static void removePet() {
        System.out.print("Nhập ID cần xóa: ");
        String id = sc.nextLine();
        if (petManager.removeById(id)) {
            activityLog.log("Đã xóa thú cưng: " + id);
            System.out.println("Xóa thành công.");
        } else {
            System.out.println("Không tìm thấy.");
        }
    }

    static void addCustomer() {
        System.out.print("Customer ID: ");
        String id = sc.nextLine();
        System.out.print("Tên: ");
        String name = sc.nextLine();
        System.out.print("SĐT: ");
        String phone = sc.nextLine();

        Customer c = new Customer(id, name, phone);
        if (customerManager.addCustomer(c)) {
            activityLog.log("Đã thêm khách hàng: " + id);
            System.out.println("Thêm thành công.");
        } else {
            System.out.println("Trùng ID hoặc SĐT.");
        }
    }

    static void findCustomer() {
        System.out.print("Nhập Customer ID: ");
        String id = sc.nextLine();
        Customer c = customerManager.findById(id);
        System.out.println(c != null ? c : "Không tìm thấy.");
    }

    static void addToSpa() {
        System.out.print("Nhập ID thú cưng: ");
        String id = sc.nextLine();
        Pet p = petManager.findById(id);
        if (p != null) {
            spaService.addToQueue(p);
            activityLog.log("Đã thêm vào SPA: " + id);
            System.out.println("Đã thêm vào hàng chờ.");
        } else {
            System.out.println("Không tìm thấy thú cưng.");
        }
    }

    static void processSpa() {
        spaService.processNext();
    }
}
