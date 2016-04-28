package yuanronghua.TimeSheet.common;

public class RestResponse implements java.io.Serializable {

	private int restCode = REST_REST_SUCCESS_CODE;
	
	private String appCode = SUCCESS_CODE;
	
	public static final int REST_REST_SUCCESS_CODE=200;
	
	public static final int REST_REST_FAILED_CODE=500;
	
	public static final String SUCCESS_CODE = "_successful_";

	public static final String FAILED_CODE = "_failed_";

	private String msg="";

	public Object result;


	public int getRestCode() {
		return restCode;
	}

	public void setRestCode(int restCode) {
		this.restCode = restCode;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
