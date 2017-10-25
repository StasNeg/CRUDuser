package repository;


import matcher.BeanMatcher;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.NotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static testData.UserTestData.ADMIN;
import static testData.UserTestData.USER;
import static testData.UserTestData.USER_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JPAUserRepositoryImplTest {

    private static final BeanMatcher<User> MATCHER = new BeanMatcher<>();

    @Autowired
    private UserRepository repository;

    @Test
    public void testSave() throws Exception {
        User newUser = new User(null, "NewName","NewLastName", "new@gmail.com");
        User created = repository.save(newUser);
        newUser.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(USER,ADMIN, newUser), repository.getAll());
    }

    @Test
    public void getAll() throws Exception {
        List<User> all = repository.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(USER, ADMIN), all);
    }

    @Test(expected = DataAccessException.class)
    public void testDuplicateMailSave() throws Exception {
        repository.save(new User(null, "Duplicate", "DuplicateLastName","user@yandex.ru"));
    }

    @Test
    public void testDelete() throws Exception {
        repository.delete((long) USER_ID);
        MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN), repository.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        repository.delete(1L);
    }

    @Test
    public void testGet() throws Exception {
        User user = repository.get((long) USER_ID);
        MATCHER.assertEquals(USER, user);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        repository.get(1L);
    }

    @Test
    public void testGetByFilter() throws Exception {
        List<User> user = repository.getByFilter("user@yandex.ru","","");
        MATCHER.assertCollectionEquals(Collections.singletonList(USER), user);
    }

    @Test
    public void testUpdate() throws Exception {
        User updated = repository.get((long)USER_ID);
        updated.setFirstName("UpdatedName");
        repository.save(updated);
        MATCHER.assertEquals(updated, repository.get((long)USER_ID));
    }
}