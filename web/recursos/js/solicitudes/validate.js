/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateText(control) {
    $val = $(control).val();
    $error = $(control).parent().parent().children('div.msg');
    if ($.trim($val) == '') {
        $error.html("*Valor requerido");
        $error.slideDown("slow");
        return false;
    }
    else {
        $error.slideUp("slow");
        return true;
    }
}

function validateRegex(control,regex,errorString)
{
    $val = $(control).val();
    $error = $(control).parent().parent().children('div.msg');
    
    if ($.trim($val) === '') {
        $error.html("*Valor requerido");
        $error.slideDown("slow");
        return false;
    }
    else if (!regex.test($val)) {
        
        $error.slideDown("slow");
        $error.html("*" + errorString);
        return false;
    }
    else {
        $error.slideUp("slow");
        return true;
    }
}

// MAIL
function validateMail()
{
    $regex = /^[a-zA-Z-0-9_]+(\.[a-zA-Z-0-9_]+)?@([a-zA-Z-0-9_]+)(\.[a-zA-Z-0-9_]+)?(\.[a-zA-Z]{2,3})$/;
    var r = validateRegex("#frmMail",$regex,"*Correo inválido");
    return r;
}

$(document).ready(function () {
    $("#frmMail").blur(function () {
        validateMail();
    });
});

//Name
function validateName()
{
    var r = validateText("#frmName");
    return r;
}

$(document).ready(function () {
    $("#frmName").blur(function () {
        validateName();
    });
});

//LName
function validateLName()
{
    var r = validateText("#frmLName");
    return r;
}

$(document).ready(function () {
    $("#frmLName").blur(function () {
        validateLName();
    });
});

//Pass
function validatePass()
{
    $regex =  /^(?=.*[\W])(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9\W]{5}/;
    var r = validateRegex("#frmPass",$regex,"Ingrese una contraseña segura.");
    console.log(r);
    return r;
}

$(document).ready(function () {
    $("#frmPass").blur(function () {
        validatePass();
    });
});

//Confirm
function confirmPass()
{
    var r = validateText("#confPass");
    if(r)
    {
        var pass = $("#frmPass").val();
        var cpass = $("#confPass").val();
        r = (pass == cpass);
        if(!r)
        {
            $error = $("#confPass").parent().parent().parent().children('div.msg').children("div.noError");
            $error.html("*Las Contraseñas no coinciden");
            $error.parent().slideDown("slow");
        }
        else
        {
            $error.parent().slideUp("slow");
        }
    }
    return r;
}

$(document).ready(function () {
    $("#confPass").blur(function () {
        confirmPass();
    });
});

//Date

function validatDate(control)
{
    $regex = /^(\d{4})\D?(0[1-9]|1[0-2])\D?([12]\d|0[1-9]|3[01])$/;
    var r = validateRegex(control,$regex,"Ingrese una fecha correcta.");
    return r;
}

$(document).ready(function () {
    $("#id-date-picker-2").blur(function () {
        validatDate("#id-date-picker-2");
    });
});

$(document).ready(function () {
    $("#date").blur(function () {
        validatDate("#date");
    });
});

function validateTitle()
{
    var r = validateText("#title");
    console.log(r);
    return r;
}

$(document).ready(function () {
    $("#title").blur(function () {
        validateTitle();
    });
});

function validateTitle()
{
    var r = validateText("#title");
    console.log(r);
    return r;
}

$(document).ready(function () {
    $("#title").blur(function () {
        validateTitle();
    });
});

function validateDes()
{
    var r = validateText("#des");
    return r;
}

$(document).ready(function () {
    $("#des").blur(function () {
        validateDes();
    });
});

function validate()
{
    return (validateDes() && validateTitle());
}
