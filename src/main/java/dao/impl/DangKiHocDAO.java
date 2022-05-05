package dao.impl;

import dao.IDangKiHocDAO;
import mapper.DangKiHocMapper;
import model.DangKiHoc;
import model.KiHoc;
import model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class DangKiHocDAO extends AbstractDAO<DangKiHoc> implements IDangKiHocDAO {
    @Override
    public List<DangKiHoc> findAllByKyHocOfSinhVien(KiHoc kh, SinhVien sv) {
        String sql = "SELECT * FROM viewDangKiHoc WHERE idSinhVien = ? AND idKiHoc = ?";
        return query(sql, new DangKiHocMapper(), sv.getId(), kh.getId());
    }
}
