.data
ARRAY:  .word 6, 2, 3, 9, 5, 7, 1, 4, 0, 8 # Array de exemplo com 10 elementos
TAMANHO: .word 10       # Tamanho do array
ESPACO:  .asciiz ", "	 # String de virgula e espaco

.text
.globl main

main:
    # Carrega o endereco base do array e o tamanho em registradores
    la $a0, ARRAY
    lw $a1, TAMANHO    # Tamanho do array
    jal selectionSort  # Chama a funcao de ordenacao por selecao
    
    # Imprime o array ordenado
    la $a0, ARRAY
    lw $a1, TAMANHO
    jal printArray

    # Encerra o programa
    li $v0, 10
    syscall
    
    
# Funcao swap    
swap:    
    sll $t1, $a1, 2     # $t1 = i * 4
    add $t1, $a0, $t1   # $t1 = v + (i*4)  (endereco de v[i])
    sll  $t2, $a2, 2    # $t2 = j * 4
    add  $t2, $a0, $t2  # $t2 = v + (j*4)  (endereco de v[j])
    lw  $t0, 0($t1)     # $t0 (temp) = v[i]
    lw  $t3, 0($t2)     # $t3 = v[j]
    sw  $t3, 0($t1)     # v[i] = v[j]
    sw  $t0, 0($t2)     # v[j] = $t0
    jr  $ra             # retorna

# Funcao selectionSort
selectionSort: 
    addi $sp, $sp, -24       # Reserva espaco na pilha
    sw $ra, 20($sp)
    sw $s4, 16($sp)
    sw $s3, 12($sp)
    sw $s2, 8($sp)
    sw $s1, 4($sp)
    sw $s0, 0($sp)
    
    # Move parametros
    move $s3, $a0            # salva $a0 em $s3
    move $s4, $a1            # salva $a1 em $s4
    
    move $s0, $zero          # i = 0
for1tst:
    addi $t0, $s4, -1        # t0 = n - 1
    slt $t1, $s0, $t0        # $t1 = 0 se $s0 >= $s4 - 1  (i >= n-1)
    beq $t1, $zero, exit1    # vai para exit1 se $s0 >= $s4 (i >= n-1)
    move $s2, $s0            # indiceMenor = i
    
    addi $s1, $s0, 1         # j = i+1
for2tst: 
    slt $t2, $s1, $s4        # $t2 = 0 se $s1 >= $s4  (j >= n)
    beq $t2, $zero, exit2    # vai para exit2 se $s1 >= $s4  (j >= n)
    
    sll $t3, $s1, 2          # $t3 = j * 4
    add $t3, $s3, $t3        # $t3 = v + (j * 4)
    lw	$t4, 0($t3)	      # $t4 = v[j]
    
    sll $t5, $s2, 2          # $t5 = indiceMenor * 4
    add $t5, $s3, $t5        # $t5 = v + (indiceMenor * 4)
    lw	$t6, 0($t5)	      # $t6 = v[indiceMenor]
    
    bge	$t4, $t6, if_exit    # pula o if quando v[i] >= v[indiceMenor]
    move $s2, $s1            # indiceMenor = j
  
if_exit:
    addi $s1, $s1, 1	# j += 1
    j for2tst
    
exit2:
    # Passagem de parametros
    move $a0, $s3            # 1º param de swap é v
    move $a1, $s0            # 2º param de swap é i
    move $a2, $s2            # 3º param de swap é indiceMenor
    jal swap                 # chama swap
    
    addi $s0, $s0, 1         # i += 1
    j for1tst                # salta p/ teste do laco externo
    
exit1:
    lw $s0, 0($sp)
    lw $s1, 4($sp)
    lw $s2, 8($sp)
    lw $s3, 12($sp)
    lw $s3, 16($sp)
    lw $ra, 20($sp)
    addi $sp, $sp, 24
    jr $ra



# Funcao para imprimir o array ordenado
printArray:	
    la  $s0, TAMANHO
    lw  $s0, 0($s0)		
    addi  $t0, $zero, 0		
    la  $t1, ARRAY		
NEXT_ARRAY_PRINT:
    beq $t0, $s0, DONE_PRINTING 	
    addi $v0, $zero, 1		
    lw $a0, 0($t1)			
    syscall	
    			
    addiu $t1, $t1, 4		
    addiu  $t0, $t0, 1		
    beq $t0, $s0, DONE_PRINTING
    addi  $v0, $zero, 4		
    la $a0, ESPACO
    syscall			

    j NEXT_ARRAY_PRINT	
    	
DONE_PRINTING:
    addi $v0, $zero, 10		
    syscall	
