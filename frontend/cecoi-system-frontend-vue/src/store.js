import Vue from 'vue'
import Vuex from 'vuex'
import VuexPersist from 'vuex-persist'

Vue.use(Vuex)

const vuexPersist = new VuexPersist({
  key: 'my-sec-app',
  storage: localStorage
})

export default new Vuex.Store({
  plugins: [
    vuexPersist.plugin
  ],
  state: {
    permiteNavegacao: true,
    usuario: null,    
    token: null,
//    token_mock: "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyRGV0YWlscyI6IntcImlkXCI6MSxcImxvZ2luXCI6XCJhZG1pblwiLFwic2VuaGFcIjpcIiQyYSQxMCQybEdZcG9CVk4zejJPQWVJbEV4Mm0uOGZUem1rYmRkNnd0MmlmNnk5TEUvR1V5LkFoTW5jZVwiLFwicGVybWlzc29lc1wiOlt7XCJpZFwiOjEsXCJub21lXCI6XCJST0xFX0FETUlOXCJ9XSxcImVtYWlsXCI6XCJhZG1pbkBjZWNvaS5jb21cIixcInJnXCI6XCIxMjM0NTY3ODlcIixcImNwZlwiOlwiMTIzNDU2Nzg5XCIsXCJub21lXCI6XCJzdXBlciBhZG1pblwiLFwic2V4b1wiOlwiTWFzY3VsaW5vXCIsXCJkYXRhTmFzY2ltZW50b1wiOlwiMDUvMDUvMjAxOVwiLFwidGVsZWZvbmVzXCI6W10sXCJlbmRlcmVjb3NcIjpbXX0iLCJpc3MiOiJici5vcmcuY2VsaW9sZW1vcyIsInN1YiI6InN1cGVyIGFkbWluIiwiZXhwIjoxNTU4MzAwOTA1fQ.7pPgEywvUSF6x7wgt0j-B4dgRx2sHQiyDDcr4wVXJrHB5APxy_FZGFM2tLa0PbMEdSEGlZdqFHLx5b7SkNJOZw"
  },
  mutations: {
    alteraPermiteNavegacao(state) {
      state.permiteNavegacao = !state.permiteNavegacao
    },
    setUsuario(state, usuario) {
      state.usuario = usuario
    },
    setToken(state, token) {
      state.token = token
    },
    logout(state) {
      state.token = null 
      state.usuario = null
    }
  },
  getters: {
    getUsername(state) {
      return state.usuario.nome
    },
    getPermission(state) {
      if (state.usuario.permissoes[0].nome == 'ROLE_EDITOR'){
        return 'editor'
      }
      else if (state.usuario.permissoes[0].nome == 'ROLE_ADMIN'){
        return 'admin'
      }
      else if (state.usuario.permissoes[0].nome == 'ROLE_VIEWER'){
        return 'viewer'
      }
    },
    isAuthenticated(state){
      if (state.token !== null){
        return true;
      }else{
        return false;
      }
    }
  },
  actions: {

  }
})