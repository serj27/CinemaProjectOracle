package dao.impl;

import model.Users;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.INSERT_USERS;
import static dao.impl.SQLs.UPDATE_USERS;

/**
 * Created by serj27 on 17.07.2016.
 */
public class UserDaoImpl extends CrudDAO<Users>{


    private static MovieDaoImpl crudDAO;

    public UserDaoImpl() {
        super(Users.class);
    }


    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Users entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS);
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString(4, entity.getSecondName());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setObject(6, entity.getGender().toString());
        preparedStatement.setDate(7, Date.valueOf(entity.getBirthday()));
        preparedStatement.setObject(8, entity.getRole().toString());
        preparedStatement.setInt(9, entity.getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Users entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString(4, entity.getSecondName());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setObject(6, entity.getGender().toString());
        preparedStatement.setDate(7, Date.valueOf(entity.getBirthday()));
        preparedStatement.setObject(8, entity.getRole().toString());
        return preparedStatement;
    }

    @Override
    protected List<Users> readAll(ResultSet resultSet) throws SQLException {
        List<Users> usersList = new LinkedList<>();
        Users users = null;
        while (resultSet.next()){
            users = new Users();
            users.setId(resultSet.getInt("id"));
            users.setRole(Users.Role.valueOf(resultSet.getString("role_type")));
            users.setBirthday(resultSet.getDate("birthday").toLocalDate());
            users.setEmail(resultSet.getString("email"));
            users.setFirstName(resultSet.getString("first_name"));
            users.setSecondName(resultSet.getString("second_name"));
            users.setLogin(resultSet.getString("login"));
            users.setPassword(resultSet.getString("password"));
            users.setGender(Users.Gender.valueOf(resultSet.getString("sex")));
            usersList.add(users);
        }
        return usersList;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Users findOne(Integer id) {
        return null;
    }

    @Override
    public void deleteOne(Integer key) {

    }

    @Override
    public Users getBy(String login, String value) {
        return null;
    }
}
