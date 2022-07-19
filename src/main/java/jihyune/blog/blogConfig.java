package jihyune.blog;

import jihyune.blog.reapository.MemoryPostRepository;
import jihyune.blog.reapository.PostRepository;
import jihyune.blog.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class blogConfig {
    @Bean
    public PostService postService() {
        return new PostService(postRepository());
    }
    @Bean
    public PostRepository postRepository() {
        return new MemoryPostRepository();
    }
}
