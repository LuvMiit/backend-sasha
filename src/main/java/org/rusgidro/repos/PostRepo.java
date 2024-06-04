package org.rusgidro.repos;

import org.rusgidro.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    Post findByPostName(String postName);
}
