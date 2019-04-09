package com.qianfeng.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class VService {

	 private Integer serId;

	    private String serType;

	    private String serTitle;

	    private String custName;

	    private String serStatus;

	    private String serRequest;

	    private String usrCreateName;

	    private Date serCreateDate;

	    private String usrDueName;

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
			this.serType = serType;
		}

		public String getSerTitle() {
			return serTitle;
		}

		public void setSerTitle(String serTitle) {
			this.serTitle = serTitle;
		}

		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}

		public String getSerStatus() {
			return serStatus;
		}

		public void setSerStatus(String serStatus) {
			this.serStatus = serStatus;
		}

		public String getSerRequest() {
			return serRequest;
		}

		public void setSerRequest(String serRequest) {
			this.serRequest = serRequest;
		}

		public String getUsrCreateName() {
			return usrCreateName;
		}

		public void setUsrCreateName(String usrCreateName) {
			this.usrCreateName = usrCreateName;
		}

		 @DateTimeFormat(pattern="yyyy-MM-dd")
		public Date getSerCreateDate() {
			return serCreateDate;
		}

		public void setSerCreateDate(Date serCreateDate) {
			this.serCreateDate = serCreateDate;
		}

		public String getUsrDueName() {
			return usrDueName;
		}

		public void setUsrDueName(String usrDueName) {
			this.usrDueName = usrDueName;
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
			this.serDeal = serDeal;
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
			this.serResult = serResult;
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
