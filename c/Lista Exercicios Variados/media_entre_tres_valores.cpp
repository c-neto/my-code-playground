#include<stdio.h>
#include<conio.h>
int main (void)
{
  
  int ano_atual, ano_nascimento, idade;
  
  printf ("Informe seu Ano de Nascimento: ");
  	scanf ("%d", & ano_nascimento);
  
  printf ("informe o ano atual: ");
    scanf ("%d", & ano_atual);
    
    idade = ano_atual-ano_nascimento;
    
    printf ("sua idade eh: %d", idade);
  
  
  
}
