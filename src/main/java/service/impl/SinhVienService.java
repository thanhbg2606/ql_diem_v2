package service.impl;

import dao.ISinhVienDAO;
import model.SinhVien;
import service.ISinhVienService;

import javax.inject.Inject;

public class SinhVienService implements ISinhVienService {
    @Inject
    private ISinhVienDAO sinhVienDAO;

    @Override
    public SinhVien checkLogin(SinhVien sv) {
        return sinhVienDAO.checkLogin(sv);
    }
}
