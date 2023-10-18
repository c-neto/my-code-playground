# Conceito de Injeção de Depêndencias

Para entendermos o que é Injeção de Depêndencias (_Dependency Injection_ em inglês, ou DI), primeiramente devemos entender o que é Inversão de Controle (Inversion of Control ou IoC, em inglês). 
 
A Inversão de Controle é um Padrão de Desenvolvimento de Código, uma maneira de se codificar. Na inversão de controle, a sequência (controle) de chamadas dos métodos é invertida em relação à programação tradicional, ou seja, ela não é determinada diretamente pelo programador. Este controle é delegado a uma infraestrutura de software muitas vezes chamada de Contêineres (não confudir com Docker e afins), que são gerenciadores de contextos ou a qualquer outro componente que possa tomar controle sobre a execução do código.
 
A Injeção de Dependencia é um tipo de Inversão de Controle. Basicamente ela contribui com o baixo acoplamento entre as classes, em que as classes com dependências de outras classes, não tem por responsabilidade instanciar suas depedências, estas depêndencias são __injetadas__ por algum Contêiner gerenciador de contexto. Em Java, as depêndencias injetadas pelos Containers, utilizam como meio de injeção, métodos Construtures e metodos _setters_, Interfaces ou por meio de anotações.

Em resumo, para trabalharmos com Injeção de Depêndencias, precisamos fundamentalmente de três componentes:

- Contêiner Gerenciador de Contexto;
- Depêndencias instanciadas, denominadas _Beans_.; e
- Classe que receberá a Injeção. 


# Spring em Ação

Para o desenvolvimento com Injeção de Dependência, o Spring oferece o módulo `spring-context`. Nas seções de códigos nos subtópicos abaixo, entende-se que a anotação `@Component` serve para tornar a classe em questão elegível para a gerencia do Spring.

## Container Gerenciador de Contexto 

As seção de código abaixo, mostra como instanciar o Container Gerenciador de Contexto do Spring, em que `context` é o Container Gerenciador de Contexto e os _Beans_ são fornecidos pela classe `Factories`.

```java
public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.scan(ApplicationMain.class.getPackage().getName());
    context.refresh();

    Impressor printer = context.getBean(Impressor.class);

    printer.mostrarInformacoes();
}
...
```

## Criação dos Beans 

Para popular o Conteiner com os _Beans_, deve-se anotar com `@Bean` as funções que tem como o retorno as instancias prontas de depêndencias que serão injetadas. Caso dois Beans tiverem a mesmo tipo, deve-se anotar `@Qualifier("ID-DO-BEAN")` para distinguir no ato da injeção. 

```java
@Component
public class Factories {
    @Bean
    @Qualifier("gaucho-da-gema")
    public GauchoCostumes produzGauchoRaiz(){
        return new GauchoRaiz("Humberto Gessinger", 50);
    }

    @Bean
    @Qualifier("gaucho-inocente")
    public GauchoCostumes produzGauchoNutella(){
        return new GauchoNutella("Enzo", 20);
    }
...
```

O que define o _Bean_ não é o tipo de retorno dos metódos produtores, mas sim a Interface que a classe da instância produzida implementa. Caso a instância produzida não implementar nenhuma interface, o tipo dela que definirá o _Bean_.


## Classe que recebe a Injeção

As classes que contém as depêndencias, são instanciadas pelo Framework `spring-context`, como mostra a seção abaixo: 
 
```java
public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.scan(ApplicationMain.class.getPackage().getName());
    context.refresh();

    Impressor printer = context.getBean(Impressor.class);
...
}
```
> `Impressor` é uma classe que contém dependencias. 
 
A seção de código abaixo, mostra uma classe com dependências. As dependências são denotadas como ponto de injeção por meio da anotação `@Autowired`. A anotação `@Qualifier`, foi usada devido o fato de se ter  dois _Beans_ no Container implementado a Interface `GauchoCostumes`.

```java
@Component
public class Impressor {


    @Qualifier("gaucho-inocente")
    @Autowired
    private GauchoCostumes gauchoNutella;

    @Qualifier("gaucho-da-gema")
    @Autowired
    private GauchoCostumes gauchoRaiz;
...
```

> Quase sempre as dependências são definidas com Interfaces, contribuindo ainda mais com o desacoplamento do código.


# Sobre o Projeto

- Estrutura:

```
└── src/main/java/br/augustoliks
    ├── ApplicationMain.java
    ├── domain
    │   ├── api
    │   │   ├── BrasileiroCostumes.java
    │   │   ├── CariocaCostumes.java
    │   │   └── GauchoCostumes.java
    │   ├── Factories.java
    │   └── implementation
    │       ├── CariocaNutella.java
    │       ├── CariocaRaiz.java
    │       ├── GauchoNutella.java
    │       ├── GauchoRaiz.java
    │       └── Pessoa.java
    └── services
        └── Impressor.java
```

- Saída:

```
Gaucho Nutella:
	- falaEnrolado:false
	- jogaFutebol:false
	- ouveBaitaca:false
	- tomaChimarrao: true
Gaucho Raiz:
	- falaEnrolado:true
	- jogaFutebol:false
	- ouveBaitaca:true
	- tomaChimarrao: true
Carioca Raiz:
	- jogaFutebol:true
	- vaiPraPraia:true

Carioca Nutella:
	- jogaFutebol:false
	- vaiPraPraia:true
```

# Referências

- https://blog.algaworks.com/injecao-de-dependencias-com-spring/
- https://dzone.com/articles/what-is-a-spring-context
- https://pt.wikipedia.org/wiki/Invers%C3%A3o_de_controle
- https://www.devmedia.com.br/inversao-de-controle-x-injecao-de-dependencia/18763
