package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.SinhVien;
import service.ISinhVienService;
import untils.HttpUtil;
import untils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/sinh-vien"})
public class SinhVienAPI extends HttpServlet {

    @Inject
    private ISinhVienService sinhVienService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        SinhVien sv = HttpUtil.of(req.getReader()).toModel(SinhVien.class);
        sv = sinhVienService.checkLogin(sv);
        mapper.writeValue(resp.getOutputStream(), sv);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
