package com.example.movie;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie,ObjectId> {

    Optional<Movie> findByImdbId(String id);
    //Optional<Movie> getMovieByTrailerLink(String lnk);

}
