package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void add (User user);
    public void update (long id, String newName, String newLastName);
    public void delete (long id);
    public User get (long id);
    public List<User> getAll ();
}
