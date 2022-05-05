package testDAO;

import dao.impl.KiHocDAO;
import model.KiHoc;
import model.SinhVien;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KiHocDAOTest {

    public static KiHocDAO kiHocDAO;
    @BeforeAll
    public static void setup(){
        kiHocDAO = new KiHocDAO();
    }

    @Test
    @DisplayName("Lấy tất cả kỳ học đã đăng kí học của Sinh Viên")
    public void findAllOfSinhVien(){
        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(1);
        KiHoc kiHocTest = new KiHoc();
        kiHocTest.setId(12);

        List<KiHoc> listKH = kiHocDAO.findAllOfSinhVien(sinhVien);
        KiHoc kiHoc =listKH.get(1);
        Assertions.assertEquals(kiHocTest.getId(), kiHoc.getId());
        Assertions.assertEquals(listKH.size(), 3);
    }

    //Test giá trị lấy ra đầu tiên của list nhận được
    @Test
    @DisplayName("Test giá trị nhận được đầu tiên của list KiHoc")
    public void findAllOfSinhVien_testFirst(){
        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(1);
        KiHoc kiHocTest = new KiHoc();
        kiHocTest.setId(11);

        List<KiHoc> listKH = kiHocDAO.findAllOfSinhVien(sinhVien);
        KiHoc kiHoc =listKH.get(0);
        Assertions.assertEquals(kiHocTest.getId(), kiHoc.getId());
    }

    //Test giá trị lấy ra cuối cùng của list của list nhận được
    @Test
    @DisplayName("Test giá trị cuối cùng nhận được của list KiHoc")
    public void findAllOfSinhVien_testFinal(){
        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(1);
        KiHoc kiHocTest = new KiHoc();
        kiHocTest.setId(13);

        List<KiHoc> listKH = kiHocDAO.findAllOfSinhVien(sinhVien);
        KiHoc kiHoc =listKH.get(listKH.size()-1);
        Assertions.assertEquals(kiHocTest.getId(), kiHoc.getId());
    }


    @Test
    @DisplayName("Test lấy Học Kỳ theo năm học khi tồn tại")
    public void getKiHocByHocKiNamHoc(){
        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(1);

        KiHoc kiHocExpected = new KiHoc();
        kiHocExpected.setId(11);

        KiHoc kh = kiHocDAO.getKiHocByHocKiNamHoc(sinhVien, "1", "2018");
        Assertions.assertEquals(kiHocExpected.getId(), kh.getId());

    }

    @Test
    @DisplayName("Test lấy Học Kỳ theo năm học khi không tồn tại")
    public void getKiHocByHocKiNamHoc_NotExist(){
        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(1);


        KiHoc kh = kiHocDAO.getKiHocByHocKiNamHoc(sinhVien, "1", "2006");
        Assertions.assertEquals(null, kh);

    }


    //Không ảnh hưởng vì đã validate trước khi lấy dữ liệu
    @Test
    @DisplayName("Test lấy Học Kỳ theo năm học để trống")
    public void getKiHocByHocKiNamHoc_Null(){
        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(1);


        KiHoc kh = kiHocDAO.getKiHocByHocKiNamHoc(sinhVien, "1", "");
        Assertions.assertEquals(null, kh);

    }

}
