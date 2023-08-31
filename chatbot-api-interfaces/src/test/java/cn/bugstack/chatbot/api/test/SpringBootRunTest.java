package cn.bugstack.chatbot.api.test;

import cn.bugstack.chatbot.api.common.TableDefinition;
import cn.bugstack.chatbot.api.domain.ai.IOpenAI;
import cn.bugstack.chatbot.api.domain.excel.model.HospitalConfigVo;
import cn.bugstack.chatbot.api.domain.excel.model.TableInfo;
import cn.bugstack.chatbot.api.domain.excel.service.ReadExcel;
import cn.bugstack.chatbot.api.domain.zsxq.IZsxqApi;
import cn.bugstack.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import cn.bugstack.chatbot.api.domain.zsxq.model.vo.Topics;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import generator.service.Dls0131VMedinsInfoDayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.group01.groupId}")
    private String groupId;
    @Value("${chatbot-api.group01.cookie}")
    private String cookie;
    @Value("${chatbot-api.group01.openAiKey}")
    private String openAiKey;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;


    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId：{} text：{}", topicId, text);

            // 回答问题
            zsxqApi.answer(groupId, cookie, topicId, openAI.doChatGPT(openAiKey, text), false);
        }
    }

    @Test
    public void test_openAi() throws IOException {
        String response = openAI.doChatGPT(openAiKey, "帮我写一个java冒泡排序");
        logger.info("测试结果：{}", response);
    }

    @Test
    public void test_readExcel(){

        String excelPath = "D:/桌面/院内标准数据集接口结构文档.xlsx";
        String tableName = "门诊处方记录";

        List<TableDefinition> definitions = readExcel(excelPath,tableName);
        String sql = generateSQL(definitions, tableName);
        logger.info(sql);

    }

    public List<TableDefinition> readExcel(String fileName,String sheetName) {
        List<TableDefinition> list = new ArrayList<>();
        EasyExcel.read(fileName, TableDefinition.class, new AnalysisEventListener<TableDefinition>() {
            @Override
            public void invoke(TableDefinition data, AnalysisContext context) {
                list.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
            }
        }).sheet(sheetName).doRead();
        return list;
    }

    public String generateSQL(List<TableDefinition> definitions, String tableName) {
        StringBuilder sql = new StringBuilder("CREATE TABLE ");
        sql.append(tableName).append(" (\n");
        for (TableDefinition def : definitions) {
            sql.append(def.getFieldName()).append(" ").append(def.getType()).append(" COMMENT '").append(def.getComment()).append("',\n");
        }
        sql.deleteCharAt(sql.length() - 2); // remove the last comma
        sql.append(");");
        return sql.toString();
    }


    @Test
    public void test_writeExcel(){
        List<HospitalConfigVo> hospitalConfigVos = new ArrayList<>();
        HospitalConfigVo hospitalConfigVo = new HospitalConfigVo();
        hospitalConfigVo.setOrganizationCode("420031231232");
        hospitalConfigVo.setName("xxx卫生院");
        hospitalConfigVo.setOrgType("MEDICAL");
        hospitalConfigVo.setOrgLevel("TOWN");
        hospitalConfigVo.setProvince("湖北");
        hospitalConfigVo.setCity("十堰市");
        hospitalConfigVo.setCounty("郧西县");
        hospitalConfigVo.setTown("大撒大撒");
        hospitalConfigVo.setAddress("");
        hospitalConfigVo.setUpperHospital("卫健委");
        hospitalConfigVos.add(hospitalConfigVo);
        // 指定本地文件路径
        String fileName = "D:/桌面/智杰机构信息"+System.currentTimeMillis()+".xlsx";
        EasyExcel.write(fileName, HospitalConfigVo.class).sheet("机构信息").doWrite(hospitalConfigVos);

    }


}
