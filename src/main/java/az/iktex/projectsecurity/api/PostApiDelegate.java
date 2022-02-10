package az.iktex.projectsecurity.api;

import az.iktex.projectsecurity.models.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Cavid R.
 */

public interface PostApiDelegate {

    default ResponseEntity<?> getPosts() {
        return ResponseEntity.ok(new PostDTO());
    }

    default ResponseEntity<?> addPost(PostDTO postDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
