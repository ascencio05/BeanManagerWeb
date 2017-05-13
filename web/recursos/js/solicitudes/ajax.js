/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function info(id)
{
    $.post(
             "calls/getInfo.jsp", 
             {"id":id}, //meaasge you want to send
             function(result) {
                 $('#loading').dialog('close');
                 $('#frmDetSol').dialog('open');
                 $("#dialogFi").val(getARP("fI",result));
                 $("#hidFi").val(getARP("fI",result));
                 $("#dialogFf").val(getARP("fF",result));
                 $("#hidFf").val(getARP("fF",result));
                 $("#dialogDes").val(getARP("des",result));
                 $("#hidDes").val(getARP("des",result));
                 $("#dTitle").val(getARP("titulo",result));
                 $("#hidTitle").val(getARP("titulo",result));
                 $("#hidId").val(getARP("id",result));
         });
    
    return false;
} //getInfo

function update()
{
    $.post(
             "calls/update.jsp", 
             {"idProyecto":$("#hidId").val(),"titulo":$("#dTitle").val(),"des":$("#dialogDes").val(),"fI":$("#dialogFi").val(),"fF":$("#dialogFf").val()}, //meaasge you want to send
             function(result) {
                 $("#loading").dialog('close');
                 var r = getARP("done",result);
                 if(r == "true")
                 {
                     var id = getARP("id",result);
                     var title = getARP("titulo",result);
                     $("#title" + id).html(title);
                     $("#successMsg").html("Exito actualizando");
                     $("#successMsg").slideDown('slow');
                 }
         });
    
    return false;
} //updateInfo

function dropSol(id)
{
    $("#loading").dialog('open');
    $.post(
             "calls/dropSol.jsp", 
             {"id":id}, //meaasge you want to send
             function(result) {
                 $("#loading").dialog('close');
                 var r = getARP("done",result);
                 if(r == "true")
                 {
                     var id = getARP("id",result);
                     $("#row" + id).detach();
                     $("#successMsg").html("Eliminado con exito");
                     $("#successMsg").slideDown('slow');
                 }
         });
    
} //eliminar solicitud

function infoReq(id)
{
    $("#loading").dialog('open');
    $.post(
            "calls/infoReq.jsp",
            {"id":id},
            function(result)
            {
                $("#loading").dialog('close');
                $("#title").val(getARP("titulo",result));
                $("#date").val(getARP("date",result));
                $("#des").val(getARP("des",result));
                $("#hidId").val(getARP("id",result));
                $("#fileId").val(getARP("id",result));
                $("#hidTitle").val(getARP("titulo",result));
                $("#hidDate").val(getARP("date",result));
                $("#hidDes").val(getARP("des",result));
                $('#frmDetReq').dialog('open');
                console.log(result);
            });
}

function updateReq()
{
    $("#file").val("");
    $.post(
             "calls/updateReq.jsp", 
             {"idRequerimiento":$("#hidId").val(),"titulo":$("#title").val(),"des":$("#des").val(),"mode":"1"}, //meaasge you want to send
             function(result) {
                 $("#loading").dialog('close');
                 var r = getARP("done",result);
                 if(r == "true")
                 {
                     var id = getARP("id",result);
                     var title = getARP("titulo",result);
                     $("#title" + id).html(title);
                     $("#successMsg").html("Exito actualizando");
                     $("#successMsg").slideDown('slow');
                 }
                 else
                 {
                   $("#errorMsg").html("Error actualizando");
                   $("#errorMsg").slideDown('slow');
                 }
         });
    
}

function updateFile()
{
    $("#loading").dialog('open');
    $("#loadingFile").show();
    var data = new FormData($("#frmFile")[0]);
    $.ajax(
        {
            type: "POST",
            enctype: 'multipart/form-data',
            url: "calls/UploadServlet",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            success: function (data) {
                   if(n)
                   {
                     $("#reload").submit();
                   }
                   $("#loading").dialog('close');
                   $("#loadingFile").hide();
                   var divfile = "#file" + getARP2("id",data);
                   var h = "<button onclick=\"window.open('http://" + getARP2("server",data) + "/Uploads/Requerimientos/" + getARP2("id",data) + "/"+ getARP2("file",data) + "')\"";
                   h += "class=\"btn btn-sm btn-success\">"+"<i class=\"ace-icon glyphicon glyphicon-file\"></i></button> <button class='btn btn-sm btn-danger ace-icon glyphicon glyphicon-remove' onclick=\"ajaxDropFile(" + getARP2("id",data) + ")\"</button>";
                   $(divfile).html(h);
                   $("#successMsg").html("Archivo actualizando");
                   $("#successMsg").slideDown('slow');
                   
            },
            error: function (e) {
                   $("#errorMsg").html("Error actualizando ");
                   $("#errorMsg").slideDown('slow');
            }
        }
    );
}

function getARP(name,res)
{
    response = res.trim();
    var params = response.split("&");
    for (var i = 0; i < params.length; i++)
    {
        var pName = params[i].split(':');
        if (pName[0] === name)
        {
            return pName[1];
        }
    }
}

function getARP2(name,res)
{
    response = res.trim();
    var params = response.split("&");
    for (var i = 0; i < params.length; i++)
    {
        var pName = params[i].split('=');
        if (pName[0] === name)
        {
            return pName[1];
        }
    }
}
var file = false;
var n = false;
function newReq()
{
    $("#loading").dialog('open');
    file = ($("#file").val().trim() != "");
    $.post(
            "calls/updateReq.jsp", 
             {"idProyecto":$("#hidIdP").val(),"titulo":$("#title").val(),"des":$("#des").val(),"mode":"0"}, //meaasge you want to send
             function(result) {
                 var r = getARP("done",result);
                 if(r == "true")
                 {
                     $("#fileId").val(getARP("id",result));
                     if(file)
                     {
                         updateFile();
                         n = true;
                     }
                     $("#msg").val("Agregado con exito");
                     $("#msgm").val("1");
                 }
                 else
                 {
                     $("#msg").val("Error al agregar");
                     $("#msgm").val("0");
                     $("#reload").submit();
                 }
             });
}

function dropReq(id,title)
{
    var r = confirm("Seguro que quiere borrar el siguiente requerimiento: " + title );
    if(r)
    {
        ajaxDropReq(id);
    }
}

function ajaxDropReq(id)
{
    $("#loading").dialog('open');
    $.post(
            "calls/updateReq.jsp", 
             {"idRequerimiento":id,"mode":"2"}, //meaasge you want to send
             function(result) {
                 var r = getARP("done",result);
                 if(r == "true")
                 {
                     $("#msg").val("Borrado con exito");
                     $("#msgm").val("1");
                     $("#reload").submit();
                 }
                 else
                 {
                     $("#msg").val("Error al borrar");
                     $("#msgm").val("0");
                     $("#reload").submit();
                 }
             });
}

function ajaxDropFile(id)
{
    $("#loading").dialog('open');
    $.post(
            "calls/updateReq.jsp", 
             {"idRequerimiento":id,"mode":"3"}, //meaasge you want to send
             function(result) {
                 $("#loading").dialog('close');
                 var r = getARP("done",result);
                 if(r == "true")
                 {
                     $("#msg").val("Borrado con exito");
                     $("#msgm").val("1");
                     $("#reload").submit();
                 }
                 else
                 {
                     $("#msg").val("Error al borrar");
                     $("#msgm").val("0");
                     $("#reload").submit();
                 }
             });
}



