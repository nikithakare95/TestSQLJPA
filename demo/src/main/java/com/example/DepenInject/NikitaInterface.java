package com.example.DepenInject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NikitaInterface extends JpaRepository<Nikita, Integer> {
	List<Nikita> findByAidGreaterThan(int aid);

	List<Nikita> findByatech(String docker);

	@Query("from  Nikita where atech=?1 order by aid")
	List<Nikita> findByatechSorted(String atech);
}
