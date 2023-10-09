package com.gwh.fuyou.fz;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author 123
 */
@JacksonXmlRootElement(localName = "xml")
public class OpenFatspAccountOut {
    private String traceNo;
    private String mchntCd;
    private String accountIn;
    private String respCode;
    private String respDesc;
    private String signature;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getMchntCd() {
        return mchntCd;
    }

    public void setMchntCd(String mchntCd) {
        this.mchntCd = mchntCd;
    }

    public String getAccountIn() {
        return accountIn;
    }

    public void setAccountIn(String accountIn) {
        this.accountIn = accountIn;
    }

    public void setResp(String respCode, String respDesc) {
        setRespCode(respCode);
        setRespDesc(respDesc);
    }

    @Override
    public String toString() {
        return "OpenFatspAccountOut{" +
                "traceNo='" + traceNo + '\'' +
                ", mchntCd='" + mchntCd + '\'' +
                ", accountIn='" + accountIn + '\'' +
                ", respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
