package cn.bugstack.chatbot.api.domain.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class TableInfo {

    @ExcelProperty(value = "表名描述", index = 0)
    private String nameDesc;

    @ExcelProperty(value = "表名", index = 1)
    private String name;

}
