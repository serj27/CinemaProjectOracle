package dao.impl;

import datasource.DataSource;
import model.Tickets;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.*;

/**
 * Created by serj27 on 17.07.2016.
 */
public class TicketsDaoImpl extends CrudDAO<Tickets> {

    private static TicketsDaoImpl crudDAO;

    public TicketsDaoImpl(Class type) {
        super(type);
    }

    public static synchronized TicketsDaoImpl getInstance() {
        if (crudDAO == null){
            crudDAO = new TicketsDaoImpl(Tickets.class);
        }return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Tickets entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TICKETS);
        preparedStatement.setInt(1, entity.getSessionID());
        preparedStatement.setInt(2, entity.getUserID());
        preparedStatement.setInt(3, entity.getRowNumber());
        preparedStatement.setInt(4, entity.getSeatNumber());
        preparedStatement.setBoolean(5, entity.isSold());
        preparedStatement.setInt(6, entity.getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Tickets entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TICKETS, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getSessionID());
        preparedStatement.setInt(2, entity.getUserID());
        preparedStatement.setInt(3, entity.getRowNumber());
        preparedStatement.setInt(4, entity.getSeatNumber());
        preparedStatement.setBoolean(5, entity.isSold());
        return preparedStatement;
    }

    @Override
    protected List<Tickets> readAll(ResultSet resultSet) throws SQLException {
        List<Tickets> ticketsList = new LinkedList<>();
        Tickets tickets = null;
        while (resultSet.next()){
            tickets = new Tickets();
            tickets.setId(resultSet.getInt("id"));
            tickets.setSessionID(resultSet.getInt("session_id"));
            tickets.setUserID(resultSet.getInt("users_id"));
            tickets.setRowNumber(resultSet.getInt("row_number"));
            tickets.setSeatNumber(resultSet.getInt("seat_number"));
            tickets.setSold(resultSet.getBoolean("is_sold"));
            ticketsList.add(tickets);
        }
        return ticketsList;
    }

     public void updateTicketRowNumber (int rowNumber, Integer id){
         Connection connection = DataSource.getInstance().getConnection();
         try {
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TICKET_ROW_NUMBER);
             preparedStatement.setInt(1,rowNumber);
             preparedStatement.setInt(2,id);
             preparedStatement.executeUpdate();
             connection.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

    public void updateTicketSeatNumber (int seatNumber, Integer id){
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TICKET_SEAT_NUMBER);
            preparedStatement.setInt(1,seatNumber);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tickets> getTicketBySession (Integer session_id){
        Connection connection = DataSource.getInstance().getConnection();
        List<Tickets> ticketsList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TICKET_BY_SESSION_ID);
            preparedStatement.setInt(1,session_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ticketsList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return ticketsList;
    }

    public List<Tickets> getTicketByUser (Integer id){
        Connection connection = DataSource.getInstance().getConnection();
        List<Tickets> ticketsList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TICKET_BY_USER_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ticketsList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketsList;
    }

    public List<Tickets> getTicketByIsSold (boolean isSold){
        Connection connection = DataSource.getInstance().getConnection();
        List<Tickets> ticketsList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TICKET_BY_IS_SOLD);
            preparedStatement.setBoolean(1,isSold);
            ResultSet resultSet = preparedStatement.executeQuery();
            ticketsList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketsList;
    }

    @Override
    public List<Tickets> findAll() {
        return null;
    }

    @Override
    public Tickets findOne(Integer id) {
        return null;
    }

    @Override
    public void deleteOne(Integer key) {

    }

    @Override
    public Tickets getBy(String login, String value) {
        return null;
    }
}
