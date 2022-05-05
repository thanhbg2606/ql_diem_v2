package testDAO;

import dao.impl.KetQuaDAO;
import model.DangKiHoc;
import model.KetQua;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class KetQuaDAOTest {
    public static KetQuaDAO ketQuaDAO;
    @BeforeAll
    public static void setup(){
        ketQuaDAO = new KetQuaDAO();
    }


    //Phải viết hàm đếm số lượng kết quả theo id đăng kí học
    @Test
    @DisplayName("Test số lượng kết quả của list kết quả nhận được")
    public void findAllByDangKiHocOfSinhVien(){
        KetQua kqExpected = new KetQua();
        kqExpected.setId(1);

        DangKiHoc dkh = new DangKiHoc();
        dkh.setId(5);

        int Expected = 4;

        List<KetQua> ketQuaList = ketQuaDAO.findAllByDangKiHocOfSinhVien(dkh);

        Assertions.assertEquals(ketQuaList.size(), Expected);

    }

    //Cần viết hàm lấy kết quả đầu tiên
    @Test
    @DisplayName("Test kết quả đầu tiên của list kết quả nhận được")
    public void findAllByDangKiHocOfSinhVien_TestFirst(){
        KetQua kqExpected = new KetQua();
        kqExpected.setId(19);

        DangKiHoc dkh = new DangKiHoc();
        dkh.setId(5);


        List<KetQua> ketQuaList = ketQuaDAO.findAllByDangKiHocOfSinhVien(dkh);

        Assertions.assertEquals(ketQuaList.get(0).getId(), kqExpected.getId());

    }

    //Cần viết hàm lấy kết quả cuối cùng
    @Test
    @DisplayName("Test kết quả cuối cùng của list kết quả nhận được")
    public void findAllByDangKiHocOfSinhVien_TestFinal(){
        KetQua kqExpected = new KetQua();
        kqExpected.setId(22);

        DangKiHoc dkh = new DangKiHoc();
        dkh.setId(5);

        List<KetQua> ketQuaList = ketQuaDAO.findAllByDangKiHocOfSinhVien(dkh);
        Assertions.assertEquals(ketQuaList.get(ketQuaList.size()-1).getId(), kqExpected.getId());

    }

    @Test
    @DisplayName("Test kết quả trả về nếu không tồn tại")
    public void findAllByDangKiHocOfSinhVien_NotExits(){
        KetQua kqExpected = new KetQua();
        kqExpected.setId(1);

        DangKiHoc dkh = new DangKiHoc();
        dkh.setId(1000);


        List<KetQua> ketQuaList = ketQuaDAO.findAllByDangKiHocOfSinhVien(dkh);

        Assertions.assertEquals(new ArrayList<>(), ketQuaList);

    }

    @Test
    @DisplayName("Test kết quả trả về nếu DangKiHoc null")
    public void findAllByDangKiHocOfSinhVien_Null(){
        KetQua kqExpected = new KetQua();
        kqExpected.setId(1);

        DangKiHoc dkh = new DangKiHoc();


        List<KetQua> ketQuaList = ketQuaDAO.findAllByDangKiHocOfSinhVien(dkh);

        Assertions.assertEquals(new ArrayList<>(), ketQuaList);

    }




}
