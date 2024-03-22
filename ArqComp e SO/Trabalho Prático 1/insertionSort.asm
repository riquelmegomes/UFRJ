.data
ARRAY:  .word 21, 12, 3, 1, 2, 7, 5, 4, 0, 56 # Array de exemplo com 10 elementos
TAMANHO: .word 10       # Tamanho do array
ESPACO:  .asciiz ", "	 # String de virgula e espa�o

.text
.globl main

main:
    # Carrega o endereco base do array e o tamanho em registradores
    la $a0, ARRAY
    lw $a1, TAMANHO   # Carrega o valor de TAMANHO em $a1

    # Chama a funcao de ordenacao por insercao
    jal insertionSort
    
    # Imprime o array ordenado
    la $a0, ARRAY
    lw $a1, TAMANHO
    jal printArray

    # Encerra o programa
    li $v0, 10
    syscall
    
    # Funcao de ordenacao
    insertionSort:
	la $a0, ARRAY	      # Carrega o enderecoo base da matriz A (array) no registrador $a0.				
	la $a1, TAMANHO	      # Carrega o endereco da variavel TAMANHO no registrador $a1.			
	lw $a1, 0($a1)	      # Carrega o valor da variavel TAMANHO
	addi $t0, $zero, 1    # Inicializa i com 1: i = 1	
	
	for_loop:	
		slt $t3, $t0, $a1        # Compara o contador $t0 com o tamanho da matriz $a1. --> i <= TAMANHO ?		
		beq $t3, $zero, exit1    # Saia do loop se i >= tamanho
		sll $t2, $t0,2	         # Atualiza o endereco base do array A			
		add $t2, $a0,$t2         # eleito = A[i];		
		lw $s1, 0($t2)	         # Carrega o valor do eleito em $s1		
		addi $t1, $t0,-1         # Calcula j = i - 1			
			
	while_loop:	sge $t4, $t1, $zero	  # Verificacao para quando j >= 0 (recebe 1 - verdadeiro)  		
		sll $t2, $t1, 2	                  # Atualiza a posicao do array			
		add $t2, $a0,$t2                 # eleito = A[j]		
		lw $s3, 0($t2)	                 # Guardamos eleito em $s3			
		slt $t5, $s1, $s3                # comparamos se eleito eh menor que A[j]		
		and $t4, $t4, $t5                # fazemos uma operacao logica AND		
		beq $t4, $zero, exit2            # se falso saimos do loop
		sw $s3, 4($t2)	                 # A[j+1] = A[j]		
		addi $t1, $t1, -1                # j = j - 1			
		j while_loop                     # volta para o inicio do loop while
	exit2:	
		sw $s1, 4($t2)                   # guarda A[i++]				
		addi $t0,$t0,1	                  # i = i +1			
		j for_loop	                  # volta para o inicio do loop for				
	exit1:



# funcao para imprimir o array ordenado
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
