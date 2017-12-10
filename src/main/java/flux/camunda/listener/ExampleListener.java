package flux.camunda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component("exampleListener")
public class ExampleListener implements ExecutionListener{

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        
        System.out.println("Hier ist ein listener registriert!");
        
    }

}
