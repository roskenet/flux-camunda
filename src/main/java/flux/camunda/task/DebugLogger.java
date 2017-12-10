package flux.camunda.task;

import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("debugLogger")
public class DebugLogger implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Map<String, Object> variables = execution.getVariables();
        System.out.println(variables.get("myInteger"));
        System.out.println(variables.get("result"));
    }

}
