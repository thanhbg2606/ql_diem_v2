package mapper;

import model.KiHoc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KiHocMapper implements IRowMapper<KiHoc> {
    @Override
    public KiHoc mapRow(ResultSet rs) {
        try {
            KiHoc kh = new KiHoc();
            kh.setId(rs.getInt("idKiHoc"));
            return kh;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
