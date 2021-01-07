package qlthuvien;

import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tenSach;
    private String loaiSach;
    private String tenTg;
    private int namXB;
    private int soLuong;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String loaiSach, String tenTg, int namXB, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.tenTg = tenTg;
        this.namXB = namXB;
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public String getTenTg() {
        return tenTg;
    }

    public void setTenTg(String tenTg) {
        this.tenTg = tenTg;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int nhaXb) {
        this.namXB = namXB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void nhapsach() {
        Scanner scr = new Scanner(System.in);
        do {
            System.out.print("Mã sách: ");
            this.maSach = scr.nextLine();
        } while (maSach.length() <= 0);
        do {
            System.out.print("Tên sách: ");
            this.tenSach = scr.nextLine();
        } while (tenSach.length() <= 0);
        do {
            System.out.print("Loại sách: ");
            this.loaiSach = scr.nextLine();
        } while (loaiSach.length() <= 0);
        do {
            System.out.print("Tác giả: ");
            this.tenTg = scr.nextLine();
        } while (tenTg.length() <= 0);
        do {
            System.out.print("Năm xuất bản: ");
            this.namXB = scr.nextInt();
        } while (namXB <= 1000);
        do {
            System.out.print("Số Lượng: ");
            this.soLuong = scr.nextInt();
        } while (soLuong <= 0);

    }
    @Override
    public String toString() {
        return maSach + "#" + tenSach + "#" + loaiSach + "#" + tenTg + "#" + namXB + "#" + soLuong + "\n";
    }
}