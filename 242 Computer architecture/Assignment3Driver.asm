;Dean Trojanowski
;340 Ferner
;Division Driver Program

.ORIG x3000;At the top, specify that the program should be loaded at address x3000
LEA R0, OP1      ;*Load the address of operand 1 into register R0 (use LEA)
LEA R1, OP2      ;*Load the address of operand 2 into register R1 (use LEA)
LEA R2, QUO      ;*Load the address of the quotient variable into register R2 (use LEA)
LEA R3, REM      ;*Load the address of the remainder variable into register R3 (use LEA)
LEA R4, DIV      ;*Load the address of the DIVISION subroutine (this is just a load instruction, not LEA) into register R4
JSRR R4         ;Jump to the subroutine (use the JSRR) at the address in R4
HALT            ;HALT the program
;You should put a break point at the HALT instruction. If your program works correctly, you should see in memory immediately after the HALT instruction the two operands and the product, all in hex. 

;Create variables:
OP1 .FILL #1        ;*Operand 1 (initialize to some non-trivial value. Use the .FILL)
OP2 .FILL #2        ;*Operand 2 (initialize to some non-trivial value. Use the .FILL)
QUO .BLKW 1         ;***Quotient
REM .BLKW 1         ;***Remainder
DIV .Fill x3150     ;*DIVISION subroutine address, initialized to x3150

.END