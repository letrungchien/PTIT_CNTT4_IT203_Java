package Session08;

import java.util.Scanner;

 class Student {
    // 1. Khai báo thuộc tính (Attributes)
    private String studentId;     // Mã SV
    private String studentName;   // Họ tên
    private int age;              // Tuổi
    private boolean sex;          // Giới tính
    private double mathScore;     // Toán
    private double physicsScore;  // Lý
    private double chemistryScore; // Hóa

    // Hai thuộc tính phụ (tự tính toán)
    private double avgScore;      // Điểm TB [FR6]
    private String rank;          // Xếp loại [FR6]

    // 2. Constructor
    public Student(String studentId, String studentName, int age, boolean sex, double mathScore, double physicsScore, double chemistryScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;

        //tính toán ngay khi khởi tạo
        setMathScore(mathScore);
        setPhysicsScore(physicsScore);
        setChemistryScore(chemistryScore);

        //Xếp loại + tính điểm trung bình
        classify();
        calculateAvgAndRank();
    }

    // 3. Các phương thức xử lý (Methods)
    //Xếp loại
    private void classify() {
        if (avgScore >= 8 && mathScore >= 6.5 && physicsScore >= 6.5 && chemistryScore >= 6.5) {
            rank = "Giỏi";
        } else if (avgScore >= 6.5 && mathScore >= 5 && physicsScore >= 5 && chemistryScore >= 5) {
            rank = "Khá";
        } else if (avgScore >= 5) {
            rank = "Trung bình";
        } else {
            rank = "Yếu";
        }
    }

    // [FR6] Tính điểm TB và Xếp loại
    public void calculateAvgAndRank() {
        this.avgScore = (mathScore + physicsScore + chemistryScore) / 3;
        classify();
    }

    // Getter & Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    //Set điểm toán
    public void setMathScore(double mathScore) {
        if (mathScore >= 0 && mathScore <= 10) {
            this.mathScore = mathScore;
        } else {
            System.out.println("Lỗi: Điểm Toán phải từ 0 đến 10!");
            this.mathScore = 0;
        }
    }

    // Setter cho điểm Lý
    public void setPhysicsScore(double physicsScore) {
        if (physicsScore >= 0 && physicsScore <= 10) {
            this.physicsScore = physicsScore;
        } else {
            System.out.println("Lỗi: Điểm Lý phải từ 0 đến 10!");
            this.physicsScore = 0;
        }
    }

    // Setter cho điểm Hóa
    public void setChemistryScore(double chemistryScore) {
        if (chemistryScore >= 0 && chemistryScore <= 10) {
            this.chemistryScore = chemistryScore;
        } else {
            System.out.println("Lỗi: Điểm Hóa phải từ 0 đến 10!");
            this.chemistryScore = 0;
        }
    }


    //get AvgScore
    public double getAvgScore() {
        return avgScore;
    }
    //getRank
    public String getRank() {
        return rank;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    public double getMathScore() {
        return mathScore;
    }

    public double getPhysicsScore() {
        return physicsScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Tên: %-15s | Tuổi: %d | GT: %s | Toán: %.1f | Lý: %.1f | Hóa: %.1f | TB: %.2f | Loại: %s",
                studentId, studentName, age, (sex ? "Nam" : "Nữ"),
                mathScore, physicsScore, chemistryScore, avgScore, rank);
    }
}

class StudentManager {
    // --- KHAI BÁO THUỘC TÍNH (Attributes) ---
    private Student[] students;       // Mảng chứa sinh viên
    private int currentCount;         // Biến đếm số lượng hiện tại
    private final int MAX_SIZE = 100; // Hằng số giới hạn mảng

    // --- CONSTRUCTOR ---
    public StudentManager() {
        this.students = new Student[MAX_SIZE];
        this.currentCount = 0;
    }


    // [FR1] Thêm sinh viên mới
    public boolean addStudent(Student s) {
        if (currentCount >= students.length) {
            System.out.println("Danh sách đã đầy");
            return false;
        }

        for (int i = 0; i < currentCount; i++) {
            if (students[i].getStudentId().equalsIgnoreCase(s.getStudentId())) {
                System.out.println("Mã sinh viên đã tồn tại");
                return false;
            }
        }

        students[currentCount++] = s;
        return true;
    }

    // [FR2] Hiển thị danh sách sinh viên
    public void displayAllStudents() {
        if (currentCount == 0) {
            System.out.println("Danh sách sinh viên đang trống!");
            return;
        }

        System.out.println("\n================= DANH SÁCH SINH VIÊN =================");
        System.out.printf("%-8s %-20s %-5s %-10s %-8s %-12s\n",
                "Mã SV", "Họ tên", "Tuổi", "Giới tính", "Điểm TB", "Xếp loại");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < currentCount; i++) {
            Student s = students[i];
            System.out.printf("%-8s %-20s %-5d %-10s %-8.2f %-12s\n",
                    s.getStudentId(),
                    s.getStudentName(),
                    s.getAge(),
                    (s.isSex() ? "Nam" : "Nữ"),
                    s.getAvgScore(),
                    s.getRank());
        }
    }

    // [FR3] Tìm kiếm sinh viên theo Mã
    public Student findById(String maSV) {
        for (int i = 0; i < currentCount; i++) {
            if (students[i].getStudentId().equalsIgnoreCase(maSV))
                return students[i];
        }
        return null;
    }

    // [FR3] Tìm kiếm sinh viên theo Tên
    public void findByName(String keyword) {
        boolean found = false;
        System.out.println("--- KẾT QUẢ TÌM THEO TÊN ---");

        for (int i = 0; i < currentCount; i++) {
            if (students[i].getStudentName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(students[i].toString());
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sinh viên nào có tên chứa: " + keyword);
    }

    // [FR4] Cập nhật thông tin sinh viên
    public boolean updateStudent(String id, Student newInfo) {
        for (int i = 0; i < currentCount; i++) {
            if (students[i] != null && students[i].getStudentId().trim().equalsIgnoreCase(id.trim())) {
                //Cập nhật thông tin mới
                students[i].setStudentName(newInfo.getStudentName());
                students[i].setAge(newInfo.getAge());
                students[i].setSex(newInfo.isSex());
                students[i].setMathScore(newInfo.getMathScore());
                students[i].setPhysicsScore(newInfo.getPhysicsScore());
                students[i].setChemistryScore(newInfo.getChemistryScore());

                //Tự tính lại điểm trung bình
                students[i].calculateAvgAndRank();

                return true;
            }
        }
        return false;
    }

    // [FR5] Xóa sinh viên
    public boolean deleteStudent(String maSV) {
        for (int i = 0; i < currentCount; i++) {
            if (students[i].getStudentId().equalsIgnoreCase(maSV)) {
                for (int j = i; j < currentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--currentCount] = null;
                return true;
            }
        }
        return false;
    }

    //[FR6]
    public void calculateAvgAndRankById(String maSV) {
        for (int i = 0; i < currentCount; i++) {
            if (students[i].getStudentId().equalsIgnoreCase(maSV)) {

                students[i].calculateAvgAndRank();

                System.out.println("Điểm trung bình: " + students[i].getAvgScore());
                System.out.println("Xếp loại: " + students[i].getRank());
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên!");
    }


    // [FR7] Sắp xếp theo Điểm TB giảm dần
    public void sortByAvgDesc() {
        for (int i = 0; i < currentCount - 1; i++) {
            for (int j = 0; j < currentCount - 1 - i; j++) {
                if (students[j].getAvgScore() < students[j + 1].getAvgScore()) {
                    // Hoán đổi
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp theo điểm trung bình giảm dần (Bubble Sort)!");
    }

    // [FR7] Sắp xếp theo Tên A-Z
    public void sortByName() {
        for (int i = 0; i < currentCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < currentCount; j++) {
                if (students[j].getStudentName()
                        .compareToIgnoreCase(students[minIndex].getStudentName()) < 0) {
                    minIndex = j;
                }
            }

            // Đổi chỗ nếu tìm được tên nhỏ hơn
            if (minIndex != i) {
                Student temp = students[i];
                students[i] = students[minIndex];
                students[minIndex] = temp;
            }
        }
        System.out.println("Đã sắp xếp theo tên A-Z (Selection Sort)!");
    }

    // [FR7] Hiển thị thông tin khi sắp xếp BẢNG TẠM
    public void showSortedRankTable() {
        if (currentCount == 0) {
            System.out.println("Danh sách trống!");
            return;
        }

        Student[] tempStudents = new Student[currentCount];
        for (int i = 0; i < currentCount; i++) {
            tempStudents[i] = students[i];
        }

        for (int i = 0; i < currentCount - 1; i++) {
            for (int j = 0; j < currentCount - 1 - i; j++) {
                if (tempStudents[j].getAvgScore() < tempStudents[j + 1].getAvgScore()) {
                    // Hoán đổi vị trí trong mảng TEMP
                    Student t = tempStudents[j];
                    tempStudents[j] = tempStudents[j + 1];
                    tempStudents[j + 1] = t;
                }
            }
        }

        System.out.println("\n=== BẢNG XẾP HẠNG (VIEW ONLY) ===");
        System.out.printf("%-10s %-20s %-10s %-15s\n", "Mã SV", "Họ và Tên", "Điểm TB", "Xếp Loại");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < currentCount; i++) {
            System.out.printf("%-10s %-20s %-10.2f %-15s\n",
                    tempStudents[i].getStudentId(),
                    tempStudents[i].getStudentName(),
                    tempStudents[i].getAvgScore(),
                    tempStudents[i].getRank());
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("(Lưu ý: Danh sách gốc vẫn giữ nguyên thứ tự nhập)");
    }

    // [FR8] Thống kê báo cáo
    public void showStatistics() {
        // Nếu chưa có sinh viên nào thì báo và thoát
        if (currentCount == 0) {
            System.out.println("Hiện tại chưa có sinh viên nào.");
            return;
        }

        // Biến đếm số lượng theo xếp loại
        int xuatSac = 0;
        int gioi    = 0;
        int kha     = 0;
        int trungBinh = 0;
        int yeu     = 0;

        // Theo dõi sinh viên điểm TB cao nhất / thấp nhất
        double maxTB = -1.0;
        Student svMax = null;

        double minTB = 11.0;   // lớn hơn điểm max để so sánh
        Student svMin = null;

        // Duyệt toàn bộ danh sách
        for (int i = 0; i < currentCount; i++) {
            Student s = students[i];
            if (s == null) continue;

            double tb = s.getAvgScore();     // lấy điểm TB
            String loai = s.getRank();       // lấy xếp loại

            // Cập nhật max / min
            if (tb > maxTB) {
                maxTB = tb;
                svMax = s;
            }
            if (tb < minTB) {
                minTB = tb;
                svMin = s;
            }

            // Đếm theo xếp loại
            if (loai.equals("Xuất sắc")) {
                xuatSac++;
            } else if (loai.equals("Giỏi")) {
                gioi++;
            } else if (loai.equals("Khá")) {
                kha++;
            } else if (loai.equals("Trung bình")) {
                trungBinh++;
            } else {
                yeu++;
            }
        }

        // In báo cáo thống kê
        System.out.println("\n===== BÁO CÁO THỐNG KÊ =====");
        System.out.println("Tổng số sinh viên: " + currentCount);
        System.out.println("Theo xếp loại:");
        System.out.println("  - Xuất sắc : " + xuatSac);
        System.out.println("  - Giỏi     : " + gioi);
        System.out.println("  - Khá      : " + kha);
        System.out.println("  - Trung bình : " + trungBinh);
        System.out.println("  - Yếu      : " + yeu);
        System.out.println("-----------------------------");

        // In sinh viên điểm cao nhất
        if (svMax != null) {
            System.out.println("Sinh viên điểm TB cao nhất:");
            System.out.println("  " + svMax.getStudentId() + " - " +
                    svMax.getStudentName() + " → TB: " + String.format("%.2f", maxTB));
        }

        // In sinh viên điểm thấp nhất
        if (svMin != null) {
            System.out.println("Sinh viên điểm TB thấp nhất:");
            System.out.println("  " + svMin.getStudentId() + " - " +
                    svMin.getStudentName() + " → TB: " +String.format("%.2f", minTB));
        }

        System.out.println("=============================");
    }
}
public class Mini_Project {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Mời bạn chọn chức năng (1-9): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: //THÊM SINH VIÊN MỚI
                    System.out.println("--- THÊM SINH VIÊN MỚI ---");
                    //Nhập thông tin Student
                    System.out.print("Nhập mã SV: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Giới tính (true: Nam, false: Nữ): ");
                    boolean sex = sc.nextBoolean();

                    double m = inputScore(sc, "Toán");
                    double p = inputScore(sc, "Lý");
                    double c = inputScore(sc, "Hóa");
                    sc.nextLine();

                    //Tạo đối tượng
                    Student newStudent = new Student(id, name, age, sex, m, p, c);
                    if (manager.addStudent(newStudent)) {
                        System.out.println("Thêm thành công!");
                    } else {
                        System.out.println("Thêm thất bại (Trùng mã hoặc đầy bộ nhớ)!");
                    }
                    break;

                case 2: //HIỂN THỊ THÔNG TIN SINH VIÊN
                    manager.displayAllStudents();
                    break;

                case 3: //TÌM KIẾM SINH VIÊN THEO MÃ | TÊN
                    System.out.println("--- TÌM KIẾM SINH VIÊN ---");
                    System.out.print("Nhập từ khóa (Mã SV hoặc Tên): ");
                    String keyword = sc.nextLine().trim();

                    Student foundById = manager.findById(keyword);

                    if (foundById != null) {
                        System.out.println("Tìm thấy sinh viên theo Mã ID:");
                        System.out.println(foundById.toString());
                    } else {
                        //Tìm sinh viên theo Name
                        manager.findByName(keyword);
                    }
                    break;

                case 4: //CẬP NHẬT THÔNG TIN
                    System.out.println("--- CẬP NHẬT THÔNG TIN ---");
                    //Nhập ID cần sửa
                    System.out.print("Nhập ID sinh viên cần sửa: ");
                    String idUpdate = sc.nextLine();
                    Student existingStudent = manager.findById(idUpdate);
                    if (existingStudent == null) {
                        System.out.println("Không tìm thấy ID!!");
                    } else {
                        //Nhập thông tin mới
                        System.out.print("Nhập Tên mới: ");
                        String newName = sc.nextLine();

                        System.out.print("Nhập Tuổi mới: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nhập Giới tính (true: Nam, false: Nữ): ");
                        boolean newSex = sc.nextBoolean();

                        //Nhập điểm toán lý hóa
                        double newMath = inputScore(sc, "Toán");
                        double newPhys = inputScore(sc, "Lý");
                        double newChem = inputScore(sc, "Hóa");
                        sc.nextLine();

                        Student newInfo = new Student(idUpdate, newName, newAge, newSex, newMath, newPhys, newChem);

                        boolean check = manager.updateStudent(idUpdate, newInfo);

                        if (check) {
                            System.out.println("Cập nhật thành công!");
                        } else {
                            System.out.println("Thất bại: Không tìm thấy mã SV này.");
                        }
                    }
                    break;

                case 5: //XÓA SINH VIÊN
                    System.out.print("Nhập mã SV cần xóa: ");
                    String idDelete = sc.nextLine();
                    if (manager.deleteStudent(idDelete))
                        System.out.println("Xóa sinh viên thành công!");
                    else
                        System.out.println("Không tìm thấy sinh viên!");
                    break;

                case 6:
                    System.out.print("Nhập mã sinh viên: ");
                    String maSV = sc.nextLine();

                    manager.calculateAvgAndRankById(maSV);
                    break;

                case 7:
                    System.out.println("\n--- TÙY CHỌN SẮP XẾP ---");
                    System.out.println("1. Xem Bảng xếp hạng theo Điểm TB (Giảm dần)");
                    System.out.println("2. Xem Danh sách theo Tên (A-Z)");
                    System.out.print("Bạn chọn (1 hoặc 2): ");

                    int sortChoice = 0;
                    if (sc.hasNextInt()) {
                        sortChoice = sc.nextInt();
                        sc.nextLine();
                    } else {
                        sc.nextLine();
                    }

                    if (sortChoice == 1) {
                        manager.showSortedRankTable();
                    } else if (sortChoice == 2) {
                        manager.sortByName();
                        manager.displayAllStudents();

                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;
                case 8:
                    System.out.println("\n=== THỐNG KÊ ===");
                    manager.showStatistics();
                    break;
                case 9:
                    System.out.println("Kết thúc chương trình!");
                    break;
                default:
                    System.out.println("Chức năng không tồn tại. Vui lòng chọn lại!");
            }
        } while (choice != 9);
    }

    private static void printMenu() {
        System.out.println("\n================ QUẢN LÝ SINH VIÊN ================");
        System.out.println("| 1. Thêm sinh viên mới                           |");
        System.out.println("| 2. Hiển thị tất cả sinh viên                    |");
        System.out.println("| 3. Tìm kiếm sinh viên                           |");
        System.out.println("| 4. Cập nhật thông tin sinh viên                 |");
        System.out.println("| 5. Xóa sinh viên                                |");
        System.out.println("| 6. Tính điểm trung bình và xếp loại (Tự động)   |");
        System.out.println("| 7. Sắp xếp sinh viên                            |");
        System.out.println("| 8. Thống kê                                     |");
        System.out.println("| 9. Thoát                                        |");
        System.out.println("===================================================");
    }

    private static double inputScore(Scanner sc, String subjectName) {
        double score;
        while (true) {
            System.out.print("Nhập điểm " + subjectName + " (0-10): ");
            score = sc.nextDouble();
            if (score >= 0 && score <= 10) {
                break;
            }
            System.out.println("Lỗi nhập điểm, điểm số môn từ 0-10!!");
        }
        return score;
    }

}
