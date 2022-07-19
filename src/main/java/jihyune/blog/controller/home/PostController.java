package jihyune.blog.controller.home;

import jihyune.blog.domain.Post;
import jihyune.blog.domain.PostForm;
import jihyune.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path="/posts")
public class PostController {
    private final PostService postService;

    @GetMapping(value ="/new")
    public String createForm(){return "posts/create";}


    @PostMapping(value = "/new")
    public String create(@ModelAttribute PostForm form){
        Post post = new Post();
        post.setId(form.getId());
        postService.join(post);
        return "posts/home";
    }

    @GetMapping(value = "")
    public String list(Model model) {
        List<Post> posts = postService.findPosts();
        model.addAttribute("posts", posts);
        return "";
    }
}
