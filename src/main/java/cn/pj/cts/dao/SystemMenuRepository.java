package cn.pj.cts.dao;

import cn.pj.cts.model.SystemMenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 20:33 2019/4/14
 * @Modify By:
 **/
@Repository
public interface SystemMenuRepository extends JpaRepository<SystemMenuModel,String> {

}
