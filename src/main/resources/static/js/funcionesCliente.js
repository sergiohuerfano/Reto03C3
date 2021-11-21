/*
@author SergioHuerfano
*/

/* consultarCliente (obtener informacion de la TBL CLIENT)
@param void
* Funcion que llama el metodo API "GET" a traves de AJAX
* Responde en consola la data de la TBL CLIENT
* Llama a la funcion mostrarTabla
*/
function consultarCliente(){

    $.ajax({
        dataType:'json',
        url:"http://localhost:8080/api/Client/all",
        type:'GET',
        success:function(response){
            console.log(response),

            mostrarTablaCl(response.items)
        }

    });
}

/* mostrarTabla (imprimir data obtenida en pantalla)
* Funcion que imprime en pantalla la data de la TBL CINEMA
@param lista, constituida de id, owner, capacity, category_id y name
@return myTable, devolviendo una tabla con la data obtenida
* Adiciona a cada linea un boton de 'Borrar' que incluye la funcion borrarCinema
* Adiciona a cada linea un boton de 'Cargar para editar' que incluye la funcion obtenerItemEditar
*/
function mostrarTablaCl(lista){
    var miTabla = "<table>";
    for(var i=0;i<lista.length;i++){
        miTabla+="<tr>";
        miTabla+="<th>NAME</th>";
        miTabla+="<th>EMAIL</th>";
        miTabla+="<th>AGE</th>";
        miTabla+="</tr>";
        miTabla+="<tr>";
        miTabla+="<td>"+lista[i].name+"</td>";
        miTabla+="<td>"+lista[i].email+"</td>";
        miTabla+="<td>"+lista[i].age+"</td>";
        miTabla+="<td> <button onclick='borrarCliente("+lista[i].name+")'>Borrar</button>";
        miTabla+="<td> <button onclick='obtenerItemEditar2("+lista[i].name+")'>Cargar para editar</button>";
        miTabla+="</tr>";
    }
    miTabla+="</table>";
    $("#resultado2").empty();
    $("#resultado2").append(miTabla);
}

/* guardarCliente (guardar informacion en la BD)
* Funcion que guarda un nuevo registro en la TBL CLIENT a traves de un llamado AJAX con metodo API "POST"
@param nuevoItem, donde se ingresa la información a almacenar (id, nombre, email y edad)
*/
function guardarCliente(){
    var nuevoItem={
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),
    };

    var dataToSend=JSON.stringify(nuevoItem);

    $.ajax({
        dataType:'json',
        data: nuevoItem,
        url:"http://localhost:8080/api/Client/save",
        type:'POST',
        success:function(response){
            console.log(response);
            alert('Guardado exitosamente');
            mostrarTablaCl();
        },

    });
}

/* obtenerItemEditar2 (cargar en las cajas de texto el item seleccionado)
@param idItem
@return los datos del item seleccionado en las cajas de texto
*/
function obtenerItemEditar2(idItem){
    $.ajax({
        dataType: 'json',
        url: "http://localhost:8080/api/Client/"+idItem,
        type:'GET',
        success:function(response) {
            console.log(response);
            var item=response.items[0];

            $("#nameC").val(item.name);
            $("#email").val(item.email);
            $("#age").val(item.age);

        },
    });
}

/* editarCliente (actualizar data ya existente en la BD)
* Funcion que permite actualizar la data existente de la TBL CLIENT, de acuerdo a su ID, con llamado AJAX Y metodo API "PUT"
@param myData, con ID como PK
*/
function editarCliente(){
    var myData={
        name:$("#nameC").val(),
        email:$("#email").val(),
        age:$("#age").val(),
    };

    var dataToSend=JSON.stringify(myData);
    $.ajax({
        dataType:'json',
        data: dataToSend,
        url:"http://localhost:8080/api/Client/update",
        type:'PUT',
        contentType: 'application/json',

        success:function(response){

            console.log(response);
            alert("Información actualizada exitosamente");
            mostrarTablaCl();
        }
    });
}

/* borrarCliente(elimina data existente en la BD)
* Funcion que permite eliminar la data existente de la TBL CLIENT, con llamado AJAX y metodo API "DELETE"
@param idElemento, con ID como PK
*/
function borrarCliente(idElemento){
    var myData={
        id:idElemento
    };
    var dataToSend=JSON.stringify(myData);

    $.ajax({
        dataType:'json',
        data: dataToSend,
        contentType: 'application/json',
        url:"http://localhost:8080/api/Client/"+myData,
        type:'DELETE',

        success:function(response){
            console.log(response);
            alert("Información eliminada exitosamente");
            mostrarTablaCl();
        }
    });
}