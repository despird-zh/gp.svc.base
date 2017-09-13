/*
 * Licensed to the G.Obal under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  G.Obal licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 */
package com.gp.common;

import java.io.Serializable;
import java.security.Principal;
import java.text.DateFormat;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.gp.info.InfoId;

/**
 * Keep the principal info of user, this class is not defined like normal bean
 * It uses EntityEntry to R/W the attributes. 
 * <p>The EntryParser be used to communicate with EntityEntry</p>
 * 
 * @author despird
 * @version 1.0 2014-01-01
 *
 **/
public class GPrincipal implements Principal, Serializable{
		
	private static final long serialVersionUID = 5413765750513254954L;

	/** the entity id */
	private InfoId<Long> userId;
	
	private Integer sourceId;
	
	/** the account information */
	private String account;
	
	/** the email information */
	private String email;
	
	/** the password information */
	private String password;
	
	/** the group array */
	private Set<String> groups;
	
	/** the role array */
	private Set<String> roles;
	
	/** the time zone */
	private ZoneId timeZone;
	
	/** the locale object */
	private Locale locale;
	
	/** the classification of current user */
	private String classification;
	
	public GPrincipal(String account){
		this.account = account;
		this.locale = Locale.getDefault();
		this.timeZone = ZoneId.systemDefault();
	}
	
	public GPrincipal(InfoId<Long> userId){
		
		this.userId = userId;
		this.locale = Locale.getDefault();
		this.timeZone = ZoneId.systemDefault();
	}
	
	public GPrincipal(InfoId<Long> userId, String account){
		
		this.userId = userId;
		this.account = account;
		this.locale = Locale.getDefault();
		this.timeZone = ZoneId.systemDefault();
	}
	
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * Get the entity id 
	 **/
	public Integer getSourceId() {
		
		return sourceId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public InfoId<Long> getUserId() {
		
		return userId;
	}
	
	public void setUserId(InfoId<Long> userId){
		this.userId = userId;
	}
	@Override
	public boolean equals(Object other) {
		// step 1
		if (other == this) {
			return true;
		}
		// step 2
		if (!(other instanceof GPrincipal)) {
			return false;
		}
		// step 3
		GPrincipal that = (GPrincipal) other;
		// step 4
		String account = this.getAccount();
		String oacct = that.getAccount();
		return new EqualsBuilder()
			.append(account, oacct).isEquals();
	}

	@Override
	public int hashCode() {
		String account = this.getAccount();
		return new HashCodeBuilder(17, 37)
				.append(account).toHashCode();
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public ZoneId getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(ZoneId timeZone) {
		this.timeZone = timeZone;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public Set<String> getGroups() {
		return groups;
	}

	public void setGroups(Set<String> groups) {
		this.groups = groups;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}	
	
	/**
	 * Get the date format as per the locale 
	 **/
	public DateFormat getDateFormat(){
		Locale locale = this.getLocale();
		
		DateFormat datefmt = DateFormat.getDateInstance(DateFormat.LONG, locale);
		return datefmt;
	}

	@Override
	public String getName() {
		return this.account;
	}
}
