package controller;

import model.DangKiHoc;
import model.KiHoc;
import model.SinhVien;
import model.WrapperDangKiHoc;
import service.IDangKiHocService;
import service.IKiHocService;
import service.IWrapperDangKiHocService;
import untils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;


@WebServlet(urlPatterns = {"/xem-bang-diem"})
public class XemBangDiemController extends HttpServlet {

    @Inject
    private IDangKiHocService dangKiHocService;

    @Inject
    private IKiHocService kiHocService;

    @Inject
    private IWrapperDangKiHocService wrapperDangKiHocService;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param  = req.getParameter("hocky");
        String action = req.getParameter("search");

        List<WrapperDangKiHoc> wrapperDangKiHocs = null;

        SinhVien svCurrent = (SinhVien) SessionUtil.getInstance().getValue(req, "sinhvien");

        if(action != null && action.equals("Xem")){
            if(param != null  && param.trim().length() == 5) {
                //20221
                String namHoc = param.substring(0, 4);
                String hocKy = param.substring(4, 5);
                KiHoc kh =  kiHocService.getKiHocByHocKiNamHoc(svCurrent, hocKy, namHoc);
                if(kh != null) {
                    wrapperDangKiHocs = wrapperDangKiHocService.getAllDangKiHocSapXepTheoKi(
                            svCurrent, kh);

                }
                else{
                    wrapperDangKiHocs = null;
                    req.setAttribute("message", resourceBundle.getString("not_found"));
                }

            } else {

            }

        }
        else{
            wrapperDangKiHocs = wrapperDangKiHocService.getAllDangKiHocSapXepTheoKi(svCurrent, null);
        }

        req.setAttribute("wrapperDangKiHocs", wrapperDangKiHocs);
        RequestDispatcher rd = req.getRequestDispatcher("/views/xembangdiem.jsp");
        rd.forward(req, resp);
    }
}
