var radio = false;

$(document).ready(function () {
    $("div.msg").click(function()
    {
        $(this).css("display", "none");
    });
});

$(document).ready(function () {
    $("#ContentPlaceHolder1_Entrega_1").change(function () {
        if (this.checked && this.value == "re")
            $("#ContentPlaceHolder1_newRep").slideDown();
        else
            $("#ContentPlaceHolder1_newRep").hide();
    });
});

$(document).ready(function () {
    $("#ContentPlaceHolder1_Entrega_0").change(function () {
        if (this.checked && this.value == "usuario")
            $("#ContentPlaceHolder1_newRep").slideUp();
    });
});

$(document).ready(function () {
    $("#rdCanton").click(function (event) {
        $("#rdCanton").parent().children("div.select").children("div.noError").slideUp("slow");
        if (this.checked) {
            if (radio) {
                this.checked = false;
                radio = false;
            }
            else {
                radio = true;
            }
        }
    });
});

$(document).ready(function () {
    $("#rdCarac_no").click(function (event) {
        $("#dateCarac").parent().children("div.noError").slideUp("slow");
    });
});

function confirmDelete(id)
{
    var result = confirm("Seguro que quiere borrar la solicitud con el id: " + id + "?");
    if (result === true) {

        return true;
    }
    else
    {
        return false;
    }
}

function confirmPro(id) {
    var result = confirm("Seguro que quiere avanzar la solicitud con el id: " + id + "?");
    return result;
}

function rejectSol(id) {
    var result = confirm("Seguro que quiere rechazar la solicitud con el id: " + id + "?");
    return result;
}

function AceptSol(id) {
    var result = confirm("Seguro que quiere rechazar la solicitud con el id: " + id + "?");
    return result;
}

function hidDate() {
    var $date = $("#txtDate").val();
    $("#hiddenDate").val($date);
}