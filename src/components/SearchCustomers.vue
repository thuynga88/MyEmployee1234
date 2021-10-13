<template>
  <div class="searchform">
    <ul class="search-result">
      
      <li v-for="(employee, index) in employees" :key="index">
        <h6>{{employee.fullname}} ({{employee.age}})</h6>
      </li>
    </ul>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "search-employee",
  data() {
    return {
      age: 0,
      employees: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    searchemployees() {
      http
        .get("/employees/age/" + this.age)
        .then(response => {
          this.employees = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
    /* eslint-enable no-console */
  }
};
</script>

<style>
.searchform {
  max-width: 300px;
  margin: auto;
}
.search-result {
  margin-top: 20px;
  text-align: left;
}
</style>