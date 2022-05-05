package dao.impl;

import dao.IKetQuaDAO;
import mapper.KetQuaMapper;
import model.DangKiHoc;
import model.KetQua;

import java.util.List;

public class KetQuaDAO extends AbstractDAO<KetQua> implements IKetQuaDAO {
    @Override
    public List<KetQua> findAllByDangKiHocOfSinhVien(DangKiHoc dkh) {
        String sql = "SELECT * FROM viewkq WHERE idDangKiHoc = ?";
        return query(sql, new KetQuaMapper(), dkh.getId());
    }
}
