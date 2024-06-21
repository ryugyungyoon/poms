package com.jg.poms.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//findByMemberEntity_MemberId(Long id);
	//List<Category> findByCategory_ParentIdx(Long categoryIdx);
	List<Category> findByParentCategory_CategoryIdx(Long categoryIdx);
}
