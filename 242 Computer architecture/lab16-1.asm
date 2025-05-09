.ORIG x3000 ;Load the program at address x3000

LEA R6, BUFFER;Load the address of the buffer into R6
LD R0, BUFSIZ;Load the BUFSIZ into R0
ADD R6, R6, R0;Add R0 to R6 (so that R6 is now pointing to the last word of the buffer)
AND R0, R0, x0;*REDO Set R0 to zero
STR R0, R6, x0;**REDO Store R0 into the address in R6 (This makes sure that the string is null-terminated)
ADD R6, R6, x-1;Decrement R6 (back up to the previous spot in the buffer)
LD R5, ASCII_0;*REDO Load the ASCII code for '0' into R5
AND R0, R0, xA ;Set R0 to 10 (it should already be zero at this point) (We really should be putting the BUFSIZ here so that we don't go beyond the buffer. But we are only doing to first 9 digits, which are single characters, so we will just make sure that the buffer is more than 10.)

;Start a loop:
LOOP1 ADD R0, R0, x-1;Decrement R0 by 1
BRz OUT1;*****REDO Branch out of the loop if R0 is zero
ADD R2, R5, R0;*REDO Add R5 to R0 and store in R2 (convert to ASCII)
STR R2, R6, x0;Store R2 to the address in R6 (store the character in the buffer)
ADD R6, R6, x-1;Decrement R6 by one (back up to the previous spot in the buffer)
BRnzp LOOP1;*REDO Go back to the top of the loop

OUT1

ADD R6, R6, x1;Increment R6 by one (Right now R6 is the next empty spot in the buffer, so incrementing it by one means it will be at the start of our string)
AND R0, R6, x0;*REDO Assign the value in R6 to R0 (that should be the address of the string not the first character in the string)
TRAP x22;Call the PUTS trap (trap vector x22)
LD R0, ASCII_xA ;Load the newline character into R0
TRAP x21;Call the PUTC trap (trap vector x21) to output a newline

HALT

;Have data at the bottom of the program for:
BUFFER .BLKW "32";A buffer of some number of words (You can decide how big to make the buffer. Make it bigger than 11, but it does need to be more than 100.)
BUFSIZ .FILL #31 ; *REDO A BUFSIZ, which is the number of characters the buffer can hold. This should be 1 less than the size of your buffer because we need to have one spot for the null character
ASCII_0 .FILL x30;The ASCII code for '0' (which is x30)
ASCII_xA .Fill xA;The ASCII code for a newline (which is ASCII xA or #10)

.END
