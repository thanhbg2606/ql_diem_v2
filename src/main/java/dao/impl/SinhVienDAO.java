package dao.impl;

import dao.ISinhVienDAO;
import mapper.SinhVienMapper;
import model.SinhVien;

import java.util.List;

public class SinhVienDAO extends AbstractDAO<SinhVien> implements ISinhVienDAO  {
    @Override
    public SinhVien checkLogin(SinhVien sv) {
        String sql = "SELECT  idSinhVien, ten, maSV FROM tblsinhvien WHERE username = ? AND password = ?";
        List<SinhVien> sinhviens = query(sql, new SinhVienMapper(), sv.getUsername(), sv.getPassword());
        return sinhviens.isEmpty() ? null: sinhviens.get(0);
    }
}
