/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var t;
function timeRun(x, y) {

    //set minutes 
    mins = x;
    //calculate the seconds 
    secs = mins * 60 + y;

    //countdown function is evoked when page is loaded 
    t = setInterval('Decrement()', 1000);
}
//Decrement function decrement the value. 
function Decrement() {
    minutes = document.getElementById("minutes");
    seconds = document.getElementById("seconds");

    //if less than a minute remaining 
    //Display only seconds value. 
    if (seconds < 59) {
        seconds.innerHTML = secs;
    }

    //Display both minutes and seconds 
    //getminutes and getseconds is used to 
    //get minutes and seconds 
    else {
        minutes.innerHTML = getminutes();
        seconds.innerHTML = getseconds();
    }
    //if seconds becomes zero, 
    //then page alert time up 
    if (mins < 0) {
        minutes.innerHTML = 0;
        seconds.innerHTML = 0;
        clearInterval(t);
        document.getElementById("forma").submit();
        return;
    }
    //if seconds > 0 then seconds is decremented 
    else {
        secs--;
    }
}

function getminutes() {
    //minutes is seconds divided by 60, rounded down 
    mins = Math.floor(secs / 60);
    return mins;
}

function getseconds() {
    //take minutes remaining (as seconds) away  
    //from total seconds remaining 
    return secs - Math.round(mins * 60);
}
