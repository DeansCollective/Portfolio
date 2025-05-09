;Dean Trojanowski stack

.ORIG x3000

LD R6, ADDRESS 
LD R0, RESULT
JSR PUSH

;A
LD R0, ASCII_A
JSR PUSH

;B
LD R0, ASCII_B
JSR PUSH

;C
LD R0, ASCII_C
JSR PUSH

JSR MYFUN

JSR POP ; pop result

JSR POP ; pop c
JSR POP ; pop b
JSR POP

HALT

ASCII_A .Fill #9
ASCII_B .Fill #8
ASCII_C .Fill #6
RESULT .BLKW 1
ADDRESS .FILL x4000

.END

;push
.ORIG x3100
PUSH
ADD R6, R6, #-1
STR R0, R6, #0 ;logic
RET
.End

;pop
.ORIG x3200
POP
LDR R0, R6, #0 ;logic
ADD R6, R6, #1 
RET
.End

;myfun
.ORIG x3300
MYFUN
ST R0, SavedR0
ST R1, SavedR1
ST R2, SavedR2
ST R3, SavedR3

AND R0, R0, #0 ;logic

LDR R1, R6, #0 ;Logic a b and c
LDR R2, R6, #1 ; i did 0 0 0 
LDR R3, R6, #2

ADD R0, R0, R1
ADD R0, R0, R1
ADD R0, R0, R1

ADD R0, R0, R2
ADD R0, R0, R2
ADD R0, R0, R2
ADD R0, R0, R2

ADD R0, R0, R3

STR R0, R6, #3 ; R6 is stack 

LD R0, SavedR0
LD R1, SavedR1
LD R2, SavedR2
LD R3, SavedR3

RET

SavedR0 .BLKW 1
SavedR1 .BLKW 1
SavedR2 .BLKW 1
SavedR3 .BLKW 1
.End