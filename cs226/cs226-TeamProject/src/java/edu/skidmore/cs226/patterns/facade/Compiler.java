package edu.skidmore.cs226.patterns.facade;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Facade: Translated book example (page 191)
 * <p>
 * This is the Facade class, hiding all the complexity of using the other
 * classes when compiling a program.
 * </p>
 * 
 * @author readda
 */
public class Compiler {
    public Compiler() {

    }

    public void compile(InputStream input, OutputStream output) {
        Scanner scanner = new Scanner(input);
        ProgramNodeBuilder builder = new ProgramNodeBuilder();
        Parser parser = new Parser();

        parser.parse(scanner, builder);

        RiscCodeGenerator generator = new RiscCodeGenerator(output);
        ProgramNode parseTree = builder.getRootNode();
        parseTree.traverse(generator);
    }
}
