#!/bin/bash

regra_REJECT(){
	iptables -A FORWARD -i "$eth_localweb" -s "$ip" -m string --algo bm --string "$url" -j REJECT
}


regra_ACCEPT(){
	iptables -A FORWARD -i "$eth_localweb" -s "$ip" -m string --algo bm --string "$url" -j ACCEPT
}



menu(){
	echo Menu de Opções:
	echo 1 - Inserir o bloqueio de sites manualmente
	echo 2 - Listar sites bloqueados
	echo 3 - Liberar sites bloqueados
	echo 4 - Liberar TODOS os bloqueios
	echo 5 - Sair
}

tratativa_excessao(){
	while [ $op  -gt 5 -o $op -le 0 ]
	do
		clear
		echo Digite uma opção válida!
		read op
	done
	
}

casos(){
	case $1 in

	"1")
		opcao1
	;;		

	"2")
		opcao2
	;;

	"3")
		opcao3
	;;

	"4")
		opcao4
	;;

	"5")
		echo Deseja sair? s = sim / n = não: ; read op
		while [ $op != "s" ] && [ $op != "n" ] 
		do
			echo -n Digite uma opção válida! sim/não: ; read op
		done

		if [ $op == "s" ] 
		then
			exit
		elif [ $op == "n" ] 
		then 
			main
		fi
	;;
	esac
}

opcao1(){
	echo -n Digite o site a ser bloqueado: ; read url
	echo -n Digite o nome da placa de rede da sua rede: ; read eth_localweb
	echo -n Deseja bloquear o acesso a todos hosts-clientes? s - sim / n - não: ; read op

	while [ $op != "s" ] && [ $op != "n" ]
	do
		echo -n Insira uma opção válida! s - sim / n - não: ; read op
	done
	if [ $op == "s" ] ; then
		ip="0/0"
		regra_REJECT
	fi
	if [ $op == "n" ]
	then
		op="s"
		while [ $op != "s"] 
		do
			echo Digite o endereço de IP, do cliente que deseja não ter acesso: ; read $ip 
			regra_REJECT
			echo -n Deseja Inserir outro endereço de IP? s - sim / n - não: ; read $op
		done
	fi
	if [ $op == "s" ]; then 
		clear
		regra_REJECT
		echo $url Bloqueado com Sucesso! ; sleep 2
		
	fi
	casos "5"	

}

opcao2(){
	iptables -L FORWARD
	casos "5"
}	

opcao3(){
	echo -n Digite o site a ser LIBERADO: ; read url
	echo -n Digite o nome da placa de rede da sua rede: ; read eth_localweb
	echo -n Deseja liberar o acesso a todos hosts-clientes? s - sim / n - não: ; read op

	while [ $op != "s" ] && [ $op != "n" ]
	do
		echo -n Insira uma opção válida! s - sim / n - não: ; read op
	done
	if [ $op == "s" ] ; then
		ip="0/0"
		regra_ACCEPT
	fi
	if [ $op == "n" ]
	then
		op="s"
		while [ $op != "s"] 
		do
			echo Digite o endereço de IP, do cliente que deseja ter acesso: ; read $ip 
			regra_ACCEPT
			echo -n Deseja Inserir outro endereço de IP? s - sim / n - não: ; read $op
		done
	fi
	if [ $op == "s" ]; then 
		clear
		regra_ACCEPT
		echo $url LIBERADO com Sucesso! ; sleep 3 
	fi
	casos "5"	

}

opcao4(){
	echo Deseja APAGAR TODOS AS REGRAS CRIADAS? s = sim / n = não: ; read op
		while [ $op != "s" ] && [ $op != "n" ] 
		do
			echo -n Digite uma opção válida! sim/não: ; read op
		done

		if [ $op == "s" ] 
		then
			iptables -F FORWARD		
		elif [ $op == "n" ] 
		then 
			casos "5"
		fi
		main
}


main(){
	clear
	echo !!! Bem Vindo ao Facilitador de regras de Firewall IPTABLES !!!
	menu
	echo -n Digite a opção desejada: ; read op
	tratativa_excessao
	casos "$op"
}
main
