package web;

import dao.impl.*;
import datasource.DataSource;
import helpers.PropertyHolder;
import model.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.time.LocalDate;


/**
 * Created by serj27 on 02.06.2016.
 */
public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException{

        System.out.println(PropertyHolder.getInstance().getJdbcUrl());
        Connection connection = DataSource.getInstance().getConnection();
        CrudDAO<Movie> movieCrudDAO = new MovieDaoImpl(Movie.class);
        MovieDaoImpl movieDaoImpl = new MovieDaoImpl(Movie.class);
        CrudDAO<Hall> hallCrudDAO = new HallDaoImpl(Hall.class);
        HallDaoImpl hallDaoImpl = new HallDaoImpl(Hall.class);
        CrudDAO<Row> rowCrudDAO = new RowDaoImpl(Row.class);
        RowDaoImpl rowDaoImpl = new RowDaoImpl(Row.class);
        CrudDAO<Session> sessionCrudDAO = new SessionDaoImpl(Session.class);
        SessionDaoImpl sessionDaoImpl = new SessionDaoImpl(Session.class);
        CrudDAO<Tickets> ticketsCrudDAO = new TicketsDaoImpl(Tickets.class);
        TicketsDaoImpl ticketsDaoImpl = new TicketsDaoImpl(Tickets.class);
        CrudDAO<Users> usersCrudDAO = new UserDaoImpl(Users.class);
        UserDaoImpl userDaoImpl = new UserDaoImpl(Users.class);

        System.out.println(movieCrudDAO.getById(1));

        Movie movie1 = new Movie("Stranger Things","На дворе уютные 80-е. В маленьком провинциальном " +
                "                                  Хоукинсе, штат Индиана, никогда не случалось ничего " +
                "                                  экстраординарного, жизнь текла своим чередом, и всех такое " +
                "                                  положение дел устраивало. Поэтому когда при очень странных " +
                "                                  обстоятельствах пропал один из обитателей этого райского местечка, " +
                "                                  подросток по имени Уилл, никто, кроме его мамы Джойс и лучших друзей, " +
                "                                  поначалу всерьез не обеспокоился.",
                47, LocalDate.of(2016,7,19), LocalDate.of(2017,7,25),"Mistic", 8);

        Movie movie2 = new Movie("Arrow", "Прошло пять лет с тех пор, как молодой бизнесмен, наследник многомиллионного" +
                "                          состояния и легкомысленный сердцеед Оливер Куин был объявлен погибшим вместе" +
                "                          со своим отцом и другими членами экипажа частного судна. На самом деле после" +
                "                          кораблекрушения в водах Тихого океана из семи человек выжить удалось только " +
                "                          ему. Оливера выкинуло на необитаемый остров, полный опасностей. Борясь за " +
                "                          свою жизнь, Куин менялся день за днем: остров закалил его тело и дух, " +
                "                          превратив из избалованного мальчишки в отважного воина, который обрел  " +
                "                          новую цель в жизни.",48, LocalDate.of(2012,10,12), LocalDate.of(2016, 5, 24), "Action", 10);
        movieCrudDAO.upload(movie1);
        movieCrudDAO.upload(movie2);
        movieDaoImpl.getAll();

        Movie movie3 = movieCrudDAO.getById(2);
        movieCrudDAO.update(movie3);
        movie2.setDescription("В пятом сезоне «Стрелы» (Arrow) Оливер Куин всерьез задумается над тем, чтобы собрать" +
                "              компанию последователей, ведь Тея и Диггл команду покинули, а врагов у Куина со временем" +
                "              меньше не становится. На фестивале Comic-Con создатели сериала представили первый трейлер" +
                "              к будущим эпизодам, свидетельствующий о том, что новичков Стреле придется долго и упорно " +
                "              тренировать.");

        movieCrudDAO.update(movie2);



    }
}
