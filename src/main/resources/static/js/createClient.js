async function registerClient(){

    let data={};

    data.first_name=document.querySelector("#FirstName").value;
    data.last_name=document.querySelector("#LastName").value;
    data.email=document.querySelector("#InputEmail").value;
    data.city=document.querySelector("#City").value;
    data.phone=document.querySelector("#Phone").value;

    const response = await fetch('api/altaCliente', {
              method: 'POST',
              headers: getHeaders(),
              body: JSON.stringify(data)
            });

        alert('Cliente creado con exito');

         window.location= 'clientes.html';

}

function getHeaders(){

        return  {
                   'Accept': 'application/json',
                   'Content-Type': 'application/json',
                   'Authorization':localStorage.token
                 };
}
