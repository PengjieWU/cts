package cn.pj.cts.dao;

import cn.pj.cts.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 23:46 2019/1/17
 * @Modify By:
 **/
@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {

}
