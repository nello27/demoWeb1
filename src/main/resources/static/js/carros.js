/*function traerDatosCarros(){

    $.ajax({

        url: 'https://g127742c93d7e5c-r09bclxntcqiu4s0.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/car/car',
        type: 'GET',
        datatype: 'json',
        succes: function(respuesta){

            pintarDatos(respuesta.items);

        },
        error: function(respuesta, xhr){

            alert("Error peticion")
        }
    });
    
}*/

function traerDatosCarros(){


    $.ajax({
        url:"https://g127742c93d7e5c-r09bclxntcqiu4s0.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/car/car",
        type: "GET",
        datatype:"JSON",
        success:function(respuesta){

            console.log(respuesta);
            pintarDatos(respuesta.items, 'brand', 'car');
        },
        error: function(respuesta, xhr){

            alert("Error peticion")
        }

    });
}

function GuardarDatos(){

        let EnviarDatos={
            'id':$("#id").val(),
            'brand':$("#brand").val(),
            'model':$("#model").val(),
            'category_id':$("#category_id").val(),
  
    
        };
    
        //let dataToSend=JSON.stringify(myData);
    
        $.ajax({

            url:"https://g127742c93d7e5c-r09bclxntcqiu4s0.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/car/car",
            type:"POST",
            contentType: 'application/json',
            data:JSON.stringify(EnviarDatos),

            success:function(respuesta){

                traerDatosCarros();
                alert("Se he guardado");
            },
            error: function(respuesta, xhr){
    
                alert("Error peticion")
            }
    
        });


}

