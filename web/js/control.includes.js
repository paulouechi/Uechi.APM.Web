/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
            results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

try {
    vartempo = getParameterByName('t');
    if (vartempo == null || vartempo == 0){
        vartempo = 60;
    }
} catch (e) {
    vartempo = 60;
}

try {
    varpagina= getParameterByName('p');
    if (varpagina == null){
        varpagina = 0;
    }
} catch (e) {
    varpagina = 0;
}

try {
    vartotal = getParameterByName('s');
    if (vartotal == null){
        vartotal = 0;
    }
} catch (e) {
    vartotal = 0;
}

try {
    varconta = getParameterByName('c');
    if (varconta == null){
        varconta = 0;
    } else {
        if (vartotal < varpagina){
            varconta = parseInt(varconta) + parseInt(vartotal);
        } else {
            varconta = parseInt(varconta) + parseInt(varpagina);
        }
        if (varconta >= vartotal){
            varconta = 0;
        } 
    }
} catch (e) {
    varconta = 0;
}

(function countdown(remaining) {
    if (remaining === 0) {
        location.href = 'monitor?t=' + vartempo + '&p=' + varpagina + '&c=' + varconta + '&s=' + vartotal;
    }
    document.getElementById('divCount').innerHTML = remaining;
    setTimeout(function () {
        countdown(remaining - 1);
    }, 1000);
})(vartempo);

var themeColour = 'black';
