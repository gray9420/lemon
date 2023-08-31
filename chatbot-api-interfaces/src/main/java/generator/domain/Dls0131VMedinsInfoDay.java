package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName DLS_01_31_V_MEDINS_INFO_DAY
 */
@TableName(value ="DLS_01_31_V_MEDINS_INFO_DAY")
@Data
public class Dls0131VMedinsInfoDay implements Serializable {
    /**
     * 单位成立时间
     */
    private Date estaDate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 拉链开始时间
     */
    private Date startTime;

    /**
     * 拉链结束时间
     */
    private Date endTime;

    /**
     * 机构编码
     */
    private String orgId;

    /**
     * 统一社会信用代码
     */
    private String uscc;

    /**
     * 管理区划代码
     */
    private String mgtAdmdvsCode;

    /**
     * 设置/主办单位代码
     */
    private String setEmpCode;

    /**
     * 医疗机构执业许可证登记号
     */
    private String orgLicense;

    /**
     * 政府办医疗卫生机构隶属关系代码
     */
    private String afilRltsCode;

    /**
     * 单位所在地是否民族自治地方标志
     */
    private String natyFlag;

    /**
     * 是否分支机构
     */
    private String divideOrgFlag;

    /**
     * 是否末级机构
     */
    private String finalOrgFlag;

    /**
     * 上级组织机构ID
     */
    private String prntOrgId;

    /**
     * 上级组织机构代码
     */
    private String prntOrgCode;

    /**
     * 上级机构名称
     */
    private String prntOrgName;

    /**
     * 组织机构代码
     */
    private String orgCode;

    /**
     * 是否有第二名称
     */
    private String orgScdNameFlag;

    /**
     * 机构第二名称
     */
    private String orgScdName;

    /**
     * 地址-省（自治区、直辖市）
     */
    private String addrProv;

    /**
     * 地址-市（地区、州）
     */
    private String addrCity;

    /**
     * 地址-县（区）
     */
    private String addrCoty;

    /**
     * 地址-乡（镇、街道办事处）
     */
    private String addrSubdagcy;

    /**
     * 地址-村（街、路、弄等）
     */
    private String addrVilcm;

    /**
     * 地址-门牌号码
     */
    private String addrHouseNo;

    /**
     * 经度
     */
    private String lnt;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 邮政编码
     */
    private String poscode;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 单位电子邮箱
     */
    private String email;

    /**
     * 单位网站域名
     */
    private String website;

    /**
     * 法人代表（单位负责人）
     */
    private String legent;

    /**
     * 是否单独设立党委
     */
    private String setPtceFlag;

    /**
     * 是否为应急机构
     */
    private String erOrgFlag;

    /**
     * 建造面积
     */
    private String buildArea;

    /**
     * 法人代表（单位负责人）联系电话
     */
    private String legentTel;

    /**
     * 机构状态
     */
    private String orgStas;

    /**
     * 法人代表类别
     */
    private String legentType;

    /**
     * 直管上级
     */
    private String straightSuperiors;

    /**
     * 准确核验等级
     */
    private String exactLv;

    /**
     * 入湖时间戳
     */
    private String lasttime;

    /**
     * 注销原因
     */
    private String cancRea;

    /**
     * 登记注册类型代码
     */
    private String orgLvRegType;

    /**
     * 医疗卫生机构类别代码
     */
    private String orgType;

    /**
     * 机构分类管理代码
     */
    private String orgTypeMgtCode;

    /**
     * 行政区划代码
     */
    private String admdvsCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}