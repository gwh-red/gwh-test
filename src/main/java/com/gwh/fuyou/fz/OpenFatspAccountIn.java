package com.gwh.fuyou.fz;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author 123
 */
@JacksonXmlRootElement(localName = "xml")
public class OpenFatspAccountIn {
    /**
     * 机构号
     */
    private String mchntCd;
    /**
     * 申请日期
     */
    private String applyDate;
    /**
     * 流水号
     */
    private String traceNo;
    /**
     * 记账户类型
     */
    private String isIndividualMchnt;
    /**
     * 商户名称
     */
    private String insNameCn;
    /**
     * 结算类型
     */
    private String settleTp;
    /**
     * 开户行行号
     */
    private String interBankNo;
    /**
     * 户名
     */
    private String outAcntNm;
    /**
     * 身份证号
     */
    private String outAcntIdNo;
    /**
     * 账号
     */
    private String outAcntNo;
    /**
     * 开户许可证扫描照片
     */
    private String khxkjPic;
    /**
     * 银行卡正面扫描照片
     */
    private String yhkzmPic;
    /**
     * 签名
     */
    private String signature;
    /**
     * 证件类型
     */
    private String flagTp;
    /**
     * 证件名称
     */
    private String certifiNm;
    /**
     * 开办资金
     */
    private String startUpCapital;
    /**
     * 证件代码
     */
    private String licNo;
    /**
     * 有效期
     */
    private String licTov;
    /**
     * 证件扫描照片
     */
    private String licPic1;
    /**
     * 品牌名称
     */
    private String platNameCn;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 联系人
     */
    private String contactPerson;
    /**
     * 联系手机
     */
    private String contactMobile;
    /**
     * 组织机构代码证编号
     */
    private String zzjgdmzNo;
    /**
     * 有效期到期日期
     */
    private String zzjgdmzExpireDt;
    /**
     * 组织机构代码证扫描照片
     */
    private String zzjgdmzPic1;
    /**
     * 法人姓名
     */
    private String artifNm;
    /**
     * 身份证号
     */
    private String certifId;
    /**
     * 有效期至
     */
    private String validDt;
    /**
     * 联系手机
     */
    private String contactPhone;
    /**
     * 证件扫描照片正面
     */
    private String certifIdPic1;
    /**
     * 证件扫描照片反面
     */
    private String certifIdPic2;

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }


    public String getMchntCd() {
        return mchntCd;
    }

    public void setMchntCd(String mchntCd) {
        this.mchntCd = mchntCd;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getIsIndividualMchnt() {
        return isIndividualMchnt;
    }

    public void setIsIndividualMchnt(String isIndividualMchnt) {
        this.isIndividualMchnt = isIndividualMchnt;
    }

    public String getInsNameCn() {
        return insNameCn;
    }

    public void setInsNameCn(String insNameCn) {
        this.insNameCn = insNameCn;
    }

    public String getSettleTp() {
        return settleTp;
    }

    public void setSettleTp(String settleTp) {
        this.settleTp = settleTp;
    }

    public String getInterBankNo() {
        return interBankNo;
    }

    public void setInterBankNo(String interBankNo) {
        this.interBankNo = interBankNo;
    }

    public String getOutAcntNm() {
        return outAcntNm;
    }

    public void setOutAcntNm(String outAcntNm) {
        this.outAcntNm = outAcntNm;
    }

    public String getOutAcntIdNo() {
        return outAcntIdNo;
    }

    public void setOutAcntIdNo(String outAcntIdNo) {
        this.outAcntIdNo = outAcntIdNo;
    }

    public String getOutAcntNo() {
        return outAcntNo;
    }

    public void setOutAcntNo(String outAcntNo) {
        this.outAcntNo = outAcntNo;
    }

    public String getKhxkjPic() {
        return khxkjPic;
    }

    public void setKhxkjPic(String khxkjPic) {
        this.khxkjPic = khxkjPic;
    }

    public String getYhkzmPic() {
        return yhkzmPic;
    }

    public void setYhkzmPic(String yhkzmPic) {
        this.yhkzmPic = yhkzmPic;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getFlagTp() {
        return flagTp;
    }

    public void setFlagTp(String flagTp) {
        this.flagTp = flagTp;
    }

    public String getCertifiNm() {
        return certifiNm;
    }

    public void setCertifiNm(String certifiNm) {
        this.certifiNm = certifiNm;
    }

    public String getStartUpCapital() {
        return startUpCapital;
    }

    public void setStartUpCapital(String startUpCapital) {
        this.startUpCapital = startUpCapital;
    }

    public String getLicNo() {
        return licNo;
    }

    public void setLicNo(String licNo) {
        this.licNo = licNo;
    }

    public String getLicTov() {
        return licTov;
    }

    public void setLicTov(String licTov) {
        this.licTov = licTov;
    }

    public String getLicPic1() {
        return licPic1;
    }

    public void setLicPic1(String licPic1) {
        this.licPic1 = licPic1;
    }

    public String getPlatNameCn() {
        return platNameCn;
    }

    public void setPlatNameCn(String platNameCn) {
        this.platNameCn = platNameCn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getZzjgdmzNo() {
        return zzjgdmzNo;
    }

    public void setZzjgdmzNo(String zzjgdmzNo) {
        this.zzjgdmzNo = zzjgdmzNo;
    }

    public String getZzjgdmzExpireDt() {
        return zzjgdmzExpireDt;
    }

    public void setZzjgdmzExpireDt(String zzjgdmzExpireDt) {
        this.zzjgdmzExpireDt = zzjgdmzExpireDt;
    }

    public String getZzjgdmzPic1() {
        return zzjgdmzPic1;
    }

    public void setZzjgdmzPic1(String zzjgdmzPic1) {
        this.zzjgdmzPic1 = zzjgdmzPic1;
    }

    public String getArtifNm() {
        return artifNm;
    }

    public void setArtifNm(String artifNm) {
        this.artifNm = artifNm;
    }

    public String getCertifId() {
        return certifId;
    }

    public void setCertifId(String certifId) {
        this.certifId = certifId;
    }

    public String getValidDt() {
        return validDt;
    }

    public void setValidDt(String validDt) {
        this.validDt = validDt;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCertifIdPic1() {
        return certifIdPic1;
    }

    public void setCertifIdPic1(String certifIdPic1) {
        this.certifIdPic1 = certifIdPic1;
    }

    public String getCertifIdPic2() {
        return certifIdPic2;
    }

    public void setCertifIdPic2(String certifIdPic2) {
        this.certifIdPic2 = certifIdPic2;
    }


}
