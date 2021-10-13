import Vue from "vue";
import Router from "vue-router";
import CustomersList from "./views/CustomersList.vue";
import AddCustomer from "./components/AddCustomer.vue";
import SearchCustomers from "./components/SearchCustomers.vue";
import Customer from "./components/Customer.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "customers",
      alias: "/customer",
      component: CustomersList,
    },
    {
      path: "/customer/:id",
      name: "employee-details",
      component: Customer,
      props: true
    },
    {
      path: "/edit/:id",
      name: "edit",
      component: AddCustomer,
      props: true
    },
    {
      path: "/add",
      name: "add",
      component: AddCustomer,
    },
    {
      path: "/search",
      name: "search",
      component: SearchCustomers,
      props: true
    }
  ]
});