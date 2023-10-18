import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
/*
import Aluno from "./views/Aluno.vue";
import Usuario from "./views/Usuario.vue";
import Login from './views/Login.vue';
import Teste from './views/teste.vue';
import Turmas from './views/Turmas.vue';
*/

import store from './store';

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: '/',
      component: Home
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('./views/Login.vue')
    },
    {
      path: '/usuarios',
      name: 'usuarios',
      component: () => import('./views/Usuario.vue')/*
      beforeEach: (to, from, next) => {
        console.log('carlos beforeEachUsuario')
        /*if((from.name === "/turmas" || to.name === "/turmas") && store.state.usuario.permissoes[0].nome != 'ROLE_VIEWER'){
          alert('acesso negado')
          router.push("/login");
        }
          if (to.name === 'usuarios' ||
          from.name === 'usuarios' ||
          from.name === 'login' ||
          from.name === 'alunos') {
          next()
        }
        else {
          alert('acesso negado')
          next(false)
        }    
    }      */
    },
    {
      path: '/turmas',
      name: 'turmas',
      component: () => import('./views/Turmas.vue')/*,
      beforeEach: (to, from, next) => {
        if (to.name === 'turmas' ||
          from.name === 'turmas' ||
          from.name === 'login') {
          next()
        }
        else{
          alert('acesso negado')
          next(false)
        }
      }*/
    },
    {
      path: '/alunos',
      name: 'alunos',
      component: () => import('./views/Aluno.vue')/*,
      beforeEach: (to, from, next) => {
        if (to.name === 'alunos' ||
          from.name === 'alunos' ||
          from.name === 'login'  ||
          from.name === 'usuarios') {
          next()
        }
        else {
          alert('acesso negado')
          next(false)
        }
      }*/
    }
  ]
})
/*
router.beforeEach((to, from, next) => {
  if (store.state.permiteNavegacao) {
    next()
  } else {
    next(false)
  }
})
*/
export default router 