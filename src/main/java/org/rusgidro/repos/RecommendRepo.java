package org.rusgidro.repos;

import org.rusgidro.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendRepo extends JpaRepository<Recommend, Long> {
}
