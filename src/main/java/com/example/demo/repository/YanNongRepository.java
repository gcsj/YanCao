package com.example.demo.repository;

import com.example.demo.entity.YanNong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface YanNongRepository extends JpaRepository<YanNong,Long> {

    @Query("select y from YanNong y where y.id in (select max(y.id) from YanNong y group by y.name)")
    List<YanNong> selectDistinctYanNongName();

    @Query("select distinct y from YanNong y where y.name =?1")
    List<YanNong> selectByYanNongName(String name);
}