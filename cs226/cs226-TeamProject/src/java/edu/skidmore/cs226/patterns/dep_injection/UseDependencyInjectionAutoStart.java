package edu.skidmore.cs226.patterns.dep_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Used to demonstrate the use of Spring's IoC container including use of the
 * auto start configuration.
 * <p>
 * Note that Spring can call methods that are private.
 * </p>
 * 
 * @author readda
 */
public class UseDependencyInjectionAutoStart {
    private Mortgage mortgage;

    @SuppressWarnings("unused")
    private void useSpringIoCAutoStart() {
        System.out.println("\nDependency Injection Using Spring's IoC Container"
            + " (auto start application)");

        System.out.println(mortgage);
    }

    @SuppressWarnings("unused")
    private void shutdownApp() {
        System.out.println("Shutdown called");
    }

    public void setMortgage(Mortgage mortgate) {
        this.mortgage = mortgate;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context =
            new ClassPathXmlApplicationContext(
                new String[] { "mortgage_autorun.xml" },
                Mortgage.class);
        ((AbstractApplicationContext) context).registerShutdownHook();
    }
}
