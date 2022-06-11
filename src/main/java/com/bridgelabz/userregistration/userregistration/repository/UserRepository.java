package com.bridgelabz.userregistration.userregistration.repository;

import com.bridgelabz.userregistration.userregistration.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
}
