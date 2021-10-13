<template>
    <div id="app">
      <Layout />
      <div class="container">
        
        <br><br><br>
        <nav>
            <router-link class="btn btn-primary" to="/">Employee</router-link>
            <router-link class="btn btn-primary" to="/add">Add</router-link>
        </nav>
        <br/>
        
        <router-view/>
        </div>
    </div>
</template>

<script>
import Layout from "./components/Layout"
export default {
  name: "app",
  components: {
    Layout,
  }
};
</script>

<style>

.btn-primary {
  margin-right: 5px;
}

</style>
