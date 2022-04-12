//////////////////////////////////////////////
//
// CS318 Lab 6: Loops and Procedures
//
// Your name: Derrell Downey
//////////////////////////////////////////////
	.align 2
	.data
list1: // An array of signed doubleword values
	.dword 5 // number of items in array list1
	.dword 945,151,882,543,478 // values in list1
list2: // An array of signed doubleword values
	.dword 12 // number of items in array list2
	.dword -91,8,86,-88,99,49,15,89,18,-44,34,36 // values in list2
	.text
	.global main
main:
    // Placing values into registers X9 through X15 so that we can confirm
    // the search procedure has no side effects.
    // DO NOT MODIFY THIS BLOCK OF CODE
    MOV X9,#0x113
    MOV X10,#0x456
    MOV X11,#0x789
    MOV X12,#0xABC
    MOV X13,#0xDEF
    MOV X14,#0x1A2B
    MOV X15,#0x3C4D

    // Call the search procedure to search for a value in list1.
    // This is a demonstration of how to call a procedure.

    // Setup registers as expected by the search procedure
    ADR X2,list1 // put address of list1 into X2
    LDR X3,[X2,#0] // put length of list1 into X3
    ADD X2,X2,#8 // add size of dword to X2, now X2 refers to first array item
    MOV X1,#543 // put item to search for into X1 (should be found at position 3)
    ADD X10,XZR,XZR// putting X10(offset to current element to zero
	MOV X12, #0

    // Call the search procedure
    BL search

    // placeholder. Check that X0 contains the correct return value from the search procedure
    // Check that X1, X2, X3, and X9 through X15 have the same values as they did
    // before the search procedure was called.
    MOV X7,#0 // placeholder

    // LAB 6 TASK 3:
    // Call the search procedure to search for a value in list2.
    // Write your code for Task 3 here:
	ADR X2,list2 // put address of list2 into X2
    LDR X3,[X2,#0] // put length of list2 into X3
    ADD X2,X2,#8 // add size of dword to X2, now X2 refers to first array item
    MOV X1,#10 // put item to search for into X1 (should be found at position -1)
    ADD X10,XZR,XZR// putting X10(offset to current element to zero
	MOV X12, #0
	BL search

	// End of your code for Task 3


	MOV X7,#0 // placeholder, pause execution here and check values in registers
	B the_end // finish the main procedure

////////////////////////////B the_end//////
// Procedure search:
// Searches an array of signed doubleword values.
// Returns the index in the array where the first occurrence of the item is found.
// Returns -1 if the item is not found in the array.
//
// Returns in Register X0: index where the item is found, or -1 if not found
//
// Parameters:
//     Register X1: the item to search for
//     Register X2: the memory address of the beginning of the array
//     Register X3: the length of the array
//
// Use of registers for temporary values:
// LAB 6 TASK 1: STUDENT MUST DOCUMENT HOW REGISTERS X9 THROUGH X15 ARE USED IN THIS PROCEDURE
// (do not need to use all of them)
// X9 to place the value of comparing the values of X1 and X11
// X10 offset to current array element
// X11 temp value
// X12 index
//////////////////////////////////

search:
	// LAB 6 TASK 2: WRITE CODE HERE FOR THE search PROCEDURE

	//Comparing the value we want to the value we are currently at
	//continue looping until X9 = 0

	SUB SP,SP,#32 // move stack pointer up by 40 Bytes
	STR X12,[SP,#0] // copy value from stack to X12
	STR X11,[SP,#8] // copy value from stack to X11
	STR X10,[SP,#16] // copy value from stack to X10
	STR X9,[SP,#24] // copy value from stack to X9



	CBZ X3, search_not_found // if the length reaches 0, go to search_not_found
	LDR X11,[X2,X10] //setting X11 to the current value at the index
	SUB X9, X1, X11 //comparing the wanted value to the selected value
	CBZ X9, search_found // if 0, the values are equal to eachother, go to search_found
	ADD X12, X12, #1 //if not found adding one to the index
	ADD X10,X10,#8 // updating the current element offset
	SUB X3,X3,#1 //subtracting one from the length
	B search // go to the start of the loop again

search_found:
	MOV X0, X12 // setting X0 to the index+1
	B search_end

search_not_found:
	MOV X0,#-1 //if not found setting the index to -1


search_end:
	LDR X12,[SP,#0] // copy value from stack to X12
	LDR X11,[SP,#8] // copy value from stack to X11
	LDR X10,[SP,#16] // copy value from stack to X10
	LDR X9,[SP,#24] // copy value from stack to X9
	ADD SP,SP,#32 // move stack pointer up by 32 Bytes
	BR X30
	// End of your code for Task 2

	// End of search procedure.
	// Make no modifications below this comment.
the_end:
	MOV X7,#0 // placeholder for end of program breakpoint
	.end
