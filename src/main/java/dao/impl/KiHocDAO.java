package dao.impl;

import dao.IKiHocDAO;
import mapper.KiHocMapper;
import model.KiHoc;
import model.SinhVien;

import java.util.List;

public class KiHocDAO extends AbstractDAO<KiHoc> implements IKiHocDAO  {
    @Override
    public List<KiHoc> findAllOfSinhVien(SinhVien sv) {
        String sql = "SELECT DISTINCT idKiHoc FROM viewDangKiHoc WHERE idSinhVien = ? ";
        return query(sql, new KiHocMapper(), sv.getId());
    }

    @Override
    public KiHoc getKiHocByHocKiNamHoc(SinhVien sv, String hocKy, String namHoc) {
        String sql = "SELECT DISTINCT idKiHoc FROM viewDangKiHoc WHERE idSinhVien = ? AND tenhocky = ? AND namhoc LIKE ?";
        List<KiHoc> kiHocs = query(sql, new KiHocMapper(), sv.getId(), "Kỳ " + hocKy, namHoc + "%");
        return (kiHocs == null || kiHocs.isEmpty()) ? null: kiHocs.get(0);
    }
}
