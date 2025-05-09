; Dean Trojanowski
; Assembly Multiplication Subroutine

            .ORIG   x3100       ; Start at 0x3100

            ST      R0,REG0     ; Stores R0
            ST      R1,REG1     ; Stores R1
            ST      R2,REG2     ; Stores R2
            ST      R3,REG3     ; Stores R3
            ST      R4,REG4     ; Stores R4
            ST      R5,REG5     ; Stores R5
            ST      R6,REG6     ; Stores R6
            ST      R7,REG7     ; Stores R7
            
            AND     R0,R0,0     ; AND sets R0 to 0
            LDI     R2,REG0     ; Loads val from stored R0 pointer
            LDI     R1,REG1     ; Loads val from stored R1 pointer
            
STARTLOOP   BRnz    ENDLOOP     ; Exits loop on R1<=0
            ADD     R0,R0,R2    ;
            ADD     R1,R1,#-1   ; R1=R1-1
            BRnzp   STARTLOOP   ; Returns to beginning of loop
            
ENDLOOP     STI     R0,REG2     ; Stores indirect at add. in R2
            
            LD      R0,REG0     ; Loads val of R0 back
            LD      R1,REG1     ; Loads val of R1 back
            LD      R2,REG2     ; Loads val of R2 back
            LD      R3,REG3     ; Loads val of R3 back
            LD      R4,REG4     ; Loads val of R4 back
            LD      R5,REG5     ; Loads val of R5 back
            LD      R6,REG6     ; Loads val of R6 back
            LD      R7,REG7     ; Loads val of R7 back
            
            RET                 ; Returns to driver prog.

REG0        .FILL   1           ; R0 Store
REG1        .FILL   1           ; R1 Store
REG2        .FILL   1           ; R2 Store
REG3        .FILL   1           ; R3 Store
REG4        .FILL   1           ; R4 Store
REG5        .FILL   1           ; R5 Store
REG6        .FILL   1           ; R6 Store
REG7        .FILL   1           ; R7 Store

            .END                ; END