package com.qianfeng.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class VServiceShort {

	 	private Integer serId;

	    private String serType;

	    private String serTitle;

	    private String custName;

	    private String usrCreateName;
	    
	    private Date serCreateDate;

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

		


}
