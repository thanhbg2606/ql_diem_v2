package dao;

import mapper.IRowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, IRowMapper<T> IRowMapper, Object... parameters);
}
