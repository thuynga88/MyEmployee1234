<template>
  <div>
    <form v-if="!submitted" :model="employee">
      <section id="section-1">
        <div class="form-group">
          <label for="firstname">Firstname</label>
          <input
            type="text"
            class="form-control"
            id="firstname"
            required
            v-model="employee.firstname"
            name="firstname"
          />
        </div>
        <div class="form-group">
          <label for="lastname">LastName</label>
          <input
            type="text"
            class="form-control"
            id="lastname"
            required
            v-model="employee.lastname"
            name="lastname"
          />
        </div>
        <div class="form-group">
          <label for="fullname">FullName</label>
          <input
            type="text"
            class="form-control"
            id="fullname"
            required
            v-model="employee.fullname"
            name="fullname"
          />
        </div>
        <div class="form-group">
          <label for="age">Age</label>
          <input
            type="number"
            class="form-control"
            id="age"
            required
            v-model="employee.age"
            name="age"
          />
        </div>
        <div class="form-group">
          <label for="address">Address</label>
          <input
            type="text"
            class="form-control"
            id="address"
            required
            v-model="employee.address"
            name="address"
          />
        </div>
      </section>
      <section>
        <div class="form-group">
          <label for="gender">Gender</label>
          <input
            type="text"
            class="form-control"
            id="gender"
            required
            v-model="employee.gender"
            name="gender"
          />
        </div>

        <div class="form-group">
          <label for="phone">Phone</label>
          <input
            type="text"
            class="form-control"
            id="phone"
            required
            v-model="employee.phone"
            name="phone"
          />
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <input
            type="email"
            class="form-control"
            id="email"
            required
            v-model="employee.email"
            name="email"
          />
        </div>
        <div class="form-group">
          <label for="skill">Skill</label>
          <input
            type="text"
            class="form-control"
            id="skill"
            required
            v-model="employee.skill"
            name="skill"
          />
        </div>
        <div class="form-group">
          <label for="description">Description</label>
          <input
            type="text"
            class="form-control"
            id="description"
            required
            v-model="employee.description"
            name="description"
          />
        </div>
      </section>
      <router-link
              :to="{
                  name: 'customers',
                  params: { employee: employee, id: employee.id }
                  }"
            >
               <button id="but1" v-on:click="saveEmployee" class="btn btn-success">
        Submit
      </button>
            </router-link>
      <!-- <button id="but1" v-on:click="saveEmployee" class="btn btn-success">
        Submit
      </button> -->
    </form>
    <!-- <div v-else>
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" v-on:click="newemployee">
        Add
      </button>
    </div> -->
    <!-- <div>User {{ $route.params.id }}</div> -->
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "add-employee",
  data() {
    return {
      employee: {
        id: 0,
        firstname: "",
        lastname: "",
        fullname: "",
        age: 0,
        address: "",
        gender: "",
        phone: "",
        email: "",
        skill: "",
        description: "",
        active: false
      },
      submitted: false
    };
  },
  methods: {
    /* eslint-disable no-console */
    saveEmployee() {
      if (this.employee.id === 0) {
        var data = {
          firstname: this.employee.firstname,
          lastname: this.employee.lastname,
          fullname: this.employee.fullname,
          age: this.employee.age,
          address: this.employee.address,
          gender: this.employee.gender,
          phone: this.employee.phone,
          email: this.employee.email,
          skill: this.employee.skill,
          description: this.employee.description
        };

        http
          .post("/employee", data)
          .then(response => {
            this.employee.id = response.data.id;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });

        this.submitted = true;
    }
    else{
        var empl = {
          id: this.employee.id,
          firstname: this.employee.firstname,
          lastname: this.employee.lastname,
          fullname: this.employee.fullname,
          age: this.employee.age,
          address: this.employee.address,
          gender: this.employee.gender,
          phone: this.employee.phone,
          email: this.employee.email,
          skill: this.employee.skill,
          description: this.employee.description
        };
        http
        .put("employee", empl)
        .then(response => {
          console.log(response.empl);
          this.$emit("refreshData");
          })
        .catch(e => {
          console.log(e);
        })

       
    }

    },
    newemployee() {
      this.submitted = false;
      this.employee = {};
    }
  },
  created() {
    if (this.$route.params.id) {
      http
      .get("/employee/" + this.$route.params.id)
      .then(response => {
        console.log(response.data);
        this.employee = response.data;
      });
    }
  }
  /* eslint-enable no-console */
  /* eslint-disable */
};
</script>

<style scoped>
form {
  display: flex;
  border: 1px solid black;
  padding-left: 100px;
  padding-top: 30px;
  margin-left: 90px;
}

section {
  width: 400px;
  /* margin-top: 200px; */
}
#section-1 {
  margin-right: 30px;
  /* margin-left: 400px; */
}

/* #button {
  margin-left: 1170px;
} */

#but1 {
  width: 80px;
  height: 50px;
  margin-top: 430px;
}
</style>