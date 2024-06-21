package com.jg.poms.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	List<Category> findByParentCategory_CategoryIdx(Long categoryIdx);
}
