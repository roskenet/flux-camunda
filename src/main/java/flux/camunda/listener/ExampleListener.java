package flux.camunda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import flux.camunda.business.MyBusinessClass;

@Component("exampleListener")
public class ExampleListener implements ExecutionListener{

    private final MyBusinessClass businessClass;
    
    public ExampleListener(MyBusinessClass businessClass) {
        this.businessClass = businessClass;
    }
    
    @Override
    public void notify(DelegateExecution execution) throws Exception {
        
        System.out.println("Hier ist ein listener registriert!");
        businessClass.printSomething(); 
    }

}
