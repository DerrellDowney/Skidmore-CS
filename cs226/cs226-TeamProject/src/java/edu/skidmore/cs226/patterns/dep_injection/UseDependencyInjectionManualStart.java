package edu.skidmore.cs226.patterns.dep_injection;

import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Used to demonstrate the use of Spring's IoC container.
 * <p>
 * Note that the calls to "getBean()" are not typically made when using Spring.
 * It is shown here to demonstrate that code can be written to "reach into" the
 * IoC container. However, normally you let the container inject objects, using
 * Spring's configuration to execute an initial method to start the program.
 * </p>
 * 
 * @author readda
 */
public class UseDependencyInjectionManualStart {
    /**
     * Create objects and inject dependencies manually into the Mortgage object.
     * All of this can be done through configuration in Spring as demonstrated
     * in other methods.
     */
    private void useMortgageClassManually() {
        System.out.println("\nDependency Injection in Java Code");
        Person mortgagee = new Person("Ann",
            new GregorianCalendar(1992, 3, 29).getTime(), 5000);
        Property property = new Property("123 Apple Ave, Appleton, AZ, 12345",
            "Single family", 280900);

        Mortgage mortgage = new Mortgage(mortgagee, property);

        mortgage.setLienholder(new Bank("Bob's Trust and Loan",
            "987 Main St, Phoenix, AZ, 54321", "987-654-3210"));

        mortgage.setLoanDetails(new Loan(360, 250000, 0.054));

        System.out.println(mortgage);

    }

    /**
     * Use the Spring IoC container to create and inject all the dependencies
     * for the Mortgage object. The underlying configuration uses explicit
     * wiring of the dependencies.
     */
    private void useSpringIoCExplicitWiring() {
        System.out.println("\nDependency Injection Using Spring's IoC Container"
            + " (explicit wiring)");
        ApplicationContext context =
            new ClassPathXmlApplicationContext(
                new String[] { "mortgage_explicitwire.xml" },
                Mortgage.class);
        ((AbstractApplicationContext) context).registerShutdownHook();

        Mortgage mortgage = (Mortgage) context.getBean("mortgage");
        System.out.println(mortgage);

        ((ConfigurableApplicationContext) context).close();
    }

    /**
     * Use the Spring IoC container to create and inject all the dependencies
     * for the Mortgage object. The underlying configuration uses autowiring of
     * the dependencies.
     */
    private void useSpringIoCAutoWiring() {
        System.out.println("\nDependency Injection Using Spring's IoC Container"
            + " (autowire)");
        ApplicationContext context =
            new ClassPathXmlApplicationContext(
                new String[] { "mortgage_autowire.xml" },
                Mortgage.class);
        ((AbstractApplicationContext) context).registerShutdownHook();

        Mortgage mortgage = (Mortgage) context.getBean("mortgage");
        System.out.println(mortgage);

        ((ConfigurableApplicationContext) context).close();
    }

    public static void main(String[] args) {
        UseDependencyInjectionManualStart diCheck =
            new UseDependencyInjectionManualStart();
        diCheck.useMortgageClassManually();
        diCheck.useSpringIoCExplicitWiring();
        diCheck.useSpringIoCAutoWiring();
    }
}
