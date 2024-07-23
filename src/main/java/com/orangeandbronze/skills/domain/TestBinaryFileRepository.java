package com.orangeandbronze.skills.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBinaryFileRepository extends JpaRepository<BinaryFile, String> {
}
