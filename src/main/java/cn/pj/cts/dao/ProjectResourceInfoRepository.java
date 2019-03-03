package cn.pj.cts.dao;

import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.model.ProjectResourceInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:49 2019/3/3
 * @Modify By:
 **/
@Repository
public interface ProjectResourceInfoRepository extends JpaRepository<ProjectResourceInfoModel,String> {
}
