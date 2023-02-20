package com.travelblog.service.repository;

import com.travelblog.service.model.UserInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends CrudRepository<UserInformation, String> {

}
