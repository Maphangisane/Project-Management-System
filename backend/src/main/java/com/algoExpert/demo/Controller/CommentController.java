package com.algoExpert.demo.Controller;

import com.algoExpert.demo.Entity.Comment;
import com.algoExpert.demo.Entity.Task;
import com.algoExpert.demo.Entity.User;
import com.algoExpert.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

//  create new comment using member and task id
    @PostMapping("/create/{member_id}/{task_id}")
    private Task createComment(@RequestBody Comment comment, @PathVariable int member_id,@PathVariable int task_id){
        return commentService.createComment(comment,member_id,task_id);
    }

//    get all comments
    @GetMapping("/getAllComments")
    private List<Comment> getUsers(){
        return commentService.getAllComments();
    }


    @PutMapping("/edit/{comment_id}")
    private Comment editComment(@PathVariable int comment_id,@RequestBody Comment comment){
        return commentService.editComment(comment_id, comment);
    }

    @DeleteMapping("/delete/{comment_id}")
    List<Comment> deleteComment(@PathVariable int comment_id){
        return commentService.deleteComment(comment_id);
    }

}
