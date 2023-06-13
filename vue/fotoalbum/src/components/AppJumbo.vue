<script>
import axios from 'axios';
export default {

    data() {
        return {
            apiURL: 'http://127.0.0.1:8080/api/v1/foto/filtro',
            foto: [],
            titolo: '',

        }
    },
    methods: {
        getFoto() {
            axios.get(this.apiURL, {
                params: {
                    titolo: this.titolo
                }
            })
                .then((response) => {

                    // console.log(response.data);
                    this.foto = response.data;
                })
        }
    },
    created() {
        this.getFoto();
    }
}
</script>

<template>
    <div v-if="$route.name != 'messaggio'" class="container mt-4">
        <div class="jumbo">
            <div id="carousel-foto" class="carousel slide carousel-fade">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://wallpaperaccess.com/full/1640112.jpg" class="d-block w-100 img-fluid" alt="...">
                    </div>
                    <div class="carousel-item" v-for="foto in foto">
                        <img :src="foto.url" class="d-block w-100 img-fluid" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carousel-foto" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carousel-foto" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
</template>

<style scoped>
.jumbo {
    height: 650px;
    width: 100%;
}

.carousel-inner {
    width: 100%;
    height: 100%;
}

#carousel-foto {
    width: 100%;
    height: 100%;
}

.carousel-item {
    width: 100%;
    height: 100%;
}

.carousel-item img {
    width: 100%;
    height: 100%;
}
</style>