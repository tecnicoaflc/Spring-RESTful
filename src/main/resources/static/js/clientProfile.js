$(document).ready(function() {


   loadClient();

});

async function loadClient(){

    //Obtenemos el ID  de la URL y realizamos el Fetch
   const queryString = window.location.search;

   const urlParams = new URLSearchParams(queryString);

   const id = urlParams.get('id');


  const response = await fetch('api/clientes/'+id, {
        method: 'GET',
        headers: getHeaders()
      });

  const client = await response.json();

      document.querySelector('#clientId').value=client.id;
      document.querySelector('#FirstName').value=client.first_name;
      document.querySelector('#LastName').value=client.last_name;
      document.querySelector('#InputEmail').value=client.email;
      document.querySelector('#City').value=client.city;
      document.querySelector('#Phone').value=client.phone;

}

function getHeaders(){

        return  {
                   'Accept': 'application/json',
                   'Content-Type': 'application/json',
                   'Authorization':localStorage.token
                 };
}

async function updateClient(){

    let data={};
        data.id=document.querySelector("#clientId").value;
        data.first_name = document.querySelector("#FirstName").value;
        data.last_name = document.querySelector("#LastName").value;
        data.email = document.querySelector("#InputEmail").value;
        data.city = document.querySelector("#City").value;
        data.phone = document.querySelector("#Phone").value;


    const id=document.querySelector('#clientId').value;

    const response = await fetch('api/clientes/'+id, {
          method: 'PUT',
          headers: getHeaders(),
          body: JSON.stringify(data)
        });


      alert('Cliente modificado');
      window.location='clientes.html';



}