// <student's name(s)>
// CS318 Programming Assignment 3
// A64 implementation of Binary Search Tree
	.align 2
	.data
	// Assume that the BST's are full and complete
	// (every node other than the leaves has exactly two children, leaves are all
	// at the same depth).
	// Structure of the tree data:
	// First value is the number of nodes in the tree.
	// This is followed by the values stored in each node. The BST is stored as
	// an array where the childern of the node at index i are located at indexes
	// (2i+1) and (2i+2).
treeA: 
	.dword 15 // number of nodes in treeA
	.dword 57,39,72,23,50,62,87,20,27,49,53,60,63,81,95 // BST represented as an array
treeB: 
	.dword 63 // number of nodes in treeB
	// BST represented as an array
	.dword 2941,1836,3400,1418,2176,3298,4199,1128,1472,2143
    .dword 2552,3060,3310,3598,4280,1020,1150,1438,1713,2037
    .dword 2154,2219,2634,2987,3104,3305,3362,3487,3674,4242
    .dword 4733,1009,1057,1146,1223,1426,1453,1663,1755,1962
    .dword 2079,2145,2175,2189,2379,2602,2654,2974,3012,3095
    .dword 3162,3300,3307,3325,3373,3458,3511,3632,3912,4222
    .dword 4278,4673,4947
treeC: // empty tree
	.dword 0 // number of nodes in treeC
treeD: // tree has one node
	.dword 1 // number of nodes in treeD
	.dword 12345 // single node in the tree
	.text
	.global main
main:

	////////////////////
	// Test 1: treeA
	// Call the search procedure
	ADR X1,treeA // base memory address of the tree
	ADD X1,X1,#8 // before calling the procedure, put address of first array element into X1
	MOV X2,#87 // key value to search for
	MOV X3,#0 // offset of root node
	MOV X4,#0 // array index of root node
	BL p_search

	MOV X7,#0 //placeholder, after implementing p_search, check if X0 contains 6 

	////////////////////
	// Test 2: treeB
	// Call the search procedure
	ADR X1,treeB // base memory address of the tree
	ADD X1,X1,#8 // before calling the procedure, put address of first array element into X1
	MOV X2,#2189 // key value to search for
	MOV X3,#0 // offset of root node
	MOV X4,#0 // array index of root node
	BL p_search

	MOV X7,#0 //placeholder, after implementing p_search, check if X0 contains 2B, i.e., 43

	////////////////////
	// Test 3: treeC
	
	// Call the search procedure
	ADR X1,treeC // base memory address of the tree
	ADD X1,X1,#8 // before calling the procedure, put address of first array element into X1
	MOV X2,#987 // key value to search for
	MOV X3,#0 // offset of root node
	MOV X4,#0 // array index of root node
	BL p_search

	MOV X7,#0 //placeholder, after implementing p_search, check if X0 contains -1

	////////////////////
	// Test 4: treeD
	
	// Call the search procedure
	ADR X1,treeD // base memory address of the tree
	ADD X1,X1,#8 // before calling the procedure, put address of first array element into X1
	MOV X2,#12345 // key value to search for
	MOV X3,#0 // offset of root node
	MOV X4,#0 // array index of root node
	BL p_search

	MOV X7,#0 //placeholder, after implemeOV X3, #0nting p_search, check if X0 contains 0

	// End of main procedure, branch to end of program
	B program_end

p_search:
	// Search Procedure (recursive implementation)
	// X0: Returns the array index where the key is found, or -1 if the key is not found.
	// X1: The memory base address of the binary search tree. Assumes the value before this
	// memory address is the number of nodes in the BST, followed by the values in each node
	// of the BST. Assumes the BST is full and complete (procedure will not alter)
	// X2: The key value to search for (procedure will not alter)
	// X3: The memory offset of the current sub-tree root (procedure may alter)
	// X4: The index of the current sub-tree root (procedure may alter)
	//
	// This procedure must use a recursive algorithm that has worst case
	// performance O(tree height).
	//
	// Temporary registers used by this procedure:
	// <student must list the registers; start with X9, and use registers in number order
	// as needed up to X15>
	// X9: value of the node
	// X10: length of the array
	// X11: temp value
	// Values of the temporary registers used by this procedure must be preserved.
	// When procedure returns, only X0, X3, and X4 may have a different value than they did at the start.

	//******* Write your code for the search procedure here ******/

	// Save the temporary register
	SUB SP,SP,#32 // Make room on stack, subtract 32 from SP
	STR X9,[SP,#0] // Save X9 to the stack
	STR X10,[SP,#8] // Save X10 to the stack
	STR X11,[SP,#16] // Save X11 to the stack

	// Before recursive call, save X30 and X1 to the stack
	//SUB SP,SP,#16 // Make room on the stack
	//STR X30,[SP,#8] // Save X30

	LDR X10,[X1,#-8] // put length of list1 into X10
	SUB X11,X10,X4 // comparing the index to the length
	CBZ X11,not_found //if index = length then move to not_found

	//MOV X11,X4 //setting X11 to the index as a temp value

	LDR X9,[X1,X3]//setting X10 to the first value in the tree
	SUBS X0,X2,X9 //comparing the value to the key value

	B.EQ found // if answer found jump to found
	B.HI greater_than_node
	B.LO less_than_node





//	SUB SP,SP,#16 // Make room on the stack
//	STR X30,[SP,#8] // Save X30

//	B p_search

//	LDR X30,[SP,#8]
//	ADD SP,SP,#16

	// End of search procedure

greater_than_node: //moving to the right branch
	ADD X4,X4,X4
	ADD X4,X4,#2
	MOV X3, #0
	B offset


less_than_node: //mobing to the left branch
	ADD X4,X4,X4
	ADD X4,X4,#1
	MOV X3, #0 //offset = 0
	B offset

offset:
	//SUB X11,X4,#1
	//ADD X3,X3,#8
	//CBNZ X11, offset
	MOV X11, #8
	MUL X3,X4,X11
	B p_search //recursive call

found:
	MOV X0, X4
	B found_end

not_found:
	MOV X0,#-1


found_end:
	// Restore value into registers and adjust SP
	LDR X11,[SP,#16] // Copy from stack into X11
	LDR X10,[SP,#8] // Copy from stack into X10
	LDR X9,[SP,#0] // Copy from stack into X9
	ADD SP,SP,#32 // release space on the stack, add 32 to SP
	BR X30

program_end:
	MOV X7,#0 // placeholder at end of program
	.end
