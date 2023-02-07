package test.courses.rest.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;
    /*
    Теперь вы можете использовать JsonIgnoreProperties для подавления сериализации свойств (во время сериализации)
     или игнорировать обработку чтения свойств JSON (во время десериализации) . Если это не то, что вы ищете,
     продолжайте читать ниже.
        JsonManagedReference и JsonBackReference
    Начиная с версии Jackson 1.6 вы можете использовать две аннотации для решения проблемы бесконечной рекурсии,
     не игнорируя геттеры/сеттеры во время сериализации: @JsonManagedReferenceи @JsonBackReference.
    Чтобы Джексон работал хорошо, одна из двух сторон отношения не должна быть сериализована, чтобы избежать бесконечного цикла,
     который вызывает ошибку переполнения стека.
    Итак, Джексон берет прямую часть ссылки (ваш Set<BodyStat> bodyStatsкласс Trainee) и преобразует ее в формат хранения,
     подобный json; это так называемый процесс сортировки . Затем Джексон ищет заднюю часть ссылки
     (т.е. Trainee traineeв классе BodyStat) и оставляет ее как есть, не сериализуя ее.
     Эта часть отношения будет перестроена во время десериализации ( разупорядочения ) прямой ссылки.
       */
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonBackReference
//    @JsonManagedReference
    private List<ToDoEntity> list = new ArrayList<>();


}
