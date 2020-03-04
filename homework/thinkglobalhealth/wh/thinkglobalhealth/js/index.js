function show_left_menu() {
  var leftMenu = document.getElementById("left-menu");
  leftMenu.style.left = 0;
}

function close_lest_menu() {
  var leftMenu = document.getElementById("left-menu");
  leftMenu.style.left = "-620px";
}

var box = document.getElementById("carousel-ul");

var offset = 0; //偏移量
function carousel_left_move() {
  var ul = document.getElementById("carousel-ul");
  var lis = ul.children;
  var timer = setInterval(function() {
    var currentPotion = ul.offsetLeft;
    var nextPotion = currentPotion - 2;
    ul.style.left = nextPotion + "px";
    offset += 2;
    if (offset >= 360) {
      clearInterval(timer);
      ul.appendChild(lis[0]);
      // ul.style.left = "0px";
      ul.style.left = "-351px";
      offset = 0;
    }
  }, 10);
}

function carousel_right_move() {
  var ul = document.getElementById("carousel-ul");
  var lis = ul.children;

  var timer = setInterval(function() {
    var currentPotion = ul.offsetLeft;
    var nextPotion = currentPotion + 2;
    ul.style.left = nextPotion + "px";
    offset += 2;
    if (offset >= 360) {
      clearInterval(timer);
      ul.style.left = "-351px";
      ul.insertBefore(lis[lis.length - 1], lis[0]);
      offset = 0;
    }
  }, 10);
}
