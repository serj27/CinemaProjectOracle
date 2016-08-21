package dao.impl;

/**
 * Created by serj27 on 02.06.2016.
 */
public class SQLs {
    public static final String SELECT_ALL = "SELECT * FROM %s";
    public static final String FIND_BY_ID = "SELECT * FROM %s WHERE id = ?";
    public static final String DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";

    public static final String INSERT_MOVIE = "INSERT INTO movie (title, description, duration, rent_start, rent_end, genre, rating) values (?,?,?,?,?,?,?)";
    public static final String UPDATE_MOVIE = "UPDATE movie SET title = ?, description = ?, duration = ?, rent_start = ?, rent_end = ?, genre = ?, rating = ?, WHERE id = ?";
    public static final String UPDATE_MOVIE_TITLE = "UPDATE movie SET title = ? WHERE id = ?";
    public static final String GET_MOVIE_BY_TITLE = "SELECT * FROM movie WHERE title Like ?";

    public static final String INSERT_HALL = "INSERT INTO hall (hall_name) values (?)";
    public static final String UPDATE_HALL = "UPDATE hall SET hall_name = ? WHERE id = ?";
    public static final String GET_HALL_BY_NAME = "SELECT * FROM hall WHERE hall_name LIKE ?";

    public static final String INSERT_ROWS = "INSERT INTO rows (row_number, seat_quantity, hall_id) values (?, ?, ?)";
    public static final String UPDATE_ROWS = "UPDATE rows SET row_number = ?, seat_quantity = ?, hall_id = ? WHERE id = ?";
    public static final String UPDATE_ROWS_SEATS_NUMBER = "UPDATE rows SET seat_quantity = ? WHERE id = ?";
    public static final String GET_ROW_BY_ROW_NUMBER = "SELECT * FROM rows WHERE row_number = ?";
    public static final String GET_ROW_BY_SEAT_NUMBER = "SELECT * FROM rows WHERE seat_quantity = ?";
    public static final String GET_ROW_BY_HALL = "SELECT * FROM rows WHERE hall_id = ?";

    public static final String INSERT_SESSION = "INSERT INTO session (movie_id, startSession, price, hall_id) values (?, ?, ?, ?)";
    public static final String UPDATE_SESSION = "UPDATE session movie_id = ?, startSession = ?, price = ?, hall_id = ? WHERE id = ?";
    public static final String UPDATE_SESSION_TIME = "UPDATE session SET time = ? WHERE id =?";
    public static final String UPDATE_SESSION_DATE = "UPDATE session SET date = ? WHERE id =?";
    public static final String UPDATE_SESSION_PRICE = "UPDATE session SET price = ? WHERE id = ?";
    public static final String GET_SESSION_BY_TIME = "SELECT * FROM session WHERE \"time\" = ?";
    public static final String GET_SESSION_BY_DATE = "SELECT * FROM session WHERE \"date\" = CAST(? As Date)";
    public static final String GET_SESSION_BY_PRICE = "SELECT * FROM session WHERE price = ?";
    public static final String GET_SESSION_BY_HALL = "SELECT * FROM session WHERE hall_id = ?";
    public static final String GET_SESSION_BY_MOVIE_ID = "SELECT * FROM session WHERE movie_id = ?";

    public static final String INSERT_TICKETS = "INSERT INTO tickets (session_id, users_id, row_number, seat_number, is_sold) values (?, ?, ?, ?, ?)";
    public static final String UPDATE_TICKETS = "UPDATE tickets session_id = ?, users_id = ?, row_number = ?, seat_number = ?, is_sold = ? WHERE id = ?";
    public static final String UPDATE_TICKET_ROW_NUMBER = "UPDATE ticket SET row_number = ? WHERE id = ?";
    public static final String UPDATE_TICKET_SEAT_NUMBER = "UPDATE ticket SET seat_number = ? WHERE id = ?";
    public static final String GET_TICKET_BY_SESSION_ID = "SELECT * FROM ticket WHERE session_id = ?";
    public static final String GET_TICKET_BY_USER_ID = "SELECT * FROM ticket WHERE user_id = ?";
    public static final String GET_TICKET_BY_IS_SOLD = "SELECT * FROM ticket WHERE is_sold = ?";

    public static final String INSERT_USERS = "INSERT INTO users (login, password, first_name, second_name, email, gender, birthday, role_name) values (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USERS = "UPDATE users set login = ?, password = ?, first_name = ?, second_name = ?, email = ?, gender = ?, birthday = ?, role_name = ? WHERE id = ?";
    public static final String UPDATE_USER_NAME = "UPDATE users SET first_name = ? WHERE id = ?";
    public static final String GET_USER_BY_NAME = "SELECT * FROM users WHERE first_name = ?";
    public static final String GET_USER_BY_EMAIL = "SELECT *FROM users WHERE email = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";

}
