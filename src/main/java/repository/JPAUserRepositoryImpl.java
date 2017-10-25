package repository;

import model.User;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import util.NotFoundException;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JPAUserRepositoryImpl extends AbstractDaoImpl<User> implements UserRepository {

    public JPAUserRepositoryImpl() {
        super(User.class);
    }

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }


    @Override
    public User get(Long id) {
        User getUser = em.find(User.class, id);
        if (getUser == null) throw new NotFoundException("User with id " + id + " is not available");
        return getUser;
    }


    @Override
    @Transactional
    public void delete(Long id) {
        if (em.createNamedQuery(User.DELETE)
                .setParameter("id", id)
                .executeUpdate() == 0) throw new NotFoundException("User with id " + id + " is not available");
    }


    @Override
    public List<User> getByFilter(String email, String firstName, String lastName) {
        return em.createNamedQuery(User.BY_FILTER, User.class)
                .setParameter(1, email)
                .setParameter(2, firstName)
                .setParameter(3, lastName)
                .getResultList();

    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.ALL, User.class).getResultList();
    }
}