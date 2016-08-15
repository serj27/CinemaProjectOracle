package dao.impl;

/**
 * Created by serj27 on 02.06.2016.
 */
public class SQLs {
    public static final String SELECT_ALL = "Select * from %s";
    public static final String FIND_BY_ID = "Select * from %s where id = ?";

    public static final String DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";
    public static  final String INSERT_MOVIE = "Insert into movie (title, description, duration, rent_start, rent_end, genre, rating) values (?,?,?,?,?,?,?)";
    public static  final String UPDATE_MOVIE = "UPDATE movie SET title = ?, description = ?, duration = ?, rent_start = ?, rent_end = ?, genre = ?, rating = ?, WHERE id = ?";
    public static final String INSERT_HALL = "Insert into hall (hall_name) values (?)";
    public static final String UPDATE_HALL = "Update hall set hall_name = ? where id = ?";

    public static final String INSERT_ROWS = "Insert into rows (row_number, seat_quantity, hall_id) values (?, ?, ?)";
    public static final String UPDATE_ROWS = "Update rows set row_number = ?, seat_quantity = ?, hall_id = ? where id = ?";

    public static final String INSERT_SESSION = "Insert into session (movie_id, time, price, hall_id) values (?, ?, ?, ?)";
    public static final String UPDATE_SESSION = "Update session movie_id = ?, time = ?, price = ?, hall_id = ? where id = ?";

    public static final String INSERT_TICKETS = "Insert into tickets (session_id, users_id, row_number, seat_number, is_sold) values (?, ?, ?, ?, ?)";
    public static final String UPDATE_TICKETS = "Update tickets session_id = ?, users_id = ?, row_number = ?, seat_number = ?, is_sold = ? where id = ?";

    public static final String INSERT_USERS = "Insert into users (login, password, first_name, last_name, email, sex, birthday, role_type) values (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USERS = "Update users set login = ?, password = ?, first_name = ?, last_name = ?, email = ?, sex = ?, birthday = ?, role_type = ? where id = ?";

}
