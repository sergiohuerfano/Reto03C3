/*
@author SergioHuerfano
*/

/* consultarMensajes (obtener informacion de la TBL MESSAGE)
@param void
* Funcion que llama el metodo API "GET" a traves de AJAX
* Responde en consola la data de la TBL MESSAGE
* Llama a la funcion mostrarTabla
*/
function consultarMsj(){

    $.ajax({
        dataType:'json',
        url:"http://localhost:8080/api/Message/all",
        type:'GET',
        success:function(response){
            console.log(response),

            mostrarTablaMsj(response.items)
        }

    });
}

/* mostrarTablaMsj (imprimir data obtenida en pantalla)
* Funcion que imprime en pantalla la data de la TBL MESSAGE
@param lista, constituida de id, message
@return myTable, devolviendo una tabla con la data obtenida
* Adiciona a cada linea un boton de 'Borrar' que incluye la funcion borrarCinema
* Adiciona a cada linea un boton de 'Cargar para editar' que incluye la funcion obtenerItemEditar
*/
function mostrarTablaMsj(lista){
    var miTabla = "<table>";
    for(var i=0;i<lista.length;i++){
        miTabla+="<tr>";
        miTabla+="<th>MESSAGE</th>";
        miTabla+="</tr>";
        miTabla+="<tr>";
        miTabla+="<td>"+lista[i].messageText+"</td>";
        miTabla+="<td> <button onclick='borrarMsj("+lista[i].messageText+")'>Borrar</button>";
        miTabla+="<td> <button onclick='obtenerItemEditar3("+lista[i].messageText+")'>Cargar para editar</button>";
        miTabla+="</tr>";
    }
    miTabla+="</table>";
    $("#resultado3").empty();
    $("#resultado3").append(miTabla);
}

/* guardarMsj (guardar informacion en la BD)
* Funcion que guarda un nuevo registro en la TBL MESSAGE a traves de un llamado AJAX con metodo API "POST"
@param nuevoItem, donde se ingresa la información a almacenar (id, message)
*/
function guardarMsj(){
    var nuevoMsj={
        messageText:$("#messageText").val(),
    };

    var dataToSend=JSON.stringify(nuevoMsj);

    $.ajax({
        dataType:'json',
        data: nuevoMsj,
        contentType:'application/json',
        url:"http://localhost:8080/api/Message/save",
        type:'POST',
        success:function(response){
            console.log(response);
            alert('Guardado exitosamente');
            mostrarTablaMsj();
        },

    });
}

/* obtenerItemEditar3 (cargar en las cajas de texto el item seleccionado)
@param idItem
@return los datos del item seleccionado en las cajas de texto
*/
function obtenerItemEditar3(idItem){
    $.ajax({
        dataType: 'json',
        url: "http://localhost:8080/api/Message/"+idItem,
        type:'GET',
        success:function(response) {
            console.log(response);
            var item=response.items[0];

            $("#messageText").val(item.messageText);

        },
    });
}

/* editarMsj (actualizar data ya existente en la BD)
* Funcion que permite actualizar la data existente de la TBL MESSAGE, de acuerdo a su ID, con llamado AJAX Y metodo API "PUT"
@param myData, con ID como PK
*/
function editarMsj(){
    var myData={
        messageText:$("#messageText").val(),
    };

    var dataToSend=JSON.stringify(myData);
    $.ajax({
        dataType:'json',
        data: dataToSend,
        url:"http://localhost:8080/api/Message/update",
        type:'PUT',
        contentType: 'application/json',

        success:function(response){

            console.log(response);
            alert("Información actualizada exitosamente");
            mostrarTablaMsj();
        }
    });
}

/* borrarMsj(elimina data existente en la BD)
* Funcion que permite eliminar la data existente de la TBL message, con llamado AJAX y metodo API "DELETE"
@param idElemento, con ID como PK
*/
function borrarMsj(idElemento){
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
            mostrarTablaMsj();
        }
    });
}