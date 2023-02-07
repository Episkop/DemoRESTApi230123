package test.courses.rest.Servise;

import org.springframework.stereotype.Service;
import test.courses.rest.Entity.UserEntity;
import test.courses.rest.Exceptions.UserAlreadyExistException;
import test.courses.rest.Exceptions.UserBDIsEmpty;
import test.courses.rest.Exceptions.UserNotFoundException;
import test.courses.rest.Model.UserModel;
import test.courses.rest.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiseImpl implements UserServise {
    public final UserRepository userRepository;

    public UserServiseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity registratoin(UserEntity userEntity) throws UserAlreadyExistException {
        if (userRepository.findByUsername(userEntity.getUsername()) != null) {
            throw new UserAlreadyExistException("User have already existed");
        }
        return userRepository.save(userEntity);
    }

    @Override
    public UserModel foundOneUserName(String username) throws UserNotFoundException {
      UserEntity user = userRepository.findByUsername(username);
      if (user == null){
          throw new UserNotFoundException("Users not found!");
      }
        return UserModel.toModel(user);
    }

    @Override
    public UserModel foundOneUsers(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if(id == null){
            throw new UserNotFoundException("Users not found!");
        }
        return UserModel.toModel(user);
    }

    @Override
    public List<UserModel> findAll() throws UserBDIsEmpty {
        List<UserEntity> list = userRepository.findAll();
        List<UserModel> modelList = new ArrayList<>();
        for (UserEntity lists:list) {
            modelList.add(UserModel.toModel(lists));
        }
        if(list.isEmpty()){
            throw new UserBDIsEmpty("Users not found! The DB is empty!");
        }
        return modelList;
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        userRepository.deleteById(id);
    }

}