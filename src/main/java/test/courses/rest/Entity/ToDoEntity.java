package test.courses.rest.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private Boolean completed;
//     должны использовать @JsonBackReference с сущностью @ManyToOne и
//        @JsonManagedReference с @onetomany, содержащей классы сущностей.
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    @JsonManagedReference
//    @JsonBackReference   https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion хорошая статья!!!
    private UserEntity userEntity;


}
