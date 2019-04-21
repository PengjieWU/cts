package cn.pj.cts.service.impl;

import cn.pj.cts.dao.ProjectTaskInfoRepository;
import cn.pj.cts.entity.ProjectTaskInfoEntity;
import cn.pj.cts.model.ProjectTaskInfoModel;
import cn.pj.cts.service.ProjectTaskInfoService;
import cn.pj.cts.util.IOUtil;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 16:47 2019/3/3
 * @Modify By:
 **/
@Service("projectTaskInfoService")
@Slf4j
public class ProjectTaskInfoServiceImpl implements ProjectTaskInfoService {

    @Autowired
    private ProjectTaskInfoRepository projectTaskInfoRepository;
    @Override
    public ProjectTaskInfoModel addProjectTaskInfo(ProjectTaskInfoModel projectTaskInfoModel) {
        return projectTaskInfoRepository.save(projectTaskInfoModel);
    }

    @Override
    public List<ProjectTaskInfoModel> addBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels) {
        return null;
    }

    @Override
    public int updateProjectTaskInfo(ProjectTaskInfoModel projectTaskInfoModel) {
        return projectTaskInfoRepository.update(projectTaskInfoModel);
    }

    @Override
    public int updateBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels) {
        return 0;
    }

    @Override
    public void deleteProjectTaskInfoById(String projectTaskInfoId) {

    }

    @Override
    public void deleteBacthProjectTaskInfos(List<ProjectTaskInfoModel> projectTaskInfoModels) {

    }

    @Override
    public boolean existsById(String projectTaskInfoId) {
        return false;
    }

    @Override
    public ProjectTaskInfoModel findProjectTaskInfoById(String projectTaskInfoId) {
        return null;
    }

    @Override
    public ProjectTaskInfoModel findByProjectTaskInfoLoginAccount(ProjectTaskInfoModel projectTaskInfoModel) {
        return null;
    }

    @Override
    public List<ProjectTaskInfoModel> findProjectTaskInfosByExample(Example projectTaskInfoModel) {
        return null;
    }

    @Override
    public ProjectTaskInfoModel findProjectTaskInfoListByCurrentdayAndLoginUser(ProjectTaskInfoModel projectTaskInfoModel) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String dateStr = simpleDateFormat.format(date);
        projectTaskInfoModel = projectTaskInfoRepository.findProjectTaskInfosByExample(projectTaskInfoModel.getProjectId(),projectTaskInfoModel.getCreator(),dateStr);
        return Optional.ofNullable(projectTaskInfoModel).orElse(new ProjectTaskInfoModel());
    }

    @Override
    public List<ProjectTaskInfoModel> findTaskInfoByProjectIdAndAllTeam(ProjectTaskInfoEntity projectTaskInfoEntity) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = simpleDateFormat.format(projectTaskInfoEntity.getSelectDay());
        List<ProjectTaskInfoModel> projectTaskInfoModels = new ArrayList<>(8);
        projectTaskInfoModels = projectTaskInfoRepository.findTaskInfoByProjectIdAndAllTeam(projectTaskInfoEntity.getProjectId(),dateStr);
        return Optional.ofNullable(projectTaskInfoModels).orElse(new ArrayList<ProjectTaskInfoModel>());
    }

    @Override
    public void projectTaskAnalyse(ProjectTaskInfoEntity projectTaskInfoEntity, HttpServletResponse response)  throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = simpleDateFormat.format(projectTaskInfoEntity.getSelectDay());
        List<ProjectTaskInfoModel> projectTaskInfoModels = new ArrayList<>(8);
        projectTaskInfoModels = projectTaskInfoRepository.findKeyWordTaskInfo(projectTaskInfoEntity.getProjectId(),dateStr);
        if(!CollectionUtils.isEmpty(projectTaskInfoModels)){
            StringBuffer taskInfoBuffer = new StringBuffer("");
            for(ProjectTaskInfoModel projectTaskInfoModel:projectTaskInfoModels){
                if(!StringUtils.isEmpty(projectTaskInfoModel.getProjectTaskScheduleDoneValue())){
                    taskInfoBuffer.append(projectTaskInfoModel.getProjectTaskScheduleDoneValue());
                }
                if(!StringUtils.isEmpty(projectTaskInfoModel.getProjectTaskScheduleTodoValue())){
                    taskInfoBuffer.append(projectTaskInfoModel.getProjectTaskScheduleDoneValue());
                }
                if(!StringUtils.isEmpty(projectTaskInfoModel.getProjectTaskScheduleProblemValue())){
                    taskInfoBuffer.append(projectTaskInfoModel.getProjectTaskScheduleProblemValue());
                }
            }
            IOUtil.createAndWriteFile(taskInfoBuffer.toString());
            this.wordAnalyse();
            response.setHeader("Content-Type","image/png");
            response.getOutputStream().write(IOUtil.readFile("E:\\paper\\page\\TeamCollaborationSystem\\img\\wordAnalyse.png"));
        }
    }


    @Override
    public void wordAnalyse() throws Exception {
        //建立词频分析器，设置词频，以及词语最短长度，此处的参数配置视情况而定即可
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);

        //引入中文解析器
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
//指定文本文件路径，生成词频集合
        final List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load("E:\\wordAnalyse.txt");
//设置图片分辨率
        Dimension dimension = new Dimension(1920,1080);
//此处的设置采用内置常量即可，生成词云对象
        WordCloud wordCloud = new WordCloud(dimension,CollisionMode.PIXEL_PERFECT);
        //设置边界及字体
        wordCloud.setPadding(2);
        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 20);
//设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setKumoFont(new KumoFont(font));
//设置背景色
        wordCloud.setBackgroundColor(new Color(255,255,255));
//设置背景图片
        //wordCloud.setBackground(new PixelBoundryBackground("E:\\爬虫/google.jpg"));
//设置背景图层为圆形
        wordCloud.setBackground(new CircleBackground(255));
        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
//生成词云
        wordCloud.build(wordFrequencyList);

        String tempPath = "E:\\paper\\page\\TeamCollaborationSystem\\img\\wordAnalyse.png";
        wordCloud.writeToFile(tempPath);
    }
}
