<template>
  <div class="container">
    <div class="row">
      <div class="col-sm">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Adicionar Turma</h5>
            <p class="card-text">Clique aqui para adicionar uma turma.</p>
            <button
              class="btn btn-primary"
              href
              data-toggle="modal"
              data-target="#modal_add_turma"
              @click="flagUpdateFalse"
            >
              <i class="fas fa-user-plus"></i>
              Adicionar Turma
            </button>
          </div>
        </div>
      </div>
    </div>

    <br>
    <br>
    <br>

    <div
      id="modal_alunos"
      class="modal fade bd-example-modal-xl"
      tabindex="-1"
      role="dialog"
      aria-labelledby="myExtraLargeModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog modal-xl">
        <div class="modal-content">
          <table
            id="table_alunos"
            class="table table-striped tablebordered"
            cellspacing="0"
            width="100%"
          >
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Sexo</th>
                <th scope="col">Cor</th>
                <th scope="col">Data de Nascimento</th>
                <th scope="col">Nº de Irmãos</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="aluno in alunos" :key="aluno.id">
                <td>{{ aluno.id }}</td>
                <td>{{ aluno.nome }}</td>
                <td>{{ aluno.sexo }}</td>
                <td>{{ aluno.cor }}</td>
                <td>{{ aluno.dataNascimento }}</td>
                <td>{{ aluno.numeroDeIrmao }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <div
      id="modal_add_turma"
      class="modal fade"
      tabindex="-1"
      role="dialog"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <form class="form" @submit.prevent="addTurma">
            <div class="container">
              <h5 class="modal-title">Turma</h5>

              <div class="form-group">
                <label>Periodo</label>
                <input v-model="new_turma.periodo" type="text" class="form-control form-control-sm">
              </div>
              <div class="form-group">
                <label>Nome</label>
                <input v-model="new_turma.nome" type="text" class="form-control form-control-sm">
              </div>

              <div class="modal-footer">
                <button
                  v-if="flag_update == false"
                  type="submit"
                  class="btn btn-primary"
                  @click="alerta"
                >Adicionar turma</button>

                <button
                  v-else
                  type="button"
                  class="btn btn-primary"
                  @click="editTurmaDB"
                >Editar turma</button>

                <button type="submit" class="btn btn-secondary" data-dismiss="modal">Close</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>

    <table id="table_turmas" class="table table-striped tablebordered" cellspacing="0" width="100%">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Nome</th>
          <th scope="col">Período</th>
          <th>Opções</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="turma in turmas" :key="turma.id">
          <td>{{ turma.id }}</td>
          <td>{{ turma.nome }}</td>
          <td>{{ turma.periodo }}</td>
          <td>
            <div class="row justify-content-around">
              <button
                type="button"
                class="btn btn-warning col-4.5 btn-sm"
                href
                data-toggle="modal"
                data-target="#modal_add_turma"
                @click="editTurma(turma.id)"
              >
                <i class="fas fa-edit"></i> Editar
              </button>
              <button
                type="button"
                class="btn btn-danger col-4.5 btn-sm"
                @click="deleteTurma(turma)"
              >
                <i class="fas fa-trash"></i> Excluir
              </button>
              <button
                type="button"
                class="btn btn-success col-4.5 btn-sm"
                data-toggle="modal"
                data-target="#modal_alunos"
                @click="getAlunosByTurma(turma.alunos)"
              >
                <i class="fas fa-users"></i> Listar Alunos
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
  name: "main_menu",
  data() {
    return {
      turmas: [],
      alunos: [],
      flag_update: false,
      table_view: false,
      form_view: false,
      id_to_update: "",
      new_turma: {
        periodo: "Matutino",
        nome: "turma do mau"
      }
    };
  },
  methods: {
    async getAlunosByTurma(alunos) {
      this.getAllTurmas();
      this.alunos = alunos;
      $(document).ready(function() {
        $("#table_alunos").DataTable();
        $(".dataTables_length").addClass("bs-select");
      });
    },
    flagUpdateFalse() {
      this.flag_update = false;
    },
    async alerta() {
      console.log(this.new_turma);
    },
    async atualizar() {
      $(document).ready(function() {
        $("#table_turmas").DataTable();
        $(".dataTables_length").addClass("bs-select");
      });
    },
    async getAllTurmas() {
      await axios
        .get("turmas")
        .then(res => {
          console.log(res);
          this.turmas = res.data;
        })
        .catch(error => console.log(error));
      this.atualizar();
    },
    async deleteTurma(turma) {
      await axios
        .delete("turmas/" + turma.id)
        .then(res => {
          console.log(res.data);
          alert("turma: " + turma.nome + " Removido com Sucesso");
          this.getAllTurmas();
        })
        .catch(error => console.log(error));
    },
    editTurmaDB() {
      console.log(">>> EditTurmaBD");
      console.log(this.new_turma);
      console.log(">>> Id turma");
      console.log(this.id_to_update);
      let insert_to_db = {
        nome: this.new_turma.nome,
        periodo: this.new_turma.periodo
      };
      axios
        .put("turmas/" + this.id_to_update, insert_to_db)
        .then(res => {
          console.log(res.data);
          alert("turma: " + insert_to_db.nome + " Editado com Sucesso");
          this.getAllTurmas();
        })
        .catch(error => console.log(error));
    },
    editTurma(id) {
      this.id_to_update = id;
      this.flag_update = true;
      this.new_turma = this.turmas.filter(obj => {
        return obj.id == id;
      })[0];
      console.log(">>> Edit turma");
      console.log(this.new_turma);
    },
    addTurma() {
      console.log("turma que sera inserido");
      let turma_insert = this.new_turma;
      console.log(turma_insert);
      axios
        .post("turmas/", turma_insert)
        .then(res => {
          console.log(res.data);
          alert("turma: " + turma_insert.nome + " Inserido com Sucesso");
          this.getAllTurmas();
        })
        .catch(error => console.log(error));
    }
  },
  computed: {
    ...mapGetters(["getUsername", "getPermission"])
  },
  beforeMount() {
    this.getAllTurmas();
    console.log(this.new_turma);
  }
};
</script>


<style>
h11 {
  color: red;
}

#logo {
  width: 50%;
  height: 50%;
}

.panel-heading {
  font-size: 150%;
}
</style>
