; Dean Trojanowski
; print x + y 

.ORIG x3000

LEA     R0, BUFFER
LD      R1, BUFFER_SIZE
LD      R4, GETS
JSRR    R4
LEA     R6, BUFFER
LD      R5, ASCII_ZERO
LEA     R0, X
LEA     R1, BASE_10
LEA     R2, X       ;load the adress of X into R2
LD      R4, Multiplication ;Load multiplication into R4, NOT LEA because Mult... is already adress

LOOP1 
LDR R3, R6, #0 ;load adress of r6 into R3
BRz OUT1 ;exit out of the loop
ADD R3, R3, R5 ;add r5 to r3 and store in r3
JSRR R4 ; jump to R4 
LD R7, X ;load x into R7
ADD R7, R7, R3; Add R3 into R7 and store in R7
ST R7, X ;store r7 into x
ADD R6, R6, #1
BRnzp LOOP1

OUT1

;change x's to y's

LEA     R0, BUFFER
LD      R1, BUFFER_SIZE
LD      R4, GETS
JSRR    R4
LEA     R6, BUFFER
LD      R5, ASCII_ZERO
LEA     R0, Y
LEA     R1, BASE_10
LEA     R2, Y       ;load the adress of y into R2
LD      R4, Multiplication ;Load multiplication into R4, NOT LEA because Mult... is already adress

LOOP2 
LDR R3, R6, #0 ;load adress of r6 into R3
BRz OUT2 ;exit out of the loop
ADD R3, R3, R5 ;add r5 to r3 and store in r3
JSRR R4 ; jump to R4 
LD R7, Y ;load y into R7
ADD R7, R7, R3; Add R3 into R7 and store in R7
ST R7, Y ;store r7 into y
ADD R6, R6, #1
BRnzp LOOP2
OUT2

; add the two variables and store into result Q
LD R0, X
LD R1, Y
ADD R0, R1, R0
ST R0, RESULT

LEA R6, BUFFER ;load the adrress of the buffer in R6
LD R0, BUFFER_SIZE ;Load R0 with the buffer size 
ADD R6, R0, R6 ;add r0 and r6 store into r6
AND R0, R0, #0
STR R0, R6, #0 ;store r0 into the adress of r6
ADD R6, R6, #-1 ;decrement r6 by one
LD R4, DIVISION ;load the adress subrioutine into r4
LD R5, ASCII_0 ;load the ascii 0 into r5
LD R0, RESULT ;load result into r0
ST R0, QUO ;Store quotient into R0 Q
LEA R0, QUO ;load the adress of the quo into R0
LEA R1, BASE_10 ;load the adress of the base in R1
LEA R2, QUO ;load the adress of the quo into R2
LEA R3, REM  ;load the adress of the rem in R3

LOOP3 LD R7, QUO ;load the quo into r7
BRnz OUT3
JSRR R4
LD R0, REM ;load the value of remainder in r0
ADD R0, R5, R0 ; add r5 to r0 and store into r0
STR R0, R6, #0 ;store r0 into the adress of R6 Q
ADD R6, R6, #-1 ;decrement r6 by one
AND R0, R0, #0 ;set R0 to zero 
ST R0, REM ;store r0 into the remainder 
LEA R0, QUO ;store the adress of quo into r0
BRnzp LOOP3
OUT3

ADD R6, R6, #1 ;incremenet R6 by one
ADD R0, R6, #0 ;copy the adress of r6 into r0
Trap x22    ;call trap x 22
LD R0, ASCII_A
TRAP X21
HALT

X .BLKW 1;x
Y .BLKW 1;y
RESULT .BLKW 1;result 
BASE_10 .FILL #10;base with value 10 (this is the base that we will used for the input and output so that the user recognizes the values)
QUO .BLKW 1;quotient
REM .BLKW 1;remainder
BUFFER .BLKW 16;buffer (choose a size that is at least big enough to hold the number of digits that a 16 bit register can hold in base 10 plus the null character. The largest value that we can hold in a 16-bit register is 65,536.  Since we are going to add two of these values, then the sum of the two values can't be more than this. We are not going to deal with negative values.)
BUFFER_SIZE .FILL #15;buffer size (this should be one less than the number of characters that the buffer can hold because we need room for the null character)
ASCII_0 .FILL x30;ASCII value of '0' (this is x30)
ASCII_ZERO .FILL x-30;Negative ASCII value of '0'
ASCII_A .FILL xA;ASCII value if a new line (xA)
MULTIPLICATION .FILL x3100 ;Address of the multiplication subroutine
DIVISION .FILL x3150;Address of the division subroutine
GETS .FILL x3200;Address of the gets subroutine
.END