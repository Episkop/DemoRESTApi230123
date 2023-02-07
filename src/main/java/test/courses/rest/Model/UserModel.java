package test.courses.rest.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.courses.rest.Entity.ToDoEntity;
import test.courses.rest.Entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {

    private Long id;
    private String username;
    private List<TodoModel> todos;
    public static UserModel toModel(UserEntity userEntity){
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setUsername(userEntity.getUsername());
        userModel.setTodos(userEntity.getList().stream().map(TodoModel::toModel).collect(Collectors.toList()));
        return userModel;
    }
}
