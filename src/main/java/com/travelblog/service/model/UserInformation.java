package com.travelblog.service.model;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "user-info")
@Data
@Builder
public class UserInformation {

  @MongoId
  private String id;
  private String email;
  private String password;

  @CreatedDate
  private Instant createdDate;

}
