/*
@author SergioHuerfano
*/

/* consultarCinema (obtener informacion de la TBL CINEMA)
@param void
* Funcion que llama el metodo API "GET" a traves de AJAX
* Responde en consola la data de la TBL CINEMA
* Llama a la funcion mostrarTabla
*/
function consultarCinema(){

    $.ajax({
        dataType:'json',
        url:"http://localhost:8080/api/Cinema/all",
        type:'GET',
        success:function(response){
            console.log(response),

            mostrarTabla(response.items)
        }

    });
}

/* mostrarTabla (imprimir data obtenida en pantalla)
* Funcion que imprime en pantalla la data de la TBL CINEMA
@param lista, constituida de id, owner, capacity, category_id y name
@return miTabla, devolviendo una tabla con la data obtenida
* Adiciona a cada linea un boton de 'Borrar' que incluye la funcion borrarCinema
* Adiciona a cada linea un boton de 'Cargar para editar' que incluye la funcion obtenerItemEditar1
*/
function mostrarTabla(items){
    var miTabla = "<table>";
    for(let i=0;i<items.length;i++){
        miTabla+="<tr>";
        miTabla+="<th>OWNER</th>";
        miTabla+="<th>CAPACITY</th>";
        miTabla+="<th>CATEGORY_ID</th>";
        miTabla+="<th>NAME</th>";
        miTabla+="</tr>";
        miTabla+="<tr>";
        miTabla+="<td>"+items[i].owner+"</td>";
        miTabla+="<td>"+items[i].capacity+"</td>";
        miTabla+="<td>"+items[i].category_id+"</td>";
        miTabla+="<td>"+items[i].name+"</td>";
        miTabla+="<td> <button onclick='borrarCinema("+items[i].name+")'>Borrar</button>";
        miTabla+="<td> <button onclick='obtenerItemEditar1("+items[i].name+")'>Cargar para editar</button>";
        miTabla+="</tr>";
    }
    miTabla+="</table>";
    $("#resultado1").empty();
    $("#resultado1").append(miTabla);
}

/* guardarCinema (guardar informacion en la BD)
* Funcion que guarda un nuevo registro en la TBL CINEMA a traves de un llamado AJAX con metodo API "POST"
@param nuevoItem, donde se ingresa la información a almacenar (id, owner, capacity, category_id y name)
@return funcion consularCinema, e imprimiendo la información adicionada
*/
function guardarCinema(){
    var nuevoItem={
        owner:$("#owner").val(),
        capacity:$("#capacity").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val()
    };

    var dataToSend=JSON.stringify(nuevoItem);

    $.ajax({
        dataType:'json',
        data: nuevoItem,
        url:"http://localhost:8080/api/Cinema/save",
        type:'POST',
        success:function(response){
            console.log(response);
            alert('Guardado exitosamente');
            mostrarTabla();
        },

    });
}

/* obtenerItemEditar (cargar en las cajas de texto el item seleccionado)
@param idItem
@return los datos del item seleccionado en las cajas de texto
*/
function obtenerItemEditar1(idItem){
    $.ajax({
        dataType: 'json',
        url: "http://localhost:8080/api/Cinema/"+idItem,
        type:'GET',
        success:function(respuesta) {
            console.log(respuesta);
            var item=respuesta.items[0];

            $("#owner").val(item.owner);
            $("#capacity").val(item.capacity);
            $("#category_id").val(item.category_id);
            $("#name").val(item.name);

        },
    });
}

/* editCinema (actualizar data ya existente en la BD)
* Funcion que permite actualizar la data existente de la TBL CINEMA, de acuerdo a su ID, con llamado AJAX Y metodo API "PUT"
@param myData, con ID como PK
*/
function editarCinema(){
    var myData={
        owner:$("#owner").val(),
        capacity:$("#capacity").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val(),
    };

    var dataToSend=JSON.stringify(myData);
    $.ajax({
        dataType:'json',
        data: dataToSend,
        url:"http://localhost:8080/api/Cinema/update",
        type:'PUT',
        contentType: 'application/json',

        success:function(respuesta){

            console.log(respuesta);
            alert("Información actualizada exitosamente");
            mostrarTabla();
        }
    });
}

/* borrarCinema (elimina data existente en la BD)
* Funcion que permite eliminar la data existente de la TBL CINEMA, con llamado AJAX y metodo API "DELETE"
@param idElemento, con ID como PK
*/
function borrarCinema(idElemento){
    var myData={
        id:idElemento
    };
    var dataToSend=JSON.stringify(myData);

    $.ajax({
        dataType:'json',
        data: dataToSend,
        contentType: 'application/json',
        url:"http://localhost:8080/api/Cinema/"+myData,
        type:'DELETE',

        success:function(respuesta){
            console.log(respuesta);
            alert("Información eliminada exitosamente");
            mostrarTabla();
        }
    });
}