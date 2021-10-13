<template>
  <div class="container">
    <br />
    <br />
    <form class="form-inline">
      <b-form-input
        class="form-control mr-sm-2"
        v-model="term"
        placeholder="Search by name ..."
      />
      <div class="btn-group">
        <!-- <router-link
              :to="{
                  name: 'search',
                  params: { employee: employee, id: employee.id }
                  }"
            >
              <b-button id="sea" @click="searchemployees" class="btn btn-success">Search</b-button>
            </router-link> -->
            <b-button id="sea" @click="searchemployees" class="btn btn-success">Search</b-button>
      </div>
    </form>
    
    <br />
    <br />
    <table>
      <thead>
        <tr id="head">
          <th>Full Name</th>
          <th>Age</th>
          <th>Gender</th>
          <th>Email</th>
          <th>Address</th>
          <th scope="col">Action</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="employee in employees" :key="employee.id">
          <td>{{employee.fullname}}</td>
          <td>{{employee.age}}</td>
          <td>{{employee.gender}}</td>
          <td>{{employee.email}}</td>
          <td>{{employee.address}}</td>
          <td>
            <router-link
              :to="{
                  name: 'edit',
                  params: { employee: employee, id: employee.id }
                  }"
            >
              <b-button size="sm" class="btn btn-success">
                <b-icon icon="pen" aria-hidden="true"></b-icon>
              </b-button>
            </router-link>
            &nbsp;
            <b-button size="sm" class="btn btn-success" @click="clickDel(employee)">
              <b-icon icon="trash" aria-hidden="true"></b-icon>
            </b-button>
            &nbsp;
            <router-link
              :to="{
                  name: 'employee-details',
                  params: { employee: employee, id: employee.id }
                  }"
            >
              <b-button size="sm" class="btn btn-success">
                <b-icon icon="info" aria-hidden="true"></b-icon>
              </b-button>
            </router-link>
            <!-- <button v-on:click.native="onSubmit()" >Delete</button>  -->
          </td>
        </tr>
      </tbody>
    </table>
    <div class="col-md-6">
      <router-view @refreshData="refreshList"></router-view>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import http from "../http-common";

export default {
  name: "customers-list",
  data() {
    return {
      employees: [],
      term: ''
    };
  },
  methods: {
    onSubmit() {
      console.log("runing...");
    },

    /* eslint-disable no-console */
    retrieveCustomers() {
      // this.a
      //   .get("/customers")
      //   .then(response => {
      //     this.customers = response.data; // JSON are parsed automatically.
      //     console.log(response.data);
      //   })
      //   .catch(e => {
      //     console.log(e);
      //   });

      Vue.axios.get("http://localhost:8080/api/employees").then(response => {
        console.log(response.data);
        this.employees = response.data;
      });
    },
    refreshList() {
      this.retrieveCustomers();
    },
    clickDel(employee) {
      console.log("Id: ", employee.id);
      http
        // Xóa nhân viên
        .delete("/employee/delete/" + employee.id)
        // Xóa xong sẽ gọi vào then
        .then(response => {
          console.log(response.data);
          // Gọi lại hàm retrieveCustomers để lấy list employee mới
          this.retrieveCustomers();
          // this.$emit("refreshData");
          // this.$router.push("/").catch(() =>{});
        })
        .catch(e => {
          console.log(e);
        });
    },
    // function tự định nghia phải ở trong methods nhé
    // chỗ gọi function thì ko cần ngoặc (bt a code bằng typescript thì có ngoặc cũng ko chết đâu, nhưng chắc vuejs này nó dị)
    searchemployees(event) {
      console.log("click event :", event)
      console.log("term :", this.term)
      http
          .get("/employees/search/" + this.term)
          .then(response => {
            console.log(response);
            this.employees = response.data; // JSON are parsed automatically.
            // console.log(response.data);
            this.$emit("refreshData");
            this.$router.push("/")
          .catch(() =>{});
          })
          .catch(e => {
            console.log(e);
          });
    },
    /* eslint-enable no-console */
  },
  mounted() {
    this.retrieveCustomers();
  },
};
</script>

<style scoped>
table,
th,
td {
  border: 2px solid black;
  text-align: center;
  width: 1200px;
}
#head {
  background-color: #fff1(177, 124, 124);
}
button {
  padding-top: 5px;
  width: 35px;
  height: 30px;
  align-items: center;
  background-color: rgb(83, 81, 81);
}
#sea{
  width: 80px !important;
  height: 40px;
}
</style>

