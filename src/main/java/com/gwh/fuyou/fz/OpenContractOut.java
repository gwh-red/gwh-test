package com.gwh.fuyou.fz;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @author 123
 */
@JacksonXmlRootElement(localName = "xml")
@Data
public class OpenContractOut {

    /**
     * 机构号
     */
    private String mchntCd;


    /**
     * 分账合同编号
     */
    private String contractSsn;


    /**
     * 流水号
     */
    private String traceNo;

    private String respCode;
    private String respDesc;

    /**
     * 签名
     */
    private String signature;

}
