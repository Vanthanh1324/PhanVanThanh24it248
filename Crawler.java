package Crawler;
import java.io.FileInputStream;
import java.io.*;
import java.util.Scanner;

public class Crawler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "RealEstateData.csv";

        System.out.print("Bạn có muốn xóa dữ liệu cũ không? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            clearFile(fileName);
            System.out.println("Dữ liệu đã được xóa!");
        }

        int recordCount = countRecords(fileName);
        System.out.println("Số lượng bất động sản đã lưu: " + recordCount);

        try (FileOutputStream fos = new FileOutputStream(fileName, true)) {
            if (recordCount == 0) {
                String header = "STT,Tiêu đề,Giá,Diện tích,Địa chỉ,Số phòng,Liên hệ\n";
                fos.write(header.getBytes());
            }

            while (true) {
                System.out.println("Nhập thông tin bất động sản (hoặc nhập 'exit' để thoát):");

                System.out.print("Tiêu đề: ");
                String title = scanner.nextLine();
                if (title.equalsIgnoreCase("exit")) break;

                System.out.print("Giá: ");
                String price = scanner.nextLine();

                System.out.print("Diện tích: ");
                String area = scanner.nextLine();

                System.out.print("Địa chỉ: ");
                String address = scanner.nextLine();

                System.out.print("Số phòng: ");
                String rooms = scanner.nextLine();

                System.out.print("Liên hệ: ");
                String contact = scanner.nextLine();

                recordCount++;
                String data = recordCount + "," + title + "," + price + "," + area + "," + address + "," + rooms + "," + contact + "\n";
                fos.write(data.getBytes());
            }

            System.out.println("Tổng số bất động sản đã lưu: " + recordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n Danh sách bất động sản:");
        displayData(fileName);


        scanner.close();
    }

    private static void displayData(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    System.out.println("--------------------------------");
                    System.out.println(line);
                    System.out.println("--------------------------------");
                    isFirstLine = false;
                } else {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
	private static void clearFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
        } catch (IOException e) {
            System.out.println("Lỗi khi xóa file: " + e.getMessage());
        }
    }

    private static int countRecords(String fileName) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            return 0;
        }
        return count > 0 ? count - 1 : 0;
    }
}
