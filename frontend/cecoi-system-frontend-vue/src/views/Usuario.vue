<template>
  <div class="container">

    <div class="row" v-if="getPermission == 'admin'">
      <div class="col-sm">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Adicionar<br> <u><b>ADMINISTRADOR</b></u> </h5>
            <p class="card-text">
              Clique aqui para adicionar um usuário de nível Administrador<br><br>
              Este usuário será capaz de <b>Listar</b>, <b>Inserir</b>, <b>Apagar</b>, <b>Atualizar</b> outros Usuários e Alunos
              </p>
            <button class="btn btn-primary" href data-toggle="modal" data-target="#modal_add_aluno" 
                    @click="link_admin">

              <i class="fas fa-user-plus"></i>
              Adicionar Usuário
            </button>
          </div>
        </div>
      </div>

      <div class="col-sm">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Adicionar<br> <u><b>SECRETÁRIA</b></u></h5>
            <p class="card-text">Clique aqui para adicionar um usuário de nível Editor
              <br><br>
              Este usuário será capaz de <b>Listar</b>, <b>Editar</b> Usuários e Alunos
            </p>
            <button class="btn btn-primary" href data-toggle="modal" data-target="#modal_add_aluno" 
                    @click="link_editor">

              <i class="fas fa-user-plus"></i>
              Adicionar Usuário
            </button>
          </div>
        </div>
      </div>      

      <div class="col-sm">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Adicionar<br> <u><b>PROFESSOR</b></u> </h5>
            <p class="card-text">Clique aqui para adicionar um usuário de nível Professor.<br><br>
              Este usuário será capaz de <b>Listar</b>, <b>Inserir</b>, <b>Apagar</b>, <b>Atualizar</b> Turmas, além de ser possível <b>listar</b> os Alunos nelas presentes.  
            </p>

            <button class="btn btn-primary" href data-toggle="modal" data-target="#modal_add_aluno" 
                    @click="link_viewer">

              <i class="fas fa-user-plus"></i>
              Adicionar Usuário
            </button>
          </div>
        </div>
      </div>
      </div>

    <div
      id="modal_add_aluno"
      class="modal fade"
      tabindex="-1"
      role="dialog"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <form class="form" @submit.prevent="addUsuario">
            <div class="container">
              <h5 class="modal-title">Usuário</h5>

              <div class="form-group">
                <label>Nome</label>
                <input v-model="new_usuario.nome" type="text" class="form-control form-control-sm">
              </div>

              <div class="form-group">
                <label>RG</label>
                <input v-model="new_usuario.rg" type="text" class="form-control form-control-sm">
              </div>

              <div class="form-group">
                <label>CPF</label>
                <input v-model="new_usuario.cpf" type="text" class="form-control form-control-sm">
              </div>

              <div class="form-group">
                <label>Data de Nascimento</label>
                <input
                  v-model="new_usuario.dataNascimento"
                  value="2015/08/09"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Email</label>
                <input v-model="new_usuario.email" type="text" class="form-control form-control-sm">
              </div>

              <div class="form-group">
                <label>Login</label>
                <input v-model="new_usuario.login" type="text" class="form-control form-control-sm">
              </div>

              <div class="form-group">
                <label>Senha</label>
                <input v-model="new_usuario.senha" type="text" class="form-control form-control-sm">
              </div>

              <div class="form-group">
                <label>Sexo</label>
                <input v-model="new_usuario.sexo" type="text" class="form-control form-control-sm">
              </div>

              <div class="form-group">
                <label>Bairro</label>
                <input
                  v-model="new_usuario.enderecos[0].bairro"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>CEP</label>
                <input
                  v-model="new_usuario.enderecos[0].cep"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Cidade</label>
                <input
                  v-model="new_usuario.enderecos[0].cidade"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Complemento</label>
                <input
                  v-model="new_usuario.enderecos[0].complemento"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Numero</label>
                <input
                  v-model="new_usuario.enderecos[0].numero"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Rua</label>
                <input
                  v-model="new_usuario.enderecos[0].rua"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>UF</label>
                <input
                  v-model="new_usuario.enderecos[0].uf"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="col-group">
                <label>n Telefone</label>
                <input
                  v-model="new_usuario.telefones[0].numero"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>tipo Telefones</label>
                <input
                  v-model="new_usuario.telefones[0].tipo"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>


            </div>
            <div class="modal-footer">
              <button
                v-if="flag_update"
                type="button"
                class="btn btn-primary"
                @click="editUsuarioDB"
              >Editar Usuario</button>

              <button
                v-else
                type="submit"
                class="btn btn-primary"
                @click="alerta"
              >Adicionar Usuario
              </button>

              <button type="submit" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </form>
        </div>
      </div>
    </div>

    <br>
    <br>
    <br>

    <table
      id="table_usuarios"
      class="table table-striped tablebordered"
      cellspacing="0"
      width="100%"
    >
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Login</th>
          <th scope="col">Permissões</th>
          <th scope="col">Email</th>
          <th scope="col">RG</th>
          <th scope="col">CPF</th>
          <th scope="col">Nome</th>
          <th scope="col">Sexo</th>
          <th scope="col">Data de Nascimento</th>
          <th>Opções</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="usuario in usuarios" :key="usuario.id">
          <td>{{ usuario.id }}</td>
          <td>{{ usuario.login }}</td>
          <td>{{ usuario.permissoes[0].nome }}</td>
          <td>{{ usuario.email }}</td>
          <td>{{ usuario.rg }}</td>
          <td>{{ usuario.cpf }}</td>
          <td>{{ usuario.nome }}</td>
          <td>{{ usuario.sexo }}</td>
          <td>{{ usuario.dataNascimento }}</td>

          <td>
            <div class="row justify-content-around">
              <button v-if="getPermission == 'admin' || getPermission == 'editor'" 
                type="button"
                class="btn btn-warning col-3.5 btn-sm"
                href
                data-toggle="modal"
                data-target="#modal_add_aluno"
                @click="editUsuario(usuario.id)"
              >
                <i class="fas fa-user-edit"></i> Editar
              </button>
              <button v-if="getPermission == 'admin'" 
                type="button" 
                class="btn btn-danger col-3.5 btn-sm" 
                @click="deleteUsuario(usuario)">
                <i class="fas fa-user-times"></i> Excluir
              </button>

            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>


</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";
import { strict } from "assert";

export default {
  data() {
    return {
      usuarios: [],
      url_type_user: "",
      id_to_update: "",
      flag_update: false,
      new_usuario: {
        nome: "testecode",
        rg: "12.345.678-9",
        cpf: "423.456.689-96",
        dataNascimento: "02/03/2019",
        email: "teste@teste",
        login: "testUser",
        senha: "secreta",
        sexo: "Masculino",
        enderecos: [
          {
            bairro: "bairro t",
            cep: "12345-678",
            cidade: "teste",
            complemento: "string",
            numero: 9,
            rua: "string",
            uf: "sp"
          }
        ],
        telefones: [
          {
            numero: "42 3455-1882",
            tipo: "Residencial"
          }
        ]
      }
    }
  },
  methods: {
    alerta() {
      console.log(this.new_usuario);
    },
    atualizar() {
      $(document).ready(function() {
        $("#table_usuarios").DataTable();
        $(".dataTables_length").addClass("bs-select");
      });
    },
    link_admin(){
      this.flag_update = false;
      this.url_type_user = '/usuarios/secretaria'
    },
    link_editor(){
      this.flag_update = false;
      this.url_type_user = '/usuarios/recepcao'
    },
    link_viewer(){
      this.flag_update = false;
      console.log(this.flag_update)
      this.url_type_user = '/usuarios/assistente/social' 
    },    
    editUsuarioDB() {
      console.log(this.new_usuario)
  //    delete this.new_usuario.id;
 //     delete this.new_usuario.telefones[0].id;
//      delete this.new_usuario.enderecos[0].id;
      console.log(">>> Edit usuarioBD");      
      console.log(this.new_usuario);
      console.log(">>> Id usuario");
      console.log(this.id_to_update);
      axios
        .put("usuarios/" + this.id_to_update, this.new_usuario)
        .then(res => {
          console.log(res.data);
          alert("usuario: " + this.new_usuario.nome + " Editado com Sucesso");
          this.getAllusuarios();
        })
        .catch(error => console.log(error));
    },
    editUsuario(id) {
      this.flag_update = true;
      console.log(this.flag_update)
      this.id_to_update = id;
      this.new_usuario = this.usuarios.filter((obj) => {return obj.id == id})[0];
      console.log(">>> Edit usuario");
      console.log(this.new_usuario);
    },
    async getAllUsuarios() {
      await axios
        .get("usuarios")
        .then(res => {
          console.log(res);
          this.usuarios = res.data;
        })
        .catch(error => console.log(error));
      this.atualizar();
    },
    async addUsuario() {
      console.log(this.new_usuario);
      await axios
        .post(this.url_type_user, this.new_usuario)
        .then(res => {
          console.log(res.data);
          alert("Aluno: " + this.new_usuario.nome + " Inserido com Sucesso");
          this.getAllUsuarios();
        })
        .catch(error => console.log(error));
    },
    deleteUsuario(usuario) {
      axios
        .delete("usuarios/" + usuario.id)
        .then(res => {
          console.log(res.data);
          alert("Aluno: " + usuario.nome + " Removido com Sucesso");
          this.getAllUsuarios();
        })
        .catch(error => console.log(error));
    }
  },
  computed: {
    ...mapGetters(["getUsername", "getPermission"])
  },
  beforeMount() {
    this.getAllUsuarios();
  }
};
</script>

