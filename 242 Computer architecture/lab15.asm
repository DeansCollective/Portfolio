; Dean Trojanowski 
; In this lab, you will convert a string of decimal-digit characters to a numeric value. 
; This means that you will need the MULTIPLY subroutine. You will to have completed Lab 13.

        .ORIG x3000              ; Start at line 3000

        LEA R0, RESULT           ; Load the address of your result variable into R0 (using the LEA)
        LEA R1, OP2              ; Load the address of your variable with the value 10 into R1 (using the LEA)
        LEA R2, RESULT           ; Load the address of your result variable into R2 (using the LEA) 
; (This means that the result of multiplying the result varaible by 
; 10 will be stored into the same variable and overwriting the old value.)
        LD R4, MULTIPLY          ; Load the address of MULTIPLY subroutine into R4 (using the LD)
        LEA R6, BUFFER           ; Load the address of your string variable into R6 (using the LEA)
        LD R5, ASCII_0           ; Load the negation of the ASCII code for '0' in R5 (using the LD)

; Start a loop:
LOOP1   LDR R3, R6, #0           ; Load the value at address R6 into R3 (using the LDR)
        BRz OUT1                 ; Branch out of the loop if this is zero

        ADD R3, R3, R5           ; Add R5 to R3 and store in R3 (this converts from a character to zero or one)
        JSRR R4                  ; Multiply the result by 10 by jumping to the subroutine at the address in R4. 
        ; (The result variable should now be 10 times its previous value.)


        LD R0, RESULT            ; Load the resulting value into R0
        ADD R0, R0, R3           ; Add R3 to R0 and store in R0
        ST R0, RESULT            ; Store R0 to the result
        LEA R0, RESULT           ; Reload the address of your result variable into R0 (This is a repeat of step 3 above. Perhaps we could have used R7 instead of overusing R0, but I usually avoid R7 since it is used for the return address.)
        ADD R6, R6, #1           ; Increment R6 by one
        BRnzp LOOP1              ; Go back to the start of the loop.

OUT1    HALT ; Halt the program

; data
ASCII_0  .FILL x-30              ; The negative ASCII code for '0' (So that we can convert '0' to 0 and '1' to 1)
BUFFER   .STRINGZ "73852"        ; A reasonably sized string of a decimal value.
RESULT   .BLKW 1                 ; result
OP2      .FILL #10               ; operand 2 the value 10, which will be the 2nd operand of the multiplication
MULTIPLY .FILL x3100             ; The address of the MULTIPLY subroutine (that should be x3100)

        .END
