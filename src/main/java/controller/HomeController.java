package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.SinhVien;
import service.ISinhVienService;
import untils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/dang-nhap", "/dang-xuat"})
public class HomeController extends HttpServlet {

    @Inject
    private ISinhVienService sinhVienService;

    Locale localeVi = new Locale("vi");
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message", localeVi);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equals("login")){
            String alert = req.getParameter("alert");
            String message = req.getParameter("message");
            if (message != null && alert != null) {
                req.setAttribute("message", resourceBundle.getString(message));
                req.setAttribute("alert", alert);
            }
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }
        else if(action != null && action.equals("logout")){
            SessionUtil.getInstance().removeValue(req, "sinhvien");
            resp.sendRedirect(req.getContextPath()+"/dang-nhap");
        }
        else {
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("login")) {
            String user = req.getParameter("username");
            String pass = req.getParameter("password");
            SinhVien sv = new SinhVien();
            sv.setUsername(user);
            sv.setPassword(pass);

            sv = sinhVienService.checkLogin(sv);
            if (sv != null) {
                SessionUtil.getInstance().putValue(req,"sinhvien", sv);
                resp.sendRedirect(req.getContextPath() + "/xem-bang-diem");
            } else {
                resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger");
            }
        }
    }
}
