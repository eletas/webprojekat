<template>
    <a type="button" href="/create-menadzer" class="btn btn-primary">Kreiraj Menadžera</a>
    <a type="button" href="/create-dostavljac" class="btn btn-primary">Kreiraj Dostavljača</a>
    <a type="button" href="/create-restoran" class="btn btn-primary">Kreiraj Restoran</a>
    <a type="button" href="/profile" class="btn btn-primary">Moj profil</a>
    <a type="button" href="/login"  class="btn btn-primary">Izloguj se</a>
<section id="korisnici">
  <h2>Pregled korisnika</h2>

    <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Username</th>
      <th scope="col">First name</th>
      <th scope="col">Last name</th>
      <th scope="col">Gender</th>
      <th scope="col">Role</th>
      <th scope="col">Date of birth</th>
    </tr>
  </thead>
  <tbody>
    <tr  v-for="user in users" :key="user.id">
      <th scope="row">{{user.id}}</th>
      <td>{{user.korisnickoIme}}</td>
      <td>{{user.ime}}</td>
      <td>{{user.prezime}}</td>
      <td>{{user.pol}}</td>
      <td>{{user.uloga}}</td>
      <td>{{user.datumRodjenja}}</td>
    </tr>
  </tbody>
</table>
</section>
<section id="restorani">
  <h2>Pregled restorana</h2>

    <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Naziv</th>
      <th scope="col">Tip restorana</th>
      <th scope="col">Adresa</th>
    </tr>
  </thead>
  <tbody>
    <tr  v-for="restoran in restorani" :key="restoran.id">
      <th scope="row">{{restoran.id}}</th>
      <td>{{restoran.naziv}}</td>
      <td>{{restoran.tipRestorana}}</td>
      <td>{{restoran.lokacija}}</td>
    </tr>
  </tbody>
</table>
</section>
</template>

<script>
import axios from "axios";

export default {
  name: "Admin Vue",
   data: function () {
    return {
      users: [],
      filter : "",
      value : "",
      filter1 : "",
      value1 : "",
      restorani: [],
    };
  },
   mounted: function () {
    axios
      .get("http://localhost:8080/api/korisnici", {withCredentials:true})
      .then((res) => {
        this.users = res.data
      })
      .catch((err) =>{
        console.log(err)
      }),
          axios
      .get("http://localhost:8080/api/svi-restorani",{withCredentials: true})
      .then(res => {
        this.restorani = res.data;
      })
      .catch(error => {
        console.log(error);
      });
   },

   methods: {
   }
};
</script>

<style scoped>
#korisnici{
  margin-top: 20px
}
</style>