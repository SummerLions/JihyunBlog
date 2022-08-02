package jihyune.blog.board.controller;

import jihyune.blog.board.Post;
import jihyune.blog.board.service.CommentService;
import jihyune.blog.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/board/post/detail/comment")
@RequiredArgsConstructor
@Controller
public class CommentController {
    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("/create/{id}")
    public String createComment(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        Post post = this.postService.getPost(id);
        this.commentService.create(post, content);
        return String.format("redirect:/board/post/detail/%s", id);
    }
}
