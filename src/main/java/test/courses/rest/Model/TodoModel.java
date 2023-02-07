package test.courses.rest.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.courses.rest.Entity.ToDoEntity;

@Getter
@Setter
@NoArgsConstructor
public class TodoModel {

    private Long id;
    private String title;
    private Boolean completed;

    public static TodoModel toModel(ToDoEntity entity){
        TodoModel model = new TodoModel();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setCompleted(entity.getCompleted());
        return model;
    }


}
