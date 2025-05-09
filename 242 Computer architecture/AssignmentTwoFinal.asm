; Dean Trojanowski
        .ORIG x3200                         ; The subroutine should start at location x3200

        ST R0, SAVER0                      ; Save the values in registers R0
        ST R1, SAVER1                      ; Save the values in registers R1
        ST R2, SAVER2                      ; Save the values in registers R2
        ST R3, SAVER3                      ; Save the values in registers R3
        ST R7, SAVER7                      ; Save the values in registers R7

        AND R2, R0, #0                     ; Initialize R2 to new2.gif R0 zero
        ADD R2, R2, R0                     ; Add R2 to R0 and store in R2

        LEA R0, PROMPT                     ; Load the address of the prompt in R0 (use LEA)
        TRAP x22                           ; Call the PUTS trap (Trap x22) to print the prompt to the console

        ADD R1, R1, #0                     ; Add zero to R1 (This is just so that the nzp flags will be updated for the following branch)

LOOP1   BRnz OUT1                          ; Branch out of the loop if R1 is less than or equal to zero

        TRAP x20                           ; Call the GETC trap (Trap x20) to get a character from the user
        TRAP x21                           ; Call the OUT trap (Trap x21) to echo the character to back to the console (so that the user knows they they actually entered the correct character)

        LD R3, RERE                      ; Subtract 13 (which is the ASCII of a return character) from R0 and store in R3.
        NOT R3, R3
        ADD R3, R3, #1
        ADD R3, R0, R3
        BRz OUT1                           ; Branch out of the loop if R3 is zero

        STR R0, R2, #0                      ; Store the character (in R0) to the address in R2 (using the STR)
        ADD R2, R2, #1                     ; Increment R2 by one (so that the next character will be store in the next position)
        ADD R1, R1, #-1                      ; Decrement R1 by one

        BRnzp LOOP1                        ; Start a loop that

OUT1    AND R0, R0, #0                        ; Set R0 to 0
        STR R0, R2, #0                     ; Store R0 to the address in R2 (using the STR)

        LD R0, SAVER0                      ; Restore the values in R0
        LD R1, SAVER1                      ; Restore the values in R1
        LD R2, SAVER2                         ; Restore the values in R2
        LD R3, SAVER3                      ; Restore the values in R3
        LD R7, SAVER7                      ; Restore the values in R7
        RET                                ; Return

; Data at the bottom
SAVER0  .BLKW 1                            ; the values of registers 0
SAVER1  .BLKW 1                            ; the values of registers 1
SAVER2  .BLKW 1                                ; the values of registers 2
SAVER3  .BLKW 1                            ; the values of registers 3
SAVER7  .BLKW 1                            ; the values of registers 7
RERE  .FILL #13                          ; ASCII 13 (Return key)
PROMPT  .STRINGZ "876567"                   ; a string for the prompt
        .END


; Driver program
        .ORIG x3000                         ; Created a driver program for your subroutine.

        LEA R0, BUFFER                      ; Load the address of the buffer into R0 (using the LEA)
        LD  R1, BUFSIZE                      ; Load the value of the BUFSIZ into R1 (using LD)
        LD  R4, GETSA                    ; Load the address of the GETS subroutine in R4 (using LD)
        JSRR R4                             ; Jump to the subroutine at the address of the GETS
        HALT                                ; Halt

BUFSIZE  .FILL #8                           ; A variable for the buffer size (BUFSIZ)
BUFFER   .BLKW 9                            ; A buffer of at least BUFSIZ + 1 words
GETSA .FILL x3200                        ; The address of the GETS subroutine (x3200)
        .END
