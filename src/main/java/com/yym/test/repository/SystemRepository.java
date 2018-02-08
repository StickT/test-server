package com.benlai.test.repository;

import com.benlai.test.entity.System;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by yaoyimin on 2018/2/1
 */
@Repository
@Transactional
public interface SystemRepository extends JpaRepository<System, Long > , JpaSpecificationExecutor<System> {

    @Modifying
    @Query(value = "update system s set " +
            "s.name = :name, " +
            "s.env = :env, " +
            "s.basic_url = :basicUrl, " +
            "s.login_url = :loginUrl, " +
            "s.login_type = :loginType, " +
            "s.login_user = :loginUser, " +
            "s.login_password = :loginPassword, " +
            "s.updated_by = :updatedBy, " +
            "s.updated_on = :updatedOn " +
            "where s.id = :id",
            nativeQuery=true)
    int updateSystem(@Param("id") Long id, @Param("name") String name, @Param("env") Integer env, @Param("basicUrl") String basicUrl,
                     @Param("loginUrl") String loginUrl, @Param("loginType") Integer loginType, @Param("loginUser") String loginUser,
                     @Param("loginPassword") String loginPassword, @Param("updatedBy") String updatedBy, @Param("updatedOn") Date updatedOn);
}
