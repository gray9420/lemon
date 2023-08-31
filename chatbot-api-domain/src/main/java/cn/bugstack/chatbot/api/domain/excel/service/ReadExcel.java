package cn.bugstack.chatbot.api.domain.excel.service;

import cn.bugstack.chatbot.api.domain.excel.model.TableInfo;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReadExcel extends AnalysisEventListener<TableInfo>{

    private List<TableInfo> list = new ArrayList<>();

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        super.onException(exception, context);
    }

    @Override
    public void invoke(TableInfo tableInfo, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(tableInfo));
        list.add(tableInfo);
    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        super.extra(extra, context);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return super.hasNext(context);
    }


    public List<TableInfo> getList() {
        return list;
    }
}
