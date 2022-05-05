package mapper;

import model.SinhVien;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SinhVienMapper implements IRowMapper<SinhVien> {
    @Override
    public SinhVien mapRow(ResultSet rs) {
        try {
            SinhVien sv = new SinhVien();
            sv.setId(rs.getInt("idSinhVien"));
            sv.setTen(rs.getString("ten"));
            sv.setMaSV(rs.getString("maSV"));
            return sv;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
