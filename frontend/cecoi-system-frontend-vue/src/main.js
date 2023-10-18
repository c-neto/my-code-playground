import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
//import bootstrap from 'bootstrap'
import axios from 'axios'
//import { ServerHttp2Stream } from 'http2';
/*
import { library } from '@fortawesome/fontawesome-svg-core'
import { faCoffee } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(faCoffee)

Vue.component('font-awesome-icon', FontAwesomeIcon)
*/

Vue.config.productionTip = false
Vue.prototype.$http = axios
//axios.defaults.baseURL = 'http://127.0.0.1:8080/'
axios.defaults.baseURL = 'https://cecoi.herokuapp.com'

router.beforeResolve((to, from, next) => {
  if (store.state.token) {
 //   console.log('IF do toekn')
 //   console.log(to)
 //   console.log(from)
    
    if((from.name === "turmas" || to.name === "turmas") && store.state.usuario.permissoes[0].nome != 'ROLE_VIEWER'){
      alert('acesso negado')
      router.push('/');
    }
    else if ((from.name === "alunos" || to.name === "alunos" || 
             (from.name === "usuarios" || to.name === "usuarios" )) && store.state.usuario.permissoes[0].nome == 'ROLE_VIEWER'){
      alert('acesso negado')
      router.push('/')    
    }
    next()
  }
  else if (to.name === "/" || to.name === "login" ||
    from.name === "login" || from.name === "/"
  ) {
    next()
  }
  else {
    alert('acesso negado')
    router.push("/login");
  }
})

axios.interceptors.request.use(config => {
  if (store.state.token) {
    config.headers.Authorization = store.state.token
  }
  return config
})

axios.interceptors.response.use(res => {
  return res
}, error => {
  if (error.response.status === 400) {
    alert('400 - Requisição inválida: O pedido não pôde ser entregue devido à sintaxe incorreta')
  }
  else if (error.response.status === 401) {
    alert('401 - Não autorizado')
  }
  else if (error.response.status === 403) {
    alert('403 - Conflito de Dados: O pedido é reconhecido pelo servidor mas este recusa-se a executá-lo.')
  }
  else if (error.response.status === 409) {
    alert('409 - Conflito de Dados')
  }
  throw error
})

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
