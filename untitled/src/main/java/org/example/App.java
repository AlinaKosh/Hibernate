package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            /*
            1)С помощью Hibernate получите любого режиссера, а затем получите список его фильмов.

            Director director = session.get(Director.class, 5);
            System.out.println(director);

            List<Movie> movies = director.getMovies();
            System.out.println(movies);
------------------------------------------------------------------------
            2) Получите любой фильм, а затем получите его режиссера

            Movie movie = session.get(Movie.class,3);
            System.out.println(movie);

            Director director = movie.getDirector();
            System.out.println(director);
-------------------------------------------------------------------------
            3)Добавьте еще один фильм для любого режиссера.

            Director director = session.get(Director.class, 5);
            Movie newMovie = new Movie("New movie", 2024, director);
            session.save(newMovie);
            director.getMovies().add(newMovie);
--------------------------------------------------------------------------
            4)Создайте нового режиссера и новый фильм и свяжите эти сущности

            Director director = new Director("New director", 77);
            Movie movie = new Movie("New movie", 2024, director);
            director.setMovies(new ArrayList<>(Collections.singletonList(movie)));

            session.save(director);
            session.save(movie);
--------------------------------------------------------------------------
            5) Смените режиссера у существующего фильма.
            Movie movie = session.get(Movie.class, 2);
            Director director = session.get(Director.class, 4);

            movie.setDirector(director);

            director.getMovies().remove(movie);

            director.getMovies().add(movie);

---------------------------------------------------------------------------
            6) Удалите фильм у любого режиссера.
            Director director = session.get(Director.class, 5);
            List<Movie> movies = director.getMovies();
            for (Movie movie:movies){
                session.remove(movie);
            }
            director.getMovies().clear();

             */

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }


    }
}
