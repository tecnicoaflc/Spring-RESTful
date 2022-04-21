$(document).ready(function() {

    // on ready

});


async function loginUser(){

    let data={};
    data.email = document.querySelector("#InputEmail").value;
    data.password = document.querySelector("#InputPassword").value;

    const request = await fetch('api/login', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)

    });
    const response = await request.text();

    if(response!="FAIL"){
        localStorage.token=response;
        localStorage.email=data.email;
        window.location= 'clientes.html';

    }else{

        alert("Usuario no encontrado");
        return;
    }
}