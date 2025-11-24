package com.burakcanaksoy.developercamp.dataAccess.abstracts;

import com.burakcanaksoy.developercamp.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
