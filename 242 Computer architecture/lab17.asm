; Dean Trojanowski
;In this lab, you are going to convert a numeric value stored in hex to decimal and print it. 
;when we can reverse the digits to display it correctly.  
;You can do that if you want, but we are going to do that in Assignment 4.  
;Create the decimal digits we want, regardless of the order they appear.  
;have the division subroutine working loaded into address x3150, and load it into the simulator.

;Create an Assembly program:

.ORIG x3000 ;Load the program at address x3000.

LD R4, ADDRESS;Load the address of the division subroutine in R4
LD R5, ASCII_0;Load the ASCII value for '0' in R5
LEA R0, QUOTIENT ;Load the address of the quotient variable in R0
LEA R1, BASE ;Load the address of the base in R1
LEA R2, QUOTIENT ;Load the address of the quotient variable in R2 (because we are going to overwrite the quotient)
LEA R3, REMAINDER;Load the address of the remainder variable in R3

;Start a loop:
LOOP1 LD R7, QUOTIENT;Load the value of the quotient into R7 (this is just to update the flags so that we know when to stop the loop)
BRnz OUT1;Branch out of the loop if R7 is less than or equal to zero
JSRR R4 ;*REDO Jump to the division subroutine (the address is in R4)
;(At this point, you should have the left-most digit of the original value of the quotient in decimal in the remainder variable and the remaining digits in the quotient)

LD R0, REMAINDER;Load the remainder into R0
ADD R0,R0,R5 ;*have to conv to ascii
TRAP x21;*REDO Call the PUTC (trap x21) to display the value
LEA R0, QUOTIENT ;Load the address of the quotient variable in R0 (Step 5 again)
BRnzp LOOP1;*REDOGo back to the start of the loop.

OUT1

LD R0, ASCII_A;Load the ASCII code for the newline into R0
TRAP x21;Call the PUTC (trap x21) to display the newline
Halt
;Deliverables (What to turn in):
;Please just turn in your program. Do not turn in a picture of your program.  Do not turn in the .obj or .sym files.  I want to see the .asm (which is the Assembly source code) file.

;Data for
BASE .FILL xA;The base (initialized to 10 in decimal or xA)
QUOTIENT .FILL #543;*REDOThe quotient or value to be displayed in decimal (You can just make up a number as long as it is no more than 65535.)
REMAINDER .FILL x0;The remainder
ASCII_0 .FILL x30;The ASCII code for '0' (x30)
ASCII_A .FILL xA;The ASCII code for a newline (xA)
ADDRESS .FILL x3150;The address of the division subroutine
.END;*REDO