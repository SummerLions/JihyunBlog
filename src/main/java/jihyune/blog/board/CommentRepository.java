package jihyune.blog.board;

import jihyune.blog.board.Comment;
import jihyune.blog.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}