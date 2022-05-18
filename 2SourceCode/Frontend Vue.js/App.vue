<template>
    <div id="app">
        <v-app>
            <title-bar></title-bar>
        <v-content>
        <router-view></router-view>
        </v-content>
        </v-app>
    </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld';
//import RestaurantCreate from "./views/RestaurantCreate";

import TitleBar from "./components/titleBar";
export default {
  name: 'App',

  components: {
      TitleBar
    //RestaurantCreate
  },

  data: () => ({
    //
  }),
};
</script>

<style scoped>
</style>
