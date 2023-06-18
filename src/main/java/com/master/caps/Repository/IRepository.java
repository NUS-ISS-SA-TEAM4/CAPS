package com.master.caps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository<T> extends JpaRepository<T, Integer> {

}
