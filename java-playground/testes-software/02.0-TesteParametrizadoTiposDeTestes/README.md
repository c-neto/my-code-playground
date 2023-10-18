# Dica de aplicação
Essa classe se encontra no pacote org.junit e os seus métodos são estáticos, desta forma, eles podem ser invocados diretamente a partir da classe:
### Assert.assertEquals( “abc”, “abc”);

Porém recomenda-se fazer uma importação estática:
### import static org.junit.Assert.*;

e chamar o método diretamente sem a classe:
### assertEquals( “abc”, “abc”);

Possibilita uma leitura de forma mais direta e legível por parte programador que desenvolve ou até mesmo quem analisa.
---

# Tipos de Metodos
A classe Assert possui os seguintes métodos que são úteis para escrever testes. Esses métodos são usados para verificar falhas, ou seja, eles não lançam a exceção AssertionError quando o resultado do teste está correto:

### * fail(String message) e fail(): 
>> Estes métodos são usados criar uma falha, ou seja, ao colocar ele no corpo de um método de @Test ele irá acusar a falha.

### * assertEquals: 
>> Este método é usado para testar se o resultado da operação confere com o valor esperado. Por ele estar sobrecarregado ele possui várias formas de ser chamado.

### * assertTrue e assertFalse: 
>> Estes métodos são usados para conferir se uma condição é true e false, respectivamente.

### * assertNull e assertNotNull: 
>> * Estes métodos são usados para conferir se um objeto é nulo.

### * assertSame e assertNotSame: 
>> * Estes métodos são usados para conferir se dois objetos referenciam o mesmo objeto.

### assertArrayEquals: 
>> * Este método é usado para conferir se dois arrays possuem o mesmo conteúdo.

### @timeout: (teste de tempo de execução de um método):
>> * @Test(timeout=1000): o teste irá falhar caso ele dure mais de 1 segundo;
>> * @Test(expected=Exception): o teste irá falhar caso ele não lance a exceção esperada ou um subtipo dela.
