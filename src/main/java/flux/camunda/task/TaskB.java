package flux.camunda.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class TaskB implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("myInteger", 130);
        execution.setVariable("anotherInteger", 100);
        System.out.println("Hier bin ich im TASK B!");
    }

}
