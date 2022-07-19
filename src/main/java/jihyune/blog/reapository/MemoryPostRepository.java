package jihyune.blog.reapository;

import jihyune.blog.domain.Post;

import java.util.*;

public class MemoryPostRepository implements PostRepository {

    private static Map<Long, Post> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Post save(Post post) {
        post.setId((++sequence));
        store.put(post.getId(), post);
        return null;
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Post> findByTitle(String title) {
        return store.values().stream()
                .filter(member -> member.getTitle().equals(title))
                .findAny();
    }

    @Override
    public Optional<Post> findByContent(String content) {
        return store.values().stream()
                .filter(member -> member.getContent().equals(content))
                .findAny();
    }
}
