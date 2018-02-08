package com.benlai.test.repository;

import com.benlai.test.entity.SystemGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by yaoyimin on 2018/2/1
 */
@Repository
public interface GroupRepository extends JpaRepository<SystemGroup, Long> , JpaSpecificationExecutor<SystemGroup> {
}
