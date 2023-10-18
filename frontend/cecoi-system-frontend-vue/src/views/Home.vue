<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <h1>Projeto final da matéria de Tópicos Especiais em Informatica</h1>

    <p>Este é um projeto que tem como objetivo atender os requisitos abaixo:</p>
    <ul>
      <p>Utilizar as tecnologias:</p>
      <li>Vue.js;</li>
      <li>Vuex;</li>
      <li>Router</li>
    </ul>
    <ul>
      <li>
        Possuir uma página de login, responsável por realizar a autenticação com o back-end;
      </li>
      <li>Até a realização do login não deve ser possível navegar para as demais páginas;</li>
    </ul>
    <ul>
      <li>Acessar alguma funcionalidade restrita a alguns usuários.</li>
      <li>
        Quando um usuário tentar acessar uma funcionalidade para a qual não possui acesso, deve ser emitida uma mensagem de erro legível (tratar erros do tipo 403).
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scope>
ul {
  list-style: none;
}
</style>
