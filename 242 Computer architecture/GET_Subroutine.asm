; Dean Trojanowski
; GETS subroutine

        .ORIG   x3200       ; Start at 0x3200
        
        ST      R0,REG0     ; Stores R0 to REG0
        ST      R1,REG1     ; Stores R1 to REG1
        ST      R2,REG2     ; Stores R2 to REG2
        ST      R3,REG3     ; Stores R3 to REG3
        ST      R7,REG7     ; Stores R7 to REG7
        
        ADD     R2,R0,#0    ; Sets R2 to R0
        LEA     R0,PROMPT   ; Loads add. of prompt to R0
        TRAP    x22         ; PUTS prints prompt
        
        ADD     R1,R1,#0    ; Adds 0 to R1 (for BR next)
        
S_LOOP  BRnz    E_LOOP      ; Exits loop on R1<=0
        TRAP    x20         ; GETC from user
        TRAP    x21         ; Prints char got to console
        ADD     R3,R0,#-10  ; Subtract 13 from R0 (line feed char) in R3
        BRz     E_LOOP      ; Exits loop on R3=0
        ADD     R3,R0,#-13  ; Subtract 13 from R0 (carriage return char) in R3
        BRz     E_LOOP      ; Exits loop on R3=0
        STR     R0,R2,#0    ; Stores R0 in add. in R2
        ADD     R2,R2,#1    ; R2=R2+1
        ADD     R1,R1,#-1   ; R1=R1-1
        BRnzp   S_LOOP      ; Return to beginning of loop
        
E_LOOP  AND     R0,R0,#0    ; AND sets R0 to 0
        STR     R0,R2,#0    ; Stores R0 to add. in R2
        
        LD      R0,REG0     ; Restores R0 val
        LD      R1,REG1     ; Restores R1 val
        LD      R2,REG2     ; Restores R2 val
        LD      R3,REG3     ; Restores R3 val
        LD      R7,REG7     ; Restores R7 val
        
        RET                 ; RETURN
        
REG0    .BLKW   1           ; R0 storing
REG1    .BLKW   1           ; R1 storing
REG2    .BLKW   1           ; R2 storing
REG3    .BLKW   1           ; R3 storing
REG7    .BLKW   1           ; R7 storing

PROMPT  .FILL   x49         ; "I"
        .FILL   x6E         ; "n"
        .FILL   x70         ; "p"
        .FILL   x75         ; "u"
        .FILL   x74         ; "t"
        .FILL   x20         ; " "
        .FILL   x61         ; "a"
        .FILL   x20         ; " "
        .FILL   x6E         ; "n"
        .FILL   x75         ; "u"
        .FILL   x6D         ; "m"
        .FILL   x62         ; "b"
        .FILL   x65         ; "e"
        .FILL   x72         ; "r"
        .FILL   x3A         ; ":"
        .FILL   x20         ; " "
        .FILL   x0          ; NULL
        
        .END                ; END