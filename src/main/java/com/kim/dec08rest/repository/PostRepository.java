package com.kim.dec08rest.repository;

import com.kim.dec08rest.bean.Post;
import com.kim.dec08rest.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
