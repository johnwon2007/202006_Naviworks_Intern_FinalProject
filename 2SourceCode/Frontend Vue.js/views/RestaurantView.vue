<template>
    <div>
        <v-card v-for = "(rest, index) in restaurantsData"
                :key = index
                class="mx-auto"
                max-width="600"
                >
<!--                @click="checkConsole(index)"-->
            <v-container v-if = "restaurantsData.length > 0">
                <v-img
                        class="white--text align-end"
                        height="200px"
                        :src="rest.imagelink"
                >
                    <v-card-title>{{rest.name}}</v-card-title>
                </v-img>

                <v-card-subtitle class="pb-0">Rating: {{rest.rating}} / 5</v-card-subtitle>

                <v-card-text class="text--primary">
                    <div>Best Menu: {{bestMenuData[index].name}} $ {{bestMenuData[index].price}}</div>
                    <div>{{locationData[index].province}}, {{locationData[index].address}}</div>
                    <div class="info_text">{{rest.information}}</div>
                </v-card-text>
            </v-container>
        </v-card>
    </div>
</template>

<script>
    import axios from 'axios';
    export default {
        name: "RestaurantView",
        data() {
            return {
                restaurantsData: [],
                bestMenuData: [],
                locationData: []
            }
        },
        mounted(){
            this.getRestaurants()
        },
        methods: {
            // checkConsole: function(idx){
            //     alert(idx)
            // },
            getRestaurants: function() {
                //var url;
                axios.get(`${process.env.VUE_APP_SERVER_URL}/restaurants`)
                    .then((response) => {
                        console.log(response);
                        this.restaurantsData = response.data._embedded.restaurants;
                        axios.get(`${process.env.VUE_APP_SERVER_URL}/bestmenus`).then((res) => {
                            console.log(res.data);
                            this.bestMenuData = res.data._embedded.bestMenus;
                        }).catch((ex) => {
                            console.log("ERRRRROR", ex);
                        });
                        axios.get(`${process.env.VUE_APP_SERVER_URL}/locations`).then((res) => {
                            this.locationData = res.data._embedded.locations;
                        }).catch((ex) => {
                            console.log("ERRRRROR", ex);
                        });

                    }).catch((ex) => {
                    console.log("ERRRRROR", ex);
                })

            }
        }
    }
</script>

<style scoped>
    .info_text{
        font-size: 10px;
    }
</style>