package flux.camunda;

import java.util.UUID;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FluxCamundaApplicationTests {

    @Autowired
    private RuntimeService runtimeService;
    
	@Test
	public void contextLoads() {
	}

	@Test
	public void runTaskB() {
	    UUID uuid = UUID.randomUUID();
	    ProcessInstance procInst = runtimeService.startProcessInstanceByKey("proc_1", uuid.toString());
//	    runtimeService.messageEventReceived("TASKB", procInst.getProcessInstanceId());
	    
	    MessageCorrelationResult result = runtimeService.createMessageCorrelation("TASKB")
	            .processInstanceBusinessKey(uuid.toString())
//	            .processDefinitionId(procInst.getProcessDefinitionId())
	            .setVariable("payment_type", "creditCard")
	            .correlateWithResult();
	    
	}
}
