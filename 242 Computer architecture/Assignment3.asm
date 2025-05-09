;Dean Trojanowski
;Ferner 340
;Division Subroutine

.ORIG x3150             ;At the top, specify that the program should be loaded at address x3150
ST R0, Var1 ; adress of 1             ;Store the values of all 8 register into your variables
ST R1, Var2 ;address 1
ST R2, Var3 ;address of quo
ST R3, Var4 ;address rem
ST R4, Var5 ;adress of div routine
ST R5, Var6
ST R6, Var7
ST R7, Var8

;initalize all the var to store the addresses
;the variable was in the R#
;store into the variable

LDI R0, Var1    ;1  ;load is Register   ;*Load indirect the value stored in memory at the address given in the saved R0 variable into register R0
LDI R1, Var2    ;1                      ;Load indirect the value stored in memory at the address given in the saved R1 variable into register R1
NOT R1, R1                              ;***Negate R1 (R1 = -R1)
ADD R1, R1, #1

;load all the rigisters with the real values from the variables with load 
;load indirect. The value is there it had to go to that adress in the variable and put in register 

;r0 was 1
;r1 was 1
;We flipped r1
; r1 is now -1

AND R2, R2, #0          ;Initialize registers R2 and R3 to be zero.
AND R3, R3, #0

;r2 == 0
;r3 = 0

;Start the division loop:
LOOP1 ADD R4, R0, R1    ;*R4 = R0 + R1
BRn OUT1               ;Branch on less than to zero out of the loop
ADD R3, R3, #1          ;Increment R3 by 1
ADD R4, R0, #0          ;Copy R4 into R0
BRnzp LOOP1                   ;***Branch back to the start of the loop

;subtract for division R4 =R0 (1) + R1 (-1) ; then make R4 => back to R0
;r3 is the counter =1
;R4 is temp storage for decramented div
;At this point, you now have the quotient in R3 and the remainder in R0

OUT1 HALT
;we just want to store 
;
;
;it says saved memory in r3 but r3 has a fucking number in it
;
STR R0, R3, #0        ;**Store indirect the value in R0 into memory at the address given in the saved R3
STR R3, R2, #0        ;**Store indirect the value in R3 into memory at the address given in the saved R2
LD R0, Var1             ;**Restore the values of all 8 registers from your variables
LD R1, Var2
LD R2, Var3
LD R3, Var4
LD R4, Var5
LD R5, Var6
LD R6, Var7
LD R7, Var8

;str take this second register in the adress in the first register 

RET                     ;Return




;Create variables to store the values of all 8 registers at the bottom of the program. 
;The variables should all be of size 1 word (use the .BLKW)
;bottom data
Var1 .BLKW 1
Var2 .BLKW 1
Var3 .BLKW 1
Var4 .BLKW 1
Var5 .BLKW 1
Var6 .BLKW 1
Var7 .BLKW 1
Var8 .BLKW 1

.END