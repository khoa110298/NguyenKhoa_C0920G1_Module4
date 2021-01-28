package vn.codegym.service;

import vn.codegym.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
