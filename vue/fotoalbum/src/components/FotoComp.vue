<script>
import axios from 'axios';

export default {
    props: {
        titolo: String,
        descrizione: String,
        url: String,
        categorie: Object,
        id: Number,
        show: Boolean
    },
    data() {
        return {

        }
    },

}

</script>

<template>
    <div class="col-4 my-3">
        <div class="card" style="width: 25rem;height: 100%;">
            <div class="text-center">
                <img :src="url" class="card-img-top w-100 img-fluid" style="height: 15rem;">
            </div>
            <div class="card-body">
                <h5 class="card-text">{{ descrizione }}</h5>
                <p class="card-text">
                    <span v-for="categoria in categorie"> #{{ categoria.titolo }} </span>
                </p>
            </div>
        </div>
    </div>
</template>

<style scoped lang="scss"></style>
