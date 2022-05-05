package testService;

import dao.impl.DangKiHocDAO;
import dao.impl.KetQuaDAO;
import model.DangKiHoc;
import model.KiHoc;
import model.SinhVien;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.impl.DangKiHocService;
import service.impl.TinhToanBangDiem;

import java.util.List;

public class TinhToanBangDiemTest {

    public static TinhToanBangDiem tinhToanBangDiem;

    public static DangKiHocService dangKiHocService;

    public static DangKiHocDAO dangKiHocDAO;

    public static KetQuaDAO ketQuaDAO;

    public static SinhVien sv;

    public static DangKiHoc dkh;

    @BeforeAll
    public static void setup(){
        tinhToanBangDiem= new TinhToanBangDiem();
        dangKiHocService = new DangKiHocService();
        ketQuaDAO = new KetQuaDAO();
        dangKiHocDAO = new DangKiHocDAO();

        sv = new SinhVien();
        sv.setId(1);

        dkh = new DangKiHoc();
        dkh.setId(5);
    }

    //Cần hàm kiểm tra có môn nào học lại không hoặc không tính điểm
    @DisplayName("Trường hợp không ds không có môn nào học lại và tính điểm")
    @Test
    public void TinhToanTinChi_TestKhongNgoaiLe(){
        //Ki 2 năm 1 (2018) không có môn học lại và không tính điểm
        KiHoc kh = new KiHoc();
        kh.setId(12);

        List<DangKiHoc> database = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv, dangKiHocDAO, ketQuaDAO);

        //Tính toán điểm TB môn
        for (DangKiHoc dangKiHoc: database) {
            dangKiHocService.TinhToanDiemTBMon(dangKiHoc);
        }

        //check = true -> xử lý 1 kỳ -> sẽ không có môn học lại
        //check = false -> xử lý các kỳ khi tính tích lũy
        int  res = tinhToanBangDiem.TinhToanTinChi(database, true, dangKiHocService);

        int expected = 8;
        Assertions.assertEquals(res, expected);
    }

    //Cần hàm kiểm tra có môn nào học lại không hoặc không tính điểm
    @DisplayName("Trường hợp không ds có môn không tính điểm")
    @Test
    public void TinhToanTinChi_TestCase_MonKhongTinhDiem(){
        //Ki 1 năm 1  có môn giáo dục thể chất không tính điểm, các môn còn lại đều đạt.
        KiHoc kh = new KiHoc();
        kh.setId(11);

        List<DangKiHoc> database = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv, dangKiHocDAO, ketQuaDAO);

        //Đếm số tín chỉ (có cả môn không tính điểm)
        int expected = 0;
        for (DangKiHoc dangKiHoc : database) {
            expected += dangKiHoc.getMonHocKiHoc().getMh().getSoTC();
        }

        expected -= 2; //Môn giáo dục thể chất không tính tín chỉ có 2 tín

        //Xử lý
        //Tính toán điểm TB môn
        for (DangKiHoc dangKiHoc: database) {
            dangKiHocService.TinhToanDiemTBMon(dangKiHoc);
        }

        //check = true -> xử lý 1 kỳ -> sẽ không có môn học lại
        //check = false -> xử lý các kỳ khi tính tích lũy
        int  res = tinhToanBangDiem.TinhToanTinChi(database, true, dangKiHocService);

        Assertions.assertEquals(res, expected);
    }

    //Cần hàm kiểm tra có môn nào học lại không hoặc không tính điểm
    @DisplayName("Trường hợp ds  có môn nào học lại hoặc cải thiện")
    @Test
    public void TinhToanTinChi_TestTruongHopHocLaiHoacCaiThien(){
        SinhVien sv5 = new SinhVien();
        sv5.setId(5);

        //Ki 1 năm 1
        KiHoc kh1 = new KiHoc();
        kh1.setId(11);

        //Ki 3 năm 1 (2018) không có môn học lại và không tính điểm, có cải thiện 1 môn của kỳ 1
        KiHoc kh = new KiHoc();
        kh.setId(13);

        List<DangKiHoc> database = dangKiHocService.findAllByKyHocOfSinhVien(kh1, sv5, dangKiHocDAO, ketQuaDAO);

        List<DangKiHoc> database1 = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv5, dangKiHocDAO, ketQuaDAO);

        database.addAll(database1);

        //Đếm số tín chỉ (có cả môn cải thiện -> khi đó sẽ có môn học được cộng 2 lần số tín chỉ)
        int expected = 0;
        for (DangKiHoc dangKiHoc : database) {
            expected += dangKiHoc.getMonHocKiHoc().getMh().getSoTC();
        }

        //Môn bị trùng là đại số 1 có 3 tín và 1 môn thể dục 2 tín không tính
        expected -= 5;


        //Tính toán điểm TB môn
        for (DangKiHoc dangKiHoc: database) {
            dangKiHocService.TinhToanDiemTBMon(dangKiHoc);
        }

        //check = true -> xử lý 1 kỳ -> sẽ không có môn học lại
        //check = false -> xử lý các kỳ khi tính tích lũy
        int  res = tinhToanBangDiem.TinhToanTinChi(database, false, dangKiHocService);


        Assertions.assertEquals(expected, res);
    }

    @DisplayName("Trường hợp  ds  có môn học trượt")
    @Test
    public void TinhToanTinChi_TestTruongHopCoMonTruot(){

        SinhVien sv5 = new SinhVien();
        sv5.setId(5);

        //Ki 2 năm 1 - > có 1 môn bị trượt
        KiHoc kh1 = new KiHoc();
        kh1.setId(12);


        List<DangKiHoc> database = dangKiHocService.findAllByKyHocOfSinhVien(kh1, sv5, dangKiHocDAO, ketQuaDAO);

        //Đếm số tín chỉ (cả môn trượt)
        int expected = 0;
        for (DangKiHoc dangKiHoc : database) {
            expected += dangKiHoc.getMonHocKiHoc().getMh().getSoTC();
        }

        //Môn bị truot có 3 tin
        expected -= 3;


        //Tính toán điểm TB môn
        for (DangKiHoc dangKiHoc: database) {
            dangKiHocService.TinhToanDiemTBMon(dangKiHoc);
        }

        //check = true -> xử lý 1 kỳ -> sẽ không có môn học lại
        //check = false -> xử lý các kỳ khi tính tích lũy
        int  res = tinhToanBangDiem.TinhToanTinChi(database, true, dangKiHocService);

        Assertions.assertEquals(res, expected);
    }

    @DisplayName("Trường hợp không ds không có môn nào học lại và tính điểm")
    @Test
    public void DiemTBKyHoc_TestKhongNgoaiLe(){
        //Ki 2 năm 1 - >  không có 1 môn bị trượt và không tính điểm
        KiHoc kh1 = new KiHoc();
        kh1.setId(12);

        List<DangKiHoc> database = dangKiHocService.findAllByKyHocOfSinhVien(kh1, sv, dangKiHocDAO, ketQuaDAO);

        //Tính toán điểm TB môn
        for (DangKiHoc dangKiHoc: database) {
            dangKiHocService.TinhToanDiemTBMon(dangKiHoc);
        }

        float expected = 1.94f;



        //check = true -> xử lý 1 kỳ -> sẽ không có môn học lại
        //check = false -> xử lý các kỳ khi tính tích lũy
        float res = tinhToanBangDiem.DiemTBKyHoc(database, true, dangKiHocService);

        Assertions.assertEquals(expected, res);

    }

    @DisplayName("Trường hợp không ds có môn không tính điểm")
    @Test
    public void DiemTBKyHoc_TestCase_CoMonKhongTinhDiem(){
        SinhVien sv5 = new SinhVien();
        sv5.setId(5);

        //Ki 2 năm 1 - >  không có 1 môn không tính vào tích lũy(The duc)
        KiHoc kh1 = new KiHoc();
        kh1.setId(11);

        List<DangKiHoc> database = dangKiHocService.findAllByKyHocOfSinhVien(kh1, sv5, dangKiHocDAO, ketQuaDAO);

        //Tính toán điểm TB môn
        for (DangKiHoc dangKiHoc: database) {
            dangKiHocService.TinhToanDiemTBMon(dangKiHoc);
        }

        //Tinh toan thủ công
        float expected = 1.00f;

        //check = true -> xử lý 1 kỳ -> sẽ không có môn học lại
        //check = false -> xử lý các kỳ khi tính tích lũy
        float res = tinhToanBangDiem.DiemTBKyHoc(database, true, dangKiHocService);

        Assertions.assertEquals(expected, res);

    }

    @DisplayName("Trường hợp ds  có môn nào học lại hoặc cải thiện")
    @Test
    public void DiemTBKyHoc_TestTruongHopHocLaiHoacCaiThien(){
        SinhVien sv5 = new SinhVien();
        sv5.setId(5);

        //Ki 1 năm 1
        KiHoc kh1 = new KiHoc();
        kh1.setId(11);

        //Ki 3 năm 1 (2018) không có môn học lại và không tính điểm, có cải thiện 1 môn của kỳ 1
        KiHoc kh = new KiHoc();
        kh.setId(13);

        List<DangKiHoc> database = dangKiHocService.findAllByKyHocOfSinhVien(kh1, sv5, dangKiHocDAO, ketQuaDAO);

        List<DangKiHoc> database1 = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv5, dangKiHocDAO, ketQuaDAO);

        database.addAll(database1);


        //Test Ky 3 và Ki 1 đều chỉ có 1 môn học, lấy kết quả của kỳ có điểm cao hơn
        float expected = 3.7f;


        //Tính toán điểm TB môn
        for (DangKiHoc dangKiHoc: database) {
            dangKiHocService.TinhToanDiemTBMon(dangKiHoc);
        }

        //check = true -> xử lý 1 kỳ -> sẽ không có môn học lại
        //check = false -> xử lý các kỳ khi tính tích lũy
        float res = tinhToanBangDiem.DiemTBKyHoc(database, false, dangKiHocService);


        Assertions.assertEquals(expected, res);
    }

    @DisplayName("Trường hợp  ds  có môn học trượt")
    @Test
    public void DiemTBKyHoc_TestTruongHopCoMonTruot(){
        SinhVien sv5 = new SinhVien();
        sv5.setId(5);

        //Ki 2 năm 1 có 1 môn trượt
        KiHoc kh1 = new KiHoc();
        kh1.setId(12);

        //Ki 3 năm 1 (2018) không có môn học lại và không tính điểm
        KiHoc kh = new KiHoc();
        kh.setId(13);

        List<DangKiHoc> database = dangKiHocService.findAllByKyHocOfSinhVien(kh1, sv5, dangKiHocDAO, ketQuaDAO);

        List<DangKiHoc> database1 = dangKiHocService.findAllByKyHocOfSinhVien(kh, sv5, dangKiHocDAO, ketQuaDAO);

        database.addAll(database1);


        //Test Ky 3 và Ki 2 đều chỉ có 1 môn học.
        float expected = 1.85f;


        //Tính toán điểm TB môn
        for (DangKiHoc dangKiHoc: database) {
            dangKiHocService.TinhToanDiemTBMon(dangKiHoc);
        }

        //check = true -> xử lý 1 kỳ -> sẽ không có môn học lại
        //check = false -> xử lý các kỳ khi tính tích lũy
        float res = tinhToanBangDiem.DiemTBKyHoc(database, false, dangKiHocService);


        Assertions.assertEquals(expected, res);
    }
}
