package test.courses.rest.Servise;

import org.springframework.stereotype.Service;
import test.courses.rest.Entity.ToDoEntity;
import test.courses.rest.Entity.UserEntity;
import test.courses.rest.Model.TodoModel;
import test.courses.rest.Repository.ToDoRepository;
import test.courses.rest.Repository.UserRepository;

@Service
public class ToDoServiceImpl implements ToDoService{

    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository, UserRepository userRepository) {
        this.toDoRepository = toDoRepository;
        this.userRepository = userRepository;
    }
// создаем новую задачу. Находим клиента по id и todoentity добавляем клиента. сохраняем todoEntity.
    @Override
    public TodoModel createToDo(ToDoEntity toDo, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        toDo.setUserEntity(user);
        return TodoModel.toModel(toDoRepository.save(toDo));
    }

    @Override
    public TodoModel completed(Long id) {
        ToDoEntity toDo = toDoRepository.findById(id).get();
        toDo.setCompleted(!toDo.getCompleted());
        return TodoModel.toModel(toDoRepository.save(toDo));
    }
}
