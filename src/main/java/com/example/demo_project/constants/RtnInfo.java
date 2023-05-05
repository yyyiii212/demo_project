package com.example.demo_project.constants;

public enum RtnInfo {
	SUCCESSFUL("200", "Successful !"),
	FAILED("500", "Error !"),
	PARAMETER_REQUIRED("400", "Parameter is not required !"), 
	DATA_REQUIRED("417", "Data is not required !");

	private String code;

	private String message;

	private RtnInfo(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
