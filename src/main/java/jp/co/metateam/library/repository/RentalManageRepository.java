package jp.co.metateam.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.metateam.library.model.RentalManage;
import java.util.List;

@Repository
public interface RentalManageRepository extends JpaRepository<RentalManage, Long>{
    List<RentalManage> findAll();

}
