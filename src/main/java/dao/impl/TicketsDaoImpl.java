package dao.impl;

import model.Tickets;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.INSERT_TICKETS;
import static dao.impl.SQLs.UPDATE_TICKETS;

/**
 * Created by serj27 on 17.07.2016.
 */
public class TicketsDaoImpl extends CrudDAO<Tickets> {

    private static MovieDaoImpl crudDAO;

    public TicketsDaoImpl(Class<Tickets> ticketsClass) {
        super(Tickets.class);
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
