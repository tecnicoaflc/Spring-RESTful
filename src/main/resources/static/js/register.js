$(document).ready(function() {

    // on ready

});


async function registerUser(){

    let datos={};
    datos.name = document.querySelector("#FirstName").value;
    datos.lastname = document.querySelector("#LastName").value;
    datos.email = document.querySelector("#InputEmail").value;
    datos.password = document.querySelector("#InputPassword").value;

    let repeatPassword= document.querySelector("#RepeatPassword").value;

       if(repeatPassword!=datos.password){
            alert("la contraseña no coincide");

            return;
       }

    const response = await fetch('api/registro', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(datos)

    });

    alert("Cuenta creada correctamente");
    window.location='login.html';
}