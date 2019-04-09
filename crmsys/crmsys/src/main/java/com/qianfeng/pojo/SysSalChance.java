package com.qianfeng.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SysSalChance {
    private Integer chcId;

    private String chcSource;

    private String chcCustName;

    private String chcTitle;

    private Double chcRate;

    private String chcLinkman;

    private String chcTel;

    private String chcDesc;

    private Integer chcCreateId;

    private Date chcCreateDate;

    private Integer chcDueId;

    private Date chcDutDate;

    private Integer chcStatus;

    private Integer chcFlag;

    public Integer getChcId() {
        return chcId;
    }

    public void setChcId(Integer chcId) {
        this.chcId = chcId;
    }

    public String getChcSource() {
        return chcSource;
    }

    public void setChcSource(String chcSource) {
        this.chcSource = chcSource == null ? null : chcSource.trim();
    }

    public String getChcCustName() {
        return chcCustName;
    }

    public void setChcCustName(String chcCustName) {
        this.chcCustName = chcCustName == null ? null : chcCustName.trim();
    }

    public String getChcTitle() {
        return chcTitle;
    }

    public void setChcTitle(String chcTitle) {
        this.chcTitle = chcTitle == null ? null : chcTitle.trim();
    }

    public Double getChcRate() {
        return chcRate;
    }

    public void setChcRate(Double chcRate) {
        this.chcRate = chcRate;
    }

    public String getChcLinkman() {
        return chcLinkman;
    }

    public void setChcLinkman(String chcLinkman) {
        this.chcLinkman = chcLinkman == null ? null : chcLinkman.trim();
    }

    public String getChcTel() {
        return chcTel;
    }

    public void setChcTel(String chcTel) {
        this.chcTel = chcTel == null ? null : chcTel.trim();
    }

    public String getChcDesc() {
        return chcDesc;
    }

    public void setChcDesc(String chcDesc) {
        this.chcDesc = chcDesc == null ? null : chcDesc.trim();
    }

    public Integer getChcCreateId() {
        return chcCreateId;
    }

    public void setChcCreateId(Integer chcCreateId) {
        this.chcCreateId = chcCreateId;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date getChcCreateDate() {
        return chcCreateDate;
    }

    public void setChcCreateDate(Date chcCreateDate) {
        this.chcCreateDate = chcCreateDate;
    }

    public Integer getChcDueId() {
        return chcDueId;
    }

    public void setChcDueId(Integer chcDueId) {
        this.chcDueId = chcDueId;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date getChcDutDate() {
        return chcDutDate;
    }

    public void setChcDutDate(Date chcDutDate) {
        this.chcDutDate = chcDutDate;
    }

    public Integer getChcStatus() {
        return chcStatus;
    }

    public void setChcStatus(Integer chcStatus) {
        this.chcStatus = chcStatus;
    }

    public Integer getChcFlag() {
        return chcFlag;
    }

    public void setChcFlag(Integer chcFlag) {
        this.chcFlag = chcFlag;
    }
}