var time = 0;

var running = 0;







function startPause(){

  if(running == 0){

    running = 1;

    increment();

    document.getElementById('start').innerHTML = "Pause";

    document.getElementById('startPause').style.backgroundColor = "red";

    document.getElementById('startPause').style.orderColor  = "red";

  } else {

    running = 0;

    document.getElementById('start').innerHTML = "Resume";

    document.getElementById('startPause').style.backgroundColor = "green";

    document.getElementById('startPause').style.borderColor = "green";

  }

}



function reset(){

  running = 0;

  document.getElementById('start').innerHTML = "Resume";

  document.getElementById("output").innerHTML = "0:00:00:00";

  document.getElementById('startPause').style.backgroundColor = "green";

  document.getElementById('startPause').style.orderColor = "green";

}

function increment(){

  if(running == 1){

    setTimeout(function(){

      time++

      var mins = Math.floor(time/10/60);

      var secs = Math.floor(time/10);

      var tenth = time % 10;

      var hours = Math.floor(time/10/60/60)

      if(mins < 10){

        mins = "0" + mins;

      }

      if(secs < 10){

        secs = "0" + secs;

      }

      document.getElementById("output").innerHTML = hours + ":" + mins + ":" + secs + ":" + tenth;

      increment();

    }, 100)



  }

}

