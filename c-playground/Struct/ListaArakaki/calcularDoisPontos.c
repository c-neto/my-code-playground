#include <stdio.h>
#include <math.h>

typedef struct {
    float x;
    float y;
}Str_COORD;

void exibe_coord (Str_COORD PONTO){
    printf("%.2f,%.2f\n", PONTO.x, PONTO.y);
    return;
}

Str_COORD soma_pontos ( Str_COORD PA, Str_COORD PB ){
    Str_COORD temp;

    temp.x = PA.x+PB.x;
    temp.y = PA.y+PB.y;

    return temp;
}

float distancia_pontos ( Str_COORD PA, Str_COORD PB ){
    float temp;

    temp = sqrt( pow(PA.x-PB.x,2) + pow(PA.y-PB.y,2) );

    return temp;
}

void main (){

    Str_COORD pa;
    Str_COORD pb;

    pa.x=10;
    pa.y=10;

    pb.x=15;
    pb.y=15;

    exibe_coord(soma_pontos(pa, pb) ) ;
    printf("\n%.2f", distancia_pontos(pa, pb) );
}
