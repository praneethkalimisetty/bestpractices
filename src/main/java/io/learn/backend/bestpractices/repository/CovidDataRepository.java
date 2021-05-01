package io.learn.backend.bestpractices.repository;

import org.springframework.data.repository.CrudRepository;

import io.learn.backend.bestpractices.bean.Covid;

public interface CovidDataRepository extends CrudRepository<Covid, String> {
     Covid findByStatecode(String statecode);
     int countByRecordInsertedDate(String date);
}
