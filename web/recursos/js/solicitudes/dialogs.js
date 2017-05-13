/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#frmDetSol').dialog({
        autoOpen: false,
        maxHeight: 500,
        resizable: false,
        modal: true,
        buttons: {
            "Aceptar": function() {
                changeSol();
                $(this).dialog("close");
                return false;
            },
            "Cancelar": function() {
                $(this).dialog("close");
                return false;
            }      
        }
    });
}); //Ver Solicitudes dialog

function openDetallesSol(id)
{
    info(id);
    $("#loading").dialog('open');
    return false;
} //Abrir sol dialog

function changeSol()
{
    var r = false;
    if($("#dialogFi").val() != $("#hidFi").val())
    {
        r = true;
        console.log(1);
    }
    if($("#dialogFf").val() != $("#hidFf").val())
    {
        r = true;
        console.log(2);
    }
    if($("#dialogDes").val() != $("#hidDes").val())
    {
        r = true;
        console.log(3);
    }
    if($("#dTitle").val() != $("#hidTitle").val())
    {
        r = true;
        console.log(4);
    }
    
    if(r)
    {
        $("#loading").dialog('open');
        update();
    }
}

$(document).ready(function () {
    $('#frmDetReq').dialog({
        autoOpen: false,
        maxHeight: 500,
        resizable: false,
        modal: true,
        buttons: {
            "Aceptar": function() {
                if($("#hidMod").val() == "1")
                {
                    changeReq();
                }
                else
                {
                    newReq();
                }
                $(this).dialog("close");
                return false;
            },
            "Cancelar": function() {
                $(this).dialog("close");
                return false;
            }      
        }
    });
}); //Ver Req dialog

function openDetallesReq(id)
{
    infoReq(id);
    $("#file").val("");
    $("#date").attr("readonly",true);
    $("#hidMod").val("1");
    return false;
} //Abrir Req dialog

function openReq(id,title)
{
    $("#hidIDP").val(id);
    $("#hidTP").val(title);
    $("#frmShowReq").submit();
}

function openNewr()
{
    $("#file").val("");
    $("#title").val("");
    $("#date").val("");
    $("#des").val("");
    $("#hidMod").val("0");
    $('#frmDetReq').dialog('open');
}

function changeReq()
{
    var r = false;
    if($("#title").val() != $("#hidTitle").val())
    {
        r = true;
        console.log(1);
    }
    if($("#des").val() != $("#hidDes").val())
    {
        r = true;
        console.log(3);
    }
    if(r && validate())
    {
        $("#loading").dialog('open');
        updateReq();
    }
    
    if($("#file").val() !== "")
    {
        var file = $("#file").val().split(".").pop().toLowerCase();
        if(file !== "pdf")
        {
            $("#errorMsg").html("Formato de archivo inválido");
            $("#errorMsg").slideDown('slow');
        }
        else
        {
            updateFile();
        }
    }
}

$(document).ready(function(){
    if($("#msgm").val() !== "")
    {
        if($("#msgm").val() == "0")
        {
            var error = $("#msg").val();
            $("#errorMsg").html(error);
            $("#errorMsg").slideDown('slow');
            $("#msg").val("");
            $("#msgm").val("")
        }
        else if($("#msgm").val() == "1")
        {
            var ss = $("#msg").val();
            $("#successMsg").html(ss);
            $("#successMsg").slideDown('slow');
            $("#msg").val("");
            $("#msgm").val("");
        }
    }
});