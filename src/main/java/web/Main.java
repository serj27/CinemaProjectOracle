package web;

import dto.MovieDTO;
import service.impl.MovieServiceImpl;

import java.time.LocalDate;

/**
 * Created by serj27 on 02.06.2016.
 */
public class Main {

    public static void main(String[] args) {

        MovieDTO movieDTO = new MovieDTO("title1", "description1", 25, new LocalDate(), new LocalDate(), "genre", 5);

        MovieServiceImpl.getInstance().save(movieDTO);

        System.out.println(MovieServiceImpl.getInstance().getAll());


    }
}
