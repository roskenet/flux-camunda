package flux.camunda.business;

import org.springframework.stereotype.Component;

@Component
public class MyBusinessClass {

    public void printSomething() {
        System.out.println("Hier ist irgendwelche Businesslogik!");
    }
}
