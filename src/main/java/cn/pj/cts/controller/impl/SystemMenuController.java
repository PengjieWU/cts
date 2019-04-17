package cn.pj.cts.controller.impl;

import cn.pj.cts.common.Response;
import cn.pj.cts.dao.SystemMenuRepository;
import cn.pj.cts.model.SystemMenuModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 23:12 2019/4/14
 * @Modify By:
 **/
@Component
@RestController
@Slf4j
@RequestMapping("systemMenu")
public class SystemMenuController {

    @Autowired
    private SystemMenuRepository systemMenuRepository;

    @GetMapping("getSystemMenu.action")
    public Response getSystemMenu(){
        List<SystemMenuModel> systemMenuModels = systemMenuRepository.findAll();
        return new Response(systemMenuModels);
    }
}
