package com.example.dao;

import com.example.dto.UserDto;

import java.util.*;

public class UserDaoImpl implements Dao<UserDto> {

    private List<UserDto> users;

    private UserDaoImpl(){
        users = new ArrayList<>();
        users.add(new UserDto("Brown", "John"));
        users.add(new UserDto("Berkley", "Susan"));
    }

    private static class SingletonHelper{
        private static final UserDaoImpl INSTANCE = new UserDaoImpl();
    }

    public static UserDaoImpl getInstance(){
        return SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<UserDto> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<UserDto> getAll() {
        return users;
    }

    @Override
    public void save(UserDto user) {
        users.add(user);
    }


    @Override
    public void update(UserDto user, String[] params) {
        user.setLastName(Objects.requireNonNull(
                params[0], "Last Name cannot be null"));
        user.setFirstName(Objects.requireNonNull(
                params[1], "First name cannot be null"));

        users.add(user);
    }

    @Override
    public void delete(UserDto user) {
        users.remove(user);
    }
}