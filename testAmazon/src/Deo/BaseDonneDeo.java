package Deo;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import Model.BaseDonne;

public interface BaseDonneDeo {
    List<BaseDonne> findAll() throws SQLException;
    List<BaseDonne> getUsers() throws SQLException;
    int getIdUser() throws SQLException;
    void insertUser(BaseDonne user);
    void updatePassword(BaseDonne user);
    BaseDonne findById(int id);
    void save(BaseDonne data) throws FileNotFoundException, SQLException;
    int deleteById(int id);
}
