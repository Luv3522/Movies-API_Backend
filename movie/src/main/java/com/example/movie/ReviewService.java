package com.example.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {


    private MongoTemplate template;
    public ReviewService(MongoTemplate template){
        this.template=template;
    }
    private ReviewRepository reviewRepository;

    public ReviewService() {
    }

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));



        template.update(Movie.class)
                .matching(Criteria.where("imdbId"))
                .apply(new Update().push("reviewIds").value(review)).first();

        return review;

    }

}
