<template>
  <div class="container">
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">CECOI</a>

      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul v-if="isAuthenticated" class="navbar-nav mr-auto">
          <li  class="nav-item" v-if="getPermission == 'viewer'">
            <a style="cursor: pointer" class="nav-link" @click="gotoTurmas">Turmas</a>
          </li>
          <li class="nav-item" v-if="getPermission == 'admin' || getPermission == 'editor'">
            <a style="cursor: pointer" class="nav-link" @click="gotoAlunos">Alunos</a>
          </li>
          <li class="nav-item" v-if="getPermission == 'admin' || getPermission == 'editor'">
            <a style="cursor: pointer" class="nav-link" @click="gotoUsuarios">Usuários</a>
          </li>
        </ul>
      </div>
      <div class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <div v-if="isAuthenticated" class="nav-link">
              <i v-if="getPermission == 'admin'" class="fas fa-user-shield"></i>
              <i v-else class="fas fa-user"></i>
              {{getUsername}} 
            </div>
          </li>
          <li class="nav-item">
            <button
              v-if="isAuthenticated"
              class="btn btn-outline-danger my-2 my-sm-0"
              @click="doLogout"
            >Logout</button>
            <button v-else class="btn btn-outline-success my-2 my-sm-0" @click="doLogin">Login</button>
          </li>
        </ul>
      </div>
    </nav>
    <br>
    <br>
    <br>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
import { mapMutations } from "vuex";

export default {
  name: "topbar",
  methods: {
    ...mapMutations(["logout"]),
    doLogin() {
      this.$router.push("/login");
    },
    doLogout() {
      this.logout();
      this.$router.push("/");
    },
    gotoUsuarios(){
      this.$router.push("/usuarios");
    },
    gotoAlunos(){
      this.$router.push("/alunos");
    },
    gotoTurmas(){
      this.$router.push("/turmas");
    }
  },
  computed: {
    ...mapGetters(["isAuthenticated", "getUsername", "getPermission"])
  }
};
</script>
