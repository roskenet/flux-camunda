package flux.camunda.expression;

import org.springframework.stereotype.Component;

@Component("doSomething")
public class DoSomething {

	public int addOne(int someValue) {
		return ++someValue;
	}
}
