package com.zhixi.domain;
	import java.io.Serializable;
	import java.util.Date;
       public class User implements Serializable{
		private static final long serialVersionUID = 1L;
		private Integer id;
		private String name;
		private String pass;
		private Date loginTime;
		public User() {
			super();
		}
		public User(String name, String pass, Date loginTime) {
			super();
			this.name = name;
			this.pass = pass;
			this.loginTime = loginTime;
		}
		public User(Integer id, String name, String pass, Date loginTime) {
			super();
			this.id = id;
			this.name = name;
			this.pass = pass;
			this.loginTime = loginTime;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public Date getLoginTime() {
			return loginTime;
		}
		public void setLoginTime(Date loginTime) {
			this.loginTime = loginTime;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", loginTime=" + loginTime + ", name=" + name
					+ ", pass=" + pass + "]";
		}
		
		
	}

