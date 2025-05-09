; Dean Trojanowski  
; Integer Division Subroutine

.ORIG x3150        

        ST R0, REG0        ; Stores R0 val
        ST R1, REG1        ; Stores R1 val
        ST R2, REG2        ; Stores R2 val
        ST R3, REG3        ; Stores R3 val
        ST R4, REG4        ; Stores R4 val
        ST R5, REG5        ; Stores R5 val
        ST R6, REG6        ; Stores R6 val
        ST R7, REG7        ; Stores R7 val

        LDI R0, REG0       ; Loads R0 w val in add. in stored R0
        LDI R1, REG1       ; Loads R1 w val in add. in stored R1

        NOT R1, R1         ; R1 = NOT R1
        ADD R1, R1, #1     ; R1 = R1 + 1
        AND R2, R2, #0
        ADD R4, R0, #0     ; R2 = R0 + R1

LOOP_S  ADD R0, R0, R1     ; R0 = R0 + R1
        BRnz LOOP_E        ; Exits loop on R0 <= 0
        ADD R4, R0, #0     ; R4 = R0
        ADD R2, R2, #1     ; R2 = R2 + 1
        BRnzp LOOP_S       ; Back to loop start

LOOP_E  STI R2, REG2       ; Stores R3 to add. in stored R3
        STI R4, REG3       ; Stores R0 to add. in stored R4 (commented out)

        LD R0, REG0        ; Restore R0 val
        LD R1, REG1        ; Restore R1 val
        LD R2, REG2        ; Restore R2 val
        LD R3, REG3        ; Restore R3 val
        LD R4, REG4        ; Restore R4 val
        LD R5, REG5        ; Restore R5 val
        LD R6, REG6        ; Restore R6 val
        LD R7, REG7        ; Restore R7 val

        RET                ; Return

REG0    .FILL x0           ; R0 Store
REG1    .FILL x0           ; R1 Store
REG2    .FILL x0           ; R2 Store
REG3    .FILL x0           ; R3 Store
REG4    .FILL x0           ; R4 Store
REG5    .FILL x0           ; R5 Store
REG6    .FILL x0           ; R6 Store
REG7    .FILL x0           ; R7 Store

.END
