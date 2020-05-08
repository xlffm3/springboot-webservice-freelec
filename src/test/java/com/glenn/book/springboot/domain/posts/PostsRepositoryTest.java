package com.glenn.book.springboot.domain.posts;

import javafx.geometry.Pos;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest extends TestCase {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();;
    }

    @Test
    public void findTest() {
        String title = "title";
        String content = "content";
        String author = "author";

        postsRepository.save(Posts.builder().title(title).content(content).author(author).build());
        List<Posts> list = postsRepository.findAll();
        Posts posts = list.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void dateTest() {
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder().title("title").content("content").author("author").build());

        List<Posts> list = postsRepository.findAll();
        Posts posts = list.get(0);
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}