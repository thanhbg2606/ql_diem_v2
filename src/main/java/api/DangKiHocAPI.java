package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.IDangKiHocService;
import service.IKiHocService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/xem-diem-thi"})
public class DangKiHocAPI extends HttpServlet {

    @Inject
    private IKiHocService kiHocService;

    @Inject
    private IDangKiHocService dangKiHocService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
    }
}
