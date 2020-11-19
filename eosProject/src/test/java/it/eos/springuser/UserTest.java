package it.eos.springuser;

import it.eos.springuser.business.UserConverter;
import it.eos.springuser.model.UserEntity;
import it.eos.springuser.model.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    UserModel user1;

    @Test
    void convertBidirectionalModelEntity() {
        user1.setMail("Mail");
        user1.setPassword("Password");
        user1.setName("Name");

        UserEntity entity = UserConverter.toEntity(user1);
        UserModel convertedFromEntity = UserConverter.toModel(entity);

        Assertions.assertEquals(convertedFromEntity, user1);
    }
}
