package mapper;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DangKiHocMapper implements IRowMapper<DangKiHoc>{
    @Override
    public DangKiHoc mapRow(ResultSet rs) {
        try {
            DangKiHoc dkh = new DangKiHoc();
            SinhVien sv = new SinhVien();
            sv.setId(rs.getInt("idSinhVien"));
            sv.setTen(rs.getString("fullname"));
            sv.setMaSV(rs.getString("maSV"));

            NamHoc nh = new NamHoc();
            nh.setId(rs.getInt("idNamHoc"));
            nh.setTem(rs.getString("namhoc"));

            HocKi hk = new HocKi();
            hk.setId(rs.getInt("idHocKi"));
            hk.setTen(rs.getString("tenhocky"));

            KiHoc kh = new KiHoc();
            kh.setId(rs.getInt("idKiHoc"));
            kh.setHocki(hk);
            kh.setNamhoc(nh);

            MonHoc mh = new MonHoc();
            mh.setId(rs.getInt("idMonHoc"));
            mh.setMaTC(rs.getString("maMH"));
            mh.setSoTC(rs.getInt("soTC"));
            mh.setTen(rs.getString("monhoc"));
            mh.setIsTinhDiem(rs.getInt("isTinhDiem"));

            MonHocKiHoc mhkh = new MonHocKiHoc();
            mhkh.setId(rs.getInt("idMonHocKiHoc"));
            mhkh.setKiHoc(kh);
            mhkh.setMh(mh);

            dkh.setId(rs.getInt("idDangKiHoc"));
            dkh.setMonHocKiHoc(mhkh);
            dkh.setSinhVien(sv);

            return dkh;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
