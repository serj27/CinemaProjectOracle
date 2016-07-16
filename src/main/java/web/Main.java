package web;

import dto.MovieDTO;
import service.impl.MovieServiceImpl;

import java.util.Date;

/**
 * Created by serj27 on 02.06.2016.
 */
public class Main {

    public static void main(String[] args) {

        MovieDTO movieDTO = new MovieDTO("title1", "description1", 25, new Date(), new Date(), "genre", 5);

        MovieServiceImpl.getInstance().save(movieDTO);

        System.out.println(MovieServiceImpl.getInstance().getAll());


    }
}
