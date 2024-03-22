.data
ARRAY:  .word 6, 2, 3, 9, 5, 7, 1, 4, 0, 8 # Array de exemplo com 10 elementos
TAMANHO: .word 10       # Tamanho do array
ESPACO:  .asciiz ", "	 # String de virgula e espaco

.text
.globl main

main:
    # Carrega o endereço base do array e o tamanho em registradores
    la $a0, ARRAY
    lw $a1, TAMANHO    # Tamanho do array
    jal bSort  # Chama a funcao de ordenacao por flutuacao
    
    # Imprime o array ordenado
    la $a0, ARRAY
    lw $a1, TAMANHO
    jal printArray

    # Encerra o programa
    li $v0, 10
    syscall


# Função swap
swap:
    sll $t1, $a1, 2    # $t1 = k * 4
    add $t1, $a0, $t1  # $t1 = v + (k*4)  (endereco de v[k])
    lw $t0, 0($t1)     # $t0 (temp) = v[k]
    
    lw $t2, 4($t1)     # $t2 = v[k+1]
    sw $t2, 0($t1)     # v[k] = $t2 (v[k+1])
    sw $t0, 4($t1)     # v[k+1] = $t0 (temp)
    jr $ra             # retorna

# Funcao bubbleSort
bSort:
    addi $sp, $sp, -20       # Reserva espaco na pilha
    sw $ra, 16($sp)
    sw $s3, 12($sp)
    sw $s2, 8($sp)
    sw $s1, 4($sp)
    sw $s0, 0($sp)
    
    # Move parametros
    move $s2, $a0            # salva $a0 em $s2
    move $s3, $a1            # salva $a1 em $s3
    
    # Laco externo
    move $s0, $zero          # i = 0
for1tst:
    slt $t0, $s0, $s3        # $t0 = 0 se $s0 >= $s3  (i >= n)
    
    # Laco interno
    beq $t0, $zero, exit1    # vai para exit1 se $s0 >= $s3 (i >= n)
    addi $s1, $s0, -1        # j = i - 1
for2tst:
    slti $t0, $s1, 0         # $t0 = 1 se $s1 < 0 (j < 0)
    bne $t0, $zero, exit2    # vai p/ exit2 se $s1 < 0 (j < 0)
    sll $t1, $s1, 2          # $t1 = j * 4
    add $t2, $s2, $t1        # $t2 = v + (j * 4)
    lw $t3, 0($t2)           # $t3 = v[j]
    lw $t4, 4($t2)           # $t4 = v[j + 1]
    slt $t0, $t4, $t3        # $t0 = 0 se $t4 >= $t3
    beq $t0, $zero, exit2    # vai p/ exit2 se $t4 >= $t3
    
    # Passagem de parametros
    move $a0, $s2            # 1º param de swap é v
    move $a1, $s1            # 2º param de swap é j
    jal swap                 # chama swap
    
    # Laco interno
    addi $s1, $s1, -1        # j -= 1
    j for2tst                # salta p/ teste do laco interno
    
    # Laco externo
exit2:
    addi $s0, $s0, 1         # i += 1
    j for1tst                # salta p/ teste do laco externo
exit1:
    lw $s0, 0($sp)
    lw $s1, 4($sp)
    lw $s2, 8($sp)
    lw $s3, 12($sp)
    lw $ra, 16($sp)
    addi $sp, $sp, 20
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
