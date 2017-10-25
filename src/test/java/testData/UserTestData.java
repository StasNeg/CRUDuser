package testData;


import model.User;
import static model.User.START_SEQ;


public class UserTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User((long)USER_ID, "UserName", "UserLastName", "user@yandex.ru");
    public static final User ADMIN = new User((long)ADMIN_ID, "AdminName", "AdminLastName","admin@gmail.com");

}
