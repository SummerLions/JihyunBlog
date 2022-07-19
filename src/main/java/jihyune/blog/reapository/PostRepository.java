package jihyune.blog.reapository;

import jihyune.blog.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(Long id);
    Optional<Post> findByTitle(String title);
    Optional<Post> findByContent(String content);
    List<Post> findAll();
}
