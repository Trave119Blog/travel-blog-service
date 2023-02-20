package com.travelblog.service.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.travelblog.service.config.RepositoryConfig;
import com.travelblog.service.model.UserInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

@DataMongoTest
@Import(RepositoryConfig.class)
class UserInformationRepositoryTest {

  @Autowired
  private UserInformationRepository userInformationRepository;

  @Test
  void shouldTest() {
    var email = "email";
    var pass = "password";
    var userInfo = UserInformation.builder()
        .email(email)
        .password(pass)
        .build();
    userInformationRepository.save(userInfo);

    var userFoundOpt = userInformationRepository.findById(userInfo.getId());
    assertTrue(userFoundOpt.isPresent());
    var userFound = userFoundOpt.get();
    assertNotNull(userFound.getId());
    assertEquals(userInfo.getId(), userFound.getId());
    assertEquals(email, userFound.getEmail());
    assertEquals(pass, userFound.getPassword());
    assertNotNull(userFound.getCreatedDate());
  }

}
