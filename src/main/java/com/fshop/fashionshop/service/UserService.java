package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User getById(String id);

    User getByIdForSingUp(String id);

    List<User> getAll();

    void delete(String id);
}
