package jihyune.blog.reapository;
import jihyune.blog.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostingRepository extends CrudRepository<Post, Integer> {

}
