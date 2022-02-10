package az.iktex.projectsecurity.entities;

import lombok.*;
import javax.persistence.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Comment")
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}
