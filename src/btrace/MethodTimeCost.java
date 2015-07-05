package btrace;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.TLS;

@BTrace
public class MethodTimeCost {
	
	@TLS
	private static Long startTime;
	
	@OnMethod(clazz="", method="", location=@Location(Kind.ENTRY))
	public static void startExecute() {
		startTime = System.currentTimeMillis();
	}
	
	@OnMethod(clazz="", method="", location=@Location(Kind.RETURN))
	public static void endExecute() {
		long timeCost = System.currentTimeMillis() - startTime;
		if (timeCost > 200) {
			System.out.println();
		}
	}

}
