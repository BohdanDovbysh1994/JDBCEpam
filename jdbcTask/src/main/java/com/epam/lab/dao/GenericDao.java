package com.epam.lab.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
	T getOne(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    boolean insertIntoTable(T table);
    boolean updateTable(T table);
    boolean deleteFromTable(int id);

}
