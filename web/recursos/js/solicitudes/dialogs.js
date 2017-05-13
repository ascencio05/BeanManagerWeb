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
        buttons: {
            "Aceptar": function() {
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

function openDetallesSol()
{
    $('#frmDetSol').dialog('open');
    return false;
} //Abrir sol dialog

$(document).ready(function () {
    $('#frmDetReq').dialog({
        autoOpen: false,
        maxHeight: 500,
        resizable: false,
        buttons: {
            "Aceptar": function() {
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

function openDetallesReq()
{
    $('#frmDetReq').dialog('open');
    return false;
} //Abrir Req dialog
