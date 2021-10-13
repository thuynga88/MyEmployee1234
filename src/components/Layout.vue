<template>
  <div class="layout">
    <nav class="navbar navbar-dark bg-dark" id="header">
      <a class="navbar-brand" href="#" >Manage Employee</a>
    </nav>
    <div class="sidebar">
    <br>
      <a href="#home">Home</a>
      <br>
      <a href="/">Employee</a>
      <br>
      <a href="#contact">Contact</a>
      <br>
      <a href="#about">About</a>
    </div>
  </div> 
</template>

<script>
export default {
  name: "Header",
};
</script>

<style scoped>
#header{
  width: 100%;
  height: 50px;
  background-color: #265325;
  display: block;
  box-shadow: 0px 2px 2px rgba(0,0,0,0.5); /*Đổ bóng cho menu*/
  position: fixed; /*Cho menu cố định 1 vị trí với top và left*/
  top: 0; /*Nằm trên cùng*/
  left: 0; /*Nằm sát bên trái*/
  z-index: 100000; /*Hiển thị lớp trên cùng*/
}

.sidebar {
  margin: 0;
  padding-top: 20px;
  padding-left: 20px;
  width: 200px;
  background-color: #343a40 ;
  position: fixed;
  height: 100%;
  overflow: auto;
}

/* Sidebar links */
.sidebar a {
  display: block;
  color: white;
  padding: 16px;
  text-decoration: none;
}

/* Links on mouse-over */
.sidebar a:hover:not(.active) {
  background-color: #555;
  color: white;
}

/* Page content. The value of the margin-left property should match the value of the sidebar's width property */
div.content {
  margin-left: 200px;
  padding: 1px 16px;
  height: 1000px;
}

/* On screens that are less than 700px wide, make the sidebar into a topbar */
@media screen and (max-width: 700px) {
  .sidebar {
    width: 100%;
    height: auto;
    position: relative;
  }
  .sidebar a {float: left;}
  div.content {margin-left: 0;}
}

/* On screens that are less than 400px, display the bar vertically, instead of horizontally */
@media screen and (max-width: 400px) {
  .sidebar a {
    text-align: center;
    float: none;
  }
}
</style>