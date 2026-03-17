package com.animatch.animatch.Repository;

import com.animatch.animatch.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}
