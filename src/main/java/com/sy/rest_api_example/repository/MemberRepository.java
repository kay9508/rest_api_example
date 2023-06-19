package com.sy.rest_api_example.repository;

import com.sy.rest_api_example.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserIdAndDelAt(String userId, String delAt);
}