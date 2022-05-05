package mapper;

import model.DauDiem;
import model.KetQua;
import model.MonHocDauDiem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KetQuaMapper implements IRowMapper<KetQua>{
    @Override
    public KetQua mapRow(ResultSet rs) {
        try {
            DauDiem dd = new DauDiem();
            dd.setId(rs.getInt("idDauDiem"));
            dd.setTen(rs.getString("tendaudiem"));

            MonHocDauDiem mhdd = new MonHocDauDiem();
            mhdd.setId(rs.getInt("idMonHocDauDiem"));
            mhdd.setTitle(rs.getFloat("title"));
            mhdd.setDauDiem(dd);

            KetQua kq = new KetQua();
            kq.setId(rs.getInt("idKetQua"));
            kq.setDiem(rs.getFloat("diem"));
            kq.setDiemtp(mhdd);
            return kq;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
