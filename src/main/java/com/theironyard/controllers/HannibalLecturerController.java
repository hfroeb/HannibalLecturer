package com.theironyard.controllers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by halleyfroeb on 10/14/16.
 * Lecturer(String name, String topic, String image)
 * Review(String author, String text, int lecturerId, boolean isGood)
 */
@RestController
public class HannibalLecturerController {
    @Autowired
    ReviewRepository reviews;

    @Autowired
    LecturerRepository lectures;

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public void postLecture(HttpServletResponse response, String name, String topic, String image) throws IOException {
        Lecturer lecturer = new Lecturer(name, topic, image);
        lectures.save(lecturer);
        response.sendRedirect("/");
    }
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void postReview(HttpServletResponse response, String author, String text, int lecturerId, boolean isGood) throws IOException {
        Review review = new Review(author, text, lecturerId, isGood);
        reviews.save(review);
        response.sendRedirect("/");
    }
    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public List<Lecturer> getLecturers() throws Exception {
       return (List<Lecturer>) lectures.findAll();
    }
    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public List<Review> getReviews() throws Exception {
        return (List<Review>) reviews.findAll();
    }

}
