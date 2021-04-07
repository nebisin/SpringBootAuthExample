package com.muaccel.testapp.post;

import com.muaccel.testapp.exception.NotFoundException;
import com.muaccel.testapp.user.User;
import com.muaccel.testapp.user.UserPrincipal;
import com.muaccel.testapp.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @GetMapping
    public List<Post> allPosts() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post createPost(@Valid @RequestBody Post newPost, HttpServletRequest request) {
        Principal userPrincipal = request.getUserPrincipal();

        User author = userRepository.findByEmail(userPrincipal.getName());

        newPost.setAuthor(author);

        return postRepository.save(newPost);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The post with id " + id + "could not found!"));
    }
}
