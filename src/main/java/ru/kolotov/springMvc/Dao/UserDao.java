package ru.kolotov.springMvc.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kolotov.springMvc.models.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDao implements UserDaoInterface {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<User> index() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void update(int id, User updateUser) {
        User existingUser = em.find(User.class, id);
        if (existingUser != null) {
            existingUser.setName(updateUser.getName());
            existingUser.setAge(updateUser.getAge());
            existingUser.setLastName(updateUser.getLastName());
            em.merge(existingUser);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }
}
