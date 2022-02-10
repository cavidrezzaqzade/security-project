package az.iktex.projectsecurity.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

/**
 * @author Cavid R.
 */

@RestController
@RequestMapping("/admin")
public class PostApiController implements PostApi {

    private final PostApiDelegate delegate;

    public PostApiController(@Autowired(required = false) PostApiDelegate delegate) {
                this.delegate = Optional.ofNullable(delegate).orElse(new PostApiDelegate() {});
     }

    @Override
    public PostApiDelegate getDelegate() {
        return delegate;
    }

}
