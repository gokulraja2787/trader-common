package org.gokapp.trader.common.domain;

import java.io.Serializable;

import lombok.Getter;

public class AppInfo implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -2063457187348992168L;

	@Getter
	private String appName;

	@Getter
	private String majorVersion;

	public AppInfo(String appName) {
		super();
		this.appName = appName;
		this.majorVersion = "0.0.5";
	}

}
