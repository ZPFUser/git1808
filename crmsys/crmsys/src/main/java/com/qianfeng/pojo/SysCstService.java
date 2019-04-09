package com.qianfeng.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SysCstService {
    private Integer serId;

    private String serType;

    private String serTitle;

    private Integer serCustNo;

    private String serStatus;

    private String serRequest;

    private Integer serCreateId;

    private Date serCreateDate;

    private Integer serDueId;

    private Date serDueDate;

    private String serDeal;

    private Date serDealDate;

    private String serResult;

    private Integer serSatisfy;

    private Integer serFlag;

    public Integer getSerId() {
        return serId;
    }

    public void setSerId(Integer serId) {
        this.serId = serId;
    }

    public String getSerType() {
        return serType;
    }

    public void setSerType(String serType) {
        this.serType = serType == null ? null : serType.trim();
    }

    public String getSerTitle() {
        return serTitle;
    }

    public void setSerTitle(String serTitle) {
        this.serTitle = serTitle == null ? null : serTitle.trim();
    }

    public Integer getSerCustNo() {
        return serCustNo;
    }

    public void setSerCustNo(Integer serCustNo) {
        this.serCustNo = serCustNo;
    }

    public String getSerStatus() {
        return serStatus;
    }

    public void setSerStatus(String serStatus) {
        this.serStatus = serStatus == null ? null : serStatus.trim();
    }

    public String getSerRequest() {
        return serRequest;
    }

    public void setSerRequest(String serRequest) {
        this.serRequest = serRequest == null ? null : serRequest.trim();
    }

    public Integer getSerCreateId() {
        return serCreateId;
    }

    public void setSerCreateId(Integer serCreateId) {
        this.serCreateId = serCreateId;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date getSerCreateDate() {
        return serCreateDate;
    }

    public void setSerCreateDate(Date serCreateDate) {
        this.serCreateDate = serCreateDate;
    }

    public Integer getSerDueId() {
        return serDueId;
    }

    public void setSerDueId(Integer serDueId) {
        this.serDueId = serDueId;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date getSerDueDate() {
        return serDueDate;
    }

    public void setSerDueDate(Date serDueDate) {
        this.serDueDate = serDueDate;
    }

    public String getSerDeal() {
        return serDeal;
    }

    public void setSerDeal(String serDeal) {
        this.serDeal = serDeal == null ? null : serDeal.trim();
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date getSerDealDate() {
        return serDealDate;
    }

    
    public void setSerDealDate(Date serDealDate) {
        this.serDealDate = serDealDate;
    }

    public String getSerResult() {
        return serResult;
    }

    public void setSerResult(String serResult) {
        this.serResult = serResult == null ? null : serResult.trim();
    }

    public Integer getSerSatisfy() {
        return serSatisfy;
    }

    public void setSerSatisfy(Integer serSatisfy) {
        this.serSatisfy = serSatisfy;
    }

    public Integer getSerFlag() {
        return serFlag;
    }

    public void setSerFlag(Integer serFlag) {
        this.serFlag = serFlag;
    }
}