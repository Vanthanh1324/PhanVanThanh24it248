package Usingthreads;

import java.util.LinkedList;
import java.util.List;

public class Bai2Test {
    private final List<Integer> danhSach = new LinkedList<>(List.of(1, 2)); // Danh sách vé

    public synchronized void phatVe() {
        if (!danhSach.isEmpty()) { 
            int ve = danhSach.remove(0); 
            System.out.println(Thread.currentThread().getName() + " phát số vé: " + ve);
        } else {
            System.out.println(Thread.currentThread().getName() + " thông báo: Hết vé!");
        }
    }

    public static void main(String[] args) {
        Bai2Test nhaPhatVe = new Bai2Test();

        Thread nhanVien1 = new Thread(nhaPhatVe::phatVe, "Nhân viên 1");
        Thread nhanVien2 = new Thread(nhaPhatVe::phatVe, "Nhân viên 2");
        Thread nhanVien3 = new Thread(nhaPhatVe::phatVe, "Nhân viên 3");

        nhanVien1.start();
        nhanVien2.start();
        nhanVien3.start();
    }
}
