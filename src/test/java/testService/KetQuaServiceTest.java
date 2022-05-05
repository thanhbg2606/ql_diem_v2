package testService;

import dao.IKetQuaDAO;
import dao.impl.KetQuaDAO;
import model.DangKiHoc;
import model.KetQua;
import model.MonHocDauDiem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.impl.KetQuaService;

import java.util.ArrayList;
import java.util.List;

public class KetQuaServiceTest {

    public static KetQuaService ketQuaService;
    public  static KetQuaDAO ketQuaDAO;

    public static DangKiHoc dkh;

    @BeforeAll
    public static void setup(){
        ketQuaDAO = new KetQuaDAO();
        ketQuaService = new KetQuaService();

        dkh = new DangKiHoc();
        dkh.setId(5);
    }

    //Khi dau diem va diem khong ton tai thi se tra ve lan luot đầu điểm = 0 và điểm = -1
    @Test
    public void formatListKetQua_TestDauDiemAndDiemNotExits(){
        List<KetQua> list = ketQuaService.findAllByDangKiHocOfSinhVien(dkh, ketQuaDAO);
        System.out.println("Size đầu vào:" + list.size());
        System.out.print("Tên đầu điểm \tĐầu điểm \tĐiểm\n");
        for (KetQua kq : list){
            System.out.print(kq.getDiemtp().getDauDiem().getTen()+"\t\t");
            System.out.print(kq.getDiemtp().getTitle()+"\t\t\t");
            System.out.print(kq.getDiem()+"\n");
        }

        List<KetQua> listKQ = ketQuaService.formatListKetQua(list);

        //Sau khi qua hàm format sẽ bổ sung đủ 5 loại đầu điểm
        Assertions.assertEquals(listKQ.size(), 5);


        //Thiếu thông tin đầu điểm thực hành và sẽ được gán % dau diem = 0
        Assertions.assertEquals(listKQ.get(2).getDiemtp().getTitle(), 0);

        // điểm sẽ được gán =-1.0;
        Assertions.assertEquals(listKQ.get(2).getDiem(), -1.0);
    }


    @Test
    public void findAllByDangKiHocOfSinhVien(){

        int Expected = 4;

        List<KetQua> list = ketQuaService.findAllByDangKiHocOfSinhVien(dkh, ketQuaDAO);
        Assertions.assertEquals(list.size(), Expected);
    }
}
