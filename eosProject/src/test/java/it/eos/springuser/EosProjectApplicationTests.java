package it.eos.springuser;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.client.ExpectedCount;
import org.junit.jupiter.api.Assertions;

class EosProjectApplicationTests {

	@Test
	void contextLoads() {
		String t = "test@mail.com";
		
		Assertions.assertTrue(t.contains("@"));
	}
	
	@Test
	void contextEqual() {
		String n = "new@mail.it";
		
		Assertions.assertEquals("new@mail.it", n);
	}

	@Test
	void contextFalse() {
		String f = "Mario Rossi";
		
		Assertions.assertFalse(f.contains("@"));
	}

	@Test
	void convertToModel(){
		UserEntity userEntity = new UserEntity;
		userEntity.setMail("Mail");
		userEntity.setPassword("Password");
		userEntity.setName("Name");

		User user = UserConverter.toUserModel(userEntity);

		Assertion.assertEquals(userEntity.getMail(), user.getMail());
		Assertion.assertEquals(userEntity.getPassword(), user.getPassword());
		Assertion.assertEquals(userEntity.getName(), user.getName());
	}

	@Test
	void convertToEntity(){
		User user = new user();
		user.setMail("Mail");
		user.setPassword("Password");
		user.setName("Name");

		String s1 = user.toString();
		String s2 = s1subString(s1.indexDf("{"));
		String converted = UserConverter.toUserEntity(user).toString();
		String converted2 = converted.subString(converted.indexDf({));

		Assertion.assertEquals(s2, converted2)
	}

		@Test
		void convertBidirectionalModelEntity(){
			User user1 = new user();
			user.setMail("Mail");
			user.setPassword("Password");
			user.setName("Name");

			UserEntity entity = UserConverter.toUserEntity(user);
			User convertedFromEntity = UserConverter.toUserModel(entity);

			Assertions.assertEquals(convertedFromEntity, user);
}
