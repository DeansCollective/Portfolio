; Dean Trojanowski
; 3-26-2025
; convert a string of binary-digit characters to a numeric value


        .ORIG   x3000             ; Load your program at address x3000
        AND     R0, R0, #0        ; Set R0 to zero (using the AND)
        LEA     R2, BIN           ; Load the address of your string variable into R2 (using the LEA)
        LD      R3, ASCII_0       ; Load the value of negative ASCII code for '0' in R3

;Start a loop:
LOOP    LDR     R1, R2, #0        ; Load the value at R2 into R1 (using the LDR)
        BRz     DONE              ; Branch out of the loop if this is zero
        ADD     R1, R1, R3        ; Add R3 to R1 and store in R1 (this converts from a character to zero or one)
        ADD     R0, R0, R0        ; Shift R0 to the left 1 bit (that means multiply R0 by 2 or just add R0 to itself)
        ADD     R0, R0, R1        ; Add R1 to R0
        ADD     R2, R2, #1        ; Increment R2 by one to go to the next character in the string
        BRnzp   LOOP              ; Go back to the start of the loop.

DONE    HALT                      ; Halts the program

; At the bottom, have data for:
; The negative ASCII code for '0' (So that we can convert '0' to 0 and '1' to 1)
; A string of a binary value. Make this a reasonably sized string.
ASCII_0 .FILL   xFFD0             ; -'0'
BIN     .FILL   x31               ; '1'
        .FILL   x30               ; '0'
        .FILL   x31               ; '1'
        .FILL   x31               ; '1'
        .FILL   x31               ; '1'
        .FILL   x30               ; '0'
        .FILL   x31               ; '1'
        .FILL   x00               ; Null terminator
        .END
