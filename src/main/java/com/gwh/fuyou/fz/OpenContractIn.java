package com.gwh.fuyou.fz;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @author 123
 */
@JacksonXmlRootElement(localName = "xml")
@Data
public class OpenContractIn {

    /**
     * 机构号
     */
    private String mchntCd;
    /**
     * 入账方编码
     */
    private String accountIn;

    /**
     * 合同名称
     */
    private String contractName;

    /**
     * 合同路径
     */
    private String contractUrl;


    /**
     * 开始时间
     */
    private String startDate;


    /**
     * 结束时间
     */
    private String endDate;

    /**
     * 流水号
     */
    private String traceNo;

    /**
     * 签名
     */
    private String signature;

}
