package qlthuvien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DSSach {
    ArrayList<Sach> bookList = new ArrayList<>();

    public DSSach() {

    }

    public DSSach(ArrayList<Sach> bookList) {
        this.bookList = bookList;
    }

    static Scanner scr = new Scanner(System.in);

    public void Run() throws IOException {
        String keyword;
        int chon;
        Menu menu = new Menu();
        do {
            chon = menu.Menu1();
            switch (chon) {
                case 1:
                    Them(bookList);
                    break;
                case 2:
                    Sua(bookList);
                    break;
                case 3:
                    Xoa(bookList);
                    break;
                case 4:
                    Hienthi(bookList);
                    break;
                case 5:
                    Tim(bookList);
                    break;
                case 6:
                    LuuFile();
                    System.exit(0);
            }
        } while (true);

    }

    public void Them(ArrayList<Sach> DSsach) {
        Sach sach = new Sach();
        sach.nhapsach();
        DSsach.add(sach);
    }

    public int tongsach(ArrayList<Sach> DSsach) {
        int tong = 0;
        for (Sach sach : DSsach) {
            tong += sach.getSoLuong();
        }
        return tong;
    }

    public void thongke(ArrayList<Sach> DSsach) {

        for (String loai : DSloai)
        {
            int tongloai = 0;
            for (Sach sach : DSsach)
            {
                if (loai.equalsIgnoreCase(sach.getLoaiSach())){
                    tongloai += sach.getSoLuong();
                }
            }
            System.out.printf(">> Loại sách ' %s ' có tất cả %d quyển\n",loai,tongloai);
        }
    }

    public void Hienthi1(Sach s) {
        System.out.printf("%-10s | %-30s | %-15s | %-15s | %-10s | %-10s\n", s.getMaSach(), s.getTenSach(), s.getLoaiSach(), s.getTenTg(), s.getNamXB(), s.getSoLuong());
    }

    public void Hienthi(ArrayList<Sach> DSSach) {
        System.out.printf("%-10s | %-30s | %-15s | %-15s | %-10s | %-10s\n", "__________", "______________________________", "_______________", "_______________", "__________", "__________");
        System.out.printf("%-10s | %-30s | %-15s | %-15s | %-10s | %-10s\n", "Mã Sách", "Tên Sách", "Loại sách", "Tác Giả", "NXB", "Số Lượng");
        System.out.printf("%-10s | %-30s | %-15s | %-15s | %-10s | %-10s\n", "__________", "______________________________", "_______________", "_______________", "__________", "__________");
        for (Sach sach : DSSach) {
            Hienthi1(sach);
        }
        System.out.printf("%-10s | %-30s | %-15s | %-15s | %-10s | %-10s\n", "__________", "______________________________", "_______________", "_______________", "__________", "__________");
        System.out.printf(">> Có tất cả %d loại sách có trong thư viện\n",demloaisach(DSSach));
        thongke(DSSach);
        System.out.println(">> Tổng tất cả sách có trong thư viện là: " + tongsach(DSSach));
    }

    public void Sua(ArrayList<Sach> DSsach) {
        Menu ht = new Menu();
        String keyword;
        do {
            System.out.print("Nhập tên sách/mã sách muốn sửa: ");
            keyword = scr.nextLine();
        } while (keyword.length() == 0);
        Sach sach = timDT(DSsach, keyword);
        if (sach == null) {
            System.out.println("Sách bạn muốn sửa không có trong thư viện");
        } else {
            while (true) {
                switch (ht.TTcansua()) {
                    case 1:
                        String msm;
                        boolean check1;
                        do {
                            check1 = true;
                            System.out.print("➤ Mã sách mới: ");
                            msm = scr.nextLine();
                            if (msm.equals(sach.getMaSach())) {
                                System.out.println("Mã sách cần thay đổi trùng với mã sách trước đó\nVui lòng nhập lại");
                                check1 = false;
                            } else {
                                System.out.println("Thay đổi thành công ✔️");
                            }
                        } while (msm.length() <= 0 | check1 == false);
                        sach.setMaSach(msm);
                        break;
                    case 2:
                        String newname;
                        boolean check2;
                        do {
                            check2 = true;
                            System.out.print("➤ Tên sách mới: ");
                            newname = scr.nextLine();
                            if (newname.equalsIgnoreCase(sach.getTenSach())) {
                                System.out.println("⚠️Tên sách cần thay đổi trùng với tên sách trước đó\nVui lòng nhập lại");
                                check2 = false;
                            } else {
                                System.out.println("Thay đổi thành công ✔️");
                            }
                        } while (newname.length() <= 0 | check2 == false);
                        sach.setTenSach(newname);
                        break;
                    case 3:
                        String newnameTG;
                        boolean check3;
                        do {
                            check3 = true;
                            System.out.print("➤ Tên tác giả mới: ");
                            newnameTG = scr.nextLine();
                            if (newnameTG.equalsIgnoreCase(sach.getTenTg())) {
                                System.out.println("⚠️Tên tác giả cần thay đổi trùng với tên tác giả trước đó\nVui lòng nhập lại");
                                check3 = false;
                            } else {
                                System.out.println("Thay đổi thành công ✔️");
                            }
                        } while (newnameTG.length() <= 0 | check3 == false);
                        sach.setTenTg(newnameTG);
                        break;
                    case 4:
                        int newNXB;
                        boolean check4;
                        do {
                            check4 = true;
                            System.out.print("➤ Năm xuất bản mới: ");
                            newNXB = scr.nextInt();
                            if (newNXB == sach.getNamXB()) {
                                System.out.println("⚠️Năm xuất bản cần thay đổi trùng với năm xuất bản trước đó\nVui lòng nhập lại");
                                check4 = false;
                            } else {
                                System.out.println("Thay đổi thành công ✔️");
                            }
                        } while (newNXB <= 1900 | check4 == false);
                        sach.setNamXB(newNXB);
                        break;
                    case 5:
                        int newSL;
                        boolean check5;
                        do {
                            check5 = true;
                            System.out.print("➤ Số lượng thay đổi: ");
                            newSL = scr.nextInt();
                            if (newSL == sach.getSoLuong()) {
                                System.out.println("⚠️Số lượng cần thay đổi trùng với số lượng trước đó\nVui lòng nhập lại");
                                check5 = false;
                            } else {
                                System.out.println("Thay đổi thành công ✔️");
                            }
                        } while (newSL <= 0 | check5 == false);
                        sach.setSoLuong(newSL);
                        break;
                    default:
                        System.out.println("⚠️Vui lòng thử lại");
                        break;
                }
                int i;
                System.out.println(">> Nhập 0 để thoát - 1 để tiếp tục sửa <<");
                i = scr.nextInt();
                if (i == 0) break;
            }
        }

    }

    public void Tim(ArrayList<Sach> DSsach) {
        boolean kt = false;
        System.out.print("Nhập mã sách/tên sách cần tìm: ");
        String ma = scr.nextLine();
        for (Sach s : DSsach) {
            if (ma.equalsIgnoreCase(s.getMaSach()) || s.getTenSach().toUpperCase().indexOf(ma.toUpperCase()) >= 0) {
                System.out.printf("%-10s | %-30s | %-15s | %-15s | %-10s | %-10s\n", "__________", "______________________________", "_______________", "_______________", "__________", "__________");
                System.out.printf("%-10s | %-30s | %-15s | %-15s | %-10s | %-10s\n", "Mã Sách", "Tên Sách", "Loại sách", "Tác Giả", "NXB", "Số Lượng");
                System.out.printf("%-10s | %-30s | %-15s | %-15s | %-10s | %-10s\n", "__________", "______________________________", "_______________", "_______________", "__________", "__________");
            }
        }
        for (Sach S : DSsach) {
            if (ma.equalsIgnoreCase(S.getMaSach()) || S.getTenSach().toUpperCase().indexOf(ma.toUpperCase()) >= 0) {
                kt = true;
                Hienthi1(S);
            }
        }
        System.out.printf("%-10s | %-30s | %-15s | %-15s | %-10s | %-10s\n", "__________", "______________________________", "_______________", "_______________", "__________", "__________");
        if (!kt) {
            System.out.println("⚠️Không có sách hoặc mã sách cần tìm");
        }
    }

    public Sach timDT(ArrayList<Sach> bookList, String keyword) {
        Sach ketqua = null;
        for (Sach S : bookList) {
            if (keyword.equalsIgnoreCase(S.getMaSach()) || S.getTenSach().toUpperCase().indexOf(keyword.toUpperCase()) >= 0) {
                ketqua = S;
            }
        }
        return ketqua;
    }

    public void Xoa(ArrayList<Sach> DSsach) {
        boolean kt = false;
        do {
            System.out.print("Nhập tên sách/mã sách muốn xoá: ");
            String keyword = scr.nextLine();
            for (int i = 0; i < DSsach.size(); i++) {
                if (DSsach.get(i).getMaSach().equalsIgnoreCase(keyword) || DSsach.get(i).getTenSach().toUpperCase().indexOf(keyword.toUpperCase()) >= 0) {
                    kt = true;
                    DSsach.remove(i);
                }
            }
            if (kt) {
                System.out.println("Xóa thành công ✔️");
            } else {
                System.out.printf("Không có sách có tên '%s' trong thư viện\n>> Vui lòng thử lại\n", keyword);
            }
        } while (!kt);

    }

    public void Docfile() {
        Ghifile sach = new Ghifile();
        bookList = sach.Docsach();
    }

    public void LuuFile() throws IOException {
        Ghifile sach = new Ghifile();
        sach.Ghisach(bookList);
    }
    ArrayList<String> DSloai = new ArrayList<>();
    public int demloaisach(ArrayList<Sach> DSSach) {
        int dem = 0;
        for (Sach s : DSSach) {
            if (!DSloai.contains(s.getLoaiSach())) {
                DSloai.add(s.getLoaiSach());
            }
        }
        for (String s : DSloai)
            dem += 1;
        return dem;
    }

}
