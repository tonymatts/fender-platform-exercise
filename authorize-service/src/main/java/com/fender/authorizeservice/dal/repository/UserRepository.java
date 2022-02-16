package com.fender.authorizeservice.dal.repository;

import com.fender.authorizeservice.dal.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    Optional<UserEntity> findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
