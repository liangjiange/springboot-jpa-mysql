package com.liangjiange.sample.repository;

import com.liangjiange.sample.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{



}
