/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.exoBootOnKubernetes.repository;

import com.example.exoBootOnKubernetes.student.Student;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author n.valeriano
 */
@RepositoryRestResource(collectionResourceRel = "students", path = "students")
public interface StudentRepository extends PagingAndSortingRepository<Student, Long>{
    
    List<Student> findByName(String name);
    List<Student> findByNameAndFamily(String name, String family);
    
}
