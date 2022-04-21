$(document).ready(function() {

    loadClients();
  //$('#userTable').DataTable();

    loadEmailToInfo();
});

function loadEmailToInfo(){
     document.querySelector('#info-user').innerText=localStorage.email;
 }
async function loadClients(){
  const response = await fetch('api/clientes', {
        method: 'GET',
        headers: getHeaders()
      });
  const clients = await response.json();

  let clientsTable= document.querySelector('#clientTable tbody');

  let template='';

   for(let client of clients){

     let deleteButton='<a href="#" onclick="deleteClient('+client.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
     let updateButton='<a href="perfilCliente.html?id='+client.id+'" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a>';

     template+='<tr><td>'+client.id+'</td>';
     template+='<td>'+client.first_name+' '+client.last_name+'</td>';
     template+='<td>'+client.email+'</td>';
     template+='<td>'+client.phone+'</td>';
     template+='<td>'+client.city+'</td>';
     template+='<td>'+updateButton+' '+deleteButton+'</td></tr>';
   }

   clientsTable.outerHTML=template;

}

async function deleteClient(id){


    if(!confirm('El cliente se borrará')){

            return;
        }

    const response = await fetch('api/clientes/'+id, {
          method: 'DELETE',
          headers: getHeaders()
        });

    alert('Cliente borrado con exito');
    loadClients();

}





function getHeaders(){

        return  {
                   'Accept': 'application/json',
                   'Content-Type': 'application/json',
                   'Authorization':localStorage.token
                 };
}