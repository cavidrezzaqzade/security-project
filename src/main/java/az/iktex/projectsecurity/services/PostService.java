package az.iktex.projectsecurity.services;

import az.iktex.projectsecurity.api.PostApiDelegate;
import az.iktex.projectsecurity.entities.Post;
import az.iktex.projectsecurity.models.CommentDTO;
import az.iktex.projectsecurity.models.PostDTO;
import az.iktex.projectsecurity.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostService implements PostApiDelegate {

    @Autowired
    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public ResponseEntity<?> getPosts() {

        List<PostDTO> postDtos = new ArrayList<>();

        List<Post> postEntities = postRepository.findAll();

        postEntities.forEach(post -> {

            Set<CommentDTO> commentDTOList = new HashSet<>();

            post.getComments().forEach(comment -> {
                commentDTOList.add(
                        CommentDTO.builder()
                                .comment(comment.getComment())
                                .build()
                );
            });

            postDtos.add(
                    PostDTO.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .comments(commentDTOList)
                        .build()
            );

        });

        return ResponseEntity.ok(postDtos);
    }

    @Override
    public ResponseEntity<?> addPost(PostDTO postDTO) {


        return ResponseEntity.ok("adding succesfull");
    }
}
