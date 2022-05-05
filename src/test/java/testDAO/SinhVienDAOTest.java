package testDAO;

import dao.impl.SinhVienDAO;
import model.SinhVien;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SinhVienDAOTest {

    public static SinhVienDAO sinhVienDAO;
    @BeforeAll
    public static void setup(){
        sinhVienDAO = new SinhVienDAO();
    }

    @Test
    @DisplayName("CheckLogin nếu đúng sẽ trả ra thông tin sinh viên")
    public void TestCheckLogin_ThanhCong(){
        int expect = 1; //id của account sv
        SinhVien sv = new SinhVien();
        sv.setUsername("admin");
        sv.setPassword("admin");
        SinhVien res = sinhVienDAO.checkLogin(sv);
        Assertions.assertEquals(res.getId(), 1);
    }

    @Test
    @DisplayName("Không tồn tại tài khoản thì trả null")
    public void TestCheckLogin_NotExist(){
        SinhVien sv = new SinhVien();
        sv.setUsername("1");
        sv.setPassword("2");
        SinhVien res = sinhVienDAO.checkLogin(sv);
        Assertions.assertEquals(res, null);
    }

    @Test
    @DisplayName("Thiếu thông tin username hoặc password")
    public void TestCheckLogin_Null(){
        SinhVien sv = new SinhVien();
        sv.setUsername("10");
        sv.setPassword("");
        SinhVien res = sinhVienDAO.checkLogin(sv);
        Assertions.assertEquals(res, null);
    }
}
