package com.company.service;

import com.company.movie.Movie;

import java.util.Scanner;

public class MovieCollector {
    public static MovieCollector instance = new MovieCollector();

    private MovieCollector(){
    }

    private MoviesService moviesService = MoviesService.instance;

    private void createMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write Movie name");
        String name = scanner.nextLine();
        System.out.println("Please write Movie genre");
        String genre = scanner.nextLine();
        System.out.println("Please write Movie duration");
        String duration = scanner.nextLine();
        Movie movie = new Movie(name, genre, duration);
        moviesService.create(movie);
    }

    private void selectMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write movie id");
        int id = scanner.nextInt();
        moviesService.selectById(id);
    }

    private void updateMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Plese write movie id");
        int id = scanner.nextInt();
        String test = scanner.nextLine();
        System.out.println("Plese write new name");
        String name = scanner.nextLine();
        System.out.println("Plese write new genre");
        String genre = scanner.nextLine();
        System.out.println("Plese write new duration");
        String duration = scanner.nextLine();
        moviesService.updateById(new Movie(name, genre, duration), id);
    }

    private void deleteMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write movie id");
        int id = scanner.nextInt();
        moviesService.deleteById(id);
    }

    public static void menu() {
        MovieCollector movieCollector = MovieCollector.instance;
        int num;
        do {
            System.out.println("______________________________");
            System.out.println("              Menu            ");
            System.out.println("   Press 1 for create movie   ");
            System.out.println("   Press 2 for select movie");
            System.out.println("   Press 3 for update movie   ");
            System.out.println("   Press 4 for delete movie   ");
            System.out.println("   Press 5 for exit           ");
            System.out.println("______________________________");

            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    movieCollector.createMovie();
                    break;
                case 2:
                    movieCollector.selectMovie();
                    break;
                case 3:
                    movieCollector.updateMovie();
                    break;
                case 4:
                    movieCollector.deleteMovie();
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
            }
        }while (num > 0 && num < 5);
    }
}
