package yatospace.jsp.user.event;

/**
 * Basic implementation event model. 
 * @author MV
 * @version 1.0
 */
public class BasicEventModel implements EventModel{
	private ParameterRunnable runnable = params->{}; 
	
	@Override
	public ParameterRunnable runnable() {
		return runnable;
	}

	public ParameterRunnable getRunnable() {
		return runnable;
	}

	public void setRunnable(ParameterRunnable runnable) {
		if(runnable==null) runnable = params->{}; 
		this.runnable = runnable;
	}
	
	public void run(ParameterMap params) {
		runnable.run(params); 
	}
}
