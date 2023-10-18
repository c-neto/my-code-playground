<template>
  <div class="container">
    <div class="justify-content-md-center">
      <img src="../assets/cecoilogo.jpg">
    </div>

    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <form @submit.prevent="login">
          <div class="form-group">
            <label for="exampleInputEmail1">Usuário</label>
              <input class="form-control" v-model="user" placeholder="Login">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Senha</label>
            <input type="password" class="form-control" placeholder="Senha" v-model="password">
          </div>
          <button @keyup.enter="login" type="submit" class="btn btn-primary col-sm-5">Entrar</button>
          <div>
            <br>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>



<script>
import axios from "axios";
import { mapGetters } from "vuex";
import { mapMutations } from "vuex";
export default {
  name: "login",
  data() {
    return {
      user: "",
      password: ""
    };
  },
  computed: {
    ...mapGetters(["getPermission"])
  },
  methods: {
    ...mapMutations(["setUsuario", "setToken"]),
    login() {
      axios
        .post("login", {
          login: this.user,
          senha: this.password
        })
        .then(res => {
          console.log(res.data);
          console.log(res.headers.token);

          this.setUsuario(res.data);
          this.setToken(res.headers.token);
          if (this.getPermission == 'editor'){
            this.$router.push("/alunos");
          }
          else if(this.getPermission == 'admin'){
            this.$router.push("/usuarios");
          }
          else if(this.getPermission == 'viewer'){
            this.$router.push("/turmas");
          }
        })
        .catch(error => console.log(error));
    }
  }
};
</script>