#include <stdio.h>  /* nome: Riquelme Freitas Gomes, DRE: 120032785 */

int main(void){
   
   int carteira_estudante[5];
   int i, j, k, sala, ingressos, valor_custo, meia_entrada, cliente_bradau, codigo_bradau;    
   /* preoço  do ingresso por meia entrada = 10 reais (-50%) */
  /* preoço do ingresso por cliente bradau = 14 reais (-30%) */
                                         
     for(i=0; i<1200; i++) {
       printf("Por favor, selecione a sala de um dos filmes em cartaz: 1 (Star Trek), 2 (Star Wars) e 3 (Tron).\n");
       scanf("%d", &sala);
       if (sala == 1){
          puts("Digite a quantidade de ingressos que deseja comprar");
          scanf("%d", &ingressos);
              if(ingressos > 400 && ingressos < 0){
                puts("A quantidade desejada não está disponível.");
                continue;
        }
       else if(ingressos == 0)
            break;
       else {
          valor_custo = ingressos*20;
          puts("Quantos ingressos obterão desconto de meia entrada?");
          scanf("%d", &meia_entrada);
               if(meia_entrada == 0)
                 break;
               else if (meia_entrada > 0 && meia_entrada <= ingressos)
                       for (j=0; j<meia_entrada; j++){
                           puts("Digite os numeros da carteira de estudante um de cada vez.");
                            for(k=0; k<5; k++){
                               scanf("%d", &carteira_estudante[k]);
                               if((carteira_estudante[0]+carteira_estudante[1]+carteira_estudante[2]+carteira_estudante[3]) % 10 == carteira_estudante[4]);
                                 valor_custo = (meia_entrada*10) + ((ingressos*20)- (meia_entrada*10));
                               /* else {
                                  puts("codigo invalido");
                                  break;
                               } */
                            }
          puts("Quantos ingressos obterao desconto cliente Bradau?");
          scanf("%d", &cliente_bradau);
               if(cliente_bradau == 0)
                 break;
                else if (cliente_bradau > 0 && cliente_bradau <= ingressos){
                        for (j=0; j<cliente_bradau; j++){ 
                            puts("Digite o codigo de cliente bradau");
                            scanf("%d", &codigo_bradau);
                            if((codigo_bradau > 0 && codigo_bradau % 237 == 0) || (codigo_bradau > 0 && codigo_bradau % 341 == 0)){
                               valor_custo = (cliente_bradau*14) + ((ingressos*20)- (cliente_bradau*10));
                               break;
                            }
                }
        } 
        if (sala == 2){
          puts("Digite a quantidade de ingressos que deseja comprar");
          scanf("%d", &ingressos);
              if(ingressos > 400 && ingressos < 0){
                puts("A quantidade desejada não está disponível.");
                continue;
        }
       else if(ingressos == 0)
            break;
       else {
          valor_custo = ingressos*20;
          puts("Quantos ingressos obterão desconto de meia entrada?");
          scanf("%d", &meia_entrada);
               if(meia_entrada == 0)
                 break;
               else if (meia_entrada > 0 && meia_entrada <= ingressos)
                       for (j=0; j<meia_entrada; j++){
                           puts("Digite os numeros da carteira de estudante um de cada vez.");
                            for(k=0; k<5; k++){
                               scanf("%d", &carteira_estudante[k]);
                               if((carteira_estudante[0]+carteira_estudante[1]+carteira_estudante[2]+carteira_estudante[3]) % 10 == carteira_estudante[4]);
                                 valor_custo = (meia_entrada*10) + ((ingressos*20)- (meia_entrada*10));
                               /* else {
                                  puts("codigo invalido");
                                  break;
                               } */
                            }
          puts("Quantos ingressos obterao desconto cliente Bradau?");
          scanf("%d", &cliente_bradau);
               if(cliente_bradau == 0)
                 break;
                else if (cliente_bradau > 0 && cliente_bradau <= ingressos){
                        for (j=0; j<cliente_bradau; j++){ 
                            puts("Digite o codigo de cliente bradau");
                            scanf("%d", &codigo_bradau);
                            if((codigo_bradau > 0 && codigo_bradau % 237 == 0) || (codigo_bradau > 0 && codigo_bradau % 341 == 0)){
                               valor_custo = (cliente_bradau*14) + ((ingressos*20)- (cliente_bradau*10));
                               break;
                            }
                }
        } 
        if (sala == 3){
          puts("Digite a quantidade de ingressos que deseja comprar");
          scanf("%d", &ingressos);
              if(ingressos > 400 && ingressos < 0){
                puts("A quantidade desejada não está disponível.");
                continue;
        }
       else if(ingressos == 0)
            break;
       else {
          valor_custo = ingressos*20;
          puts("Quantos ingressos obterão desconto de meia entrada?");
          scanf("%d", &meia_entrada);
               if(meia_entrada == 0)
                 break;
               else if (meia_entrada > 0 && meia_entrada <= ingressos)
                       for (j=0; j<meia_entrada; j++){
                           puts("Digite os numeros da carteira de estudante um de cada vez.");
                            for(k=0; k<5; k++){
                               scanf("%d", &carteira_estudante[k]);
                               if((carteira_estudante[0]+carteira_estudante[1]+carteira_estudante[2]+carteira_estudante[3]) % 10 == carteira_estudante[4]);
                                 valor_custo = (meia_entrada*10) + ((ingressos*20)- (meia_entrada*10));
                               /* else {
                                  puts("codigo invalido");
                                  break;
                               } */
                            }
          puts("Quantos ingressos obterao desconto cliente Bradau?");
          scanf("%d", &cliente_bradau);
               if(cliente_bradau == 0)
                 break;
                else if (cliente_bradau > 0 && cliente_bradau <= ingressos){
                        for (j=0; j<cliente_bradau; j++){ 
                            puts("Digite o codigo de cliente bradau");
                            scanf("%d", &codigo_bradau);
                            if((codigo_bradau > 0 && codigo_bradau % 237 == 0) || (codigo_bradau > 0 && codigo_bradau % 341 == 0)){
                               valor_custo = (cliente_bradau*14) + ((ingressos*20)- (cliente_bradau*10));
                               break;
                            }
                }
        } 
    }
     /* Não tive tempo de incluir as fileiras e poltronas e de revelar o valor a ser pago */
     return 0;
}