/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function log()
{
    $('#loading').dialog('open');
    $.post(
             "Autenticar", 
             {"user":$("#user").val(),"pass":$("#pass").val()}, //meaasge you want to send
             function(result) {
                 $('#loading').dialog('close');
                var response = result.split(":");
                
                if(response[1] == "false")
                    $("#errorMsg").show();
                else
                    location.href = "vistas/solicitudes/solicitudes.jsp";
         });
    
    return false;
}

function getParam(param)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++)
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == param)
        {
            return sParameterName[1];
        }
    }
    return false;
}

$(document).ready(function ()
{
    if(getParam('failed') != false)
    {
        $("#errorMsg").html("No ha iniciado sesión");
        $("#errorMsg").show();
    }
});