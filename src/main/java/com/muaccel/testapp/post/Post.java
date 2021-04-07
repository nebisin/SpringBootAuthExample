package com.muaccel.testapp.post;

import com.muaccel.testapp.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String content;
    private Boolean published = false;

    @ManyToOne
    private User author;

    public Post(String title, String content, Boolean published, User author) {
        this.title = title;
        this.content = content;
        this.published = published;
        this.author = author;
    }

    public User getAuthor() {
        author.setPosts(null);
        return author;
    }
}
