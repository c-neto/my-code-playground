#include<stdio.h>
#include<string.h>
#define MAX 5

int main(){

	int x, y, flag=1;
	char n[MAX], matriz[MAX][MAX];

    while(1){
        for (x=0 ; x<MAX ; x++){
            if ( (scanf("%s", matriz[x])==EOF) ){
                return 0;
            }
        }
        flag=1;
        while(flag){

            flag=0;
            for (x=0 ; x<MAX ; x++){

                for(y=0 ; y<MAX ; y++){

                    if (matriz[x][y]=='0'){

                        if(x==0){			// cima
                            if(y==0){
                                if ( (matriz[x][y+1]=='1') && (matriz[x+1][y]=='1') ){
                                    matriz[x][y]='1';
                                    flag=1;
                                }
                            }

                            else if(y==4){
                                if ( (matriz[x][y-1]=='1') && (matriz[x+1][y]=='1') ){
                                    matriz[x][y]='1';
                                    flag=1;
                                }
                            }

                            else{
                                if ( ((matriz[x][y-1]=='1')&&(matriz[x+1][y]=='1'))     //< !
                                ||   ((matriz[x][y-1]=='1')&&(matriz[x][y+1]=='1'))     //< >
                                ||   ((matriz[x+1][y]=='1')&&(matriz[x][y+1]=='1')) ){  //! >
                                    matriz[x][y]='1';
                                    flag=1;
                                }
                            }
                        }

                        else if(x==4){			// baixo
                            if(y==0){
                                if ( (matriz[x-1][y]=='1') && (matriz[x][y+1]=='1') ){  //^ >
                                    matriz[x][y]='1';
                                    flag=1;
                                }
                            }

                            else if(y==4){
                                if ( (matriz[x-1][y]=='1') && (matriz[x][y-1]=='1') ){		//^ <
                                    matriz[x][y]='1';
                                    flag=1;
                                }
                            }

                            else{
                                if ( ((matriz[x][y-1]=='1')&&(matriz[x-1][y]=='1'))
                                ||   ((matriz[x][y-1]=='1')&&(matriz[x][y+1]=='1'))
                                ||   ((matriz[x-1][y]=='1')&&(matriz[x][y+1]=='1')) ){  //^ >
                                    matriz[x][y]='1';
                                    flag=1;
                                }
                            }
                        }

                        else if(y==0){			// lado Esquerdo
                            if ( ((matriz[x-1][y]=='1')&&(matriz[x+1][y]=='1'))       //^ !
                            ||   ((matriz[x-1][y]=='1')&&(matriz[x][y+1]=='1'))       //^ >
                            ||   ((matriz[x+1][y]=='1')&&(matriz[x][y+1]=='1')) ){	  //! >
                                matriz[x][y]='1';
                                flag=1;
                            }
                        }


                        else if(y==4){			// lado Direito
                            if ( ((matriz[x-1][y]=='1')&&(matriz[x+1][y]=='1'))
                            ||   ((matriz[x-1][y]=='1')&&(matriz[x][y-1]=='1'))	//^ <
                            ||   ((matriz[x+1][y]=='1')&&(matriz[x][y-1]=='1')) ){	//! <
                                matriz[x][y]='1';
                                flag=1;
                            }
                        }

                        else{
                            if ( ((matriz[x-1][y]=='1')&&(matriz[x][y-1]=='1'))     //< ^
                            ||   ((matriz[x-1][y]=='1')&&(matriz[x][y+1]=='1'))     //^ >
                            ||   ((matriz[x][y-1]=='1')&&(matriz[x][y+1]=='1'))     //< >
                            ||   ((matriz[x][y-1]=='1')&&(matriz[x+1][y]=='1'))     //< !
                            ||   ((matriz[x+1][y]=='1')&&(matriz[x][y+1]=='1')) ){  //! >
                                matriz[x][y]='1';
                                flag=1;
                            }
                        }
                    }
                }
            }
        }

        for(x=0 ; x<MAX ; x++){
            for(y=0 ; y<MAX ;y++){
                printf("%c", matriz[x][y]);
            }printf("\n");
        }
    }
}
