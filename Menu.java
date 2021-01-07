package qlthuvien;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public int Menu1() { //  ╠   ╣   ╔   ╚   ║   ╗  ╝    ╦    ╩   ╬
        int cv = 0;
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                     QUẢN LÍ SÁCH CHO THƯ VIỆN TRƯỜNG ĐHSPKT HƯNG YÊN ®                   ║");
        System.out.println("╠═══════════════════════════╦════════════════════════════════════╦═════════════════════════╣");
        System.out.println("║     1. Thêm sách          ║       2. Sửa thông tin sách        ║      3. Xoá sách        ║");
        System.out.println("╠═══════════════════════════╬════════════════════════════════════╬═════════════════════════╣");
        System.out.println("║     4. Thống kê           ║       5. Tra cứu/Tìm kiếm          ║      6. Thoát           ║");
        System.out.println("╚═══════════════════════════╩════════════════════════════════════╩═════════════════════════╝");
        do {
            try{
                System.out.print("➤ ");
                cv = Integer.parseInt(sc.nextLine());}
            catch (Exception e){
                System.out.println("Kí tự nhập phải là số từ 1-6");
            }
        } while (cv < 1 || cv > 6);
        return cv;
    }

    public int TTcansua() {
        int cv;
        System.out.println("Chọn thông tin bạn muốn sửa*");
        System.out.println("1. Mã sách");
        System.out.println("2. Tên sách");
        System.out.println("3. Tác giả");
        System.out.println("4. Năm xuất bản");
        System.out.println("5. Số lượng");
        do {
            System.out.print("➤ ");
            cv = sc.nextInt();
        } while (cv < 1 || cv > 5);
        return  cv;
    }
}
