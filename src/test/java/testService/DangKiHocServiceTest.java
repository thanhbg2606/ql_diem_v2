package testService;

import dao.impl.DangKiHocDAO;
import dao.impl.KetQuaDAO;
import dao.impl.SinhVienDAO;
import model.DangKiHoc;
import model.KiHoc;
import model.SinhVien;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.impl.DangKiHocService;

import java.util.List;

public class DangKiHocServiceTest {

    public static DangKiHocDAO dangKiHocDAO;
    public static DangKiHocService dangKiHocService;

    public static DangKiHoc dangKiHoc;

    public static SinhVien sv;

    public static KetQuaDAO ketQuaDAO;

    @BeforeAll
    public static void setup(){
        dangKiHocDAO = new DangKiHocDAO();
        dangKiHocService = new DangKiHocService();
        ketQuaDAO = new KetQuaDAO();

        dangKiHoc = new DangKiHoc();
        dangKiHoc.setId(5);

        sv = new SinhVien();
        sv.setId(1);
    }

    //Cần hàm đếm
    @Test
    public void findAllByKyHocOfSinhVien_TestSize(){
        KiHoc kh = new KiHoc();
        kh.setId(11);
        List<DangKiHoc> dangKiHocList = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv, dangKiHocDAO, ketQuaDAO);

        int expected = 5;
        Assertions.assertEquals(dangKiHocList.size(), expected);
    }

    //test những trường hợp ở biên 8.49 || 8.74
    @Test
    public void TinhToanDiemTBMon(){
        //Lấy bảng điểm trong db rồi tính tay, sau đó so với out
        KiHoc kh = new KiHoc();
        kh.setId(11);
        List<DangKiHoc> dangKiHocList = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv, dangKiHocDAO, ketQuaDAO);

        DangKiHoc dkh = dangKiHocList.get(0);

        dangKiHocService.TinhToanDiemTBMon(dkh);

        float expected = 8.8f;
        Assertions.assertEquals(dkh.getDiemTBM(), expected);

    }

    //Test từng cái thang xếp loại
    @Test
    public void XepHangDiem(){
        String expected = "A+";
        String res = dangKiHocService.XepHangDiem(9.0f);
        Assertions.assertEquals(expected, res);
    }

    //Môn học lại sẽ được loại khỏi danh sách tính điể
    //=> còn test xem loại đúng môn không
    @Test
    public void XuLyMonHocLai(){
        //Trong danh sách này có 1 môn học lại nên sau khi xử lý size giảm đi 1

        KiHoc kh = new KiHoc();
        kh.setId(11);
        //DS môn kỳ 1
        List<DangKiHoc> db1 = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv, dangKiHocDAO, ketQuaDAO);

        //DS môn kỳ 3
        KiHoc kh1 = new KiHoc();
        kh.setId(13);
        List<DangKiHoc> db2 = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv, dangKiHocDAO, ketQuaDAO);

        //Gộp 2 kỳ mà ở đó có môn học lại
        db1.addAll(db2);

        //Xử lý
        List<DangKiHoc> list = dangKiHocService.XuLyMonHocLai(db1);

        //Kiểm tra size
        Assertions.assertEquals(db1.size()-1, list.size());
    }

    //Môn không tính điểm sẽ bị loại khỏi danh sách tính điểm
    @Test
    public void XuLyMonKhongTinhDiem(){

        //Trong danh sách này có 1 môn không tính điểm
        KiHoc kh = new KiHoc();
        kh.setId(11);
        List<DangKiHoc> db = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv, dangKiHocDAO, ketQuaDAO);


        //Lọc môn học
        List<DangKiHoc> dangKiHocList1 = dangKiHocService.XuLyMonKhongTinhDiem(db);

        //Sau khi lọc sẽ mất 1 môn học
        Assertions.assertEquals(dangKiHocList1.size(), db.size()-1);

        //Môn học có idDangKiHoc = 12 là môn Thể dục -> không tính điểm
        //có thứ tự là 4 trong danh sách
        System.out.println(db.get(4).getId());
        DangKiHoc dkhTheduc = new DangKiHoc();
        dkhTheduc.setId(12);

        //Tìm xem còn môn thể dục trong ds không ?
        Assertions.assertTrue(
                !dangKiHocList1.contains(dkhTheduc.getId())
        );
    }
}
