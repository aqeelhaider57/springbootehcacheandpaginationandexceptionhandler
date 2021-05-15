package com.cache.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cache.model.Student;

@Repository("repositoryStudent")
public interface RepositoryStudent extends JpaRepository<Student, Integer> {
	
	
	@Query("select s from Student s where email =:email")
	//@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	public Student findByEmail(@Param("email")String email);
	
	@Query(name = "select * from student s where s.zip_code =:zipcode", nativeQuery = true )
	//@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	public List<Student> findByZipCode(@Param("zipcode")String zipcode);
	
	//mysql native query
	@Query(value = "SELECT * FROM student", nativeQuery = true )
	//@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	public List<Student> getAll();
	
	
	@Query(value = "SELECT COUNT(*) FROM Student s WHERE s.name LIKE %:searchKeyword%")
	Integer predictiveSearchCount(@Param("searchKeyword") String searchKeyword);

	@Query(value = "SELECT s FROM Student s WHERE s.name LIKE %:searchKeyword%")
	List<Student> predictiveSearchWithPagination(@Param("searchKeyword") String searchKeyword, Pageable pageable);


	@Query(value = "SELECT s FROM Student s WHERE s.name LIKE %:searchKeyword%")
	List<Student> predictiveSearch(@Param("searchKeyword") String searchKeyword);
	
	@Query("select s from Student s where s.name =:name")
	public Page<Student> findByNameSearch(@Param("name")String name, Pageable pageable);

//	@Query(value = "SELECT COUNT(s) FROM student s WHERE s.isDeleted = false AND s.studentTypeId LIKE %:searchKeyword% OR s.description LIKE %:searchKeyword% OR s.descriptionArabic LIKE %:searchKeyword%")
//	Integer predictiveSearchCount(@Param("searchKeyword") String searchKeyword);
//
//	@Query(value = "SELECT s FROM student s WHERE s.isDeleted = false AND s.studentTypeId LIKE %:searchKeyword% OR s.description LIKE %:searchKeyword% OR s.descriptionArabic LIKE %:searchKeyword%")
//	List<Student> predictiveSearchWithPagination(@Param("searchKeyword") String searchKeyword,
//			@Param("pageable") Pageable pageable);
//
//	@Query(value = "SELECT s FROM student s WHERE s.isDeleted = false AND s.studentTypeId LIKE %:searchKeyword% OR s.description LIKE %:searchKeyword% OR s.descriptionArabic LIKE %:searchKeyword%")
//	List<Student> predictiveSearch(@Param("searchKeyword") String searchKeyword);	

}
