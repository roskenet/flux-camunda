package flux.camunda.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class TaskA implements JavaDelegate{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
       System.out.println("Hier bin ich im TASK A!"); 
    }

}
