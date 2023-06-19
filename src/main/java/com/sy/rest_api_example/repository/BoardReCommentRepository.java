package com.sy.rest_api_example.repository;

import com.sy.rest_api_example.entity.BoardReComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardReCommentRepository extends JpaRepository<BoardReComment, Long> {
}