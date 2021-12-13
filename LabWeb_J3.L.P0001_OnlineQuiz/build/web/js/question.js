/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var index = 0;
//if div already have class display then remove it or
function displayor(element) {
    if (element.classList.contains("display")) {
        element.classList.remove("display");
    } else {
        element.classList.add("display");
    }
}

function onloadFirst(totalQu) {
    document.getElementById("q0").classList.remove("display");
    if (totalQu === 1) {
        document.getElementById("sub-but").classList.remove("display");
        document.getElementById("div-next").classList.add("display");
    }
}

function nextQuiz(totalQu) {
    //
    if (index === totalQu) {
        index = 0;
        displayor(document.getElementById("mess-submit"));
        displayor(document.getElementById("sub-but"));
        displayor(document.getElementById("q0"));
        return;
    }
    //hidden current quiz
    document.getElementById("sub-but").classList.add("display");
    var preQ = index;
    var preX = document.getElementById("q" + preQ);
    displayor(preX);

    if (index === totalQu - 2) {
        document.getElementById("sub-but").classList.remove("display");
    }
    if (index === totalQu - 1) {
        displayor(document.getElementById("mess-submit"));
        document.getElementById("sub-but").classList.remove("display");
    }
    //open next quiz
    var next = ++index;
    var xx = document.getElementById("q" + index);
    displayor(xx);
}
function  isDelete() {
    var result = confirm("Want to delete?");
    if (result) {
        document.getElementById("formDelete").submit();
    }

}
