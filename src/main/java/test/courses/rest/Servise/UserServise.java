package test.courses.rest.Servise;

import test.courses.rest.Entity.UserEntity;
import test.courses.rest.Exceptions.UserAlreadyExistException;
import test.courses.rest.Exceptions.UserBDIsEmpty;
import test.courses.rest.Exceptions.UserNotFoundException;
import test.courses.rest.Model.UserModel;

import java.util.List;

public interface UserServise {
    public UserEntity registratoin(UserEntity userEntity) throws UserAlreadyExistException;
    public UserModel foundOneUserName(String username) throws UserNotFoundException;
    public UserModel foundOneUsers(Long id) throws UserNotFoundException;
    public List<UserModel> findAll() throws UserBDIsEmpty;
    public void deleteUser(Long id) throws UserNotFoundException;
}
