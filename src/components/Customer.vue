<template>
  <div>
    <h2>Employee {{this.employee.fullname}}</h2>
    <div id="sect1">
    <section>
      <p id="head"><b-icon icon="person-fill" font-scale="3"></b-icon>&nbsp;Full Name</p>
      <p>{{this.employee.fullname}}</p>
    </section>
    <section>
      <p id="head"><b-icon icon="file-person" font-scale="3"></b-icon>&nbsp; First Name</p>
      <p>{{this.employee.firstname}}</p>
    </section>
    <section>
      <p id="head"><b-icon icon="person" font-scale="3"></b-icon>&nbsp; Last name</p>
      <p>{{this.employee.lastname}}</p>
    </section>
    <section>
      <p id="head"><b-icon icon="caret-down-fill" font-scale="3"></b-icon>&nbsp;Age</p>
      <p>{{this.employee.age}}</p>
    </section>
    <section>
      <p id="head"><b-icon icon="aspect-ratio-fill" font-scale="3"></b-icon>&nbsp;Address</p>
      <p>{{this.employee.address}}</p>
    </section>
    </div>

  <div id="sect2">
    <section>
      <p id="head"><b-icon icon="star" font-scale="3"></b-icon>&nbsp;Gender</p>
      <p>{{this.employee.gender}}</p>
    </section>
    <section>
      <p id="head"><b-icon icon="telephone-fill " font-scale="3"></b-icon>&nbsp;Phone</p>
      <p>{{this.employee.phone}}</p>
    </section>
    <section>
      <p id="head"><b-icon icon="person" font-scale="3"></b-icon>&nbsp;Email</p>
      <p>{{this.employee.email}}</p>
    </section>
    <section>
      <p id="head"><b-icon icon="lightning-fill" font-scale="3"></b-icon>&nbsp;Skill</p>
      <p>{{this.employee.skill}}</p>
    </section>
    <section>
      <p id="head"><b-icon icon="star-fill" font-scale="3"></b-icon>&nbsp;Description</p>
      <p>{{this.employee.description}}</p>
    </section>
  </div>
  </div>
</template>

<script>

export default {
  name: "employee",
  props: ["employee"],
  methods: {
    mounted() {
    },
    /* eslint-disable no-console */
    /* eslint-enable no-console */
  }
};
</script>

<style scoped>
#sect1{
  display: flex;
  /* margin-bottom: 10px; */
  border-bottom: none ;
  text-align: center;
}

#sect2{
  display: flex;
  text-align: center;
}
section{
  border: 1px solid black;
  justify-content: space-between;
  width: 1000px;
  height: 200px;
  margin-left: 20px;
  margin-bottom: 20px;
  background-color:  whitesmoke;
}
div {
  width: 1300px;
}
p{
  padding-top: 20px;
  font-size: 15px;
}
p#head{
  font-size: 20px !important;
  background-color: lightgrey !important;
}
h2{
  margin-left: 400px;
  margin-bottom: 30px;
}
</style>