package az.iktex.projectsecurity.api;

import az.iktex.projectsecurity.models.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

/**
 * @author Cavid R.
 */

@Validated
public interface PostApi {
    
    default PostApiDelegate getDelegate(){
        return new PostApiDelegate(){};
    }
    
    @GetMapping("/posts")
    default ResponseEntity<?> getPosts(){
        return getDelegate().getPosts();
    }
    
    @PostMapping("/posts")
    default ResponseEntity<?> addPost(@Valid @RequestBody PostDTO postDTO){
        return getDelegate().addPost(postDTO);
    }
}
