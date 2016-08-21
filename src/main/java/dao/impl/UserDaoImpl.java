package dao.impl;

import datasource.DataSource;
import model.Users;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.*;

/**
 * Created by serj27 on 17.07.2016.
 */
public class UserDaoImpl extends CrudDAO<Users>{


    private static UserDaoImpl crudDAO;

    public UserDaoImpl(Class type) throws NoSuchAlgorithmException {
        super(type);
    }

    public static synchronized UserDaoImpl getInstance () throws NoSuchAlgorithmException {
        if (crudDAO == null) {
            crudDAO = new UserDaoImpl(Users.class);
        }return crudDAO;
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
            users.setRole(Users.Role.valueOf(resultSet.getString("role_name")));
            users.setBirthday(resultSet.getDate("birthday").toLocalDate());
            users.setEmail(resultSet.getString("email"));
            users.setFirstName(resultSet.getString("first_name"));
            users.setSecondName(resultSet.getString("second_name"));
            users.setLogin(resultSet.getString("login"));
            users.setPassword(resultSet.getString("password"));
            users.setGender(Users.Gender.valueOf(resultSet.getString("gender")));
            usersList.add(users);
        }
        return usersList;
    }

    public void updateUserName (String name, Integer id){
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_NAME);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Users getUserByName (String name){
        Connection connection = DataSource.getInstance().getConnection();
        List<Users> usersList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            usersList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList.get(0);
    }

    public Users getUserByEmail (String email){
        Connection connection = DataSource.getInstance().getConnection();
        List<Users> usersList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_EMAIL);
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            usersList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList.get(0);
    }

    public Users getUserByLogin (String login){
        Connection connection = DataSource.getInstance().getConnection();
        List<Users> usersList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN);
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            usersList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList.get(0);
    }

    public String encryptPassword (String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final StringBuilder md5Hash = new StringBuilder();
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes("UTF-8"));
        final byte [] data = messageDigest.digest();
        for (byte b : data) {
            md5Hash.append(Character.forDigit((b >> 4) & 0xf, 16));
            md5Hash.append(Character.forDigit(b & 0xf, 16));
        }
        return md5Hash.toString();
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
