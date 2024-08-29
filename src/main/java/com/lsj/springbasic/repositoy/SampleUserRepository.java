package com.lsj.springbasic.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lsj.springbasic.entity.SampleUserEntity;

import java.util.*;

@Repository
public interface SampleUserRepository 

// 레포지토리 만들기
// Hibarnate 구현체 만듦
// <'어떤 테이블 연결할건지', pk 타입>
extends JpaRepository<SampleUserEntity, String> {

    // Query Method:
    // - Repository의 메서드 선언시에 지정된 패턴에 따라 메서드명을 작성하면 JPA가 SQL을 만들어줌
    // findby = select * (테이블명)
    // - findby : '필드명'을 기준으로 컬럼을 모든 컬럼을 조회할 때 사용, findBy 뒤에 필드명을 붙여서 작성, 필드명의 첫글자는 대문자이어야함
   
    // List<받을 Entity명>, 조회 될 기대값이 0~n이므로 List(배열)로 받는다. 
   List<SampleUserEntity> findByName(String name);  // = select * from sample_user where name 
   //조회 될 기대값이 0 or 1이므로 단개(받을 Entity명)로 받는다. (제약조건: notnull unique라서)
   SampleUserEntity findByTelNumber(String telNumber);

   // - And/Or : and 연산 혹은 or 연산에 사용됨, 필드와 필드 사이에 사용
   // or 연산은 무조건 LIst 반환
   // And/Or 의 우선순위 주의
   List<SampleUserEntity> findByNameAndAddress(String name, String address);
    
   // -LIKE, NotLIke,StartinWith, EndingWith, Containing: Like 연산에 대하여 사용, 필드 뒤에 사용
   // like연산도 무조건 List 로 받음
   List<SampleUserEntity> findByAddressContaining(String address);

   // - OrderBy: 정렬을 사용할 필드를 지정하여 DESC 혹은 ASC 지정
   // 이름이 길어서 약어 사용하는 사람들은 적응 어려움
   // 쿼리 메서드 단점: ORM 단점 중 '결합도 증가' 때문에 작은 오타에도 실행이 안된다. (안정성에는 좋음)
   List<SampleUserEntity> findByNameOrderByTelNumberDesc(String name);

   // - existsBy : 조건에 해당하는 레코드가 존재하는지 여부 확인 시 사용
   boolean existsByName(String name);

   // -countBy: 조건에 해당하는 레코드의 개수 확인 시 사용
   int countByName(String name);

   // @Query: 
    // - 쿼리 메서드의 한계를 극복하기 위해 사용하는 방식
    // - 쿼리 메서드가 사용할 수 없는 복잡한 쿼리를 직접 작성하는 방법

    // JPQL (Java Persistence Query Language) 
    // - 표준 SQL과 매우 흡사하지만 Entity 클래스와 Entity 필드로 쿼리를 작성하는 방법
    // u = 전체 = *
    // ?1 = 첫번째 매개변수, ?2 = 두번째 매개변수 (직관적이지 않은 방법)

    @Query(value = "SELECT u FROM user u WHERE u.name = ?1 AND u.address = ?2")
    List<SampleUserEntity> getJpql(String name, String address); 

    @Query(value = "SELECT u FROM user u WHERE u.name = :name AND u.address = :address")
    List<SampleUserEntity> getJpq2(
        @Param("name") String name, 
        @Param("address")String address
        ); 


        // Native SQL: 
        // - 현재 RDBMS의 SQL 문법을 그대로 사용하는 방법
        // -@Query nativeQuery 속성을 반드시 true로 지정
        @Query(value=
        "SELECT * " +
        "FROM sample_user " +
        "WHERE name = :name " +
        " AND address = :address"
        , nativeQuery = true)
        List<SampleUserEntity> getNativeSql(
            @Param("name") String name,
            @Param("address") String address
        );
}


