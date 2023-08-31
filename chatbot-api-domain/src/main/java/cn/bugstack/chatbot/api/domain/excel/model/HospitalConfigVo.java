package cn.bugstack.chatbot.api.domain.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: yuxuecheng
 * @title: HospitalConfigVo
 * @projectName: xl-manage
 * @description: Excel导入医疗机构配置数据实体类 引用cms的实体类，随版本更新
 * @date 2022/9/27 14:02
 */
@Data
public class HospitalConfigVo {

    /**
     * 组织机构码
     */
    @ExcelProperty(value = "组织机构码")
    private String organizationCode;

    /**
     * 机构名称
     */
    @ExcelProperty(value = "机构名称")
    private String name;

    /**
     * 机构类别
     */
    @ExcelProperty(value = "机构类别")
    private String orgType;

    /**
     * 机构等级
     */
    @ExcelProperty(value = "机构等级")
    private String orgLevel;

    /**
     * 省
     */
    @ExcelProperty(value = "省")
    private String province;

    /**
     * 市
     */
    @ExcelProperty(value = "市")
    private String city;

    /**
     * 区/县
     */
    @ExcelProperty(value = "区/县")
    private String county;

    /**
     * 乡镇/街道
     */
    @ExcelProperty(value = "乡镇/街道")
    private String town;

    /**
     * 地址
     */
    @ExcelProperty(value = "地址")
    private String address;

    /**
     * 上级机构
     */
    @ExcelProperty(value = "上级机构")
    private String upperHospital;
}
