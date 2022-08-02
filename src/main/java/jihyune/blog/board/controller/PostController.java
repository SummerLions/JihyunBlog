package jihyune.blog.board.controller;

import java.util.List;

import jihyune.blog.board.PostForm;
import org.springframework.web.bind.annotation.*;
import jihyune.blog.board.Post;
import jihyune.blog.board.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import lombok.RequiredArgsConstructor;

@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Post> postList = this.postService.getList();
        model.addAttribute("postList", postList);
        return "board/post_list";
    }

    @RequestMapping(value = "/post/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Post post = this.postService.getPost(id);
        model.addAttribute("post", post);
        return "board/post_detail";
    }

    @PostMapping("/post/create")
    public String postCreate(@Valid PostForm postForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "board/post_form";
        }
        this.postService.create(postForm.getSubject(), postForm.getContent());
        return "redirect:/board/list";
    }

    @GetMapping("/post/create")
    public String postCreate(PostForm postForm) {
        return "board/post_form";
    }
}