package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class TopTrendingMovies {
    
    static class Movie {
        private String title;
        private double rating;
        private int releaseYear;
        
        public Movie(String title, double rating, int releaseYear) {
            this.title = title;
            this.rating = rating;
            this.releaseYear = releaseYear;
        }
        
        public double getRating() { return rating; }
        public int getReleaseYear() { return releaseYear; }
        public String getTitle() { return title; }
    }
    
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2023),
            new Movie("Movie B", 7.8, 2022),
            new Movie("Movie C", 9.1, 2023),
            new Movie("Movie D", 6.5, 2021),
            new Movie("Movie E", 8.9, 2023),
            new Movie("Movie F", 7.2, 2022),
            new Movie("Movie G", 8.7, 2023)
        );
        
        List<Movie> top5 = movies.stream()
            .filter(m -> m.getReleaseYear() >= 2022)
            .sorted(Comparator.comparing(Movie::getRating).reversed()
                .thenComparing(Movie::getReleaseYear).reversed())
            .limit(5)
            .collect(Collectors.toList());
        
        System.out.println("Top 5 Trending Movies:");
        top5.forEach(m -> System.out.println(m.getTitle() + " (" + m.getReleaseYear() + ") - Rating: " + m.getRating()));
    }
}