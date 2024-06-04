package org.rusgidro.repos;

import org.rusgidro.entity.IndexType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexTypeRepo extends JpaRepository<IndexType, Long> {
    IndexType findByIndexName(String name);
}
