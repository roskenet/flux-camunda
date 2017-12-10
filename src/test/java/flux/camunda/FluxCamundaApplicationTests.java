package flux.camunda;

import java.util.List;
import java.util.UUID;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
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
    
    @Autowired
    private TaskService taskService;
    
	@Test
	public void contextLoads() {
	}

	@Test
	public void runTaskB() {
	    UUID uuid = UUID.randomUUID();
	    runtimeService.startProcessInstanceByKey("proc_1", uuid.toString());
//	    runtimeService.messageEventReceived("TASKB", procInst.getProcessInstanceId());
	    
	    runtimeService.createMessageCorrelation("TASKB")
	            .processInstanceBusinessKey(uuid.toString())
//	            .processDefinitionId(procInst.getProcessDefinitionId())
	            .setVariable("the_user", "felix")
	            .setVariable("payment_type", "creditCard")
	            .correlateWithResult();
	    
	    // Hier sollten jetzt Tasks fuer mich sein:
	    List<Task> tasks = taskService.createTaskQuery().taskAssignee("felix").list();
	    
	    taskService.complete("918");
	    
	    tasks.forEach(System.out::println);
	}
}
