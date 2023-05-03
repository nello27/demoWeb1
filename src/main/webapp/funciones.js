function traerInformacion(){


    $.ajax({
        url:"http://localhost:8080/demoweb1/cliente/lista",
        type: "GET",
        datatype:"JSON",
        success:function(respuesta){

            console.log(respuesta);
            pintarRespuesta(respuesta);
        }


    });
}

function pintarRespuesta(items){

    let myTable="<table>";

    for(i=0; i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].idcliente+"</td>";
        myTable+="<td>"+items[i].nombre+"</td>";
        myTable+="<td>"+items[i].direccion+"</td>";
        myTable+="<td>"+items[i].correo+"</td>";
        myTable+="</tr>";


    }

    myTable+="</table>";
    $("#resultado").append(myTable);


}

/*function pintarRespuesta(items){
    
    let htmlParaInsertar = "";
    htmlParaInsertar += "<thead><tr>";
    Object.keys(items[0]).forEach(elemento => htmlParaInsertar+='<th>'+elemento+'</th>');

    htmlParaInsertar += "</tr></thead>";

    htmlParaInsertar += "<tbody>";

    for(let i = 0; i<items.length; i++){

        htmlParaInsertar += "<tr>";
            Object.values(items[i]).forEach((elemento, indice) => {
                
                if (indice < 1) {
                    htmlParaInsertar+="<td>"+elemento+"</td>";
                }else{
                    htmlParaInsertar+="<td><input value=\""+elemento+"\"></td>"
                }
                
            });
            
        htmlParaInsertar += "</tr>";

    }

    htmlParaInsertar += "</tbody>";

    $("#tabla").empty();
    $("#tabla").append(htmlParaInsertar);

}*/

function guardarInformacion(){

    let myData={

        'idcliente':$("#idcliente").val(),
        'nombre':$("#nombre").val(),
        'direccion':$("#direccion").val(),
        'correo':$("#correo").val(),

    };

    //let dataToSend=JSON.stringify(myData);
    
    //alert(myData);
    //alert(dataToSend);
    
    $.ajax({
        url:"http://localhost:8080/demoweb1/cliente/guardar",
            type:"POST",
            contentType: 'application/json',
            data:JSON.stringify(myData),
        success:function(respuesta){
            $("#idcliente").val(""),
            $("#nombre").val(""),
            $("#direccion").val(""),
            $("#correo").val(""),
            traerInformacion();
            alert("Se he guardado")
        },
        
        error:function(error){
            
            console.log("Error"+$(error))
        }

    });

}


function actualizarInformacion(idelemento){
    let myData={

        idcliente:$("#idcliente").val(),
        nombre:$("#nombre").val(),
        direccion:$("#direccion").val(),
        correo:$("#correo").val()

    };

    let dataToSend=JSON.stringify(myData);

    alert(dataToSend);
    let miurl= "http://localhost:8080/demoweb1/cliente/"+idelemento;
    alert (miurl);
    $.ajax({
        url:"http://localhost:8080/demoweb1/cliente/"+idelemento,
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#idcliente").empty();
            $("#nombre").val("");
            $("#direccion").val("");
            $("#correo").val("");
            traerinformacion();
            alert("Se he guardado")
        }

    });
}



function borrar() {
    
    let myData={

        idcliente:$("#idcliente").val()
        
    }
    let dataToSent = JSON.stringify(myData);
    $.ajax({
      url:"http://localhost:8080/demoweb1/cliente/"+idelemento,
      type:"DELETE",
      data: dataToSent,
      contentType: "application/json",
      datatype:"JSON",
      success:function(respuesta){
            //Acá se puede validar la respuesta.
            $("#div1").empty();
            traerinformacion();
            alert("Se ha eliminado")
      }
    });
}