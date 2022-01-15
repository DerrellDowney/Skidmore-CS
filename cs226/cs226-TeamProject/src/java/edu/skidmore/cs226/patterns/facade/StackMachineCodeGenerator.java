package edu.skidmore.cs226.patterns.facade;

import java.io.OutputStream;

/**
 * Facade: Fabricated book example (page 190)
 * <p>
 * Generate machine code. Note that this class is based on the Visitor (331)
 * design pattern. Functionality is not dealt with in the book example.
 * </p>
 * 
 * @author readda
 */
public class StackMachineCodeGenerator extends CodeGenerator {
    protected StackMachineCodeGenerator(OutputStream bstream) {
        super(bstream);
    }
}
