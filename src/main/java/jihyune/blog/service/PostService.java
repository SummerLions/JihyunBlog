package jihyune.blog.service;

import jihyune.blog.domain.Post;
import jihyune.blog.reapository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public String join(Post post) {
        postRepository.save(post);
        return post.getTitle();
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

}
