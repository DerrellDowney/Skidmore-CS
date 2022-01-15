package edu.skidmore.cs226.usepatterns;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.skidmore.cs226.base.BankAccount;
import edu.skidmore.cs226.base.CoinJar;

/**
 * A class that contains multiple money holders, specifically a BankAccount and
 * a set of CoinJars. The class is used to demonstrate the Spring IoC container
 * in two ways.
 * <p>
 * First, the container creates an instance of this class and
 * injects a BankAccount bean. Spring then runs the run() method.
 * </p>
 * <p>
 * Second, the class is aware of the IoC container (via implementation of the
 * ApplicationContextAware interface). The addCoinJar() method uses the IoC
 * container by asking for an instance of a RenameableCoinJar instead of
 * creating it with the "new" keyword.
 * </p>
 * <p>
 * An experiment to try: Run the program and note the individual names for the
 * coin jars. Then remove the
 * <br/>
 * scope="prototype"
 * <br/>
 * attribute from the renameableCoinJar bean element and run the program. Why do
 * all the CoinJars have the same name? Remember to replace the scope attribute.
 * 
 * @author readda
 */
public class AccountSetupDependencyInjection
    implements ApplicationContextAware {
    /**
     * Bank account.
     */
    private BankAccount bankAccount;

    /**
     * A set of coin jars.
     */
    private List<RenameableCoinJar> coinJars;

    /**
     * Spring's application context.
     */
    private ApplicationContext applicationContext;

    /**
     * Logger handle.
     */
    private final static Logger LOG;
    
    /**
     * Setup the logger
     */
    static {
        LOG = Logger.getLogger(AccountSetupDependencyInjection.class);
    }
    
    /**
     * Create the instance and setup the empty set of coin jars.
     */
    public AccountSetupDependencyInjection() {
        coinJars = new ArrayList<>();
    }

    /**
     * Setup a set of coin jars.
     */
    public void setup() {
        for (int i = 0; i < 10; ++i) {
            addCoinJar("Jar #" + i);
        }
    }

    /**
     * Set the bank account.
     * 
     * @param bankAccount
     *            The bank account
     */
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Add a coin jar. The instance is obtained from the Spring IoC container.
     * 
     * @param description
     *            The description for the coin jar
     */
    public void addCoinJar(String description) {
        // notice the Spring API dependency!
        RenameableCoinJar jar = this.applicationContext
            .getBean("renameableCoinJar", RenameableCoinJar.class);
        jar.setDescription(description);
        coinJars.add(jar);
        LOG.info("RenameableCoinJar added to the list of coinjars");
    }

    /**
     * Setup the coin jars and report the status of the accounts.
     */
    public void run() {
        setup();
        report();
    }

    /**
     * Report the money holder details.
     */
    public void report() {
        LOG.debug("Reporting info for bank account: " + bankAccount);
        
        System.out.println("Bank Account: " + bankAccount);
        for (CoinJar jar : coinJars) {
            System.out.println("Coin jar: " + jar);
        }
    }

    @Override
    public void setApplicationContext(
        ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        LOG.info("Application context set");;
    }

    /**
     * Load the IoC container.
     * 
     * @param configurationFiles
     *            The Spring IoC container configuration file(s)
     */
    public static void startContainer(String... configurationFiles) {
        @SuppressWarnings("resource")
        ApplicationContext context =
            new ClassPathXmlApplicationContext(configurationFiles,
                AccountSetupDependencyInjection.class);
        ((AbstractApplicationContext) context).registerShutdownHook();
        
        LOG.info("Spring container started via classpath context");
    }

    /**
     * Call the method which loads the IoC Container.
     * 
     * @param args
     *            Command line arguments, not used
     */
    public static void main(String[] args) {
        LOG.info("Start the Spring container");
        startContainer("accountsetup_explicitwire.xml");
        LOG.info("Spring container started - main exiting");
    }
}
