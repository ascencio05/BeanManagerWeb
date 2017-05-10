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

