<template>
    <v-container>
        <v-text-field
                v-model="name"
                label="맛집 이름"
                placeholder="ex) 코코넨네"
                outlined
        ></v-text-field>
        <v-text-field
                id = "checking"
                v-model="imagelink"
                label="이미지 주소"
                placeholder="Leave it blank if you want to use the default image"
                :append-icon="imagecheckicon"
                :color="imagecheckcolor"
                outlined
                @keydown="imageSuccess"
        ></v-text-field>
        <v-img
                height="0px"
                :src="imagelink"
                @error="imageError"
        >
        </v-img>
        <v-text-field
                v-model="rating"
                label="평점 (1 ~ 5)"
                placeholder="ex) 5"
                outlined
        ></v-text-field>
        <v-text-field
                v-model="menuname"
                label="추천메뉴"
                placeholder="ex) 사케돈"
                outlined
        ></v-text-field>
        <v-text-field
                v-model="menuprice"
                label="가격"
                placeholder="ex) 3만원"
                outlined
        ></v-text-field>
        <v-text-field
                v-model="province"
                label="지역"
                placeholder="ex) 서울특별시, 부산, 대구"
                outlined
                prepend-inner-icon="mdi-map-marker"
        ></v-text-field>
        <v-text-field
                v-model="address"
                label="세부주소"
                placeholder="ex) 강남구 언주로 124"
                outlined
                prepend-inner-icon="mdi-map-marker"
        ></v-text-field>
        <v-textarea
                v-model="information"
                outlined
                label="추가정보"
                placeholder="ex) 너무 맛있었다. 이곳은 뭐가 너무 좋았고 뭐가 너무 좋았다"
        ></v-textarea>
        <v-btn color="primary" @click="addRestaurant">Add Restaurant</v-btn>
    </v-container>
</template>

<script>
    import axios from 'axios';
    export default {
        name: "RestaurantCreate",
        data() {
            return {
                name: '',
                rating: '',
                menuname: '',
                menuprice: '',
                province: '',
                address: '',
                information: '',
                imagelink: '',
                imagecheckcolor: 'red',
                imagecheckicon: 'mdi-close-box'
            }
        },
        methods: {
            imageSuccess(event) {
                this.imagecheckicon = 'mdi-checkbox-marked';
                this.imagecheckcolor = 'blue';
            },
            imageError(event) {
                this.imagecheckicon = 'mdi-close-box';
                this.imagecheckcolor = 'red';
            },
            addRestaurant: function(){
                if (this.name.length <=0){
                    alert("맛집이름을 입력해주세요");
                    return;
                }
                if(this.imagelink.length <= 0){
                    this.imagelink = "https://cdn.vuetifyjs.com/images/cards/mountain.jpg"
                }
                if (this.rating.length <=0){
                    alert("평점을 입력해주세요");
                    return;
                }
                if (this.rating < 1 || this.rating > 5){
                    alert("1 ~ 5점 사이의 평점을 입력해주십시오");
                    return;
                }
                if (this.menuname.length <=0){
                    alert("추천메뉴를 입력해주세요");
                    return;
                }
                if (this.menuprice.length <=0){
                    alert("가격을 입력해주세요");
                    return;
                }
                if (this.province.length <=0){
                    alert("지역을 입력해주세요");
                    return;
                }
                if (this.address.length <=0){
                    alert("주소를 입력해주세요");
                    return;
                }
                axios.post((`${process.env.VUE_APP_SERVER_URL}/restaurants`), {"information":this.information, "name":this.name, "rating": this.rating, "imagelink": this.imagelink, "bestMenu": {"name": this.menuname, "price": this.menuprice}, "location":{"province": this.province, "address": this.address}})
                    .then((response) => {
                        console.log(response)
                        this.$router.push('/')
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