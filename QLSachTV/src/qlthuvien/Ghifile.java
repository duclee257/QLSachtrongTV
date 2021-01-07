package qlthuvien;

import java.io.*;
import java.util.ArrayList;

public class Ghifile {
    public void Ghisach(ArrayList<Sach> DSsach) throws IOException{
        File file = new File("sach.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for (Sach sach : DSsach)
        {
            fileOutputStream.write(sach.toString().getBytes());
        }
    }
    public ArrayList<Sach> Docsach(){
        ArrayList<Sach> DSsach = new ArrayList<>();
        try
        {
            File file = new File("sach.txt");
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                //maSach + "#" + tenSach + "#"+ loaiSach + "#"  + tenTg + "#" + nhaXb + "#" + soLuong + "\n"
                String maSach = line.split("#")[0];
                String ten = line.split("#")[1];
                String loai = line.split("#")[2];
                String tacgia = line.split("#")[3];
                int nxb = Integer.parseInt(line.split("#")[4]);
                int soluong = Integer.parseInt(line.split("#")[5]);
                Sach sach = new Sach(maSach,ten,loai,tacgia,nxb,soluong);
                DSsach.add(sach);
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return DSsach;
    }
}
