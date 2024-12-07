package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    private static final String API_URL = "https://jsonplaceholder.typicode.com/comments";

    @Autowired
    private RestTemplate restTemplate;

    public List<Comment> getAllComments() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(API_URL);
        Comment[] comments = restTemplate.getForObject(builder.toUriString(), Comment[].class);
        return Arrays.asList(comments);
    }
}
