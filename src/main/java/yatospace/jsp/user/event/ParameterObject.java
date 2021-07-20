package yatospace.jsp.user.event;

import java.io.Serializable;

/**
 * Parameter object. 
 * @author MV
 * @version 1.0
 */
public class ParameterObject implements Serializable, Comparable<ParameterObject>{
	private static final long serialVersionUID = 4285199175227428274L;
	private Class<?> parameterClazz; 
	private Object parameterValue;
	private String parameterName; 
	private ParameterType parameterType = ParameterType.IN;
	private Object inputProvider;
	private Object outputProvider; 
	
	public ParameterObject(String parameterName) {
		if(parameterName==null) throw new NullPointerException("Zero.");
		if(parameterName.length()==0) throw new NullPointerException("Empty.");
		this.parameterName = parameterName; 
	}
	
	public Class<?> getParameterClazz() {
		return parameterClazz;
	}
	
	public void setParameterClazz(Class<?> parameterClazz) {
		this.parameterClazz = parameterClazz;
	}

	public Object getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(Object parameterValue) {
		this.parameterValue = parameterValue;
	}

	public ParameterType getParameterType() {
		return parameterType;
	}

	public void setParameterType(ParameterType parameterType) {
		if(parameterType==null) return; 
		this.parameterType = parameterType;
	}


	public Object getInputProvider() {
		return inputProvider;
	}


	public void setInputProvider(Object inputProvider) {
		this.inputProvider = inputProvider;
	}

	public Object getOutputProvider() {
		return outputProvider;
	}

	public void setOutputProvider(Object outputProvider) {
		this.outputProvider = outputProvider;
	}

	public String getParameterName() {
		return parameterName;
	}

	@Override
	public int compareTo(ParameterObject o) {
		return parameterName.compareTo(o.parameterName);
	} 
}
