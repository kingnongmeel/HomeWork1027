package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MenuRepository extends JpaRepository<Menu, Integer> {

    // 전달 받은 menuPrice보다 큰 menuPrice를 가진 메뉴 목록 조회
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice);

    // 전달 받은 menuPrice보다 큰 menuPrice를 가진 메뉴 목록을 메뉴 가격 오름차순으로 조회
    List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(Integer menuPrice);

    // 전달 받은 menuPrice보다 큰 menuPrice를 가진 메뉴 목록을 메뉴 가격 내림차순으로 조회 (sort)
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice, Sort sort);

    @Query(value = "SELECT m FROM Menu m WHERE m.menuName = :menuName")
    public Menu findByMenuName(@Param("menuName") String input1);

    @Query(value = "SELECT m FROM Menu m")
    public List<Menu> findMenuList();

    List<Menu> findAll();
}
