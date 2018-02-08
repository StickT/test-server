package com.benlai.test.repository;

import com.benlai.test.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FieldRepository extends JpaRepository<Field, Long>, JpaSpecificationExecutor<Field> {
}
