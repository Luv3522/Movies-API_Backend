package com.example.movie;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {



    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(ObjectId id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> findByImdbId(String id){
        return movieRepository.findByImdbId(id);
    }

    //public Optional<Movie> findMovieByYtLink(String lnk){return movieRepository.findMovieByYtLink(lnk);}


//    public Optional<Movie> getMovieByYtLink(String lnk) {
//        return movieRepository.getMovieByTrailerLink(lnk);
   }


