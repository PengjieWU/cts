package cn.pj.cts.dao;

import cn.pj.cts.model.ProjectModel;
import cn.pj.cts.model.ProjectStoryResourceInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:52 2019/3/3
 * @Modify By:
 **/
@Repository
public interface ProjectStoryResourceInfoRepository extends JpaRepository<ProjectStoryResourceInfoModel,String> {
}
