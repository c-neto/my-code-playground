<template>
  <div class="container">
    <div class="row" v-if="getPermission == 'admin'">
      <div class="col-sm">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Adicionar Aluno</h5>
            <p class="card-text">Clique aqui para adicionar um aluno.</p>
            <button
              class="btn btn-primary"
              href
              data-toggle="modal"
              data-target="#modal_add_aluno"
              @click="flagUpdateFalse"
            >
              <i class="fas fa-user-plus"></i>  
              Adicionar Aluno
            </button>
          </div>
        </div>
      </div>
    </div>

    <br>
    <br>
    <br>

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
          <form class="form" @submit.prevent="addAluno">
            <div class="container">
              <h5 class="modal-title">ALUNO</h5>
              <div class="form-group">
                <label>Nome</label>
                <input v-model="new_aluno.nome" type="text" class="form-control form-control-sm">
              </div>

              <div class="form-group">
                <label>Doença</label>

                <div class="row">
                  <input
                    v-model="new_aluno.doencas[0].nome"
                    type="text"
                    class="form-control form-control-sm col-3"
                    placeholder="Nome"
                  >

                  <input
                    v-model="new_aluno.doencas[0].descricao"
                    type="text"
                    class="form-control form-control-sm col"
                    placeholder="Descrição"
                  >
                </div> 
              </div>

              <div class="form-group col">
                <label>Sexo</label>
                <input
                  v-model="new_aluno.sexo"
                  type="text"
                  class="form-control form-control-sm col"
                  placeholder="Descrição"
                >
              </div>

              <div class="form-group">
                <label>Nº de Irmãos</label>
                <input
                  v-model="new_aluno.numeroDeIrmao"
                  type="number"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Data de Nascimento</label>
                <input
                  v-model="new_aluno.dataNascimento"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Turma</label>
                <input
                  v-if="flag_update"
                  v-model="new_aluno.turma.id"
                  type="number"
                  class="form-control form-control-sm"
                >

                <input
                  v-else
                  v-model="turma_new_aluno"
                  type="number"
                  class="form-control form-control-sm"

                >
              </div>

              <h5 class="modal-title">RESPONSÁVEL</h5>

              <div class="form-group">
                <label>Nome</label>
                <input
                  v-model="new_aluno.responsavel.nome"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>RG</label>
                <input
                  v-model="new_aluno.responsavel.rg"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>CPF</label>
                <input
                  v-model="new_aluno.responsavel.cpf"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Sexo</label>
                <input
                  v-model="new_aluno.responsavel.sexo"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Grau de Parentesco</label>
                <input
                  v-model="new_aluno.responsavel.grauDeParentesco"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Profissão</label>
                <input
                  v-model="new_aluno.responsavel.profissao"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Data de Nascimento</label>
                <input
                  v-model="new_aluno.responsavel.dataNascimento"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Bairro</label>
                <input
                  v-model="new_aluno.responsavel.enderecos[0].bairro"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>CEP</label>
                <input
                  v-model="new_aluno.responsavel.enderecos[0].cep"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Cidade</label>
                <input
                  v-model="new_aluno.responsavel.enderecos[0].cidade"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Complemento</label>
                <input
                  v-model="new_aluno.responsavel.enderecos[0].complemento"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Numero</label>
                <input
                  v-model="new_aluno.responsavel.enderecos[0].numero"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Rua</label>
                <input
                  v-model="new_aluno.responsavel.enderecos[0].rua"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>UF</label>
                <input
                  v-model="new_aluno.responsavel.enderecos[0].uf"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="col-group">
                <label>n Telefone</label>
                <input
                  v-model="new_aluno.responsavel.telefones[0].numero"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>tipo Telefones</label>
                <input
                  v-model="new_aluno.responsavel.telefones[0].tipo"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>

              <div class="form-group">
                <label>Email</label>
                <input
                  v-model="new_aluno.responsavel.email"
                  type="text"
                  class="form-control form-control-sm"
                >
              </div>
            </div>
            <div class="modal-footer">
              <button
                v-if="flag_update == false"
                type="submit"
                class="btn btn-primary"
                @click="alertax"
              >Adicionar Aluno</button>

              <button
                v-else
                type="button"
                class="btn btn-primary"
                @click="editAlunoDB"
              >Editar Aluno</button>
              
              <button type="submit" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </form>
        </div>
      </div>
    </div>

    <table id="carlos" class="table table-striped tablebordered" cellspacing="0" width="100%">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Nome</th>
          <th scope="col">Sexo</th>
          <th scope="col">Cor</th>
          <th scope="col">Data de Nascimento</th>
          <th scope="col">Nº de Irmãos</th>
          <th>Opções</th>
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

          <td>
            <div class="row justify-content-around">
              <button
                type="button"
                class="btn btn-warning col-4.5 btn-sm"
                href
                data-toggle="modal"
                data-target="#modal_add_aluno"
                @click="editAluno(aluno.id)"
              >
                <i class="fas fa-user-edit"></i> Editar
              </button>
             
              <button
                type="button"
                class="btn btn-danger col-4.5 btn-sm"
                @click="deleteAluno(aluno)"
              >
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
  name: "main_menu",
  data() {
    return {
      alunos: [],
      flag_update: false,
      username: "",
      id_to_update: "",
      table_view: false,
      form_view: false,
      turma_new_aluno: "1",
      new_aluno: {
        turma: {
            id: "1"
        },
        cor: "negro",
        nome: "code65",
        numeroDeIrmao: 0,
        dataNascimento: "05/05/2019",
        sexo: "Masculino",
        doencas: [
          {
            nome: "doenca cronica",
            descricao: "doenca super fodac"
          }
        ],
        responsavel: {
          cpf: "string",
          dataNascimento: "05/05/2019",
          email: "string@stringresponsavel.com",
          grauDeParentesco: "ninguem sabe",
          nome: "ninguem sabe tambem",
          profissao: "so ele sabe",
          rg: "11.123.123-1",
          sexo: "Feminino",
          enderecos: [
            {
              bairro: "sem bairro",
              cep: "12.123-123",
              cidade: "strings",
              complemento: "ninguem coloca",
              numero: 1,
              rua: "esquerda string direita",
              uf: "sp"
            }
          ],
          telefones: [
            {
              numero: "12 3456-4567",
              tipo: "Residencial"
            }
          ]
        }
      }
    };
  },
  methods: {
    flagUpdateFalse() {
      this.flag_update = false;
    },
    alertax() {
      console.log(this.new_aluno);
    },
    alerta(x) {
      alert(x);
    },
    atualizar() {
      $(document).ready(function() {
        $("#carlos").DataTable();
        $(".dataTables_length").addClass("bs-select");
      });
    },
    async getAllAlunos() {
      await axios
        .get("alunos")
        .then(res => {
          console.log(res);
          this.alunos = res.data;
        })
        .catch(error => console.log(error));
      this.atualizar();
    },
    async deleteAluno(aluno) {
      await axios
        .delete("alunos/" + aluno.id)
        .then(res => {
          console.log(res.data);
          alert("Aluno: " + aluno.nome + " Removido com Sucesso");
          this.getAllAlunos();
        })
        .catch(error => console.log(error));
    },
    editAlunoDB() {
      console.log(">>> EditAlunoBD");
      console.log(this.new_aluno);
      console.log(">>> Id turma");
      console.log(this.id_to_update);
      axios
        .put("alunos/" + this.id_to_update, this.new_aluno)
        .then(res => {
          console.log(res.data);
          alert("Aluno: " + this.new_aluno.nome + " Editado com Sucesso");
          this.getAllAlunos();
        })
        .catch(error => console.log(error));
    },
    editAluno(id) {
      this.id_to_update = id;
      this.flag_update = true;
      this.new_aluno = this.alunos.filter(obj => {
        return obj.id == id;
      })[0];
      console.log(">>> Edit Aluno"); 
      console.log(this.new_aluno);
    },
    async addAluno() {
      console.log("aluno que sera inserido");
      let aluno_insert = this.new_aluno;
      delete aluno_insert.id;
      console.log(aluno_insert);
      
      await axios
        .post("alunos?turma=" + this.turma_new_aluno, aluno_insert)
        .then(res => {
          console.log(res.data);
          alert("Aluno: " + aluno_insert.nome + " Inserido com Sucesso");
          this.getAllAlunos();
        })
        .catch(error => console.log(error));
    }
  },
  computed: {
    ...mapGetters(["getUsername", "getPermission"])
  },
  beforeMount() {
    this.getAllAlunos();
    console.log(this.new_aluno);
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
