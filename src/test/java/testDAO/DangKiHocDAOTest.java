package testDAO;

import dao.impl.DangKiHocDAO;
import model.DangKiHoc;
import model.KiHoc;
import model.SinhVien;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DangKiHocDAOTest {
    public static DangKiHocDAO dangKiHocDAO;
    @BeforeAll
    public static void setup(){
        dangKiHocDAO = new DangKiHocDAO();
    }

    //Cần hàm đếm trong database
    @Test
    @DisplayName("Test số lượng dangkihoc của list dangkihoc nhận được")
    public void findAllByKyHocOfSinhVien(){
        SinhVien sv = new SinhVien();
        sv.setId(1);
        KiHoc kh = new KiHoc();
        kh.setId(11);

        int expected = 5;
        List<DangKiHoc> list = dangKiHocDAO.findAllByKyHocOfSinhVien(kh, sv);

        Assertions.assertEquals(list.size(), expected);

    }

    //Cần hàm lấy giá trị dầu tiên
    @Test
    @DisplayName("Test số lượng dangkihoc của list dangkihoc nhận được")
    public void findAllByKyHocOfSinhVien_TestFirst(){
        SinhVien sv = new SinhVien();
        sv.setId(1);
        KiHoc kh = new KiHoc();
        kh.setId(11);

        DangKiHoc expected = new DangKiHoc();
        expected.setId(5);


        List<DangKiHoc> list = dangKiHocDAO.findAllByKyHocOfSinhVien(kh, sv);

        Assertions.assertEquals(list.get(0).getId(), expected.getId());

    }

    //Cần hàm lấy giá trị cuối cùng
    @Test
    @DisplayName("Test số lượng dangkihoc của list dangkihoc nhận được")
    public void findAllByKyHocOfSinhVien_TestFinal(){
        SinhVien sv = new SinhVien();
        sv.setId(1);
        KiHoc kh = new KiHoc();
        kh.setId(11);

        DangKiHoc expected = new DangKiHoc();
        expected.setId(12);


        List<DangKiHoc> list = dangKiHocDAO.findAllByKyHocOfSinhVien(kh, sv);

        Assertions.assertEquals(list.get(list.size()-1).getId(), expected.getId());

    }





    @Test
    @DisplayName("Test list dangkihoc nếu không tồn tại")
    public void findAllByKyHocOfSinhVien_NotExis(){
        SinhVien sv = new SinhVien();
        sv.setId(1);
        KiHoc kh = new KiHoc();
        kh.setId(5);

        List<DangKiHoc> list = dangKiHocDAO.findAllByKyHocOfSinhVien(kh, sv);

        Assertions.assertEquals(list.size(), 0);
    }

    @Test
    @DisplayName("Test list dangkihoc nếu kỳ học hoăc SV null")
    public void findAllByKyHocOfSinhVien_Null(){
        SinhVien sv = new SinhVien();
        KiHoc kh = new KiHoc();
        kh.setId(5);

        List<DangKiHoc> list = dangKiHocDAO.findAllByKyHocOfSinhVien(kh, sv);

        Assertions.assertEquals(list.size(), 0);
    }


}
