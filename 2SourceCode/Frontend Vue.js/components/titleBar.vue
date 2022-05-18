<template>
    <div>
        <v-app-bar
                app
                color="orange"
                dark
                dense
        >
                <v-img
                        alt="Vuetify Logo"
                        class="shrink mr-2"
                        contain
                        src="https://i.pinimg.com/originals/e4/4c/57/e44c577196d295eb166d7455078f5ca9.png"
                        transition="scale-transition"
                        width="40"
                />
                <v-toolbar-title style="color: beige"><h2 @click="toHome">GoodFood</h2></v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn icon @click="toAdd">
                <v-icon >mdi-plus-box</v-icon>
            </v-btn>
        </v-app-bar>
    </div>
</template>

<script>
    export default {
        name: "titleBar",
        methods: {
            toAdd: function (event) {
                this.$router.push('/add')

            },
            toHome: function (event) {
                this.$router.push('/')

            }
        }
    }
</script>

<style scoped>

</style>