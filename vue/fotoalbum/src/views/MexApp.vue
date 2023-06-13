<script>
import axios from 'axios';

export default {
    components: {

    },
    data() {
        return {
            email: '',
            messaggio: '',
            loading: false,
            goodSuccess: false,
            errors: [],
            apiUrl: 'http://127.0.0.1:8080/api/v1/guida'
        }
    },
    methods: {
        sendMessaggio() {
            this.loading = true;
            axios.post(this.apiUrl, {
                email: this.email,
                messaggio: this.messaggio,
            })
                .then((response) => {




                    this.email = ''
                    this.messaggio = ''


                    this.goodSuccess = true;
                    this.loading = false;



                }).catch(errors => {

                    console.log(errors.response.data.errors)

                    this.errors = errors.response.data.errors

                    this.loading = false;
                })
        }
    }
}
</script>

<template>
    <div class="container mt-5">
        <div class="mb-5">
            <h4>Contattaci pure inserendo la tua email e il messagio che vuoi.</h4>
        </div>
        <div v-if="this.loading" class="text-center my-5">
            <AppLoader />
        </div>
        <div v-else-if="this.goodSuccess">
            <p class="text-center fs-1 text-success">Messaggio inviato correttamente</p>
        </div>
        <div v-else>
            <div class="alert alert-danger mt-2" v-if="errors.length != 0">
                <p v-for="error in errors" class="mb-0">{{ error }}</p>
            </div>

            <div class="mb-3 w-50 border border-secondary">
                <h5 for="email" class="form-label">email:</h5>
                <input type="email" class="form-control" id="email" v-model="email">

            </div>

            <div class="mb-3 w-50 border border-secondary">
                <h5 for="messaggio" class="form-label">messaggio:</h5>
                <textarea class="form-control" id="messaggio" rows="10" v-model="messaggio"></textarea>


            </div>
            <div class="d-flex justify-content-center">
                <button type="submit" @click="sendMessaggio" class="btn btn-success w-25">
                    <h4>Invia</h4>
                </button>
            </div>

        </div>
    </div>
</template>
