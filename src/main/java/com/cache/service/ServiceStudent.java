package com.cache.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cache.dto.DtoSearch;
import com.cache.dto.DtoStudent;
import com.cache.exception.NoDataFoundException;
import com.cache.model.Student;
import com.cache.repository.RepositoryStudent;


@Service("serviceStudent")
public class ServiceStudent {
	
	@Autowired
	private RepositoryStudent repositoryStudent;
	
	private DtoStudent dtoStudent;
	
	@CachePut(key = "#student")
	//@CachePut(value ="studentCache" , = "#student")
	public boolean create(DtoStudent dtoStudent1) {
		if(dtoStudent1 != null) {
			repositoryStudent.save(dtoStudent.mapDtoStudentToEntity(dtoStudent1));
			return true;
		}else {
			return false;
		}
	}
	
	//@Cacheable
	@Cacheable("studentCache")
	public List<DtoStudent> getAll(){
		List<Student> list = repositoryStudent.getAll();
		List<DtoStudent> dtoStudentList = new ArrayList<DtoStudent>();
		list.stream().forEach(studnt -> dtoStudentList.add(new DtoStudent(studnt)));
		return dtoStudentList;
	}
	
	
	
	//@Cacheable
	@Cacheable("studentCache")
	public List<DtoStudent> findAll(){
		List<Student> list = repositoryStudent.findAll();
		List<DtoStudent> dtoStudentList = new ArrayList<DtoStudent>();
		list.stream().forEach(studnt -> dtoStudentList.add(new DtoStudent(studnt)));
		return dtoStudentList;
	}
	
	//@CacheEvict(allEntries = true)
	@CacheEvict(value = "studentCache", allEntries = true)
	public boolean delelteStudent(DtoStudent dtoStudent) {
		boolean result = false;
		
		if(dtoStudent.getStudentId() != null) {
			try {
				repositoryStudent.deleteById(dtoStudent.getStudentId());
				result = true;
			} catch (Exception e) {
				throw new NoDataFoundException();
			}
			}else {
				result = false;
			}
		return result;
	}
	
	//@CacheEvict(allEntries = true)
	@CacheEvict(value = "studentCache", allEntries = true)
	public void refresh() {
		
	}
	
	//pagination search
	//@Cacheable("studentCache")
	public DtoSearch searchAll(DtoSearch dtoSearch) {
		
		dtoSearch.setTotalCount(repositoryStudent.predictiveSearchCount(dtoSearch.getSearchKeyword()));
		
		List<Student> students = null;
		List<DtoStudent> dtoStudents = new ArrayList<DtoStudent>();
		
		if (dtoSearch.getPageNumber() != null && dtoSearch.getPageSize() != null) {
			Pageable pageable = PageRequest.of(dtoSearch.getPageNumber(), dtoSearch.getPageSize(), Sort.Direction.DESC,
					"name");
			students = repositoryStudent.predictiveSearchWithPagination(dtoSearch.getSearchKeyword(), pageable);
		} else {
			students = repositoryStudent.predictiveSearch(dtoSearch.getSearchKeyword());
		}
		
		if(students != null && !students.isEmpty()) {
			students.stream().forEach(studnts -> dtoStudents.add(new DtoStudent(studnts)));
		}
		
		dtoSearch.setRecords(dtoStudents);
		
		return dtoSearch;
	}
	
	//pagination search
	//@Cacheable("studentCache")
	public DtoSearch search(DtoSearch dtoSearch) {
		
		List<Student> students = new ArrayList<>();
		Pageable pageable = PageRequest.of(0, 2);
		Page<Student> page = this.repositoryStudent.findByNameSearch(dtoSearch.getSearchKeyword(), pageable);
		dtoSearch.setRecords(page);
		return dtoSearch;
		
	}

}
