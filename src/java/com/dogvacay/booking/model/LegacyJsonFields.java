/*
 * This software is the confidential and proprietary information of
 * dogvacay.com and may not be used, reproduced, modified, distributed,
 * publicly displayed or otherwise disclosed without the express written
 * consent of dogvacay.com.
 *
 * This software is a work of authorship by dogvacay.com and protected by
 * the copyright laws of the United States and foreign jurisdictions.
 *
 * Copyright 2014 dogvacay.com, Inc. All rights reserved.
 *
 */
package com.dogvacay.booking.model;

/**
 * Fields we're interested in the legacy JSON blob fields.
 * 
 * @author jtafralian
 */
public abstract class LegacyJsonFields {

	public interface DETAILS  {
		static final String DECLINED = "declined";
		static final String REASON = "reason";
	}

	public interface HISTORY  {
		static final String DECLINED = "+declined";
		static final String REASON = "+reason";
	}

	
}
