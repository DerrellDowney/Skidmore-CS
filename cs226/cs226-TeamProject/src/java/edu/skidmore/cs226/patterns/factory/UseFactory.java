package edu.skidmore.cs226.patterns.factory;

/**
 * Factory: Demonstrate how the Factory instance is used.
 * 
 * @author readda
 */
public class UseFactory {
    private void useCreator() {
        System.out.println("\nCreator:");
        Creator factory = new Creator();
        Product product = factory.create(ProductId.MINE);
        System.out.println("Got an instance of " + product.getClass());
        product = factory.create(ProductId.YOURS);
        System.out.println("Got an instance of " + product.getClass());
        product = factory.create(ProductId.THEIRS);
        System.out.println("Got an instance of " + product);
    }

    private void useMyCreator() {
        System.out.println("\nMyCreator:");
        Creator factory = new MyCreator();
        Product product = factory.create(ProductId.MINE);
        System.out.println("Got an instance of " + product.getClass());
        product = factory.create(ProductId.YOURS);
        System.out.println("Got an instance of " + product.getClass());
        product = factory.create(ProductId.THEIRS);
        System.out.println("Got an instance of " + product.getClass());
    }

    private void useLazyCreator() {
        System.out.println("\nLazyCreator:");
        LazyCreator creator = new LazyCreator();
        Product product = creator.getProduct();
        System.out.println("Got an instance of " + product.getClass());
    }

    private void useStandardCreator() {
        System.out.println("\nStndardCreator:");
        StandardCreator creator = new StandardCreator();
        Product product = creator.createProduct(MyProduct.class);
        System.out.println("Got an instance of " + product.getClass());
        product = creator.createProduct(TheirProduct.class);
        System.out.println("Got an instance of " + product.getClass());
    }

    public static void main(String[] args) {
        UseFactory factoryCheck = new UseFactory();
        factoryCheck.useCreator();
        factoryCheck.useMyCreator();
        factoryCheck.useLazyCreator();
        factoryCheck.useStandardCreator();

    }
}
